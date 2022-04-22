import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun comissionMasterMounthLimit() {

        val sumLastMonthTransfer = 61_000_000
        val sumTransfer = 1_600_000
        val expectedText = "Превышен лимит отправки в месяц"

        val actualText = comissionMaster(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionMasterDayLimit() {

        val sumLastMonthTransfer = 45_000_000
        val sumTransfer = 16_000_000
        val expectedText = "Превышен дневной лимит отправки"

        val actualText = comissionMaster(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionMasterNullComission() {

        val sumLastMonthTransfer = 7_400_000
        val sumTransfer = 13_000_000
        val expectedText = "Комиссия составит: 0 копеек."

        val actualText = comissionMaster(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionMasterFullComission() {

        val sumLastMonthTransfer = 7_600_000
        val sumTransfer = 13_000_000
        val expectedText = "Комиссия составит: 78000.02000 копеек."

        val actualText = comissionMaster(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionVisaMounthLimit() {

        val sumLastMonthTransfer = 61_000_000
        val sumTransfer = 1_600_000
        val expectedText = "Превышен лимит отправки в месяц"

        val actualText = comissionVisa(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionVisaDayLimit() {

        val sumLastMonthTransfer = 45_000_000
        val sumTransfer = 16_000_000
        val expectedText = "Превышен дневной лимит отправки"

        val actualText = comissionVisa(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionVisaFullComission() {

        val sumLastMonthTransfer = 50_000_000
        val sumTransfer = 13_000_000
        val expectedText = "Комиссия составит: 97500.0 копеек."

        val actualText = comissionVisa(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionVisaMinComission() {

        val sumLastMonthTransfer = 50_000_000
        val sumTransfer = 13_000
        val expectedText = "Комиссия составит: 3500.0 копеек."

        val actualText = comissionVisa(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionVkMounthLimit() {

        val sumLastMonthTransfer = 41_000_000
        val sumTransfer = 1_600_000
        val expectedText = "Превышен лимит отправки в месяц"

        val actualText = comissionVK(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionVkDayLimit() {

        val sumLastMonthTransfer = 3_900_000
        val sumTransfer = 1_600_000
        val expectedText = "Превышен дневной лимит отправки"

        val actualText = comissionVK(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun comissionVkNullComission() {

        val sumLastMonthTransfer = 3_900_000
        val sumTransfer = 1_400_000
        val expectedText = "Комиссия составит: 0 копеек."

        val actualText = comissionVK(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedText, actualText)
    }

    @Test
    fun limitCardMounthLimit() {

        val sumLastMonthTransfer = 64_900_000
        val sumTransfer = 1_400_000
        val expectedCode = 1

        val actualCode = limitCard(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedCode, actualCode)

    }

    @Test
    fun limitCardDayLimit() {

        val sumLastMonthTransfer = 4_900_000
        val sumTransfer = 15_400_000
        val expectedCode = 2

        val actualCode = limitCard(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedCode, actualCode)

    }

    @Test
    fun limitCardNoLimit() {

        val sumLastMonthTransfer = 4_900_000
        val sumTransfer = 14_400_000
        val expectedCode = 0

        val actualCode = limitCard(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedCode, actualCode)

    }

    @Test
    fun limitVkMounthLimit() {

        val sumLastMonthTransfer = 4_900_000
        val sumTransfer = 1_400_000
        val expectedCode = 1

        val actualCode = limitVK(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedCode, actualCode)

    }

    @Test
    fun limitVkDayLimit() {

        val sumLastMonthTransfer = 3_900_000
        val sumTransfer = 1_600_000
        val expectedCode = 2

        val actualCode = limitVK(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedCode, actualCode)

    }

    @Test
    fun limitVkNoLimit() {

        val sumLastMonthTransfer = 3_900_000
        val sumTransfer = 1_400_000
        val expectedCode = 0

        val actualCode = limitVK(sumLastMonthTransfer, sumTransfer)

        assertEquals(expectedCode, actualCode)

    }
}