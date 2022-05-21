package java14.record;

import java.time.Duration;

public record Course(String courseName, Duration duration, Integer rating) {

    //this is the validation feature of the record "Course". If the rating is more than 5 it will throw IllegalArgumentException
    public Course{
        if(rating > 5)
            throw new IllegalArgumentException();
    }
}
