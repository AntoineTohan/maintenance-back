package com.opendata.back.opendataback.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opendata.back.opendataback.entity.Data;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OpenDataJsonUtilsTest {

    @Test
    void createParameters () {
        long rows = (long)1;
        long start = (long)0;
        JsonObject expectedParameters = new JsonObject ();
        expectedParameters.addProperty ("timezone", "UTC");
        expectedParameters.addProperty ("rows", rows);
        expectedParameters.addProperty ("start", start);
        expectedParameters.addProperty ("format", "json");
        expectedParameters.addProperty ("staged", false);

        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils();
        assertEquals(openDataJsonUtils.createParameters (rows,start), expectedParameters);
    }

    @Test
    void createRecords () {
        String idDataset = "id-test-records";
        Data dataTest = new Data ((long) 1, "testName","testValue");

        JsonObject expectedRecordsObj = new JsonObject ();
        expectedRecordsObj.addProperty ("datasetid", idDataset);
        String uniqueID = UUID.randomUUID ().toString ();
        expectedRecordsObj.addProperty ("recordid", uniqueID);
        expectedRecordsObj.addProperty ("record_timestamp", "2020-03-01T00:00:00+00:00");
        JsonObject fields = new JsonObject ();
        fields.addProperty ("id", dataTest.getId ());
        fields.addProperty ("name", dataTest.getName ());
        fields.addProperty ("value", dataTest.getValue ());
        expectedRecordsObj.add ("fields", fields);

        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils();
        assertEquals(openDataJsonUtils.createRecords (dataTest,idDataset).getClass (), expectedRecordsObj.getClass ());
    }

    @Test
    void createDatasets () {
        long count = (long)1;

        JsonObject expectedDatasetObj = new JsonObject ();
        expectedDatasetObj.addProperty ("datasetid", "test-MSPR-epsi-montpellier");
        expectedDatasetObj.addProperty ("has_records", true);
        expectedDatasetObj.addProperty ("data_visible", true);

        //      -------------- metas
        JsonObject metas = new JsonObject ();
        metas.addProperty ("publisher", "Equipe dev étudiante - EPSI Montpellier");
        metas.addProperty ("domain", "epsimontpellier");
        metas.addProperty ("license", "Open Database License (ODbL)");
        //      -------------- keyword
        JsonArray keyword = new JsonArray ();
        keyword.add ("EPSI");
        metas.add ("keyword", keyword);
        metas.addProperty ("title", "Valeurs de test pour de future implémentation");
        metas.addProperty ("records_count", count);
        metas.addProperty ("staged", true);
        metas.addProperty ("federated", true);
        metas.addProperty ("visibility", "domain");
        metas.addProperty ("modified", "2020-03-01T14:01:41.815000+00:00");
        metas.addProperty ("language", "fr");
        metas.addProperty ("staged", true);
        metas.addProperty ("staged", true);
        //      -------------- theme
        JsonArray theme = new JsonArray ();
        theme.add ("EPSI");
        metas.add ("theme", theme);
        metas.addProperty ("modified_updates_on_data_change", false);
        metas.addProperty ("license_url", "http://opendatacommons.org/licenses/odbl/");
        metas.addProperty ("modified_updates_on_metadata_change", false);
        metas.addProperty ("geographic_reference_auto", false);
        metas.addProperty ("data_processed", "2020-03-01T14:01:41.815000+00:00");
        metas.addProperty ("metadata_processed", "2020-03-01T14:01:41.815000+00:00");
        metas.addProperty ("description", "Jeu de test EPSI Montpellier");
        metas.addProperty ("staged", true);
        metas.addProperty ("staged", true);

        expectedDatasetObj.add ("metas", metas);

        //      -------------- fields
        JsonArray fields = new JsonArray ();
        JsonObject fileIdObj = new JsonObject ();

        fileIdObj.addProperty ("label", "Id");
        fileIdObj.addProperty ("type", "text");
        fileIdObj.addProperty ("name", "id");
        JsonArray annotations = new JsonArray ();
        fileIdObj.add ("annotations", annotations);
        fields.add (fileIdObj);

        JsonObject fileNameObj = new JsonObject ();
        fileNameObj.addProperty ("label", "Name");
        fileNameObj.addProperty ("type", "text");
        fileNameObj.addProperty ("name", "name");
        fileNameObj.add ("annotations", annotations);
        fields.add (fileNameObj);

        JsonObject fileValueObj = new JsonObject ();
        fileValueObj.addProperty ("label", "Value");
        fileValueObj.addProperty ("type", "text");
        fileValueObj.addProperty ("name", "value");
        fileValueObj.add ("annotations", annotations);
        fields.add (fileValueObj);

        expectedDatasetObj.add ("fields", fields);

        //      -------------- features
        JsonArray features = new JsonArray ();
        expectedDatasetObj.add ("features", features);

        //      -------------- attachments
        JsonArray attachments = new JsonArray ();
        expectedDatasetObj.add ("attachments", attachments);

        //      -------------- alternative_exports
        JsonArray alternative_exports = new JsonArray ();
        expectedDatasetObj.add ("alternative_exports", alternative_exports);

        //      -------------- interop_metas + dcat
        JsonObject dcat = new JsonObject ();
        dcat.addProperty ("issued", "2020-03-01T00:00:00+00:00");
        dcat.addProperty ("accrualperiodicity", "Annuelle");
        dcat.addProperty ("created", "2020-03-01T00:00:00+00:00");

        JsonObject interop_metas = new JsonObject ();
        interop_metas.add ("dcat", dcat);

        expectedDatasetObj.add ("interop_metas", interop_metas);

        OpenDataJsonUtils openDataJsonUtils = new OpenDataJsonUtils();
        assertEquals(openDataJsonUtils.createDatasets (count), expectedDatasetObj);
    }
}