package config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadTestData {

    static Properties prop;

    public static void loadData() throws IOException {

        prop = new Properties();

        File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/Environment.properties");
        FileReader obj = new FileReader(file);
        prop.load(obj);

    }

    public static String getKey(String data) throws IOException {
        loadData();
        data = prop.getProperty(data);
        return data;

    }

}
