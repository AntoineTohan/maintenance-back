package com.opendata.back.opendataback.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DTODataTest {

    @Test
    void getId () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        assertEquals(1, DTOdataTest.getDTOId ());
    }

    @Test
    void setId () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        DTOdataTest.setDTOId ((long) 2);
        assertEquals((long) 2, DTOdataTest.getDTOId ());
    }

    @Test
    void getName () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        assertEquals("testName", DTOdataTest.getDTOName ());
    }

    @Test
    void setName () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        DTOdataTest.setDTOName ("testName-bis");
        assertEquals("testName-bis", DTOdataTest.getDTOName ());
    }

    @Test
    void getValue () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        assertEquals("testValue", DTOdataTest.getDTOValue ());
    }

    @Test
    void setValue () {
        DTOData DTOdataTest = new DTOData ((long) 1, "testName","testValue");
        DTOdataTest.setDTOValue ("testValue-bis");
        assertEquals("testValue-bis", DTOdataTest.getDTOValue ());
    }
}