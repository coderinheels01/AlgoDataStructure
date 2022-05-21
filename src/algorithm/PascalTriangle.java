package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /*
     * https://www.youtube.com/watch?v=icoql2WKmbA&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=2
     * https://www.youtube.com/watch?v=VJBUH3chC64
     *
     * Generate a pascal tree.
     *
     * Time Complexity : O(N^2)
     * Space Complexity : O(N^2)
     */
    public static List<List<Integer>> buildPascalTriangle(int number){
        List<List<Integer>> pascalTriangle =  new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalTriangle.add(firstRow);


        for(int i = 1; i < number; i++){
            List<Integer> previousRow = pascalTriangle.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j < i; j++){
                row.add(previousRow.get(j-1) + previousRow.get(j));
            }
            row.add(1);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
    public static void main(String ...args){
        List<List<Integer>> pascalTriangle = buildPascalTriangle(5);

        for(List<Integer> list: pascalTriangle){
            System.out.println(list);
        }

    }
}
