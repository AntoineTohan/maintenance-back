package com.opendata.back.opendataback.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceTest {

    @Test
    void getId () {
        Maintenance maintenanceTest = new Maintenance ((long) 1, false);
        assertEquals(1, maintenanceTest.getId ());
    }

    @Test
    void setId () {
        Maintenance maintenanceTest = new Maintenance ((long) 1, false);
        maintenanceTest.setId ((long) 2);
        assertEquals((long) 2, maintenanceTest.getId ());
    }

    @Test
    void getStatus () {
        Maintenance maintenanceTest = new Maintenance ((long) 1, false);
        assertEquals(false, maintenanceTest.getStatus ());
    }

    @Test
    void setStatus () {
        Maintenance maintenanceTest = new Maintenance ((long) 1, false);
        maintenanceTest.setStatus (true);
        assertEquals(true, maintenanceTest.getStatus ());
    }
}