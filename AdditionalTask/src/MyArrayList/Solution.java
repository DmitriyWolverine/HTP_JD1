package MyArrayList;

public class Solution {

	public static void main(String[] args) {
		Integer [] arr = new Integer[5];
		for(int i = 0 ; i < 5 ; ++i) {
			arr[i] = i;
		}
		MyArrayList<Integer> arrayList = new MyArrayList<>(arr);
		
		System.out.println("Is array empty : "+ arrayList.isEmpty() );
		
		System.out.println("Before");
		
		arrayList.printArray();
		System.out.println("After adding 7 to the end");
		arrayList.add(new Integer(7));
		arrayList.printArray();
		
		System.out.println("After adding at position "+ 0 + " elemet "+ 14);
		arrayList.add(new Integer(14), 0);
		arrayList.printArray();
		
		System.out.println("After setting at position number 1 element 24");
		
		arrayList.set(new Integer(24), 1);
		arrayList.printArray();
		
		int testElement = 7;
		System.out.println("Does it contain "+ testElement+": " + arrayList.contains(testElement) );
		
		System.out.println("Index of "+ 3+": " + arrayList.indexOf(3) );
		
		System.out.println("After removing from position 2");
		arrayList.remove(2);
		arrayList.printArray();
		
		System.out.println("After removing element 14");
		arrayList.remove(new Integer(14));
		arrayList.printArray();
		
		System.out.println("After adding element 2 three times!");
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(2));
		arrayList.printArray();
		
		System.out.println("After removing all elements 2!");
		arrayList.removeAll(new Integer(2));
		arrayList.printArray();
	}
}
