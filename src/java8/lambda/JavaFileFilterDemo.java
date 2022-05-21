package java8.lambda;

import java.io.File;
import java.util.Arrays;

public class JavaFileFilterDemo {
    public static void main(String... args){
        JavaFileFilter fileFilter = new JavaFileFilter();
        File dir = new File("/Users/emiaun/Desktop/Projects/jdk14/src/java14");
        File[] javaFiles = dir.listFiles(fileFilter);
        Arrays.stream(javaFiles).forEach(javaFile -> System.out.println(javaFile.getName()));
    }
}
