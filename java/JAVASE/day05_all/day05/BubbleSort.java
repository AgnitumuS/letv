package day05;
//ð������
public class BubbleSort {
	public static void main(String[] args) {
		/*
		 * 1)������������arr������10��Ԫ��
		 * 2)��arr��ÿ��Ԫ�ظ�ֵΪ0��99��������������
		 * 3)ð���㷨��arr��������
		 * 4)���arr�е�ÿ��Ԫ��
		 */
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		System.out.println("�����:");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}













