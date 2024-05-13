package commonUtils;

import java.io.IOException;
import java.util.Properties;

public class ReusableUtils {
    public static String getProperty(String fileName, String key){

        Properties prop = new Properties();
        try {
            prop.load(ReusableUtils.class.getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);
    }
}
