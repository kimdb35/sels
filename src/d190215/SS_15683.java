package d190215;


import java.util.Scanner;

public class SS_15683 {
	
	static int[][] room;
	static int[][] tempRoom;
	static int[][] testRoom;
	static int[][] cameraDir = new int[8][7];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int width = sc.nextInt();
		int cCnt = 0;
		int temp = 100;
		int[][] cam2Room = new int[height][width];
		int[][] cam3Room = new int[height][width];
		int[][] cam4Room = new int[height][width];
		int[][] cam5Room = new int[height][width];
		int[][] cam6Room = new int[height][width];
		int[][] cam7Room = new int[height][width];
		int[][] cam8Room = new int[height][width];
		
		room = new int[height][width];
		tempRoom = new int[height][width];
		testRoom = new int[height][width];
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				room[i][j] = sc.nextInt();
				tempRoom[i][j] = room[i][j];
			}
		}
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(room[i][j]!=0 && room[i][j]!=6) {
					cameraDir[cCnt][4] = i;
					cameraDir[cCnt][5] = j;
					cameraDir[cCnt][6] = room[i][j];
					cCnt++;
				}
			}
		}
		
		int a1 = cCnt>=1 ? 4 : 1;
		int a2 = cCnt>=2 ? 4 : 1;
		int a3 = cCnt>=3 ? 4 : 1;
		int a4 = cCnt>=4 ? 4 : 1;
		int a5 = cCnt>=5 ? 4 : 1;
		int a6 = cCnt>=6 ? 4 : 1;
		int a7 = cCnt>=7 ? 4 : 1;
		int a8 = cCnt>=8 ? 4 : 1;
		
		boolean rb2 = a2==4?true:false;
		boolean rb3 = a3==4?true:false;
		boolean rb4 = a4==4?true:false;
		boolean rb5 = a5==4?true:false;
		boolean rb6 = a6==4?true:false;
		boolean rb7 = a7==4?true:false;
		boolean rb8 = a8==4?true:false;
		
		for(int aa8=0; aa8<a8; aa8++) {
			changeZtoS(cameraDir[7][6], aa8, cameraDir[7][4], cameraDir[7][5]);
			if(a8>1) roomSave(cam8Room);
			for(int aa7=0; aa7<a7; aa7++) {
				changeZtoS(cameraDir[6][6], aa7, cameraDir[6][4], cameraDir[6][5]);
				if(a7>1) roomSave(cam7Room);
				for(int aa6=0; aa6<a6; aa6++) {
					changeZtoS(cameraDir[5][6], aa6, cameraDir[5][4], cameraDir[5][5]);
					if(a6>1) roomSave(cam6Room);
					for(int aa5=0; aa5<a5; aa5++) {
						changeZtoS(cameraDir[4][6], aa5, cameraDir[4][4], cameraDir[4][5]);
						if(a5>1) roomSave(cam5Room);
						for(int aa4=0; aa4<a4; aa4++) {
							changeZtoS(cameraDir[3][6], aa4, cameraDir[3][4], cameraDir[3][5]);
							if(a4>1) roomSave(cam4Room);
							for(int aa3=0; aa3<a3; aa3++) {
								changeZtoS(cameraDir[2][6], aa3, cameraDir[2][4], cameraDir[2][5]);
								if(a3>1) roomSave(cam3Room);
								for(int aa2=0; aa2<a2; aa2++) {
									changeZtoS(cameraDir[1][6], aa2, cameraDir[1][4], cameraDir[1][5]);
									if(a2>1) roomSave(cam2Room);
									for(int aa1=0; aa1<a1; aa1++) {
										changeZtoS(cameraDir[0][6], aa1, cameraDir[0][4], cameraDir[0][5]);
										int zero = countZero(height, width);
										if(temp > zero) {
											temp = zero;
											for(int i=0; i<height; i++) {
												for(int j=0; j<width; j++) {
													testRoom[i][j] = tempRoom[i][j];
												}
											}
										}
										if(a1>1) roomReset(cam2Room, rb2);
									}
									if(a2>1) roomReset(cam3Room, rb3);
								}
								if(a3>1) roomReset(cam4Room, rb4);
							}
							if(a4>1) roomReset(cam5Room, rb5);
						}
						if(a5>1) roomReset(cam6Room, rb6);
					}
					if(a6>1) roomReset(cam7Room, rb7);
				}
				if(a7>1) roomReset(cam8Room, rb8);
			}
			if(a8>1) roomReset(null, false);
		}
		
		System.out.println(temp);
		
		sc.close();
	}
	
	static void roomReset(int[][] arr, boolean isValid) {
		if(arr!=null && isValid) {
			for(int i=0;i<arr.length; i++) {
				for(int j=0;j<arr[0].length;j++) {
					tempRoom[i][j] = arr[i][j];
				}
			}
		} else {
			for(int i=0;i<room.length; i++) {
				for(int j=0;j<room[0].length;j++) {
					tempRoom[i][j] = room[i][j];
				}
			}
			
		}
	}
	
	static void roomSave(int[][] arr) {
		for(int i=0;i<arr.length; i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = tempRoom[i][j];
			}
		}
	}
	
	
	static int countZero(int r, int c) {
		int countZero = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(tempRoom[i][j]==0) countZero++;
			}
		}
		
		return countZero;
	}
	
	static void changeZtoS(int cType, int dir, int curRow, int curCol) {
		switch(cType) {
			case 1:
				switch(dir) {
					case 0:
						for(int r=curRow; r>=0; r--) {
							if(tempRoom[r][curCol]==6) break;
							tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
						}
						break;
					case 1:
						for(int r=curRow; r<room.length; r++) {
							if(tempRoom[r][curCol]==6) break;
							tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
						}
						break;
					case 2:
						for(int c=curCol; c>=0; c--) {
							if(tempRoom[curRow][c]==6) break;
							tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
						}
						break;
					case 3:
						for(int c=curCol; c<room[0].length; c++) {
							if(tempRoom[curRow][c]==6) break;
							tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
						}
						break;
				}
				break;
			case 2:
				switch(dir) {
					case 0:
					case 1:
						for(int r=curRow; r>=0; r--) {
							if(tempRoom[r][curCol]==6) break;
							tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
						}
						for(int r=curRow; r<room.length; r++) {
							if(tempRoom[r][curCol]==6) break;
							tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
						}
						break;
					case 2:
					case 3:
						for(int c=curCol; c>=0; c--) {
							if(tempRoom[curRow][c]==6) break;
							tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
						}
						for(int c=curCol; c<room[0].length; c++) {
							if(tempRoom[curRow][c]==6) break;
							tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
						}
						break;
				}
				break;
			case 3:
				switch(dir) {
				case 0:
					for(int r=curRow; r>=0; r--) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					for(int c=curCol; c>=0; c--) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					break;
				case 1:
					for(int c=curCol; c>=0; c--) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					for(int r=curRow; r<room.length; r++) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					break;
				case 2:
					for(int r=curRow; r<room.length; r++) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					for(int c=curCol; c<room[0].length; c++) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					break;
				case 3:
					for(int c=curCol; c<room[0].length; c++) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					for(int r=curRow; r>=0; r--) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					break;
			}
				break;
			case 4:
				switch(dir) {
				case 0:
					for(int c=curCol; c>=0; c--) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					for(int r=curRow; r>=0; r--) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					for(int c=curCol; c<room[0].length; c++) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					break;
				case 1:
					for(int r=curRow; r<room.length; r++) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					for(int r=curRow; r>=0; r--) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					for(int c=curCol; c<room[0].length; c++) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					break;
				case 2:
					for(int c=curCol; c>=0; c--) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					for(int r=curRow; r>=0; r--) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					for(int r=curRow; r<room.length; r++) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					break;
				case 3:
					for(int c=curCol; c<room[0].length; c++) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					for(int r=curRow; r<room.length; r++) {
						if(tempRoom[r][curCol]==6) break;
						tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
					}
					for(int c=curCol; c>=0; c--) {
						if(tempRoom[curRow][c]==6) break;
						tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
					}
					break;
			}
				break;
			case 5:
				for(int r=curRow; r>=0; r--) { 
					if(tempRoom[r][curCol]==6) break;
					tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
				}
				for(int c=curCol; c<room[0].length; c++) {
					if(tempRoom[curRow][c]==6) break;
					tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
				}
				for(int r=curRow; r<room.length; r++) { 
					if(tempRoom[r][curCol]==6) break;
					tempRoom[r][curCol]=tempRoom[r][curCol]==0?7:tempRoom[r][curCol];
				}
				for(int c=curCol; c>=0; c--) { 
					if(tempRoom[curRow][c]==6) break;
					tempRoom[curRow][c]=tempRoom[curRow][c]==0?7:tempRoom[curRow][c];
				}
				break;
		}
	}
	
}
