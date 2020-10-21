/**
 * @author liyuke
 * @date 2020-10-20 22:30
 */

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Arrays;

public class MyClassLoader extends ClassLoader {
    /**
     * This method should be overridden by class loader implementations
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String classFilename = name + ".xlass";
        File classFile = new File(classFilename);
        if (classFile.exists()) {
            byte[] b = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(classFile);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int length;
                while ((length = fileInputStream.read(b)) != -1) {
                    outputStream.write(b);
                }
                b = outputStream.toByteArray();
                outputStream.close();
                fileInputStream.close();

                for (int i = 0; i < b.length; i++) {
                    b[i] = (byte) (255 - b[i]);
                }
                clazz = defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.loadClass(args[0]);
        Object obj = clazz.newInstance();
        Method hello = clazz.getMethod("hello");
        hello.invoke(obj);
    }
}