package day06;
import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
	System.out.println("��ӭ����Ϸ��");
	Scanner scan=new Scanner(System.in);
	int level;
	
	do{System.out.println("��������Ϸ�ȼ���5��7��9����");
		 level=scan.nextInt();
	}while(level!=5&&level!=7&&level!=9);
        System.out.println(3333);
		char[]chs=generate(level);
		System.out.println(chs);
		System.out.println("�°�");
		
		int score;
		int count=0;
	while(true){
		System.out.println("��Ϸ��ʼ�������µ�"+level+"��ĸ�����У�exit---�˳���");
		String str=scan.next().toUpperCase();
		if(str.equals("EXIT")){
			System.out.println("�װ�");
			break;
		}
		
		char[]input=str.toCharArray();
		int[]result=check(input,chs);
		if(result[1]==level){
			score=100*level-count*10;
			System.out.println("��ϲ��������ĵ÷���"+score);
			break;
		}else{
			count++;
			System.out.println("��ĸ����"+result[0]+"λ�ö���"+result[1]);
			
		}
		
	}
	}
	
	
	public static char[]generate(int level){
		System.out.println(2111);
		char[]shc=new char[level];
		char[]letters={'A','B','C','D','E'
				,'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
				'U','V','W','X','Y','Z'};
		boolean[]flags=new boolean[letters.length];
		for(int i=0;i<shc.length;i++){
			int index; 
		do{	
		 index=(int)(Math.random()*(letters.length));
		}while(flags[index]==true);
		shc[i]=letters[index];
		flags[index]=true;
		}
		
		return shc;
	}
	
	
	
	
	
	
	
	public static int[] check(char[]input,char[]chs){
		int[]result=new int[2];
		for(int i=0;i<input.length;i++){
			for(int j=0;j<chs.length;j++){
				if(input[i]==chs[j]){
					result[0]++;
					if(i==j){
						result[1]++;
					}
					break;
				}
				
			}
		}
		return result;
	}

}
