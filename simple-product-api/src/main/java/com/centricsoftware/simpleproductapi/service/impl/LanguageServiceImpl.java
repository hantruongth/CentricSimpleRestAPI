package com.centricsoftware.simpleproductapi.service.impl;

import com.centricsoftware.simpleproductapi.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author hantruong
 */

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    HttpServletRequest request;

    @Override
    public String getCurrentLanguageCode() {
        String languageCode = request.getParameter("lang");
        List<String> supportedLanguages = Arrays.asList("en","fr");

        if (languageCode == null || (!supportedLanguages.contains(languageCode.toLowerCase())) ) {
            languageCode = "en";
        }
        return languageCode.trim().toLowerCase();
    }

    @Override
    public Locale getLocale() {
        Locale locale = Locale.US;
        try{
            locale = new Locale(getCurrentLanguageCode());
        }catch (Exception e){
            e.printStackTrace();
        }
        return locale;
    }

    @Override
    public Locale getLocale(String lang) {
        if(lang == null)
            return Locale.US;
        try {
            Locale locale = new Locale(lang.trim().toLowerCase());
            return locale;
        }catch (Exception e){
            e.printStackTrace();
            return Locale.US;
        }
    }
}
