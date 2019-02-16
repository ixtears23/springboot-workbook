package com.ibdata.mvc.negotiation.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.ibdata.mvc.negotiation.model.Student;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class StudentPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Student student = (Student) model.get("student");
		
		// column widths
		float[] columnWidths = { 1.5f, 2f };
		PdfPTable pdfPTable = new PdfPTable(columnWidths);
		pdfPTable.setWidthPercentage(90f);
		
		// Table header
		PdfPCell cell = null;
		cell = new PdfPCell(new Phrase("ID"));
		pdfPTable.addCell(cell);
		cell = new PdfPCell(new Phrase(Integer.toString(student.getId())));
		pdfPTable.addCell(cell);
		cell = new PdfPCell(new Phrase("NAME"));
		pdfPTable.addCell(cell);
		cell = new PdfPCell(new Phrase(student.getName()));
		pdfPTable.addCell(cell);
		cell = new PdfPCell(new Phrase("DOB"));
		pdfPTable.addCell(cell);
		cell = new PdfPCell(new Phrase(student.getDob().toString()));
		pdfPTable.addCell(cell);
		cell = new PdfPCell(new Phrase("EMAIL"));
		pdfPTable.addCell(cell);
		cell = new PdfPCell(new Phrase(student.getEmail()));
		pdfPTable.addCell(cell);
		
		document.add(pdfPTable);
	}

}
