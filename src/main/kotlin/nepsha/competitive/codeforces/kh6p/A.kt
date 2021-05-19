package nepsha.competitive.codeforces.kh6p

fun main() {
    readLine()!!.toInt()
    val numbers = readLine()!!.split(' ').map(String::toInt)
    val output = mutableListOf<Int>()
    for (i in numbers.reversed()) {
        if (i !in output) output.add(i)
    }
    println(output.size)
    for (i in output.reversed()) {
        print("$i ")
    }
}