package structure

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test
import kotlin.test.assertFailsWith

class PriceTest {
    @Test
    fun testNegativeAmount() {
        assertFailsWith(
            exceptionClass = IllegalArgumentException::class,
            message = "Amount cannot be negative",
            block = {
                Price(amount = -1, vat = 10)
            }
        )
    }

    @Test
    fun testNegativeVAT() {
        assertFailsWith(
            exceptionClass = IllegalArgumentException::class,
            message = "VAT cannot be negative",
            block = {
                Price(amount = 100, vat = -1)
            }
        )
    }

    @Test
    fun testCalculateSameAmount() {
        val price = Price(1000)
        val result = price.getCalculatedAmount()
        assertEquals(1000f, result)
    }
    @Test
    fun testCalculateVAT() {
        val price = Price(100, 10)
        val result = price.getCalculatedAmount()
        assertEquals(110f, result)
    }
}