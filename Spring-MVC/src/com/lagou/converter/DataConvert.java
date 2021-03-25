package com.lagou.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConvert implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return date;
    }
}
