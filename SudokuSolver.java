// sudoku
  import java.util.*;

 class Solution{

public static boolean isSafe(char[][]board, int row, int col, char dig){

    // horizontal && vertical

    for(int i =0; i<9; i++){
        if(board[row][i] == dig || board[i][col] == dig){
            return false;
        }
    }

    // gird

    int sr = (row/3) * 3;
    int sc = (col/3) * 3;

    for(int i=sr; i <=sr+2; i++){
        for(int j=sc; j<=sc+2; j++){
            if(board[i][j] == dig){
                return false;
            }
        }
    }
return true;

}


public static boolean helper(char[][]board, int row, int col ){


    if(row == 9){
        return true;
    }

    int nextrow = row;
    int nextcol = col + 1;

    if(nextcol == 9){
        nextrow = row + 1;
        nextcol =0;
    }

    if(board[row][col] != '.'){
        // board[row][col] =dig;
        //if(issafe(board, row, col))
        return helper(board, nextrow, nextcol);
    }


    // place the dig

    for(char dig='1'; dig<= '9'; dig++){
        if(isSafe(board, row, col, dig)){
            board[row][col] = dig;
            if(helper(board, nextrow, nextcol)){
            return true;
        }
        board[row][col] = '.';
        }
        
    }
    return false;

}


     


public static void solvesudoku(char [][]board){
    helper(board, 0, 0);
}

public static void main(String args[]){

    char[][]board = { 
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}          

                                             };


                            solvesudoku(board);

                            // print

                            for(int i=0; i<9; i++){
                                for(int j =0; j<9; j++){
                                    System.out.print(board[i][j] + " ");
                                }
                                System.out.println();
                            }
               }
          }
