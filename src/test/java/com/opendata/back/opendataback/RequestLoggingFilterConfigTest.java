package com.opendata.back.opendataback;

import org.junit.jupiter.api.Test;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import static org.junit.jupiter.api.Assertions.*;

class RequestLoggingFilterConfigTest {

    @Test
    void logFilter () {
        RequestLoggingFilterConfig requestLoggingFilterConfig = new RequestLoggingFilterConfig();
        CommonsRequestLoggingFilter expectedLoggingFilter = new CommonsRequestLoggingFilter ();
        expectedLoggingFilter.setIncludeClientInfo (true);
        expectedLoggingFilter.setIncludeQueryString (true);
        expectedLoggingFilter.setIncludePayload (true);
        expectedLoggingFilter.setIncludeHeaders (false);
        assertEquals(requestLoggingFilterConfig.logFilter ().getClass (), expectedLoggingFilter.getClass ());
    }
}