package com.servico.correio.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prazo")
public class CorreioController{

	
	@GetMapping()
	public void getPrazo(@RequestParam("servico") Integer servico,
			@RequestParam("cep_origem") Integer cep_origem,
			@RequestParam("cep_destino") Integer cep_destino) throws IOException {
		
		URL url;
		URLConnection urlConnection;
		try {
			url = new URL("http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?" + 
					"nCdEmpresa=" + 
					"&sDsSenha=" +
					"&nCdServico=" + cep_origem +
					"&sCepOrigem=" + cep_origem +
					"&sCepDestino=" + cep_destino + 
					"&nVlComprimento=105" + 
					"&nVlAltura=2" + 
					"&nVlLargura=11"  );
		} catch(MalformedURLException e) {
			throw new RuntimeException(e);
		}
		
		
		urlConnection = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String inputLine;
		File fileXML = new File("retornoXML.xml");
		FileWriter f = new FileWriter(fileXML);
		while ((inputLine = reader.readLine()) != null) {
			f.write(inputLine);
		}
		f.close();
		reader.close();
		
		FileReader fileReader = null;
		try {
			//carrega o arquivo XML para um objeto reader
			fileReader = new FileReader("retornoXML.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
