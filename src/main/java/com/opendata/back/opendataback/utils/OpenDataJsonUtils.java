package com.opendata.back.opendataback.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opendata.back.opendataback.entity.Data;

import java.util.UUID;

public class OpenDataJsonUtils {
    public JsonObject createParameters (long rows, long start) {
        JsonObject parameters = new JsonObject ();
        parameters.addProperty ("timezone", "UTC");
        parameters.addProperty ("rows", rows);
        parameters.addProperty ("start", start);
        parameters.addProperty ("format", "json");
        parameters.addProperty ("staged", false);
        return parameters;
    }

    public JsonObject createRecords (Data data, String idDataset) {
        JsonObject recordsObj = new JsonObject ();
        recordsObj.addProperty ("datasetid", idDataset);
        String uniqueID = UUID.randomUUID ().toString ();
        recordsObj.addProperty ("recordid", uniqueID);
        recordsObj.addProperty ("record_timestamp", "2020-03-01T00:00:00+00:00");
        JsonObject fields = new JsonObject ();
        fields.addProperty ("id", data.getId ());
        fields.addProperty ("name", data.getName ());
        fields.addProperty ("value", data.getValue ());
        recordsObj.add ("fields", fields);
        return recordsObj;
    }

    public JsonObject createDatasets (long count) {
        //      -------------- datasetObj
        JsonObject datasetObj = new JsonObject ();
        datasetObj.addProperty ("datasetid", "test-MSPR-epsi-montpellier");
        datasetObj.addProperty ("has_records", true);
        datasetObj.addProperty ("data_visible", true);

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

        datasetObj.add ("metas", metas);

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

        datasetObj.add ("fields", fields);

        //      -------------- features
        JsonArray features = new JsonArray ();
        datasetObj.add ("features", features);

        //      -------------- attachments
        JsonArray attachments = new JsonArray ();
        datasetObj.add ("attachments", attachments);

        //      -------------- alternative_exports
        JsonArray alternative_exports = new JsonArray ();
        datasetObj.add ("alternative_exports", alternative_exports);

        //      -------------- interop_metas + dcat
        JsonObject dcat = new JsonObject ();
        dcat.addProperty ("issued", "2020-03-01T00:00:00+00:00");
        dcat.addProperty ("accrualperiodicity", "Annuelle");
        dcat.addProperty ("created", "2020-03-01T00:00:00+00:00");

        JsonObject interop_metas = new JsonObject ();
        interop_metas.add ("dcat", dcat);

        datasetObj.add ("interop_metas", interop_metas);
        return datasetObj;
    }
}
