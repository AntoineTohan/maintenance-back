package com.opendata.back.opendataback.controller;

import com.opendata.back.opendataback.repository.DataRepository;
import com.opendata.back.opendataback.utils.OpenDataJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class OpenDataDatasetController {

    @Autowired
    private DataRepository dataRepository;

    @RequestMapping(value = "/api/datasets/1.0/test-MSPR-epsi-montpellier/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> all () {
        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils ();
        System.out.println (openDataJsonUtils.createDatasets (dataRepository.count ()).toString ());
        return new ResponseEntity<> (openDataJsonUtils.createDatasets (dataRepository.count ()).toString (), HttpStatus.OK);
    }
}
