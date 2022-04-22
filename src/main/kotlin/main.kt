const val VKPAY = "VKPay"
const val MASTER = "MasterCard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Мир"

fun main() {
    val typeCard = VISA
    val sumLastMonthTransfer = 50_000_000
    val sumTransfer = 13_000
    var result = ""

    when (typeCard) {
        MASTER, MAESTRO -> result = comissionMaster(sumLastMonthTransfer, sumTransfer)
        VISA, MIR -> result = comissionVisa(sumLastMonthTransfer, sumTransfer)
        VKPAY -> result = comissionVK(sumLastMonthTransfer, sumTransfer)
    }

    println(result)

}

fun comissionMaster(sumLastMonthTransfer: Int, sumTransfer: Int) : String {

    return when(limitCard(sumLastMonthTransfer, sumTransfer)) {
        1-> "Превышен лимит отправки в месяц"
        2-> "Превышен дневной лимит отправки"
        0-> if (sumLastMonthTransfer < 7_500_000) "Комиссия составит: 0 копеек."
        else "Комиссия составит: " + sumTransfer / 100 * 0.6 + 2000 + " копеек."
        else -> ""
    }
}

fun comissionVisa(sumLastMonthTransfer: Int, sumTransfer: Int) : String {

    var comission = sumTransfer / 100 * 0.75
    if (comission < 3500) comission = 3500.0

    return when(limitCard(sumLastMonthTransfer, sumTransfer)) {
        1-> "Превышен лимит отправки в месяц"
        2-> "Превышен дневной лимит отправки"
        0-> "Комиссия составит: " + comission + " копеек."
        else -> ""
    }
}

fun comissionVK(sumLastMonthTransfer: Int, sumTransfer: Int) : String {

    return when(limitVK(sumLastMonthTransfer, sumTransfer)) {
        1-> "Превышен лимит отправки в месяц"
        2-> "Превышен дневной лимит отправки"
        0-> "Комиссия составит: 0 копеек."
        else -> ""
    }
}

fun limitCard(sumLastMonthTransfer: Int, sumTransfer: Int) : Int {

    return if (sumLastMonthTransfer > 60_000_000) 1
    else return if (sumTransfer > 15_000_000) 2
    else return 0

}

fun limitVK(sumLastMonthTransfer: Int, sumTransfer: Int) : Int {
    return if (sumLastMonthTransfer > 4_000_000) 1
    else return if (sumTransfer > 1_500_000) 2
    else return 0
}