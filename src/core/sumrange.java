package core;

public class sumrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rangeSum(5,1);
		
	}

	public static void rangeSum(int m, int n)
	{
		int sum=0;
		if(m<n)
		{
		for(int i=m;i<=n;i++)
		{
			sum+=i;
		}
		System.out.println("\n\nsum= "+ sum);
		}
		else {
			swap(m,n);
		}
	}
	public static void swap(int m, int n)
	{
		int temp;
		temp=m;
		m=n;
		n=temp;
		rangeSum(m,n);
	}
	

	
}
