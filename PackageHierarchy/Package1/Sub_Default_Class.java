package Package1;

public class Sub_Default_Class  extends Default_Class {
	
	void PrintMember() {
		System.out.println("Sub_Default_Class:");
		System.out.printf("Protected member of Public Class : %s%n", this.pro_member_of_def_class);
		System.out.printf("Public member of Public Class : %s%n", this.pub_member_of_def_class);
		
	}

}
