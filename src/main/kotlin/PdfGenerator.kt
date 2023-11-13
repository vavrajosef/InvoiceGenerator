import com.lowagie.text.Cell
import com.lowagie.text.Chunk
import com.lowagie.text.Document
import com.lowagie.text.Font
import com.lowagie.text.FontFactory
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph
import com.lowagie.text.Section
import com.lowagie.text.SimpleTable
import com.lowagie.text.Table
import com.lowagie.text.alignment.HorizontalAlignment
import com.lowagie.text.alignment.VerticalAlignment
import com.lowagie.text.pdf.PdfWriter
import java.io.File


fun exportPdf() {
    val doc = Document(PageSize.A4)
    val file = File("novepdf.pdf")
    PdfWriter.getInstance(doc, file.outputStream())
    doc.open()

    val tableHead = Table(2, 1)
    tableHead.borderWidth = 0f
    tableHead.padding = 5f
    val cellName = Cell("Jmeno")
    cellName.borderWidth = 0f

    val cellNumberDetail = Cell("Detail")
    cellNumberDetail.borderWidth = 0f
    cellNumberDetail.setHorizontalAlignment(HorizontalAlignment.RIGHT)

    tableHead.addCell(cellName)
    tableHead.addCell(cellNumberDetail)
    doc.add(tableHead)

    val tablePartiesInfo = Table(2, 3)

    tablePartiesInfo.borderWidth = 1f
    tablePartiesInfo.padding = 1f


    tablePartiesInfo.addCell(createPartyInfoDetail())


    tablePartiesInfo.addCell(createPaymentVariables())

    val senderAccountDetail = Cell("""
        IČ: 123456789
        DIČ: CZ123546798
        Mobil: 123456789
    """.trimIndent())
    senderAccountDetail.add(Paragraph("\n\n\n"))
    val accountNumber = Table(4, 1)
    accountNumber.addCell("Cislo:")
    accountNumber.addCell("")
    val accountNumberCell = Cell("123456")
    accountNumberCell.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    accountNumber.addCell((accountNumberCell))
    accountNumber.addCell("1234")
    senderAccountDetail.add(accountNumber)
    tablePartiesInfo.addCell(senderAccountDetail)

    val receiverAccountDetailTable = Table(3, 2)
    receiverAccountDetailTable.addCell("Odběratel:")
    receiverAccountDetailTable.addCell("IČ:")
    val receiverID = Cell("123456")
    receiverID.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    receiverAccountDetailTable.addCell(receiverID)

    receiverAccountDetailTable.addCell("")
    receiverAccountDetailTable.addCell("DIČ:")
    val receiverDID = Cell("123456")
    receiverDID.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    receiverAccountDetailTable.addCell(receiverDID)
    val receiverAccountDetail = Cell(receiverAccountDetailTable)
    val receiverAddress = Paragraph("""
        Doma 123
        Praha
        nekde
    """.trimIndent())
    receiverAccountDetail.add(receiverAddress)
    tablePartiesInfo.addCell(receiverAccountDetail)
    val dates = Table(2, 4)
    dates.addCell("Datum vystaveni: ")
    val dateOfIssue = Cell("1,1,1111")
    dateOfIssue.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    dates.addCell(dateOfIssue)
    dates.addCell("Datum splatnosti: ")
    val dueDate = Cell("1,1,1111")
    dueDate.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    dates.addCell(dueDate)

    dates.addCell("Datum uskutecneni plneni: ")
    val datePOTS = Cell("1,1,1111")
    datePOTS.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    dates.addCell(datePOTS)
    dates.addCell("Forma uhrady: ")
    val methodOfPayment = Cell("Prevodem")
    methodOfPayment.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    dates.addCell(methodOfPayment)

    tablePartiesInfo.addCell(Cell(dates))
    tablePartiesInfo.addCell(Cell(""))

    doc.add(tablePartiesInfo)

    doc.close()

}

fun createTextField(text: String, fontSize: Float = 5f): Paragraph {
    val p = Paragraph(text)
    p.font = Font(FontFactory.getFont(FontFactory.HELVETICA, fontSize))
    return p
}

fun createPartyInfoDetail(): Cell {
    val sourcePartyInfoCell = Cell(createTextField("""
        Dodavatel:
        Jmeno
        Adresa
    """.trimIndent(), 3f))
    sourcePartyInfoCell.borderWidth = 1f
    return sourcePartyInfoCell
}

fun createPaymentVariables(): Cell {
    val tablePaymentVariables = Table(2, 3)
    tablePaymentVariables.addCell(createTextField("Variabilní symbol", 2f))
    val paymentSymbol = Cell(createTextField("2023", 2f))
    paymentSymbol.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    tablePaymentVariables.addCell(createRCell())
    tablePaymentVariables.addCell("Konstantní symbol")
    val constantSymbol = Cell("0308")
    constantSymbol.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    tablePaymentVariables.addCell(constantSymbol)
    tablePaymentVariables.addCell("Objednávka č.:")
    tablePaymentVariables.addCell("ze dne:")

    return Cell(tablePaymentVariables)
}

fun createRCell(p: Paragraph): Cell {
    val rCell = Cell(p)
    rCell.setHorizontalAlignment(HorizontalAlignment.RIGHT)
    return rCell
}