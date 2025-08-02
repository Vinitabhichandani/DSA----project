
import java.util.*;

class Solution{

    public static boolean issafe(char[][]board, int row, int col){
int n = board.length;

        // first try horizontal and vertical

        for(int i=0; i<n; i++){
            if(board[row][i] == 'Q' || board[i][col] == 'Q'){
                return false;
            }
        }

        // upre left

        for(int r =row, c = col; r>=0 && c>=0; r--,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }


        // uper right
        for(int r =row, c = col; r>=0 && c<n; r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower left

        for(int r = row, c = col; r<n && c>=0; r++, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower right

        for(int r = row, c = col; r<n && c<n; r++,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    
    public static void helper(char[][]board, List<List<String>> allboard, int col){

int n = board.length; 

        if(col == n){ // ahi apne chees board e col per depend kare che apne col wise kam karishu
             saveboard(board, allboard);
             return;
        }


        for(int row =0; row<n; row++){
            if(issafe(board, row, col)){
                board[row][col] = 'Q';
                helper(board, allboard, col + 1);
                board[row][col] = '.';
            }
        }
    }


    public static void saveboard(char[][]board, List<List<String>> allboard){ // boad 
int n = board.length;
        List<String> newboard = new ArrayList<>();
        for(int i=0; i<n; i++){
            String row = "";
            for(int j=0; j<n; j++){
                row += board[i][j];
            }
            newboard.add(row);
        }
        allboard.add(newboard);
     }

     public static List<List<String>> solveNQueens(int n){ // allboard

        List<List<String>> allboard = new ArrayList<>();
        char[][] board = new char[n][n]; // apne chess board ne 2d Array banav ta te simple they che
        helper(board, allboard, 0); // starting col e 0 thi

        return allboard;
     }

     public static void main(String args[]){

        int n = 7;

        List<List<String>> result = solveNQueens(n);
        for(List<String> board : result){
            for(String row : board){
            System.out.println(row);
        }
        System.out.println();
     }
    }
}








    




