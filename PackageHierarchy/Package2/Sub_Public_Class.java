package Package2;

public class Sub_Public_Class extends Package1.Public_Class {
        // if I don't provide the constructor explicitly or use super to call the
	    // parent's(package1.Public_Class) constructor, it will not compile, because
	    // parent's constructor gives default access, which is the scope of its package
	    // I can add protected or public to it, to make it visible outside of its package.
	
	    // Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		// Implicit super constructor Public_Class() is not visible for default constructor. Must define an explicit constructor

		// at Package2.Sub_Public_Class.<init>(Sub_Public_Class.java:3)
		// at Package2.Main_Class.main(Main_Class.java:8)
	   
	    // Sub_Public_Class(){
		// super();
	    // }
	Sub_Public_Class(){
		System.out.println("inintializing a instance for Sub_Public_Class in Pkg2");
	
	}
	
	void PrintMember() {
		System.out.println("Sub_Public_Class:");
		System.out.printf("Protected member of Sub Public Class : %s%n", this.pro_member_of_pub_class);
		System.out.printf("Public member of Sub  Public Class : %s%n", this.pub_member_of_pub_class);
		// not visible here, no access modifier means this member is only visible inside package1
		// System.out.printf("Public member of Public Class : %s%n", this.def_member_of_pub_class);
    }
}
