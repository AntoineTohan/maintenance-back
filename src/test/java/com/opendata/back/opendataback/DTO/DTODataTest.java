package com.opendata.back.opendataback.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DTODataTest {

    @Test
    void getId () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        assertEquals(1, DTOdataTest.getId ());
    }

    @Test
    void setId () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        DTOdataTest.setId ((long) 2);
        assertEquals((long) 2, DTOdataTest.getId ());
    }

    @Test
    void getName () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        assertEquals("testName", DTOdataTest.getName ());
    }

    @Test
    void setName () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        DTOdataTest.setName ("testName-bis");
        assertEquals("testName-bis", DTOdataTest.getName ());
    }

    @Test
    void getValue () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        assertEquals("testValue", DTOdataTest.getValue ());
    }

    @Test
    void setValue () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        DTOdataTest.setValue ("testValue-bis");
        assertEquals("testValue-bis", DTOdataTest.getValue ());
    }
}