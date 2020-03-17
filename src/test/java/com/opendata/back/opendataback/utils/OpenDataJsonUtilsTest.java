package com.opendata.back.opendataback.utils;

import com.google.gson.JsonObject;
import com.opendata.back.opendataback.entity.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenDataJsonUtilsTest {

    @Test
    void createParameters () {
        long rows = (long)1;
        long start = (long)0;
        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils();
        JsonObject expected = openDataJsonUtils.createParameters (rows,start);
        assertEquals(openDataJsonUtils.createParameters (rows,start), expected);
    }

    @Test
    void createRecords () {
        String idDataset = "id-test-records";
        Data dataTest = new Data ((long) 1, "testName","testValue");
        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils();
        Class expected = openDataJsonUtils.createRecords (dataTest,idDataset).getClass ();
        assertEquals(openDataJsonUtils.createRecords (dataTest,idDataset).getClass (), expected );
    }

    @Test
    void createDatasets () {
        long count = (long)1;
        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils();
        JsonObject expected =  openDataJsonUtils.createDatasets (count);
        assertEquals(openDataJsonUtils.createDatasets (count), expected);
    }
}