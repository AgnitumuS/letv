package oo.day04;
//T����J��Ĳ�����
public class TJTest {
	public static void main(String[] args) {
		Tetromino t = new T(2,5);
		t.print();
		
		J j = new J(0,4);
		j.print();
	}
	
	//��ǽ+��T��
	public static void printWall(Tetromino t){
		Cell[] cells = t.cells; //��ȡt�͵�cells���洢��cells������
		
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				
				boolean flag = false; //1.�����-
				for(int k=0;k<cells.length;k++){
					if(i==cells[k].row && j==cells[k].col){
						flag = true; //2.��Ϊ��*
						break;
					}
				}
				if(flag){ //3.�жϵý��
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
				
			}
			System.out.println();
		}
	}


}














