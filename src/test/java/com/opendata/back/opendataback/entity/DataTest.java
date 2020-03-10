package com.opendata.back.opendataback.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void getId () {
        Data dataTest = new Data ((long) 1, "testName","testValue");
        assertEquals(1, dataTest.getId ());
    }

    @Test
    void setId () {
        Data dataTest = new Data ((long) 1, "testName","testValue");
        dataTest.setId ((long) 2);
        assertEquals((long) 2, dataTest.getId ());
    }

    @Test
    void getName () {
        Data dataTest = new Data ((long) 1, "testName","testValue");
        assertEquals("testName", dataTest.getName ());
    }

    @Test
    void setName () {
        Data dataTest = new Data ((long) 1, "testName","testValue");
        dataTest.setName ("testName-bis");
        assertEquals("testName-bis", dataTest.getName ());
    }

    @Test
    void getValue () {
        Data dataTest = new Data ((long) 1, "testName","testValue");
        assertEquals("testValue", dataTest.getValue ());
    }

    @Test
    void setValue () {
        Data dataTest = new Data ((long) 1, "testName","testValue");
        dataTest.setValue ("testValue-bis");
        assertEquals("testValue-bis", dataTest.getValue ());
    }
}