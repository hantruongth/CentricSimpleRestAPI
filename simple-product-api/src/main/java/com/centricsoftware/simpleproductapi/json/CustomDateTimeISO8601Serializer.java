package com.centricsoftware.simpleproductapi.json;

import com.centricsoftware.simpleproductapi.constant.ApplicationConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author hantruong
 */
public class CustomDateTimeISO8601Serializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        DateFormat df = new SimpleDateFormat(ApplicationConstants.DATA_TIME_ISO_8601_FORMAT, Locale.US);
        jsonGenerator.writeString(df.format(date));
    }
}
