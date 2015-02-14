/**
罗马数字有如下符号：
基本字符	I	V	X	L	C	D	M
对应阿拉伯数字	1	5	10	50	100	500	1000

计数规则：
相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
正常使用时，连续的数字重复不得超过三次
在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）
 */

public class RomanToInt {
	public int romanToInt(String s) {
		String S = "IVXLCDM";
		int[] I = {1, 5, 10, 50, 100, 500, 1000};
		int sum = 0;
		for (int i=1; i<s.length(); i++) {
			char c1 = s.charAt(i-1);
			char c2 = s.charAt(i);
			int i1 = I[S.indexOf(c1)];
			int i2 = I[S.indexOf(c2)];
			if (i1 >= i2)
				sum += i1;
			else
				sum -= i1;
		}
		sum += I[S.indexOf(s.charAt(s.length()-1))];
		return sum;
	}
	
	public static void main(String args[]) {
		RomanToInt rti = new RomanToInt();
		String s1 = "IV";
		String s2 = "VI";
		String s3 = "XI";
		System.out.println(rti.romanToInt(s1) + " " + rti.romanToInt(s2) + " " + rti.romanToInt(s3));
	}
	
	
}