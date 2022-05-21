package java8.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListNewMethods {

    public static void main(String... args){
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        System.out.println("original list = " +  String.join(",", list));
        list.removeIf(s-> s.length() > 4);
        System.out.println("after removing string of size 5 or greater = " + String.join(",", list));

        list.replaceAll(String::toUpperCase);

        System.out.println("after upper cased = " + String.join(",", list));

        list.sort(Comparator.naturalOrder());
        System.out.println("after sorting by natural order = " + String.join(",", list));
    }
}
