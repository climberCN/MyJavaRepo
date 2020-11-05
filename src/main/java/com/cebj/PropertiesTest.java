package com.cebj;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws Exception{
//        Properties prop = new Properties();
//        prop.load(PropertiesTest.class.getClassLoader().getResourceAsStream("blacklist.properties"));
//        System.out.println(prop.getProperty("CEB_OBTAIN_CARDS").length());
        String a = "ABC";
        String[] array = a.split(",");
        for (String s : array) {
            System.out.println(s);
        }
    }
}
