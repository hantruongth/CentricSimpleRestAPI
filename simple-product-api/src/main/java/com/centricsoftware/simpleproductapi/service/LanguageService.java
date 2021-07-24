package com.centricsoftware.simpleproductapi.service;

import java.util.Locale;
/**
 * @author hantruong
 */
public interface LanguageService {
    Locale getLocale();
    Locale getLocale(String lang);
    String getCurrentLanguageCode();
}
