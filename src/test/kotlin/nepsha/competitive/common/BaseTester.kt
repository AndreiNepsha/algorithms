package nepsha.competitive.common

import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import java.lang.AssertionError
import java.nio.charset.StandardCharsets
import kotlin.test.assertEquals

abstract class BaseTester {
    @Test
    fun runAllCases() {
        val className = javaClass.name.replace("Test", "")
        val classToTest = javaClass.classLoader.loadClass(className + "Kt")
        val methodToTest = classToTest.getDeclaredMethod("main")
        val caseResources = getResourceNames(className)
        for (case in caseResources) {
            try {
                System.setIn(javaClass.getResource(case.first).openStream())

                val actualOutputStream = ByteArrayOutputStream()
                val actualOutputPrintStream = PrintStream(actualOutputStream)
                System.setOut(actualOutputPrintStream)

                methodToTest.invoke(null)

                val expectedOutput = javaClass.getResource(case.second).readText()
                System.out.flush()
                val actualOutput = actualOutputStream.let {
                    it.close()
                    it.toString()
                }

                assertEquals(expectedOutput, actualOutput)
            } catch (ex: AssertionError) {
                val caseName = case.first
                    .substringAfter(File.separator)
                    .substringBefore("_in.txt")
                throw AssertionError("Assertion error in case $caseName:", ex)
            }
        }
    }

    // todo remove order dependency
    private fun getResourceNames(className: String): List<Pair<String, String>> {
        val resourceFolder = className.substringAfterLast('.') + File.separatorChar //"${className.toLowerCase().replace('.', File.separatorChar)}${File.separatorChar}"
        val (inRsc, outRsc) = javaClass
            .getResourceAsStream(resourceFolder)!!
            .readAllBytes()
            .toString(StandardCharsets.UTF_8)
            .split("\n")
            .dropLast(1)
            .map { resourceFolder + it }
            .partition { it.contains("in") }

        return inRsc.zip(outRsc)
    }
}