package minesweeper;
import java.util.*;
public class Game extends Board{

        
public static void startGame(){
        
        boardGenerate();
        printBoard();
        
        boolean isTrue = true;
        
        Scanner sc = new Scanner(System.in);
        
        while(isTrue){
            System.out.println("Enter the place to break: ");
            int indexi = sc.nextInt();
            int indexj = sc.nextInt();
            
            System.out.println("Enter FLag or Open: \n 1.Flag \n 2.Open \n 3.To Exit");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    if(chara[indexi][indexj] == 'F')
                        chara[indexi][indexj] = 'X';
                    else
                        chara[indexi][indexj] = 'F';
                    printBoard();
                    break;
                case 2:
                    isTrue=Open.openBox(indexi,indexj);
                    if(isTrue){
                        printBoard();
                    }break;
                case 3:
                    isTrue=false;
                    break;
                default:
                    System.out.println("Enter valid Options..! ");
                    break;
            }
            //printBoard();
            if(isWin()){
                System.out.println("You Won The Game!");
                isTrue=false;
            }
        }
    }
    
    public static boolean isWin(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(chara[i][j]=='X')
                    return false;
                else if(board[i][j]==-1 && chara[i][j]!='F')
                    return false;
                else if(chara[i][j]=='F' && board[i][j]!=-1)
                    return false;
            }
        }
        return true;
    }
    
    public static void gameOver() {
    	for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-1)
                    System.out.print(" - ");
                else if(chara[i][j]=='X' || chara[i][j]=='F' || board[i][j]==0)
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
