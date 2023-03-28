package src.com.atguigu.java1;

/**
 * @author shkstart
 * @create 2020 上午 10:59
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {

            ClassLoader classLoader3 = String.class.getClassLoader();
            System.out.println(classLoader3);

            //1.
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            //2.
            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            //3.
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
            System.out.println(classLoader2);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
