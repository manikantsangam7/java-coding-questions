package interview.questions;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

	private final String str;
	private final ArrayList<Integer> al;

	public ImmutableClass(String str, ArrayList<Integer> list) {
		this.str = str;
		
		//performing deep copy for immutability of arrayList
		ArrayList<Integer> immutableList=new ArrayList<Integer>();
		for(Integer i:list) {
			immutableList.add(i);
		}
		this.al = immutableList;
		//this.al=list;
		/*Uncomment above line to check what happens without deep copy*/
	}

	public String getStr() {
		return str;
	}

	public List<Integer> getAl() {
		return al;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list =new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		ImmutableClass immutableExample = new ImmutableClass("Manikant", list);
		System.out.println("Size of list in immutable class is :" + immutableExample.getAl().size());

		// adding more elements in the existing list
		list.add(6);
		System.out.println("Size of list in immutable class after adding new element in existing list:"
				+ immutableExample.getAl().size());

	}

}
