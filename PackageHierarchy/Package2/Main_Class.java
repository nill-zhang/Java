package Package2;

public class Main_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sub_Public_Class pkg2_sub_pub_cls = new Sub_Public_Class();
		pkg2_sub_pub_cls.PrintMember();
		System.out.printf("public member of package1 pulic class: %s%n", pkg2_sub_pub_cls.pub_member_of_pub_class);
		// not visible, only visible inside its subclass from a different package.
		// now we are in Main_Class, so we can not directly access it.
		// pkg2_sub_pub_cls.pro_member_of_pub_class;
		
		Sub_Package1_Sub_Default_Class sub_pkg1_sub_def_cls = new Sub_Package1_Sub_Default_Class();
		sub_pkg1_sub_def_cls.PrintMember();
		System.out.printf("public member of package1 sub default class: %s%n", sub_pkg1_sub_def_cls.pub_member_of_def_class);
		// not visible
		// sub_pkg1_sub_def_cls.pro_member_of_def_class
	}

}
