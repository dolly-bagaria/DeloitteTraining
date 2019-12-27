package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class MyCollection {

	public static void main(String[] args) {
		Vector<String> v=new Vector<>();
		v.add("ankit");
		v.add("computer");
		v.add("laptop");
		v.add("mobile");
		
		System.out.println(v.size());
		int len=v.size();
		System.out.println("---1. for loop---");
		for(int i=0;i<len;i++) {
			System.out.println(v.get(i));
		}
		
		System.out.println("---2. Enhanced for loop---");
		for(String s: v) {
			System.out.println(s);
		}
		
		System.out.println("---3. Enumeration interface---");
		Enumeration<String> e= v.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		System.out.println("---4. Iterator---");
		Iterator<String> it=v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("---ARRAY LIST---");
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(43);
		list.add(23);
		list.add(51);
		list.add(12);
		Iterator<Integer> iter=list.iterator();
		int sum=0,el;
		while(iter.hasNext()) {
			el=iter.next();
			System.out.println(el);
			sum+=el;
		}
		System.out.println("Sum= "+sum);
		
		Collections.sort(list);
		System.out.println("---ARRAY LIST AFTER SORTING---");
		for(int i: list) {
			System.out.println(i);
		}
		
		List<Student> students=new ArrayList<>();
		students.add(new Student("samir",123));
		students.add(new Student("venu",321));
		students.add(new Student("amar",121));
		students.add(new Student("mina",135));
		students.add(new Student("amit",124));
		students.add(new Student("vivek",322));
		students.add(new Student("adnan",125));
		students.add(new Student("nina",499));
		
		System.out.println("---sorting by name---");
		//sortByName(students);
		Collections.sort(students, new StudentNameSorter());
		Iterator<Student> sdIt=students.iterator();
		while(sdIt.hasNext()) {
			Student st=sdIt.next();
			System.out.println(st.getName());
		}
		
		System.out.println("---sorting by roll---");
		//sortByRoll(students);
		Collections.sort(students, new StudentRollSorter());
		Iterator<Student> sdIt1=students.iterator();
		while(sdIt1.hasNext()) {
			Student st1=sdIt1.next();
			System.out.println(st1.getName()+" : "+st1.getRoll());
		}
		
		System.out.println("---all names starting with a---");
		sdIt=students.iterator();
		while(sdIt.hasNext()) {
			Student st2=sdIt.next();
			String n=st2.getName();
			if(n.charAt(0) == 'a') {
				System.out.println(n);
			}
		}
		
		System.out.println("---Roll no. Search---");
		
		getRollNumber("mina",students);
	}
	
	public static void getRollNumber(String name, List<Student> students) {
		Iterator<Student> sdIt=students.iterator();
		while(sdIt.hasNext()) {
			Student st=sdIt.next();
			String n=st.getName();
			if(n.equals(name)) {
				System.out.println(st.getRoll());
			}
		}
	}
	public static void sortByName(List<Student> students) {
		Collections.sort(students,new Comparator<Student>(){
			@Override
			public int compare(Student s1,Student s2) {
				return s1.getName().compareToIgnoreCase(s2.getName());
			}
		});
		
		Iterator<Student> sdIt=students.iterator();
		while(sdIt.hasNext()) {
			Student st=sdIt.next();
			System.out.println(st.getName());
		}
	}
	
	public static void sortByRoll(List<Student> students) {
		Collections.sort(students,new Comparator<Student>(){
			@Override
			public int compare(Student s1,Student s2) {
				return s1.getRoll()-s2.getRoll();
			}
		});
		
		Iterator<Student> sdIt1=students.iterator();
		while(sdIt1.hasNext()) {
			Student st1=sdIt1.next();
			System.out.println(st1.getName()+" : "+st1.getRoll());
		}
	}
	
	

}
