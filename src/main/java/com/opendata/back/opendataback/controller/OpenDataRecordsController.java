package com.opendata.back.opendataback.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opendata.back.opendataback.entity.Data;
import com.opendata.back.opendataback.repository.DataRepository;
import com.opendata.back.opendataback.utils.OpenDataJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@Api(value="Récupérer les Datas sous format OpenData")
public class OpenDataRecordsController {

    @Autowired
    private DataRepository dataRepository;

    @ApiOperation(value = "Récupérer la data sous format OpenData")
    @RequestMapping(value = "/api/records/1.0/search/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> all(@RequestParam("rows") String idDataset, @RequestParam("rows") long rows, @RequestParam("start") long start) {
        JsonObject result = new JsonObject ();
        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils();
        //      -------------- nhits
        result.addProperty ("nhits", 1);
        //      -------------- parameters
        result.add ("parameters", openDataJsonUtils.createParameters(rows,start));
        //      -------------- records
        JsonArray records = new JsonArray ();
        Iterable<Data> recordIterable = all();
        recordIterable.forEach (data -> {
            records.add (openDataJsonUtils.createRecords(data, idDataset));
        });
        result.add ("records", records);
        System.out.println(result.toString());
        return new ResponseEntity<> (result.toString(), HttpStatus.OK);
    }

    public Iterable<Data> all() {
        return dataRepository.findAll();
    }
}
