package core;
import java.util.Arrays;
public class MyArrays {

	public static void main(String[] args) {
		int[] nums= {120,21,230,43,440,54}; //declaration, memory allocation, initialization
		
		for(int i=0;i<nums.length-1;i++) {
			System.out.println(nums[i]*nums[i]);
		}
		
		double[] amount;
		amount= new double[5];
		amount[0]=15.45;
		amount[1]=122.45;
		amount[2]=123.45;
		amount[3]=124.45;
		amount[4]=125.45;
		
		//System.out.println(amount[3]);
		
		String[] str;
		str= new String[3];
		str[1]="Dolly";
		str[0]="niharika";
		str[2]="Pragyat";
		
		stringLength(str);
		
		
		arrayAlter(str);
		System.out.println("array values in main after calling the func");
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
			
		intSort(nums); //OR USE Arrays.sort(nums);
		
		
		}
		
	}
	public static void stringLength(String[] str)
	{
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i].length());
		}
	}
	
	public static void arrayAlter(String[] str) {
		str[0]="java";
		str[1]="hello";
		str[2]="world";
		System.out.println("array values inside the func");
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
	}
	
	public static void intSort(int[] a) {
		int temp;
		int n=a.length;
		for(int j=1;j<n;j++) {
			for(int i=0;i<n-j;i++) {
				if(a[i]>=a[i+1]) {
					temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
		}
		
	}
	
	public static void intSort1(int[] a) {
		Arrays.sort(a);
		
	}

}
