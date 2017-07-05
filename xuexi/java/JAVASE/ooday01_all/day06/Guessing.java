package day06;
import java.util.Scanner;
//���ַ���Ϸ
public class Guessing {
	
	//������
	public static void main(String[] args) {
		/*
		//�������Է����Ĵ���
		char[] c1 = {'A','B','C','D','E'};
		char[] c2 = {'N','B','M','A','E'};
		int[] result = check(c1,c2);
		//���result[0]��result[1]
		
		char[] chs = generate(); 
		System.out.println(chs);
		*/
		
		Scanner scan = new Scanner(System.in);
		int level;
		do{
			System.out.println("������ȼ�(5��7��9):");
			level = scan.nextInt();
		}while(level!=5 && level!=7 && level!=9);
		
		char[] chs = generate(level); //��ȡ����ַ�����
		System.out.println(chs); //����
		int count = 0; //�´�Ĵ���
		while(true){ //������ѭ��
			System.out.println("�°�!"); //"abCDe"----"ABCDE"
			String str = scan.next().toUpperCase(); //��ȡ�û�������ַ�����ת��Ϊ��д��ĸ
			if(str.equals("EXIT")){
				System.out.println("�´�������!");
				break;
			}
			char[] input = str.toCharArray(); //���ַ���ת�����ַ�����
			int[] result = check(chs,input); //�Ա�:����ַ��������û�������ַ�����
			if(result[0]==chs.length){ //�¶���
				int score = 100*chs.length-10*count; //һ���ַ�100�֣��´�һ�ο�10��
				System.out.println("��ϲ�㣬�¶��ˣ��÷�Ϊ:"+score);
				break; //����ѭ��
			}else{ //�´���
				count++; //�´������1
				System.out.println("�ַ��Ը���:"+result[1]+"��λ�öԸ���:"+result[0]);
			}
		}
	}
	
	//��������ַ�����
	public static char[] generate(int level){
		char[] chs = new char[level]; //����ַ�����
		
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' }; //�ַ���ѡ��Χ����
		boolean[] flags = new boolean[letters.length]; //�������飬Ĭ��Ϊfalse����ʾδ���
		for(int i=0;i<chs.length;i++){ //��������ַ�����
			int index; //����±�
			do{
				index = (int)(Math.random()*letters.length); //��������±�(0��25֮��)
			}while(flags[index]==true); //���±��Ӧ�Ŀ���Ϊtrueʱ����ʾ�Ѵ��������������index
			                            //���±��Ӧ�Ŀ���Ϊfalseʱ����ʾδ���������Ϊ��ѭ������
			chs[i] = letters[index]; //����index�±�ȥletters�л�ȡ���ݣ�����ֵ��chs�е�ÿһ��Ԫ��
			flags[index] = true; //�޸�index�±��Ӧ�Ŀ���Ϊtrue����ʾ�Ѵ��
		}
		
		return chs;
	}

	//�Ա�:����ַ��������û�������ַ�����
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2]; //�ԱȽ�� result[0]Ϊλ�ö� result[1]Ϊ�ַ��ԣ�Ĭ�϶���0
		for(int i=0;i<chs.length;i++){ //��������ַ�����
			for(int j=0;j<input.length;j++){ //�����û�������ַ�����
				if(chs[i]==input[j]){ //�ַ���
					result[1]++; //�ַ��Ը�����1
					if(i==j){ //λ�ö�
						result[0]++; //λ�öԸ�����1
					}
					break; //��input�ַ�ƥ���input�������ַ����ٲ���Ƚ���
				}
			}
		}
		return result;
	}
	
}




















