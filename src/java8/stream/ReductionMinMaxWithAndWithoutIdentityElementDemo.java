package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionMinMaxWithAndWithoutIdentityElementDemo {
    public static void main(String... args){
        List<Integer> list = Arrays.asList(1);

        System.out.println("*** Min operation with identity element ***");
        int min = list.stream().reduce(0, Integer::min);
        System.out.println("*** This should return 1 because the java8.list has only one element(1) but it returns identity element 0 ***" );
        System.out.println("result = " + min );
        System.out.println("*** But if you don't pass the identity element, it will return Optional<Integer> with correct value ***");
        Optional<Integer> minOptional = list.stream().reduce(Integer::min);
        System.out.println("result = " + minOptional.get() );


        list = Arrays.asList(-1);

        System.out.println("\n\n*** Max operation with identity element ***");
        int max = list.stream().reduce(0, Integer::max);
        System.out.println("*** This should return -1 because the java8.list has only one element(-1) but it returns identity element 0 ***");
        System.out.println("result = " + max);
        System.out.println("*** But if you don't pass the identity element, it will return Optional<Integer> with correct value ***");
        Optional<Integer> maxOptional = list.stream().reduce(Integer::max);
        System.out.println("result = " + maxOptional.get() );

        System.out.println("\n\n*** If you pass empty java8.list the result will be Optioanl with empty  ***");
        list = Arrays.asList();
        Optional<Integer> emptyOptional = list.stream().reduce(Integer::max);
        System.out.println("result = " + emptyOptional );

    }
}
