package com.springboot.sqlserver.entity;

public class Test2 {

	public static void main(String[] args) {
		String input1 = "SF31||||";//8
		String input2 = "SF01|SF11|||";//12
		String input3 = "SF01|SF11|SF31||";//16
		String input4 = "SF02|SF08|SF11|SF31|";//20
		String F1 = null,F2 = null,F3 = null,F4 = null;
		int k = input4.length();
		if(k==8)
		{
			F1=input1.substring(0,4);
			F2="";
			F3="";
			F4="";
		}
		else if(k==12) {
			F1=input2.substring(0,4);
			F2=input3.substring(5,9);
			F3="";
			F4="";
		}
		else if(k==16) {
			F1=input2.substring(0,4);
			F2=input3.substring(5,9);
			F3=input3.substring(10,14);
			F4="";
		}
		else if(k==20) {
			F1=input2.substring(0,4);
			F2=input3.substring(5,9);
			F3=input3.substring(10,14);
			F4=input4.substring(15,19);
		}
		System.out.println("F1: "+F1+" F2: "+F2+" F3: "+F3+" F4: "+F4);
	}
}
