/**
�������������·��ţ�
�����ַ�	I	V	X	L	C	D	M
��Ӧ����������	1	5	10	50	100	500	1000

��������
��ͬ��������д������ʾ����������Щ������ӵõ����������磺III = 3
С�������ڴ�������ұߣ�����ʾ����������Щ������ӵõ����������磺VIII = 8
С�����֣����ڣ�I��X��C���ڴ��������ߣ�����ʾ�������ڴ�����ȥС�����õ��������磺IV = 4
����ʹ��ʱ�������������ظ����ó�������
��һ���������滭���ߣ���ʾ���������1000��������ֻ����3999���ڵ����������ò�����������
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