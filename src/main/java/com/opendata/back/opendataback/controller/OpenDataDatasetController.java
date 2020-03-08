package com.opendata.back.opendataback.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opendata.back.opendataback.repository.DataRepository;
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
    public ResponseEntity<String> all() {
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
        metas.addProperty ("records_count", dataRepository.count ());
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
        fileIdObj.add("annotations",annotations);
        fields.add(fileIdObj);

        JsonObject fileNameObj = new JsonObject ();
        fileNameObj.addProperty ("label", "Name");
        fileNameObj.addProperty ("type", "text");
        fileNameObj.addProperty ("name", "name");
        fileNameObj.add("annotations",annotations);
        fields.add(fileNameObj);

        JsonObject fileValueObj = new JsonObject ();
        fileValueObj.addProperty ("label", "Value");
        fileValueObj.addProperty ("type", "text");
        fileValueObj.addProperty ("name", "value");
        fileValueObj.add("annotations",annotations);
        fields.add(fileValueObj);

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
        System.out.println(datasetObj.toString());
        return new ResponseEntity<String> (datasetObj.toString(), HttpStatus.OK);
    }
}
