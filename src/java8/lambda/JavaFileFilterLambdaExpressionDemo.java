package java8.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class JavaFileFilterLambdaExpressionDemo {

    public static void main(String... args){
        FileFilter fileFilter = (File file) -> file.getName().endsWith(".java");
        File dir = new File("/Users/emiaun/Desktop/Projects/jdk14/src/java14");
        File[] javaFiles = dir.listFiles(fileFilter);
        Arrays.stream(javaFiles).forEach(javaFile -> System.out.println(javaFile.getName()));
    }
}
