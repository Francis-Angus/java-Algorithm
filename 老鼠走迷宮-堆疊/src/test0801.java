import java.io.*;
/* test0801 小老鼠走迷宮-stack堆疊
 * 
 * 1.當走到死路用stack回到之前的岔路
 * 2.走過的地會用2來表示當作已經走過
 * 3.x、y軸跟一般的x、y不一樣，是[x][y]
 * 4.修改範例程式的小bug
 * 	1.while(x<=ExitX && y<ExitY) 改成while(true)
 * 	2.多加	top=0; stack[top][0]=x; stack[top][1]=y;
 * 
 * */

public class test0801 {
	public static int ExitX=2;
	public static int ExitY=8;
	public static int stack[][] = new int[30][2]; 
	public static int top=-1; //堆疊指標
	public static int [][] MAZE= {{1,1,1,1,1,1,1,1,1,1,1,1},
								  {1,0,0,0,0,0,0,1,1,1,1,1},
								  {1,0,1,0,1,1,0,1,0,0,0,1},
								  {1,0,1,0,1,1,0,1,1,1,0,1},
								  {1,0,1,0,0,0,0,1,1,1,0,1},
								  {1,0,1,0,1,1,0,0,0,1,0,1},
								  {1,0,1,0,1,1,0,1,1,1,0,1},
								  {1,0,1,1,1,1,0,1,1,1,0,1},
								  {1,0,0,0,1,0,0,0,0,0,0,1},
								  {1,1,1,1,1,1,1,1,1,1,1,1}};

	public static void main(String[] args)throws IOException {
		int x=1,y=1;
			
		System.out.println("[迷宮(0代表可以走)]");
		for(int i=0;i<MAZE.length;i++) {
			for(int j=0;j<MAZE[0].length;j++) {
				System.out.print(MAZE[i][j]);
			}
			System.out.println();
		}
		
		top=0; //先存入，不然會回不到原點
		stack[top][0]=x;
		stack[top][1]=y;
		
		while(true)
		{
			MAZE[x][y]=2;
			if(walk(x,y)){ //新增到堆疊
				x=stack[top][0];
				y=stack[top][1];
				
				
			}else if(x==ExitX && y==ExitY) { //到終點離開
				MAZE[x][y]=3;
				break;
				
			}else //遇到死路往回退
			{
				top--;
				x=stack[top][0];
				y=stack[top][1];
			}
		}
		
		System.out.println("[迷宮(2代表走過了，3代表到終點)]");
		for(int i=0;i<MAZE.length;i++) {
			for(int j=0;j<MAZE[0].length;j++) {
				System.out.print(MAZE[i][j]);
			}
			System.out.println();
		}
		
	}
	public static boolean walk(int x,int y)
	{
		if(MAZE[x+1][y] == 0) //上
			x++;
	
		else if(MAZE[x-1][y] == 0) //下
			x--;
			
		else if(MAZE[x][y+1] == 0)  //左
			y++;
			
		else if(MAZE[x][y-1] == 0)  //右
			y--;
			
		else 
			return false;
		
		top++;
		stack[top][0]= x;
		stack[top][1]= y;
		
		return true;
	}

}


