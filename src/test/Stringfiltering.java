package test;

public class Stringfiltering {
	
	public static void main(String[] args) {
		String a ="\"";
		String b = a.replaceAll("[\\t\\\b\\\n\\\f\\\r\\\"\\\'\\\\`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~��@#��%����&*��������+|{}�������������������� ���� a-z]","");
		System.out.println(b);
		System.out.println(b.length());
		if (b.length()!=11) {
			System.out.println(false);
		}else {
			System.out.println(true);
		}
//		String regex = "[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~��@#��%����&*��������+|{}�������������������� ����]";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher("as  dfsd $@#!%$#%@!@ fsdf 3456   ");
//		String g = "as����ͼ                      dgas@#$&^@#*($^*(   ";
//		System.out.println(m.replaceAll(""));
//		System.out.println(g.replaceAll("[\\\\n`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~��@#��%����&*��������+|{}�������������������� ����]"+"[a-z0-9]{0,10}", ""));
		
	}

}
