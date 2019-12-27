package collection;

import java.util.ArrayDeque;
import java.util.Deque;
//import java.util.LinkedList;
import java.util.Iterator;

public class MyDeque {

	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		deque.add("Java");
		deque.add("class");
		deque.add("training");
		
		System.out.println(deque);
		
		deque.addFirst("first ele");
		deque.addLast("last ele");
		System.out.println(deque);
		
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());
		System.out.println(deque.peek());
		
		System.out.println("---Enhanced for loop---");
		for(String s: deque) {
			System.out.println(s);
		}
		System.out.println("---Iterator---");
		Iterator<String> it=deque.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
