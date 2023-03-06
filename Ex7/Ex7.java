package newJava_Ex2;

public class Ex7 {
	/**
	 * Searches for a given element in a sorted 2D array.
	 *
	 * Time complexity: O(log n)
	 * The time complexity of this function is O(log n) because it performs a binary search on both the rows and the columns of the array.
	 * Each binary search reduces the search space by half, so the function performs at most log n searches.
	 *
	 * @param a the 2D array to search in
	 * @param x the element to search for
	 * @return true if the element is found, false otherwise
	 */

	public static boolean find(int[][] a, int x) {
		// Check if the array is empty or not
		if (a == null || a.length == 0 || a[0].length == 0) {
			return false;
		}

		// Set the starting and ending rows
		int startRow = 0;
		int endRow = a.length - 1;

		// Binary search for the row that may contain x
		while (startRow <= endRow) {
			int midRow = startRow + (endRow - startRow) / 2;
			if (a[midRow][0] > x) {
				endRow = midRow - 1;
			} else if (a[midRow][0] < x) {
				startRow = midRow + 1;
			} else {
				return true;
			}
		}

		// If we didn't find x in the array, return false
		if (endRow < 0) {
			return false;
		}

		// Set the starting and ending columns for the row that may contain x
		int startCol = 0;
		int endCol = a[0].length - 1;

		// Binary search for x in the row
		while (startCol <= endCol) {
			int midCol = startCol + (endCol - startCol) / 2;
			if (a[endRow][midCol] > x) {
				endCol = midCol - 1;
			} else if (a[endRow][midCol] < x) {
				startCol = midCol + 1;
			} else {
				return true;
			}
		}

		// If we didn't find x in the row, return false
		return false;
	}

	/**
	 * Searches for a given element in a sorted array.
	 *
	 * Time complexity: O(log n)
	 * The time complexity of this function is O(log n) because it performs a binary search on the even and odd indices of the array separately.
	 * Each binary search reduces the search space by half, so the function performs at most log n searches.
	 *
	 * @param a the array to search in
	 * @param x the element to search for
	 * @return the index of the element if found, -1 otherwise
	 */
	public static int find(int[] a, int x) {
		int len = a.length;

		if (len == 0 || a == null)
			return -1;
		else if (x == a[0])
			return 0;
		else if (x == a[len - 1])
			return len - 1;

		// Calculate the last even and odd indices of the array
		int odd_index = ((len - 1) % 2 == 0) ? len - 2 : len - 1;
		int even_index = ((len - 1) % 2 == 0) ? len - 1 : len - 2;

		// Check if the element is outside the range of the even or odd indices
		if ((x < a[0] && x < a[odd_index]) || (x > a[1] && x > a[even_index])) return -1;

		// Search the even indices
		int evenIndex = searchEven(a, x, 0, even_index);
		if (evenIndex != -1) return evenIndex;

		// Search the odd indices
		int oddIndex = searchOdd(a, x, 1, odd_index);
		return oddIndex;
	}

	/**
	 * Searches for a given element in the even indices of a sorted array.
	 *
	 * Time complexity: O(log n)
	 * The time complexity of this function is O(log n) because it performs a binary search on the even indices of the array.
	 * Each binary search reduces the search space by half, so the function performs at most log n searches.
	 *
	 * @param a the array to search in
	 * @param x the element to search for
	 * @param top the start index of the search range
	 * @param bottom the end index of the search range
	 * @return the index of the element if found, -1 otherwise
	 */
	private static int searchEven(int[] a, int x, int top, int bottom) {
		if (top >= bottom) {
			// Search range is empty, element not found
			return -1;
		}
		int mid = (bottom + top) / 2;
		mid += mid % 2; // Ensure that mid is even
		if (a[mid] > x) {
			// Element is in the left half of the search range
			return searchEven(a, x, top, mid - 1);
		} else if (a[mid] < x) {
			// Element is in the right half of the search range
			return searchEven(a, x, mid + 1, bottom);
		} else {
			// Element found at mid
			return mid;
		}
	}

	/**
	 * Searches for a given element in the odd indices of a sorted array.
	 *
	 * Time complexity: O(log n)
	 * The time complexity of this function is O(log n) because it performs a binary search on the odd indices of the array.
	 * Each binary search reduces the search space by half, so the function performs at most log n searches.
	 *
	 * @param a the array to search in
	 * @param x the element to search for
	 * @param top the start index of the search range
	 * @param bottom the end index of the search range
	 * @return the index of the element if found, -1 otherwise
	 */
	private static int searchOdd(int[] a, int x, int top, int bottom) {
		while (top < bottom) {
			int mid = (bottom + top) / 2;
			mid += mid % 2 == 0 ? 1 : 0; // Ensure that mid is odd
			if (a[mid] > x) {
				// Element is in the left half of the search range
				top = mid + 1;
			} else if (a[mid] < x) {
				// Element is in the right half of the search range
				bottom = mid - 1;
			} else if (a[mid] == x) {
				// Element found at mid
				return mid;
			}
		}
		// Search range is empty, element not found
		return -1;
	}

	/**
	 * Counts the number of substrings in a given string that start with a given character and end with a different given character.
	 *
	 * Time complexity: O(n)
	 * The time complexity of this function is O(n) because it performs a linear scan through the string and processes each character once.
	 *
	 * @param s the string to process
	 * @param first the character to start the substrings with
	 * @param last the character to end the substrings with
	 * @return the number of substrings that start with 'first' and end with 'last'
	 */
	public static int countSub(String s, char first, char last) {
		return countSub(s, first, last, 0, 0, 0);
	}
	/**
	 * Recursive helper function for countSub.
	 *
	 * @param s the string to process
	 * @param first the character to start the substrings with
	 * @param last the character to end the substrings with
	 * @param index the current index in the string
	 * @param firstCount the number of occurrences of 'first' seen so far
	 * @param count the total number of substrings that start with 'first' and end with 'last' found so far
	 * @return the number of substrings that start with 'first' and end with 'last'
	 */
	private static int countSub(String s, char first, char last, int index, int first_ctr, int ctr) {
		// End of the string reached, return the final count
		if (index == s.length()) {
			return ctr;
		}
		if (s.charAt(index) == last) {
			// Character is 'last', add firstCount to count
			ctr += first_ctr;
		}
		if (s.charAt(index) == first) {
			// Character is 'first', increment firstCount
			first_ctr++;
		}
		return countSub(s, first, last, index + 1, first_ctr, ctr);
	}
}

//public static void main(String[] args) {
//
//	//********************************* TEST FOR FIRST FUNCTION **********************************************
//
//	System.out.println("\nTESTING THE FIRST FUNCTION\n");
//
//	// Test case 1
//	int arr1[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//	int x = 1;
//	boolean result = find(arr1, x);
//	System.out.println("Test case 1: " + (result == true ? "PASS" : "FAIL"));
//
//	// Test case 2
//	int arr2[][] = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
//	x = 55;
//	result = find(arr2, x);
//	System.out.println("Test case 2: " + (result == false ? "PASS" : "FAIL"));
//
//	// Test case 3
//	int arr3[][] = {{-4, -1, 1, 2}, {4, 5, 7, 8}, {11, 12, 15, 17}, {20, 30, 35, 54}};
//	x = 54;
//	result = find(arr3, x);
//	System.out.println("Test case 3: " + (result == true ? "PASS" : "FAIL"));
//
//	// Test case 4
//	int arr4[][] = {{-4, -1, 1, 2}, {4, 5, 7, 8}, {11, 12, 15, 17}, {20, 30, 35, 54}};
//	x = 15;
//	result = find(arr4, x);
//	System.out.println("Test case 4: " + (result == true ? "PASS" : "FAIL"));
//
//	// Test case 5
//	int arr5[][] = {{-4, -1, 1, 2}, {4, 5, 7, 8}, {11, 12, 15, 17}, {20, 30, 35, 54}};
//	x = 7;
//	result = find(arr5, x);
//	System.out.println("Test case 5: " + (result == true ? "PASS" : "FAIL"));
//
//	// Test case 6
//	int arr0[][] = {{}};
//	x = 0;
//	result = find(arr0, x);
//	System.out.println("Test case 6: " + (result == false ? "PASS" : "FAIL"));
//
//
//	//********************************* TEST FOR SECOND FUNCTION **********************************************
//
//	System.out.println("\nTESTING THE SECOND FUNCTION\n");
//
//	// Test case 1
//	int arr6[] = { -3, 10, 0, 9, 2, 5, 3, 0, 6, -5 };
//	int arr00[] = {};
//	x = -3;
//	int index = find(arr6, x);
//	System.out.println("Test case 1: " + (index == 0 ? "PASS" : "FAIL"));
//
//	// Test case 2
//	x = 17;
//	index = find(arr6, x);
//	System.out.println("Test case 2: " + (index == -1 ? "PASS" : "FAIL"));
//
//	// Test case 3
//	x = 2;
//	index = find(arr6, x);
//	System.out.println("Test case 3: " + (index == 4 ? "PASS" : "FAIL"));
//
//	// Test case 4
//	x = -5;
//	index = find(arr6, x);
//	System.out.println("Test case 4: " + (index == 9 ? "PASS" : "FAIL"));
//
//	// Test case 5
//	x = -5;
//	index = find(arr6, x);
//	System.out.println("Test case 5: " + (index == 9 ? "PASS" : "FAIL"));
//
//	// Test case 6
//	x = 4;
//	index = find(arr00, x);
//	System.out.println("Test case 6: " + (index == -1 ? "PASS" : "FAIL"));
//
//
//	//********************************* TEST FOR THIRD FUNCTION **********************************************
//
//	System.out.println("\nTESTING THE THIRD FUNCTION\n");
//
//	// Test case 1
//	String s1 = "ababaab";
//	char first1 = 'a';
//	char last1 = 'b';
//	int count1 = countSub(s1, first1, last1);
//	System.out.println("Test case 1: " + (count1 == 7 ? "PASS" : "FAIL"));  
//
//	// Test case 2
//	String s2 = "abcdefghijklmnopqrstuvwxyz";
//	char first2 = 'a';
//	char last2 = 'z';
//	int count2 = countSub(s2, first2, last2);
//	System.out.println("Test case 2: " + (count2 == 1 ? "PASS" : "FAIL"));  
//
//	// Test case 3
//	String s3 = "xyzxyzxyz";
//	char first3 = 'x';
//	char last3 = 'y';
//	int count3 = countSub(s3, first3, last3);
//	System.out.println("Test case 3: " + (count3 == 6 ? "PASS" : "FAIL"));  
//
//	// Test case 4
//	String s4 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
//	char first4 = 'm';
//	char last4 = 'z';
//	int count4 = countSub(s4, first4, last4);
//	System.out.println("Test case 4: " + (count4 == 3 ? "PASS" : "FAIL"));  
//
//	// Test case 5
//	String s5 = "aabaaabaaabaaa";
//	char first5 = 'a';
//	char last5 = 'a';
//	int count5 = countSub(s5, first5, last5);
//	System.out.println("Test case 5: " + (count5 == 55 ? "PASS" : "FAIL")); 
//
//	// Test case 6
//	String s6 = "";
//	char first6 = 'a';
//	char last6 = 'z';
//	int count6 = countSub(s6, first6, last6);
//	System.out.println("Test case 6: " + (count6 == 0? "PASS" : "FAIL"));
//
//	String s7 = "aa";
//	char first7 = 'a';
//	char last7 = 'a';
//	int count7 = countSub(s7, first7, last7);
//	System.out.println("Test case 7: " + (count7 == 1? "PASS" : "FAIL"));
//
//	System.out.println("\n********* END ********* ");
//}

