package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesLoader
{
    private PropertiesLoader()
    {
        throw new IllegalStateException( "Utility class" );
    }

    public static List<String> getProperties()
            throws IOException
    {
        FileReader reader = new FileReader("test.properties");

        Properties p = new Properties();
        p.load(reader);
        String email = p.getProperty("email");
        String pas = p.getProperty("password");
        List<String> list = new ArrayList<>( Arrays.asList( email, pas ) );
        return list;
    }
}
