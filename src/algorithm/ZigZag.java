package algorithm;

public class ZigZag {

    public static void main(String... args){
        String s = "PAYPALISHIRING";
        int numRow = 4;

        System.out.println("zig-zag for string " + s + " for numRow "+ numRow+ " is " +  convertZigZagStringWithIndex(s, numRow));
        System.out.println("zig-zag for string " + s + " for numRow "+ numRow+ " is " +  convertZigZagStringWithDirection(s, numRow));

        numRow =3;
        System.out.println("zig-zag for string " + s + " for numRow "+ numRow+ " is " +  convertZigZagStringWithIndex(s, numRow));
        System.out.println("zig-zag for string " + s + " for numRow "+ numRow+ " is " +  convertZigZagStringWithDirection(s, numRow));

        numRow =1;
        System.out.println("zig-zag for string " + s + " for numRow "+ numRow+ " is " +  convertZigZagStringWithIndex(s, numRow));
        System.out.println("zig-zag for string " + s + " for numRow "+ numRow+ " is " +  convertZigZagStringWithDirection(s, numRow));
    }
    /*
     * PAYPALISHIRING
     * when numRow is 4
     * cycle = 2 * 4 -2 = 6
     * P    I   N
     * A  L S  I G
     * Y A  H R
     * P    I
     * result = PINALSINGYAHRPI
     *
     * PAYPALISHIRING
     * when numRow is 3
     * cycle = 2 * 3 -2 = 4
     *
     * P  A   H    N
     * A P L S  I I  G
     * Y   I     R
     * result = PAHNAPLSIIGYIR
     *
     * Time  O(N)
     * Space O(N)
     *
     * https://www.youtube.com/watch?v=-fFDzIWebA4&t=1215s
     *
     * https://leetcode.com/problems/zigzag-conversion/
     */
    public static String convertZigZagStringWithIndex(String s, int numRow){
        if(numRow == 1)
            return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cycle = 2 * numRow - 2;
        for(int i =0; i< numRow; i++){
            for(int j=i; j< n; j+=cycle ){
                sb.append(s.charAt(j));
                int k = j + cycle - 2*i;
                if(i != 0 && i != numRow -1 && k < n){
                    sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }
    /*
     * Time  O(N)
     * Space O(N)
     */
    public static String convertZigZagStringWithDirection(String s, int numRow){
        int n = s.length();
        int row =0;
        int direction = -1;
        StringBuilder[] sbArray = new StringBuilder[numRow];
        StringBuilder result = new StringBuilder();

        if(numRow == 1 || numRow == n)
            return s;

        for(int i=0; i< sbArray.length; i++){
            sbArray[i] = new StringBuilder();
        }

        for(int i=0; i< n;i++){
            sbArray[row].append(s.charAt(i));
            if(row == 0 || row == numRow-1)
                direction *= -1;
            row += direction;
        }
        for(StringBuilder sb : sbArray){
            result.append(sb);
        }
        return result.toString();
    }

}
