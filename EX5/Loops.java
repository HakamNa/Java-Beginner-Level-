package newJava_Ex2;

public class Loops {
	//	 ***************************** private functions *****************************

	// this function calculate the length of a specific number 
	public static int numberLength(int temp) {
		int counter = 0;
		// iterating over the digits of the number and count 
		// how many time you remove digit till it ends 
		while (temp != 0) {
			temp /= 10;
			counter++;
		}
		return counter;

	}
	// this function compare the suffixes of the number if equal to the number itself 
	public static boolean endsWithDigits(int smult, int n) {
		int MultiplesOfTen = 10, temp = smult, counter = numberLength(temp), suffex = 0;
		temp = smult;
		for (int i = 0; i < counter - 1; i++) {
			suffex = temp % MultiplesOfTen;
			MultiplesOfTen *= 10;
			if (suffex == n)
				return true;
		}
		return false;
	}
	// function that find the sum of digits of a number 
	public static boolean sumOfDigits(int smult, int n) {
		int temp = smult, sum = 0, digit;
		while (temp > 0) {
			digit = temp % 10;
			sum += digit;
			temp /= 10;
		}
		if (sum == n) {
			return true;
		}
		return false;
	}
	// function that increase base with power of pow (like MATH.POW function) )
	public static int power(int base, int pow) {
		int res = 1;
		for (int i = pow; i > 0; i--) {
			res *= base;
		}
		return res;

	}
	//	 ***************************** Question functions *****************************

	//	 ***************************** First Section *****************************

	// find the special multiplication of n
	public static int specialMult(int n) {
		// flag for finding the special multiplication 
		boolean flag = false;
		// if number between 1 and nine then the special multiplication is the number itself 
		if (n >= 1 && n <= 9)
			return n;
		// if the number is equal to 11 then there is no special multiplication for it so return 0
		else if (n == 11)
			return 0;
		else {
			int index = 0;
			while (!flag) {
				// if the special multiplication found according to the conditions then the flag is ON and return it 
				if (index % n == 0 && sumOfDigits(index, n) == true && endsWithDigits(index, n)) {
					flag = true;
					return index;
				}
				index++;
			}
			// else return zero
			return 0;
		}
	}
	//	iterate over the numbers from 1 to n and prints the special multiplication for them 
	public static void printAllSpecialMult(int n) {
		for (int i = 1; i <= n; i++)
			System.out.print(i + "\t" + specialMult(i) + "\n");
	}

	//	 ***************************** Second Section *****************************

	// iterate over number and reformat it with commas ","
	public static void printWithComma(int n, int d) {
		int save = n, nLen = numberLength(n), counter = 1, mod, index = nLen;
		// if one of the conditions isn't right we cant add commas 
		if (n <= 0 || d <= 0 || nLen == 1 || nLen <= d)
			System.out.println(n);
		else {
			while (index > 0) {
				// split the number from the left time by time 
				n /= power(10, index - 1);
				System.out.print(n % 10);
				// return the number to the original form 
				n = save;
				mod = (nLen - counter) % d;
				// if found the place to find comma 
				if (mod == 0 && counter != nLen)
					System.out.print(",");
				counter++;
				index--;
			}
		}
		// new line 
		System.out.println();
	}
}