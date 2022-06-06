package com.pdf.poc.controller;

import com.pdf.poc.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

	@Autowired
	PdfService pdfservice;

	@PostMapping("/pdf")
	public ResponseEntity<String> generatePdf(@RequestBody String input) {

		return new ResponseEntity<>(pdfservice.generatePdf(input), HttpStatus.OK);
	}
	
}
