package com.cebj.flink.util;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

    public static Properties readConf(String path) {
        try {
            Properties props = new Properties();
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(path)));
            props.load(input);
            return props;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("path not exits", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
