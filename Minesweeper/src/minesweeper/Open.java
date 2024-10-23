package minesweeper;

public class Open extends Game{
	public static boolean openBox(int a,int b){
        switch(board[a][b]){
            case -1:
                gameOver();
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
            
        return board;
        
    }
}
