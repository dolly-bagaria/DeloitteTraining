package core;

public class People {
	
	private Person[] persons;
	int pers=5;
	int counter=0;
	
	public People(){
		persons= new Person[pers];
	}
	
	public void addPerson(Person p) {
		if(counter<pers) {
		persons[counter++]=p;
		}
	}
	
	public void displayPerson() {
		for(Person p: persons) {
			System.out.println(p);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People ppl= new People();
		ppl.addPerson(new Person("amit",1454556));
		ppl.addPerson(new Person("bb",54556));
		ppl.addPerson(new Person("cc",5412));
		ppl.addPerson(new Person("dd",1114556));
		ppl.addPerson(new Person("ee",11251487));
		ppl.addPerson(new Person("amit",1454556));
		ppl.displayPerson();
	}

}
