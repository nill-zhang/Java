public class Obj {
    Object num;
	public Obj(Object argu) {
		num = argu;
	}
	
	public Object getObj() {
		System.out.printf("inside Obj, its class name: %s%n", num.getClass().getName());
		return num;
		
	}
	
	public void showType() {
		
		System.out.printf("type: %s%n", num.getClass().getName());
	
	}
}
