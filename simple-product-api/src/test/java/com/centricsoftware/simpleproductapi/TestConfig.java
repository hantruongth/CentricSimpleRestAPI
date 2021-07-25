package com.centricsoftware.simpleproductapi;

import com.centricsoftware.simpleproductapi.service.LanguageService;
import com.centricsoftware.simpleproductapi.service.MessageService;
import com.centricsoftware.simpleproductapi.service.impl.LanguageServiceImpl;
import com.centricsoftware.simpleproductapi.service.impl.MessageServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author hantruong
 */

@TestConfiguration
public class TestConfig {

    @Bean
    public MessageService getMessageService(){
        return new MessageServiceImpl();
    }

    @Bean
    public LanguageService getLanguageService(){
        return new LanguageServiceImpl();
    }
}
