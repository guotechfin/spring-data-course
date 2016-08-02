package com.nwjon.sdata;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by jondann on 8/1/16.
 */
public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "Jon";
    }
}
