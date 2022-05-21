package algorithm;

public class IntegerPalindrome {

    public static void main(String... args){
        int num = 121;
        System.out.println("Is number " + num + " palindrome? " + checkPalindrome(num));
        num = 1221;
        System.out.println("Is number " + num + " palindrome? " + checkPalindrome(num));
        num = -121;
        System.out.println("Is number " + num + " palindrome? " + checkPalindrome(num));
        num = 10;
        System.out.println("Is number " + num + " palindrome? " + checkPalindrome(num));
        num = -110;
        System.out.println("Is number " + num + " palindrome? " + checkPalindrome(num));
        num = -2147483648;
        System.out.println("Is number " + num + " palindrome? " + checkPalindrome(num));
        num = 123;
        System.out.println("Is number " + num + " palindrome? " + checkPalindrome(num));
    }

    public static boolean checkPalindrome(int num){
        if(num == 0)
            return true;
        if(num < 0 || (num % 10) == 0)
            return false;
        int reversed = 0;

        while(num > reversed){
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }
        return (reversed == num ) || (reversed/10 == num) ;
    }

}
