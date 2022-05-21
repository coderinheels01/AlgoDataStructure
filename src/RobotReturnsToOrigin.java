public class RobotReturnsToOrigin {

    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    /*
     * https://leetcode.com/problems/robot-return-to-origin/
     *
     * 1. have x and y axis and have them start at 0
     * 2. loop through moves input character by character
     *    1) if char is U then increment y axis by 1
     *    2) if char is D then decrement y axis by 1
     *    3) if char is L then decrement x axis by 1
     *    3) if char is R then increment x axis by 1
     * 3. return true if both x and y are still 0 at the end.
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * https://www.youtube.com/watch?v=Rz_-Kx0LN-E&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=28
     */
    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(int i=0; i< moves.length() ; i++){
            if(moves.charAt(i) == UP){
                y++;
            }
            else if(moves.charAt(i) == DOWN){
                y--;
            }
            else if(moves.charAt(i) == LEFT){
                x--;
            }
            else if(moves.charAt(i) == RIGHT){
                x++;
            }
        }

        return (x == 0 & y == 0);
    }

    public static void main(String ...args){
        String moves = "UD";
        System.out.println("DIRECTIONS OF A ROBOT " + moves);
        System.out.println("Is it back at origin? ( 0, 0 ) " + judgeCircle(moves));

        moves = "LL";
        System.out.println("DIRECTIONS OF A ROBOT " + moves);
        System.out.println("Is it back at origin? ( 0, 0 ) " + judgeCircle(moves));

    }
}
