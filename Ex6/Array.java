
public class Array {
	// Declare an array of integers called "numbers"
	private int numbers[];

	// Constructor to create a new Array object with the given array
	public Array(int[] array) {
		// Initialize variables for the loop
		int i = 0, len = array.length;
		// Create a new array with the same length as "array"
		this.numbers = new int[len];
		// Copy the elements of "array" into "this.numbers"
		while (i <= len - 1) {
			this.numbers[i] = array[i];
			i++;
		}
	}

	// Method to check if "other" is a prefix of "this"
	public boolean isPrefix(Array other) {
		// Initialize variables for the loop
		int numbersLen = this.numbers.length, otherLen = other.numbers.length, ctr = 0;
		// If "other" is longer than "this", return false
		if (numbersLen < otherLen)
			return false;
		// If "other" is null, return true
		else if (other.numbers == null)
			return true;
		// Iterate through the elements of "other"
		for (int i = 0; i < other.numbers.length; i++) {
			// If the elements of "other" and "this" match, increment the counter
			if (other.numbers[i] == this.numbers[i])
				ctr++;
		}
		// If the counter is equal to the length of "other", return true
		if (ctr == otherLen)
			return true;
		// Otherwise, return false
		return false;
	}

	// Method to check if "other" is a suffix of "this"
	public boolean isSuffix(Array other) {
		// Initialize variables for the loop
		int numbersLen = this.numbers.length, otherLen = other.numbers.length, ctr = 0;
		// If "other" is longer than "this", return false
		if (numbersLen < otherLen)
			return false;
		// If "other" is null, return true
		else if (other.numbers == null)
			return true;
		// Iterate through the elements of "other" in reverse order
		for (int i = numbersLen - 1, j = otherLen - 1; j >= 0; i--, j--) {
			// If the elements of "other" and "this" match, increment the counter
			if (this.numbers[i] == other.numbers[j]) {
				ctr++;
			}
		}
		// If the counter is equal to the length of "other", return true
		if (ctr == otherLen)
			return true;
		// Otherwise, return false
		return false;
	}

	// Method to find the longest common prefix between "this" and "other"
	public Array longestCommonPrefix(Array other) {
		// Initialize variables for the loop
		int numbersLen = this.numbers.length, otherLen = other.numbers.length, maxLen, ctr = 0;
		// Set "maxLen" to the shorter of "this" and "other"
		if (numbersLen < otherLen)
			maxLen = numbersLen;
		else
			maxLen = otherLen;
		// If either "this" or "other" is null, return a new Array with a null value
		if (this.numbers == null || other.numbers == null)
			return new Array(null);
		// If "other" is a prefix of "this", return "other"
		else if (isPrefix(other) == true)
			return new Array(other.numbers);
		// Otherwise, find the longest common prefix
		else {
			int i = 0;
			// Iterate through the elements of "this" and "other" and count how many elements match
			while (i < maxLen && this.numbers[i] == other.numbers[i]) {
				ctr++;
				i++;
			}
			// Create a new array with the number of matching elements
			int lcp[] = new int[ctr];
			i = 0;
			// Copy the matching elements into the new array
			while (i < ctr) {
				lcp[i] = this.numbers[i];
				i++;
			}
			// Return a new Array with the matching elements
			return new Array(lcp);
		}
	}

	// Method to find the longest common suffix between "this" and "other"
	public Array longestCommonSuffix(Array other) {
		// Initialize variables for the loop
		int numbersLen = this.numbers.length, otherLen = other.numbers.length, maxLen, ctr = 0;
		// Set "maxLen" to the shorter of "this" and "other"
		if (numbersLen < otherLen)
			maxLen = numbersLen;
		else
			maxLen = otherLen;
		// If either "this" or "other" is null, return a new Array with a null value
		if (this.numbers == null || other.numbers == null)
			return new Array(null);
		// If "other" is a suffix of "this", return "other"
		else if (isSuffix(other) == true)
			return new Array(other.numbers);
		// Otherwise, find the longest common suffix
		else {
			int i = 0;
			// Iterate through the elements of "this" and "other" in reverse order
			// and count how many elements match
			while (i < maxLen && this.numbers[numbersLen - i - 1] == other.numbers[otherLen - i - 1]) {
				ctr++;
				i++;
			}
			// Create a new array with the number of matching elements
			int lcs[] = new int[ctr];
			i = 0;
			// Copy the matching elements into the new array
			while (i < ctr) {
				lcs[i] = this.numbers[numbersLen - ctr + i];
				i++;
			}
			// Return a new Array with the matching elements
			return new Array(lcs);
		}
	}

	// Method to find the longest prefix and suffix in "this"
	public int longestPrefixAndSuffix() {
		// Get the numbers in "this"
		int[] numbers = this.numbers;
		// If the array is null or empty, return 0
		if (numbers == null || numbers.length == 0) {
			return 0;
		}

		// Initialize the prefix length to 0
		int prefix = 0;
		// Iterate through the elements of "this" starting at the second element
		for (int i = 1; i < numbers.length; i++) {
			// Initialize j to the current prefix length
			int j = prefix;
			// Decrement j until either j is 0 or the elements at indices i and j match
			while (j > 0 && numbers[i] != numbers[j])
				j--;
			// If the elements at indices i and j match, increment j
			if (numbers[i] == numbers[j])
				j++;
			// Update the prefix length to j
			prefix = j;
		}
		// Return the prefix length
		return prefix;

	}

	// Method to unite "this" and "other" into a single Array
	public Array uniteWith(Array other) {
		// Get the lengths of "this" and "other"
		int numbersLen = this.numbers.length, otherLen = other.numbers.length;
		// Calculate the length of the united Array
		int length = numbersLen + otherLen;
		// Initialize the united Array with the calculated length
		int concat[] = new int[length];
		// Initialize a position counter to 0
		int pos = 0;
		// Iterate through the elements of "this" and add them to the united Array
		for (int i = 0; i < numbersLen; ++i) {
			concat[pos] = this.numbers[i];
			pos++;
		}
		// Iterate through the elements of "other" and add them to the united Array
		for (int i = 0; i < otherLen; ++i) {
			concat[pos] = other.numbers[i];
			pos++;
		}
		// Return the united Array as a new Array object
		return new Array(concat);
	}

	public void removeSub(Array other) {
		if (this.numbers == null || other.numbers == null)
			return;
		// Check if small array is bigger than big array
		if (other.numbers.length > this.numbers.length)
			return;
		// Initialize result array to store the modified version of this.numbers
		int[] result = new int[this.numbers.length];
		// Initialize index for result array
		int resultIndex = 0;
		// Initialize index for other array
		int otherIndex = 0;

		// Iterate through this.numbers
		for (int i = 0; i < this.numbers.length; i++) {
			// Check if current element in other array matches current element in this.numbers
			// If it does, then increment otherIndex
			if (otherIndex < other.numbers.length && this.numbers[i] == other.numbers[otherIndex]) {
				otherIndex++;
			}
			// If current element in other array does not match current element in this.numbers
			// then add current element in this.numbers to result array
			// Reset otherIndex to 0
			else {
				result[resultIndex] = this.numbers[i];
				resultIndex++;
				otherIndex = 0;
			}
		}

		// Reset this.numbers array
		this.numbers = new int[resultIndex];
		// Copy elements from result array to this.numbers
		for (int i = 0; i < resultIndex; i++) {
			this.numbers[i] = result[i];
		}

		// Print modified this.numbers array
		System.out.println(this.toString());
	}

	// Method to return a String representation of "this"
	public String toString() {
		// If "this" has not been created, return a message indicating this
		if (this.numbers == null)
			return "The Array object has not been initialized";
		// Initialize the result String to "{", which will represent the start of the Array
		String string_to_print = "{";
		// Iterate through the elements of "this"
		for (int i = 0; i < this.numbers.length; i++) {
			// Append the current element to the result String
			string_to_print += this.numbers[i];
			// If this is not the last element, append a comma and a space to the result String
			if (i < this.numbers.length - 1)
				string_to_print += ", ";
		}
		// Append "}" to the result String to represent the end of the Array
		string_to_print += "}";
		// Return the result String
		return string_to_print;
	}
}