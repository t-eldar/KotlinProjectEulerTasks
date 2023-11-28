import solutions.*

fun main(args: Array<String>) {
    println("---- Первая задача ----")
    println(solveMultiplesOfThreeOrFive())

    println("---- Вторая задача ----")
    println(solveSquareRootDigitalExpansion())

    println("---- Третья задача ----")
    println(solveSumSquareDifference())

    println("---- Четвертая задача ----")
    println(solve10001sPrime())

    println("---- Пятая задача ----")
    println(
        solveNameScores(
            getResourcePath("names.txt")
                ?: throw Exception("Cannot find file")
        )
    )
}

fun getResourcePath(path: String): String? {
    return object {}.javaClass.getResource(path)?.path
}