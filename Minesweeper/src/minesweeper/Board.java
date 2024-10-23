package minesweeper;
import java.util.*;

public class Board{
	public static int n=10;
    public static int flag=n;
    public static int[][] board = new int[n][n];
    
    public static int[][] boardGenerate(){
        
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        
        int iter = -1;
        for(int i=0;i<n;i++){
            array.add(new ArrayList<Integer>());
            iter=-1;
            for(int j=0;j<n;j++){
                array.get(i).add(iter);
                iter=0;
            }
        }
        
        for(int i=0;i<n;i++)
            Collections.shuffle(array.get(i));
        //System.out.println(arr);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = array.get(i).get(j);
                //fillNa(i,j,board);
            }
        }
        fillNumber();
        
        return board;
    }
    
    
    public static int[][] fillNumber(){
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == -1){
                    board = fillPlaces(i,j,board);
                }
            }
        }
        //printBoard();
        return board;
    }

    
    public static int[][] fillPlaces(int a,int b,int[][] board){
            
        int up=1,down=1,right=1,left=1;
        
        if(a==0)
            up=0;
        if(a==n-1)
            down=0;
        if(b==0)
            left=0;
        if(b==n-1)
            right=0;
        
        for(int i=a-up;i<=a+down;i++){
            for(int j=b-left;j<=b+right;j++){
                if(board[i][j]!=-1)
                    board[i][j]++;
            }
        }
        hide();
        return board;
    }
    
    public static char[][] chara = new char[n][n];
    
    public static char[][] hide(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chara[i][j] = 'X';
            }
        }
        return chara;
    }
    
    
    public static void printBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(chara[i][j]=='X' || chara[i][j]=='F' || board[i][j]==0)
                    System.out.print(" "+chara[i][j]+" ");
                else
                    System.out.print(" "+board[i][j]+" ");
            }/*System.out.print("  ");
            for(int k=0;k<n;k++){
                System.out.print(board[i][k]+" ");
            }*/
            System.out.println();
        }
    }
}
