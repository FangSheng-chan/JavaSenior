package com.ss.springwell.config;

import org.apache.commons.logging.Log;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author fangsheng
 * @date 2021/5/13 10:32 上午
 */
@Component
public class Sysconfig {

    private static final String PROPERTIES_FILE_PATH = "sysconfig.properties";

    public void getConfig() {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties(PROPERTIES_FILE_PATH);
            System.out.println(properties.get("version_num"));
            System.out.println(properties.get("svm_model_folder"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Sysconfig sysconfig = new Sysconfig();
        sysconfig.getConfig();
    }
}
