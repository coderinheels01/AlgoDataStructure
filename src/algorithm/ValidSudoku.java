package algorithm;

import algorithm.util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /*
     * 1. populate the HashSet with number with row index if it's not already there.
     * 2. populate the HashSet with number with col index if it's not already there.
     * 3. populate the HashSet with number in the sub array (row/3, col/3) index if it's not already there.
     * 4. if any of the  above if statements are false then return false.
     * 5. otherwise return true
     *
     * https://leetcode.com/problems/valid-sudoku/
     *https://www.youtube.com/watch?v=Pl7mMcBm2b8&t=300s
     */
    public static  boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i=0; i< 9; i++){
            for(int j=0; j< 9; j++){
                char c = board[i][j];
                if(c == '8'){
                    System.out.println();
                }
                if(c == '.')
                    continue;
                if(!set.add(c + "at row" +i)|| !set.add(c + "at col" +j) || !set.add(c + "sub at row" +(i/3)+ "at col" +(j/3))){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String ...args){
        char[][]  board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printTwoDCharArray(board);
        System.out.println("is that a valid sudoku board? " + isValidSudoku(board));

       char[][] board2 = {
                  {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println("----- ORIGINAL ARRAY ----- ");
        PrintUtil.printTwoDCharArray(board2);
        System.out.println("is that a valid sudoku board? " + isValidSudoku(board2));

    }

}
