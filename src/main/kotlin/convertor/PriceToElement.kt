package convertor

import com.lowagie.text.Element
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfCell
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import structure.Price
import java.lang.IllegalArgumentException

class PriceToElement(val prices: List<Price>) {
    init {
        if (prices.isEmpty()) {
            throw IllegalArgumentException("There needs to be at least one amount to invoice")
        }
    }
    fun toElement(): Element {
        val table = PdfPTable(4)
        val sortedPrices = prices.sortedBy(Price::vat)
        val header = PdfPCell(Paragraph(""))


    }
}