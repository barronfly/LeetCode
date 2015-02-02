/*
 * Given a column title as appear in an Excel sheet, 
 * return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */

class ExcelColNum {
    public int titleToNumber(String s) {
        int sum = 0;
        if (s == null) return 0;

        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if (c < 'A' || c > 'Z') return 0;
        	sum = sum * 26;
        	sum = sum + (c - 'A') + 1;
        }
        
        return sum;
    }
    
    public static void main(String args[]) {
    	ExcelColNum ecn = new ExcelColNum();
    	String s1 = "AA";
    	String s2 = "";
    	System.out.println("Sum of " + s1 + " is : " + 
    			Integer.toString(ecn.titleToNumber(s1)));
    	System.out.println("Sum of " + s2 + " is : " + 
    			Integer.toString(ecn.titleToNumber(s2)));
    	
    }
};