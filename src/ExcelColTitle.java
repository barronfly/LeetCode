/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class ExcelColTitle {
	public String convertToTitle(int n) {
		if (n <= 0) return "";
		
		int m = 0;
		char c;
		String s = "";
		while (n > 0) {
			m = n % 26;
			n = n / 26;
			if (m == 0) {
				s = s + 'Z';
				n--;
			}else {
				c = (char)('A' + m - 1);
				s = s + c;
			}
		}
		
		// reverse string
		String ss = "";
		for (int i=s.length()-1; i>=0; i--) {
			ss = ss + s.charAt(i);
		}
		
		return ss;
    }
	
	public static void main(String args[]){
		ExcelColTitle ect = new ExcelColTitle();
		System.out.println("String of 1 is : " + ect.convertToTitle(1));
		System.out.println("String of 26 is : " + ect.convertToTitle(26));
		System.out.println("String of 27 is : " + ect.convertToTitle(27));
		System.out.println("String of 28 is : " + ect.convertToTitle(28));
	}
};