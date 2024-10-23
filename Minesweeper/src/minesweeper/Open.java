package minesweeper;

public class Open extends Game{
	public static boolean openBox(int a,int b){
        switch(board[a][b]){
            case -1:
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
                System.out.println("Game Over..!! ");
                return false;
            case 0:
                openEmptys(a,b);
                break;
            default:
                chara[a][b] = ' ';          
        }
        return true;
    }
    
    /*public static int[][] visited = new int[n][n];
    
    public static int[][] initializevisited(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = 0; 
            }
        }
        return visited;
    }*/
    
    public static int[][] openEmptys(int a,int b){
        int up=1,down=1,left=1,right=1;
        
        if(a==0)
            up=0;
        if(a==n-1)
            down=0;
        if(b==0)
            left=0;
        if(b==n-1)
            right=0;

        if(board[a][b]==0){
            
            board[a][b]=10;
            chara[a][b]=' ';
            openEmptys(a-up,b-left);
            chara[a-up][b-left]=' ';
            openEmptys(a-up,b);
            chara[a-up][b]=' ';
            openEmptys(a-up,b+right);
            chara[a-up][b+right]=' ';
            openEmptys(a,b+right);
            chara[a][b+right]=' ';
            openEmptys(a+down,b+right);
            chara[a+down][b+right]=' ';
            openEmptys(a+down,b);
            chara[a+down][b]=' ';
            openEmptys(a+down,b-left);
            chara[a+down][b-left]=' ';
            openEmptys(a,b-left);
            chara[a][b-left]=' ';
            board[a][b]=0;
        }else{
            return board;
        }
            /*openEmptys(a-1,b-1);
            openEmptys(a-1,b);
            openEmptys(a-1,b+1);
            openEmptys(a,b+1);
            openEmptys(a+1,b);
            openEmptys(a+1,b-1);
            openEmptys(a,b-1);*/
        return board;
        
    }
}
