package nepsha.competitive.codewars.kyu4

// https://www.codewars.com/kata/55983863da40caa2c900004e/kotlin
fun nextBiggerNumber(n: Long): Long {
    val digits = n.toString().toCharArray().map { it.toInt() - '0'.toInt() }.toMutableList()
    val k = digits.size-1

    var i = k-1
    while (i > 0 && digits[i] >= digits[i+1]) i--
    var j = i+1
    while (j < k && digits[i] < digits[j+1]) j++

    if (i == 0 && j == i+1 && digits[i] >= digits[j]) return -1

    swap(digits, i, j)
    for (t in 0..(k-i-1)/2)
        swap(digits, i+t+1, k-t)

    return java.lang.Long.parseLong(String(digits.map { (it + '0'.toByte()).toChar() }.toCharArray()))
}

fun swap(a: MutableList<Int>, i: Int, j: Int) {
    val t = a[i]
    a[i] = a[j]
    a[j] = t
}