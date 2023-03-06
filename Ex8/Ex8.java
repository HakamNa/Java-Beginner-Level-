import java.util.Arrays;

public class Ex8 {
	public int howManyEven(int num) {
		if (num < 10) {
			return (num % 2 == 0) ? 1 : 0;
		} else {
			return (num % 2 == 0) ? 1 + howManyEven(num / 10) : howManyEven(num / 10);
		}
	}
	public int longestAscending(int[] a){// working fine, need to check for {0,0,0,0}, and {5,4,3,2,1} if its ok to return 1
		return lengthOfLongest(a,0,1);
	}

	public static int lengthOfLongest(int[] a, int i,int j){
		if(a.length == 0) return 0;
		if(i == a.length - 1) return 1;
		if(i < a.length && j < a.length){
			if(a[i] >= a[j]) return lengthOfLongest(a, i, j+1);
			else return 1+lengthOfLongest(a, j, j+1);
		}
		return 1;
	}
	public int[] merge(int[] b, int[] a) {
		int[] result = new int[b.length + a.length];
		if (b.length == 0) {
			return a;
		}
		if (a.length == 0) {
			return b;
		}

		if (b[0] < a[0]) {
			result[0] = b[0];
			int[] newB = new int[b.length - 1];
			System.arraycopy(b, 1, newB, 0, b.length - 1);
			int[] mergeResult = merge(newB, a);
			System.arraycopy(mergeResult, 0, result, 1, mergeResult.length);
		} else {
			result[0] = a[0];
			int[] newA = new int[a.length - 1];
			System.arraycopy(a, 1, newA, 0, a.length - 1);
			int[] mergeResult = merge(b, newA);
			System.arraycopy(mergeResult, 0, result, 1, mergeResult.length);
		}
		return result;
	}

	public boolean equalIgnoreCase(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		if (s1.length() == 0) return true;
		if (!isEqualIgnoreCase(s1.charAt(0), s2.charAt(0))) return false;
		return equalIgnoreCase(s1.substring(1), s2.substring(1));
	}

	public static boolean isEqualIgnoreCase(char c1, char c2) {
		if (c1 >= 'A' && c1 <= 'Z') c1 = (char)(c1 - 'A' + 'a');
		if (c2 >= 'A' && c2 <= 'Z') c2 = (char)(c2 - 'A' + 'a');
		return c1 == c2;
	}

}