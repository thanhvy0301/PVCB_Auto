package seatech.common.config;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    private static Properties properties;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;

    //Lấy đường dẫn đến project hiện tại
    static String projectPath = System.getProperty("user.dir") + "/";
    //Tạo đường dẫn đến file configs.properties mặc định
    //private static String propertiesFilePathRoot = "src/main/resources/config.properties";

    public static void setPropertiesFile() {
        properties = new Properties();
        try {
            // Load properties file directly from resources
            InputStream inputStream = PropertiesFile.class.getResourceAsStream("/config.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("config.properties not found in the classpath");
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    //Xây dựng hàm Get Value từ Key của file properties đã setup bên trên
    public static String getPropValue(String KeyProp) {
        String value = null;
        try {
            //get values from properties file
            value = properties.getProperty(KeyProp);
            System.out.println(value);
            return value;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }

    //Xây dựng hàm Set Value với Key tương ứng vào trong file properties đã setup bên trên
    public static void setPropValue(String KeyProp, String Value) {
        try {
            // Load properties file
            InputStream inputStream = PropertiesFile.class.getResourceAsStream("/config.properties");
            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            } else {
                throw new FileNotFoundException("config.properties not found in the classpath");
            }
            // Update property
            properties.setProperty(KeyProp, Value);

            // Save properties file
            OutputStream outputStream = new FileOutputStream(new File(PropertiesFile.class.getResource("/config.properties").toURI()));
            properties.store(outputStream, "Set new value in properties file");
            outputStream.close();

            System.out.println("Set new value in file properties success.");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

}
