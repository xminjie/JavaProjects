package factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ObjectFactory {
    private static HashMap<String, Object> m = new HashMap<>();

    static {
        BufferedReader br;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src/object.txt")));

            String str;
            while ((str = br.readLine()) != null) {
                String[] s = str.split("=");
                m.put(s[0], Class.forName(s[1]).getDeclaredConstructor().newInstance());
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException |
                InstantiationException | NoSuchMethodException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public static Object getObject(String key) {
        return m.get(key);
    }

    public static void main(String[] args) {
        HashMap<String, Object> mm = new HashMap<String, Object>();

        for (String s : ObjectFactory.m.keySet()) {
            System.out.println(s + " " + ObjectFactory.m.get(s).toString());
        }
    }
}
