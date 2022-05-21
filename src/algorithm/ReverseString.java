package algorithm;

public class ReverseString {
    /*
     * https://www.youtube.com/watch?v=P68JPXtFyYg
     */
    public static void main(String... args){
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println("Original string = " + new String(input));
        System.out.println("----- METHOD 1 ( Iterative )----- ");
        reverseStringIterative(input);
        System.out.println("Reversed string = " + new String(input));
        input = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println("\nOriginal string = " + new String(input));
        System.out.println("----- METHOD 2 ( Recursive )----- ");
        reverseStringRecursive(input);
        System.out.println("Reversed string = " + new String(input));
    }

    public static void reverseStringIterative(char[] input){
        int i =0;
        int j = input.length-1;
        char temp;

        while(i < j){
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;

            i++;
            j--;
        }
    }

    public static void reverseStringRecursive(char[] input){
        reverse(input, 0 , input.length-1);
    }
    private static void reverse(char[] input, int i, int j){
        if(i >= input.length/2 ) return;
        swap(input, i, j);
        reverse(input, i+1, j-1);
    }
    private static void swap(char[] input, int i, int j){
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
