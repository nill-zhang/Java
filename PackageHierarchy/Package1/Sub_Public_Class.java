package Package1;

public class Sub_Public_Class extends Public_Class {
	
	void PrintMember() {
		System.out.println("Sub_Public_Class:");
		System.out.printf("Protected member of Public Class : %s%n", this.pro_member_of_pub_class);
		System.out.printf("Public member of Public Class : %s%n", this.pub_member_of_pub_class);
		System.out.printf("Default member of Public Class : %s%n", this.def_member_of_pub_class);
		
	}

}

