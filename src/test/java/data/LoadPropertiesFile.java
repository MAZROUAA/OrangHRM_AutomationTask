package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFile {
    public static Properties userData=LoadProperties("src/test/java/data/UserData.properties");

    private static Properties LoadProperties(String path)
    {
        Properties pro=new Properties();
        //stream for reading file
        try {
            FileInputStream stream=new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occured "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occured "+e.getMessage());
        }
        return pro;
    }

}
