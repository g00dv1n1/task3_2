const val VKPAY = "VKPay"
const val MASTER = "MasterCard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Мир"

fun main() {
    val typeCard = MASTER
    val sumLastMonthTransfer = 3_500_000
    val sumTransfer = 1_600_000

    moneyTransfer(typeCard, sumLastMonthTransfer, sumTransfer)

}

fun moneyTransfer(typeCard: String = VKPAY, sumLastMonthTransfer: Int = 0,sumTransfer: Int) {

    if (typeCard == MASTER || typeCard == MAESTRO) comissionMaster(sumLastMonthTransfer, sumTransfer)
    else if (typeCard == VISA || typeCard == MIR) comissionVisa(sumLastMonthTransfer, sumTransfer)
    else if (typeCard == VKPAY) comissionVK(sumLastMonthTransfer, sumTransfer)

}

fun comissionMaster(sumLastMonthTransfer: Int, sumTransfer: Int) {

    when(limitCard(sumLastMonthTransfer, sumTransfer)) {
        1 -> println("Превышен лимит отправки в месяц")
        2-> println("Превышен дневной лимит отправки")
        0-> if (sumLastMonthTransfer > 7_500_000) println("Комиссия составит: 0 копеек." )
        else println("Комиссия составит: " + sumTransfer / 100 * 0.6 + 2000 + " копеек." )
    }
}

fun comissionVisa(sumLastMonthTransfer: Int, sumTransfer: Int) {

    var comission = sumTransfer / 100 * 0.75

    when(limitCard(sumLastMonthTransfer, sumTransfer)) {
        1 -> println("Превышен лимит отправки в месяц")
        2-> println("Превышен дневной лимит отправки")
        0-> if (sumTransfer < 3500) comission = 3500.0
    }

    println("Комиссия составит: " + comission + " копеек.")
}

fun comissionVK(sumLastMonthTransfer: Int, sumTransfer: Int) {

    when(limitVK(sumLastMonthTransfer, sumTransfer)) {
        1 -> println("Превышен лимит отправки в месяц")
        2-> println("Превышен дневной лимит отправки")
        0-> println("Комиссия составит: 0 копеек.")
    }
}

fun limitCard(sumLastMonthTransfer: Int, sumTransfer: Int) : Int {

    return if (sumLastMonthTransfer > 60_000_000) 1
    else if (sumTransfer > 15_000_000) 2
    else 0

}

fun limitVK(sumLastMonthTransfer: Int, sumTransfer: Int) : Int {
    return if (sumLastMonthTransfer > 4_000_000) 1
    else if (sumTransfer > 1_500_000) 2
    else 0
}