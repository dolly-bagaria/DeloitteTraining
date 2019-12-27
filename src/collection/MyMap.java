package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1,"laptop");
		map.put(2,"mobile");
		map.put(3,"tablet");
		map.put(4,"desktop");
	
		String device=map.get(3);
		System.out.println(device);
		
		Set<Integer> set= map.keySet();
		
		Iterator<Integer> itr= set.iterator();
		while(itr.hasNext()) {
			Integer key=itr.next();
			String value=map.get(key);
			System.out.println(key+": "+value);
		}
		
		Map<Integer, String> stud=new HashMap<>();
		List<Student> students=new ArrayList<>();
		students.add(new Student("samir",123));
		students.add(new Student("venu",321));
		students.add(new Student("amar",121));
		students.add(new Student("mina",135));
		Iterator<Student> sdIt=students.iterator();
		while(sdIt.hasNext()) {
			Student st2=sdIt.next();
			stud.put(st2.getRoll(),st2.getName());
			
			}
		//String d=map.get(123);
		//System.out.println(d);
		System.out.println("===get student name===");
		getStudentName(123,stud);
		}
	
	
	public static void getStudentName(int roll,Map<Integer, String> m) {
		//String d=m.get(123);
		//System.out.println(d);
		if(m.containsKey(roll)) {
			String st=m.get(roll);
			System.out.println(st);
		}
	}

	
}
