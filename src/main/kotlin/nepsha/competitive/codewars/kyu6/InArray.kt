package nepsha.competitive.codewars.kyu6

import java.util.*

// https://www.codewars.com/kata/550554fd08b86f84fe000a58/kotlin
fun inArray(array1: Array<String>, array2: Array<String>): Array<String> {
    val r = LinkedList<String>()
    for (s in array1) {
        if (array2.any { it.contains(s) })
            r.indexOfFirst { it >= s }.also { i ->
                if (i == -1) r.add(s)
                else if (r[i] != s) r.add(i, s)
            }
    }
    return r.toTypedArray()
}