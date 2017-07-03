package Package2;

// you can not see Default_Class from Package1 because its only visible inside Package1
// but you can subclass all the other public modified classes
// Package1.Sub_Default_Class can access Package1.Default_Class's members
public class Sub_Package1_Sub_Default_Class extends Package1.Sub_Default_Class {
	
	void PrintMember() {
		System.out.println("Sub_Package1_Sub_Default_Class:");
		System.out.printf("Protected member of Public Class : %s%n", this.pro_member_of_def_class);
		System.out.printf("Public member of Public Class : %s%n", this.pub_member_of_def_class);
		
		
	}

}
