package oo.day03;
//T����J��Ĳ�����
public class TJTest {
	public static void main(String[] args) {
		Tetromino o1 = new T(2,5); //��������
		printWall(o1); //�����ͺ�ֵ
		
		J o2 = new J(1,7);
		printWall(o2); //��ֵ��ͬʱ�Զ�����
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














