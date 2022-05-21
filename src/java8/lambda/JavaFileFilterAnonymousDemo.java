package java8.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class JavaFileFilterAnonymousDemo {

    public static void main(String... args){
        FileFilter javaFileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        File dir = new File("/Users/emiaun/Desktop/Projects/jdk14/src/java14");
        File[] javaFiles = dir.listFiles(javaFileFilter);

        Arrays.stream(javaFiles).forEach(javaFile -> System.out.println(javaFile.getName()));
    }
}
