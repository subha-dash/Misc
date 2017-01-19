package main;

/**
 * Created by sdash on 13/8/16.
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private Singleton() {
        Exception e = new Exception();
        StackTraceElement[] stackTrace = e.getStackTrace();
        if (!"<clinit>".equals(stackTrace[1].getMethodName())) {
            throw new IllegalStateException("You shall not instanciate the Singleton twice !",e);
        }
    }

    public void sayHello() {
        System.out.println("Hello World ! " + this);
    }

}
