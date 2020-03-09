package com.opendata.back.opendataback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter ();
        loggingFilter.setIncludeClientInfo (true);
        loggingFilter.setIncludeQueryString (true);
        loggingFilter.setIncludePayload (true);
        loggingFilter.setIncludeHeaders (false);
        return loggingFilter;
    }
}
