package com.opendata.back.opendataback.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opendata.back.opendataback.repository.DataRepository;
import com.opendata.back.opendataback.utils.OpenDataJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class OpenDataDatasetsController {

    @Autowired
    private DataRepository dataRepository;

    @RequestMapping(value = "/api/datasets/1.0/search/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> all (@RequestParam("rows") long rows, @RequestParam("start") long start) {
        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils ();
        JsonObject result = new JsonObject ();
        //      -------------- nhits
        result.addProperty ("nhits", 1);
        //      -------------- parameters
        result.add ("parameters", openDataJsonUtils.createParameters (rows, start));
        //      -------------- dataset
        JsonArray datasets = new JsonArray ();
        datasets.add (openDataJsonUtils.createDatasets (dataRepository.count ()));
        result.add ("datasets", datasets);
        System.out.println (result.toString ());
        return new ResponseEntity<> (result.toString (), HttpStatus.OK);
    }
}
