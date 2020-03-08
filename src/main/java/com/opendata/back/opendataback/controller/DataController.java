package com.opendata.back.opendataback.controller;

import com.opendata.back.opendataback.entity.Data;
import com.opendata.back.opendataback.repository.DataRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/data")
    public Iterable<Data> all() {
        return dataRepository.findAll();
    }

    @PostMapping(value = "/data")
    public ResponseEntity<String> uploadCsvFile(@RequestParam("files") MultipartFile[] files) {
        try {
            for (MultipartFile file : files)
            {
                String content = new String(file.getBytes(), "UTF-8");
                String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                if(extension.equals("csv")) {
                    String[] lines = content.split(System.getProperty("line.separator"));
                    for (String line : lines) {
                        String[] dataExtractFromString = line.split(";");
                        Long id = new Long(dataExtractFromString[0]);
                        String name = dataExtractFromString[1];
                        String value = dataExtractFromString[2];
                        Data data = new Data(id, name, value);
                        dataRepository.save (data);
                    }
                } else if(extension.equals("xml")) {
                    Document doc = convertStringToXMLDocument(content);
                    int linesNumber = countLines(content) + 1;
                    for (int temp = 1; temp < linesNumber; temp++)
                    {
                        String currentData = "data" + temp;
                        Node node = doc.getElementsByTagName(currentData).item(0);
                        if (node.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element eElement = (Element) node;
                            Long id = new Long(eElement.getElementsByTagName("uniqueID").item(0).getTextContent());
                            String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                            String value = eElement.getElementsByTagName("value").item(0).getTextContent();
                            Data data = new Data(id, name, value);
                            dataRepository.save (data);
                            System.out.println(eElement.getElementsByTagName("uniqueID").item(0).getTextContent());
                            System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());
                            System.out.println(eElement.getElementsByTagName("value").item(0).getTextContent());
                        }
                    }
                }
            }
            String message = "Les fichiers sont bien enregistrés sur le serveur !";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            String message = "Erreur : les fichiers sont pas enregistrés sur le serveur !";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    private static Document convertStringToXMLDocument(String xmlString)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource (new StringReader (xmlString)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static int countLines(String str){
        String[] lines = str.split("\r\n|\r|\n");
        return  ((lines.length - 2)/5);
    }
}
