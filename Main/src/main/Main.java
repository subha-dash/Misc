package main;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by sdash on 13/8/16.
 */
public class Main {

    public static void main(String[] args) {
        try {
            URL basePath = new URL("file:///Apps/java-works/Misc/out/production/Main/");

            Object instance = getClassInstance(Singleton.class);
            System.out.println(instance);
            //
            Object instance2 = getClassInstance(
                    new URLClassLoader(new URL[]{basePath}, null)
                            .loadClass("main.Singleton")
            );
            System.out.println(instance2);
            //
            Object instance3 = getClassInstance(
                    new URLClassLoader(new URL[]{basePath}, null)
                            .loadClass("main.Singleton")
            );
            System.out.println(instance3);

            // Only the 1st cast is ok
            Singleton testCast1 = (Singleton) instance;
            System.out.println("1st cast ok");
            Singleton testCast2 = (Singleton) instance2;
            System.out.println("2nd cast ok");
            Singleton testCast3 = (Singleton) instance3;
            System.out.println("3rd cast ok");
        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static Object getClassInstance(Class clazz) throws Exception {
        Method method = clazz.getMethod("getInstance");
        method.setAccessible(true);
        return method.invoke(null);
    }
}
