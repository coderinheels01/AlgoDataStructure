package algorithm;

public class Search2DMatrix {
    /*
     * 1. do binary search on the rows.
     *    a)initialize top and bottom pointer values. and calculate mid pointer mid = ( top + bottom )/2
     *    b) if target is less than middle row element then move bottom to mid-1.
     *    c) if target is greater than middle row element then move top to mid +1;
     *    d) otherwise break out of the loop
     * 2. calculate row using formula. row =( top + bottom) /2.
     * 3. do binary search on the cols. only for the row found above.
     *    a) initialize left and right pointer values. and calculate mid pointer mid = ( left + right )/2
     *    b) if target is equal to matrix[row][mid] then we return true.
     *    c) if target is less than matrix[row][mid] then decrement the mid by 1.
     *    d) if target is greater than matrix[row][mid] then increment the mid by 1.
     *
     * Time Complexity : O(log m  + log n) = O(log n)
     * Space Complexity : O(1)
     *
     * https://leetcode.com/problems/search-a-2d-matrix/
     * https://www.youtube.com/watch?v=Ber2pi2C0j0
     *
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        int top =0; int bottom = rows;

        while(top <= bottom){
            int mid = (top + bottom)/2;

            if(target < matrix[mid][0] ){
                bottom = mid -1;
            }
            else if (target >matrix[mid][0] ){
                top = mid+1;
            }
            else{
                break;
            }
        }

        int row = (top + bottom)/2;

        int left = 0; int right = cols;

        while(left <= right){
            int mid = (left + right) /2;
            if(matrix[row][mid] == target)
                return true;
            else if( target < matrix[row][mid] ){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        return false;
    }


    public static void main(String ...args){
        int[][] matrix = {{1,3,5,7},
                          {10,11,16,20}
                         ,{23,30,34,60}};

        int target = 3;
        System.out.println("found the number + " + target + " in the matrix. " + searchMatrix(matrix, target) );

        target = 16;
        System.out.println("found the number + " + target + " in the matrix. " + searchMatrix(matrix, target) );

        target = 60;
        System.out.println("found the number + " + target + " in the matrix. " + searchMatrix(matrix, target) );
    }
}
