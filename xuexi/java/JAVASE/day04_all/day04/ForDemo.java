package day04;
//for����ʾ
public class ForDemo {
	public static void main(String[] args){
		int sum = 0; 
		for(int num=1;num<=100;num++){
			if(num%10!=3){
				sum+=num; 
			}
		}
		System.out.println("sum="+sum);
		
		/*
		int sum = 0; 
		for(int num=1;num<=100;num++){
			if(num%10==3){ //��Ҫ��λΪ3��
				continue;
			}
			sum+=num; 
		}
		System.out.println("sum="+sum);
		*/
		/*
		 * sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3
		 * num=4 sum=1+2+4
		 * ...
		 * num=13 
		 * num=14 sum=...
		 * ...
		 * num=23
		 */
		
		
		
		
		
		
		
		
		
		
		/*
		int sum = 0;
		int num=1;
		for(;num<=100;num++){
			sum+=num; 
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum = 0; 
		for(int num=1;num<=100;){
			sum+=num; 
			num++;
		}
		System.out.println("sum="+sum);
		*/
		/*
		int sum = 0;
		int num=1;
		for(;num<=100;){
			sum+=num; 
			num++;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		for(;;){ //��ѭ��
			System.out.println("��Ҫѧϰ......");
		}
		*/
		
		/*
		for(int i=1,j=6;i<6;i+=2,j-=2){
		}
		*/
		/*
		 * i=1,j=6
		 * i=3,j=4
		 * i=5,j=2
		 * i=7,j=0
		 */
		
		/*
		for(int count=0;count<10;count++){
			System.out.println("�ж��ǳɹ��Ľ���");
		}
		System.out.println("over");
		
		for(int num=1;num<=9;num++){
			System.out.println(num+"*9="+num*9);
		}
		System.out.println("over");
		*/
		
		/*
		//�ۼӺ�: 1+2+3+...+99+100=5050
		int sum = 0; //��
		for(int num=1;num<=100;num++){
			sum+=num; //�ۼ�
		}
		System.out.println("sum="+sum);
		*/
		/*
		 *       sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 sum=1+2+3
		 * num=4 sum=1+2+3+4
		 * ...
		 * num=100 sum=1+2+3+4+...+100
		 * num=101
		 */
	}
}













