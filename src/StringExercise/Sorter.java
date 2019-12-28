package StringExercise;

import java.util.Arrays;
import java.util.Comparator;

import compare.Employee;

public class Sorter {

/*
	public static void StringSort(String[] a) {
		String temp;
		int n=a.length;
		for(int j=1;j<n;j++) {
			for(int i=0;i<n-j;i++) {
				if((a[i].compareTo(a[i+1]))>0) {
					temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
		}
		
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name[]= {"Rohit","Amit","Neha"};
		Arrays.sort(name);
		for(String s: name) {
			System.out.println(s);
		}
		
		Employee e1= new Employee("Akhil", 5123,500000);
		Employee e2= new Employee("Rahul", 456, 900000);
		Employee e3= new Employee("Dolly", 325,1000000);
		Employee e4= new Employee("Niharika",123,3000000);
		
		Employee emps[]=new Employee[4];
		emps[0]=e1;
		emps[1]=e2;
		emps[2]=e3;
		emps[3]=e4;
		
		//Arrays.sort(emps,e1);  //sorts according to name
		Arrays.sort(emps,new Comparator<Employee>(){
			@Override
			public int compare(Employee e1,Employee e2) {
				return e1.getName().compareToIgnoreCase(e2.getName());
			}
		});
		System.out.println("============================");
		System.out.println("sorting according to name");
		System.out.println("----------------------------");
		for(Employee e: emps) {
			System.out.println(e);
		}
		
		Arrays.sort(emps,new Comparator<Employee>(){
			@Override
			public int compare(Employee e1,Employee e2) {
				return e1.getId()-e2.getId();
			}
		});
		System.out.println("============================");
		System.out.println("sorting according to id");
		System.out.println("-----------------------------");
		for(Employee e: emps) {
			System.out.println(e);
		}
		
		Arrays.sort(emps,new Comparator<Employee>(){
			@Override
			public int compare(Employee e1,Employee e2) {
				return (int) (e1.getSalary()-e2.getSalary());
			}
		});
		System.out.println("============================");
		System.out.println("sorting according to salary");
		System.out.println("-----------------------------");
		for(Employee e: emps) {
			System.out.println(e);
		}
		
	}

}
