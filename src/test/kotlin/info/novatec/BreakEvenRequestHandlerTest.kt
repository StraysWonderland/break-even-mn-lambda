package info.novatec
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class BreakEvenRequestHandlerTest {

    @Test
    fun testHandler() {
        val bookRequestHandler = BreakEvenRequestHandler()
        val breakEvenRequest = BreakEvenRequest()
        breakEvenRequest.price = 20.00
        breakEvenRequest.unitCosts = 10.00
        breakEvenRequest.fixedCosts = 100.00
        val breakEvenResponse = bookRequestHandler.execute(breakEvenRequest)
        Assertions.assertNotNull(breakEvenResponse)
        val breakEvenPoint = kotlin.math.ceil(breakEvenRequest.fixedCosts / (breakEvenRequest.price - breakEvenRequest.unitCosts)).toInt()
        Assertions.assertEquals(breakEvenPoint, breakEvenResponse!!.breakEvenPoint)
        bookRequestHandler.applicationContext.close()
    }
}