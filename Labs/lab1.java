package secondyear;

import java.util.Scanner;

public class lab1 {
	int[][] board;
	public static final int EMPTY=0;
	int currentPlayer;
	int X=1,O=-1;
	
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		lab1 game=new lab1();
		
		while(!game.isWinner()) {
			System.out.print("Enter cordinat x:");
			int numx=scan.nextInt();
			System.out.print("Enter cordinat y:");
			int numy=scan.nextInt();
			game.putMark(numx,numy);
			game.printBoard();
			
			if(!game.isAvailablePosition())
				break;
		}
		System.out.println("Game finished.");
	}
	
	public lab1(){
		board=new int[3][3];
		this.currentPlayer=X;
	}
	
	
	void putMark(int x,int y) {
		if(isEmpty(x,y)) 
			board[x][y]=currentPlayer;
			if(currentPlayer==O)
				currentPlayer=X;
			else
				currentPlayer=O;
	}
	
	boolean isEmpty(int x,int y) {
		if(board[x][y]==0)
			return true;
		return false;
	}
	
	void clearBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				board[i][j]=0;
			}
		}
	}
	
	boolean isAvailablePosition() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==0)
					return true;
			}
		}
		return false;
	}
	
	boolean isWinner() {
		int[] conditions=new int[8];
		for(int i=0;i<board.length;i++) {
			conditions[0]+=board[0][i];
			conditions[1]+=board[1][i];
			conditions[2]+=board[2][i];
			conditions[3]+=board[i][0];
			conditions[4]+=board[i][1];
			conditions[5]+=board[i][2];
			conditions[6]+=board[i][i];
		}
		conditions[7]+=board[2][0]+board[1][1]+board[0][2];
		
		for(int i=0;i<conditions.length;i++) {
			if(conditions[i]==3 || conditions[i]==-3) 
				return true;
		}
		return false;
	}
	
	void printBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==1)
					System.out.print("X ");
				else if(board[i][j]==-1)
					System.out.print("O ");
				else
					System.out.print("- ");
			}
			System.out.println("");
		}
	}
	
	
	
	
	
	
	
	

}
