package com.centricsoftware.simpleproductapi.service.impl;

import com.centricsoftware.simpleproductapi.service.LanguageService;
import com.centricsoftware.simpleproductapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * @author hantruong
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    LanguageService languageService;

    @Autowired
    MessageSource messageSource;

    @Override
    public String getMessage(String key, Object[] values) {
        try {
            String mess = messageSource.getMessage(key, values, languageService.getLocale());
            if(mess != null )
                mess = mess.trim();
            return mess;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
