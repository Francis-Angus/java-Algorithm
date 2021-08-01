import java.io.*;
/* test0801 �p�ѹ����g�c-stack���|
 * 
 * 1.���즺����stack�^�줧�e���ø�
 * 2.���L���a�|��2�Ӫ�ܷ�@�w�g���L
 * 3.x�By�b��@�몺x�By���@�ˡA�O[x][y]
 * 4.�ק�d�ҵ{�����pbug
 * 	1.while(x<=ExitX && y<ExitY) �令while(true)
 * 	2.�h�[	top=0; stack[top][0]=x; stack[top][1]=y;
 * 
 * */

public class test0801 {
	public static int ExitX=2;
	public static int ExitY=8;
	public static int stack[][] = new int[30][2]; 
	public static int top=-1; //���|����
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
			
		System.out.println("[�g�c(0�N��i�H��)]");
		for(int i=0;i<MAZE.length;i++) {
			for(int j=0;j<MAZE[0].length;j++) {
				System.out.print(MAZE[i][j]);
			}
			System.out.println();
		}
		
		top=0; //���s�J�A���M�|�^������I
		stack[top][0]=x;
		stack[top][1]=y;
		
		while(true)
		{
			MAZE[x][y]=2;
			if(walk(x,y)){ //�s�W����|
				x=stack[top][0];
				y=stack[top][1];
				
				
			}else if(x==ExitX && y==ExitY) { //����I���}
				MAZE[x][y]=3;
				break;
				
			}else //�J�즺�����^�h
			{
				top--;
				x=stack[top][0];
				y=stack[top][1];
			}
		}
		
		System.out.println("[�g�c(2�N���L�F�A3�N�����I)]");
		for(int i=0;i<MAZE.length;i++) {
			for(int j=0;j<MAZE[0].length;j++) {
				System.out.print(MAZE[i][j]);
			}
			System.out.println();
		}
		
	}
	public static boolean walk(int x,int y)
	{
		if(MAZE[x+1][y] == 0) //�W
			x++;
	
		else if(MAZE[x-1][y] == 0) //�U
			x--;
			
		else if(MAZE[x][y+1] == 0)  //��
			y++;
			
		else if(MAZE[x][y-1] == 0)  //�k
			y--;
			
		else 
			return false;
		
		top++;
		stack[top][0]= x;
		stack[top][1]= y;
		
		return true;
	}

}


