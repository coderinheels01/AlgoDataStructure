package algorithm;

public class BadVersion {
    private static boolean isBadVersion(int n){
        return n >= 3;
    }

    /*
     * https://www.youtube.com/watch?v=86SBizUsbGY&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=20
     */
    public static int firstBadVersion(int n){
        int left = 0;
        int right = n;

        while(left < right){
            int mid = left + (right - left )/2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        if(left == right && isBadVersion(left))
            return left;

        return -1;
    }
    public static void main(String ...args){
        System.out.println("first bad version is : " +  firstBadVersion(10));
    }
}
