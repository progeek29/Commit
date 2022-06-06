package com.pdf.poc.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    @Override
	public String generatePdf(String input) {

        System.out.println("File Started");

		try {

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("Hello.pdf"));
		
			document.open();
	        //document.add(new Paragraph("A Hello World PDF document."));
	        
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk(input, font);

			document.add(chunk);
			document.close();

		} catch (DocumentException e) {
			return "Exception occurred while working on document: "+e.getMessage();


		} catch (FileNotFoundException e) {
			return "Exception occurred while creating blank file: "+e.getMessage();
		}
        return "PDF created with the text successfully: "+ input;
    }


}
