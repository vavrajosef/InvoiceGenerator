import com.lowagie.text.Document
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfWriter
import java.io.File


fun exportPdf() {
    val doc = Document(PageSize.A4)
    val file = File("novepdf.pdf")
    PdfWriter.getInstance(doc, file.outputStream())
    doc.open()
    doc.add(Paragraph("Novy paragraf"))
    doc.close()

}