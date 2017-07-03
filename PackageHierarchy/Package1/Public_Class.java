package Package1;

public class Public_Class {
	public String pub_member_of_pub_class;
	private String pri_member_of_pub_class;
	protected String pro_member_of_pub_class;
	String def_member_of_pub_class;
	Public_Class(){
	    pub_member_of_pub_class = "public_member of Public_Class";
	    pri_member_of_pub_class = "private_member of Public_Class";
	    pro_member_of_pub_class = "protected_member of Public_Class";
	    def_member_of_pub_class = "default_member of Public_Class";
	}
}

	

abstract class Abstract_Class{
		 public String pub_member_of_abs_class;
		 private String pri_member_of_abs_class;
		 protected String pro_member_of_abs_class;
		 Abstract_Class(){
		    pub_member_of_abs_class = "public_member of Abstract_Class";
		    pri_member_of_abs_class = "private_member of Abstract_Class";
		    pro_member_of_abs_class = "protected_member of Abstract_Class";
		
         }
		 
		 abstract void showMember();
}





