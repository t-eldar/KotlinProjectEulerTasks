package solutions

import java.io.File
import java.math.BigDecimal
import java.math.MathContext
import kotlin.math.sqrt

// #1, problem 1
fun solveMultiplesOfThreeOrFive(): Int {
    var sum = 0
    for (num in 1..999) {
        if (num % 3 == 0 || num % 5 == 0) {
            sum += num
        }
    }

    return sum
}

// #2, problem 80
fun solveSquareRootDigitalExpansion(): Int {
    var sum = 0
    for (num in 2..99) {
        val mathContext = MathContext(102)
        val squareRoot = num.toBigDecimal().sqrt(mathContext)

        if (squareRoot - squareRoot.toInt().toBigDecimal() == BigDecimal.ZERO) {
            continue
        }
        val rootString = squareRoot.toString()
        val delimiterIndex = rootString.indexOf('.')
        val decimalPart = rootString.substring(delimiterIndex + 1).take(99)
        for (i in rootString.takeWhile { it != '.' }) {
            sum += i.digitToInt()
        }
        for (i in decimalPart) {
            sum += i.digitToInt()
        }
    }

    return sum
}

// #3, problem 6
fun solveSumSquareDifference(): Int {
    var sumOfSquares = 0
    var sum = 0
    for (number in 1..100) {
        sumOfSquares += number * number
        sum += number
    }

    return sum * sum - sumOfSquares
}

// #4, problem 7
fun solve10001sPrime(): Int {
    var count = 0
    var number = 1

    while (count != 10_001) {
        number++
        if (isPrime(number)) {
            count++
        }
    }

    return number
}

fun isPrime(number: Int): Boolean {
    for (i in 2..sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            return false
        }
    }

    return true
}

// #5, problem 22
fun solveNameScores(namesPath: String): Int {
    val names = File(namesPath)
        .readText()
        .split(',')
        .sorted()

    var totalScore = 0
    for(name in names) {
        val alphabeticScore = getNameScore(name.substring(1, name.length - 1))
        totalScore += alphabeticScore * (names.indexOf(name) + 1)
    }

    return totalScore
}

fun getNameScore(name: String): Int {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    var score = 0
    for (char in name.lowercase()) {
        val index = alphabet.indexOf(char)
        score += index + 1
    }

    return score
}