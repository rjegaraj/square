import java.util.*;

public class Square {

	public static void main(String[] args) {
		System.out.println(sortByString("banana", "baj"));
		System.out.println(sortByString("banana", ""));
	}
	
	public static String sortByString(String toSort, String sortOrder)
	{
		Character[] toSortChars = new Character[toSort.length()];
		
		for(int i = 0; i < toSortChars.length; i++) {
			toSortChars[i] = toSort.charAt(i);
		}
		
		Arrays.sort(toSortChars, new charComparator(sortOrder));
		
		StringBuilder finalStringBuilder = new StringBuilder();
		
		for(Character c : toSortChars) {
			finalStringBuilder.append(c);
		}
		
		return finalStringBuilder.toString();
	}
	
	static class charComparator implements Comparator<Character> {

		HashMap<Character, Integer> charToPos = new HashMap<Character, Integer>();
		
		@Override
		public int compare(Character o1, Character o2) {
			Integer loc1 = charToPos.get(o1);
			Integer loc2 = charToPos.get(o2);
			
			if (loc1 == null) {
				loc1 = charToPos.size(); 
			}

			if (loc2 == null) {
				loc2 = charToPos.size(); 
			}
			
			return Integer.compare(loc1, loc2);
		}
		
		charComparator(String sortOrder) {
			for(int i = 0; i < sortOrder.length(); i++) {
				charToPos.put(sortOrder.charAt(i), i);
			}
			
		}
	}
}
