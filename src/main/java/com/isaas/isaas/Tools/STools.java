package com.isaas.isaas.Tools;

import com.isaas.isaas.Exceptions.ISException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

public class STools {

    /**
     * Get Property from properties file
     * @param propName name
     * @return value
     */
    public static String getPropertyFromFile(String propName)throws ISException{
        InputStream inputStream;
        Properties prop = new Properties();
        try {
            inputStream = new FileInputStream(new File(System.getenv("conf.home")+"\\application.properties"));
            prop.load(inputStream);
            if(prop==null){
                throw new ISException("getProperty: Cannot open property file!");
            }
            return prop.getProperty(propName);
        } catch(Exception e){
            throw new ISException("getProperty: Cannot open property file!");
        }
    }


    public static Timestamp getTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date getDateTimestamp(){
        return new Date();
    }

}
