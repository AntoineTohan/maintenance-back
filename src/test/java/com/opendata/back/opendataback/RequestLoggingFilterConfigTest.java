package com.opendata.back.opendataback;

import org.junit.jupiter.api.Test;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import static org.junit.jupiter.api.Assertions.*;

class RequestLoggingFilterConfigTest {

    @Test
    void logFilter () {
        RequestLoggingFilterConfig requestLoggingFilterConfig = new RequestLoggingFilterConfig();
        RequestLoggingFilterConfig requestLoggingFilterConfigExpected = new RequestLoggingFilterConfig();
        assertEquals(requestLoggingFilterConfig.logFilter ().getClass (), requestLoggingFilterConfigExpected.logFilter ().getClass ());
    }
}