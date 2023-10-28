package structure

import java.lang.IllegalArgumentException

class Price(private val amount: Int = 0, val vat: Int = 0) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Amount cannot be negative")
        }
        if (vat < 0) {
            throw IllegalArgumentException("VAT cannot be negative")
        }

    }
    fun getCalculatedAmount(): Float {
        val multiplier: Float = (vat + 100) / 100f
        return amount * multiplier
    }

    fun getVATDifference(): Float {
        return getCalculatedAmount() - amount
    }
}
