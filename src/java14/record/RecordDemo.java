package java14.record;

import java.time.Duration;

/**
 * Record ( preview feature of java 14 )
 * key points :
 *      1. Record is used when we want to simply represent immutable data where as Objects have setters and getters
 *         hence they are not immutable
 *      2. Records automatically generate constructors, setters and getters, hashcode and equal functions. We don't
 *         need to explicitly define them. Hence no boilerplate code that we need to otherwise write manulally if we were to use Objects
 *      3. We can add validation we need by simply declaring custom validation inside.
 *         for example:
 *            public Course {
 *                if(rating > 5 )
 *                   throws new IllegalArgumentException();
 *            }
 *
 */
public class RecordDemo {
    public static void main(String... args){
        Course course1 = new Course("What's new in java 14", Duration.ofHours(2), 5);
        System.out.println("course1: " + course1);
        Course course2 = new Course("What's new in java 14", Duration.ofHours(2), 5);
        System.out.println("course2: " + course2);

        System.out.print("course1 and course2 same objects ? ");
        System.out.println(course1 == course2);

        System.out.print("course1 and course2 have same values ? ");
        System.out.println(course1.equals(course2));

        System.out.println("testing out validation.The line below should throws IllegalArgumentException because rating can't be more 5");
        Course course3 = new Course("What's new in java 14", Duration.ofHours(2), 6);
    }
}
