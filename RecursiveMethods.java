import java.util.ArrayList;
import java.util.List;

public class RecursiveMethods {

	

// recursive method that takes a String and returns that string backwards
	public String backString(String word) {
		if (word.isEmpty()) {
			return word;
		}
		return backString(word.substring(1)) + word.charAt(0);
	}
	
	/*
	 * recursive method that takes two strings and returns true if they are equal, false otherwise.
	 * do not use .equals() method
	 */
	public boolean equalString(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		if(str1.length() == 0 && str2.length() == 0) {
			return true;
		}
		if(str1.charAt(0)==str2.charAt(0)){
			
			return equalString(str1.substring(0, str1.length()-1), str2.substring(0, str2.length()-1));
		}
		else {
			return false;
		}
	}
	
	// recursive method that takes a list of strings and returns the number of items in the string
		public int listSize(List<String> list) {
			ArrayList<String> lc = new ArrayList<String>(list);
			if (lc.isEmpty()) {
				return 0;
			}
			else {
				lc.remove(0);
				return 1 + listSize(lc);
				
			}
		}
		
	/*
	 * recursive method that takes two ArrayList<String> arguments and returns 
	 * true if they are equal. 
	 */

	public ArrayList<String> withoutFirst(ArrayList<String> l1) {
		ArrayList<String> l1c = new ArrayList<String>(l1);
		l1c.remove(0);
		return l1c;
	}
	
	public boolean equalList(ArrayList<String> l1, ArrayList<String> l2) {
		if (l1.size() == 0 && l2.size() == 0) {
			return true;
		}
		if (l1.size() != l2.size()) {
			return false;
		}
		if (equalString(l1.get(0), l2.get(0))) {
				return equalList(withoutFirst(l1), withoutFirst(l2));
		}
		return false;
	}
	
	/*
	 * With the other methods above, write a set of methods that use recursion to return true
	 * if every other item in the list is the reverse of the item in that position, starting at the first
	 * item. If the lists are empty it should return true.
	 */
	
	public ArrayList<String> withoutFirstTwo(ArrayList<String> l1) {
		ArrayList<String> l1c = new ArrayList<String>(l1);
		ArrayList<String> empty = new ArrayList<String>();
		if (listSize(l1c) >= 2) {
			l1c.remove(0);
			l1c.remove(0);
			return l1c;
		}
		if (listSize(l1c) < 2) {
			return empty;
		}
		return empty;
	}
        public boolean compareList(ArrayList<String> l1, ArrayList<String> l2) {
		if (listSize(l1) == 0) {
			return true;
		}
		if (listSize(l2) == 0) {
			return false;
		}
		if (equalString(l1.get(0), backString(l2.get(0)))) {
			return compareList(withoutFirstTwo(l1), withoutFirstTwo(l2));
		}
		return false;
	}
	
	//Main Method Testing
	public static void main(String[] args) {
		
		RecursiveMethods ex1 = new RecursiveMethods();
		//backString test
		System.out.println(ex1.backString("example test"));  //tset elpmaxe
		System.out.println(ex1.backString("second example"));  //elpmaxe dnoces
		
		//listSize test
		List<String> ls = new ArrayList<String>();
		List<String> empty = new ArrayList<String>();
		List<String> two = new ArrayList<String>();
		
		ls.add("Str1");ls.add("Str2");ls.add("Str3");
		two.add("Str1");two.add("Str2");
		
		System.out.println(ex1.listSize(ls));     //3
		System.out.println(ex1.listSize(empty));  //0
		System.out.println(ex1.listSize(two));    //2
		
		//equalString test
		String s1 = "apple";
		String s2 = "john";
		String s3 = "john";
		System.out.println(ex1.equalString(s1, s2));   //false
		System.out.println(ex1.equalString(s2, s3));   //true
		
		//equalList test
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<String> l2 = new ArrayList<String>();
		ArrayList<String> l3 = new ArrayList<String>();
		
		l1.add("bob");l1.add("joe");l1.add("evan");
		l2.add("bob");l2.add("joe");l2.add("evan");
		l3.add("bob");l3.add("joe");l3.add("will");
		
		System.out.println(ex1.equalList(l1, l2));   //true
		System.out.println(ex1.equalList(l1, l3));   //false
		
		//compareList Test
		ArrayList<String> AL1 = new ArrayList<String>();
		ArrayList<String> AL2 = new ArrayList<String>();
		ArrayList<String> AL3 = new ArrayList<String>();
		ArrayList<String> AL4 = new ArrayList<String>();
		ArrayList<String> AL5 = new ArrayList<String>();
		
		AL1.add("word");AL1.add("cheese");AL1.add("banana");
		AL2.add("drow");AL2.add("eseehc");AL2.add("ananab");
		AL3.add("drow");AL3.add("cheese");AL3.add("walrus");
		
		System.out.println(ex1.compareList(AL1, AL2));  //true
		System.out.println(ex1.compareList(AL1, AL3));  //false
		System.out.println(ex1.compareList(AL4, AL5));  //true
	}
}
