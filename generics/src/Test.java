import com.sun.org.apache.bcel.internal.classfile.InnerClass;

public class Test {
    private static class A {
    	
    }
    
    private static class B extends A {
    	
    }
    
    private static class C extends B {
    	
    }
    
    private static void  testObjectCast() {
    	
    	B bInstance = new B();
	    C cInstance = new C();
	    A a;
	    A realInstanceOfA = new A();
	    a = cInstance;
	    assert a instanceof C;
	    assert realInstanceOfA instanceof A;
	    try {
	        assert realInstanceOfA instanceof C: "realInstanceOfA is not a instance of C";
	    }catch (AssertionError e){
			System.out.println(e);
		}
	    
	    System.out.printf("Class Name of a: %s%n", a.getClass().getName());
	    a = bInstance;
	    assert a instanceof B;
	    System.out.printf("Class Name of a: %s%n", a.getClass().getName());
	    
	    a = new A();
	    System.out.printf("Class Name of a: %s%n", a.getClass().getName());
	    assert a instanceof A;
    	
    }
    
    
	 
	
	public static void main(String args[]) {
	    
	
	Obj o = new Obj(111);
    o.showType();
    // o.getObj return object, but its class‘s name is Integer??
    // because o.getObj return Object instance, but its a reference to
    // Integer instance 111. so its class type is Integer.
    // you can validate this with the testObjectCast() function
    // Since its referred class is integer why I can not
    // use autobox to convert it to int?
    // these are the disadvantages of not using generics
    // First, explicit casts must be employed to retrieve the stored data.
    // Second, many kinds of type mismatch errors
    // cannot be found until run time.
    Integer i = new Integer(11);
    int v = i;
    System.out.println(v);
    System.out.printf("outside Obj, its class Name:%s%n", o.getObj().getClass().getName());
    // int v = (int)o.getObj();
    // String s = (String)o.getObj();
    // float f = (float)o.getObj();
    // byte b = (byte)o.getObj();
    // short s = (Short)o.getObj();
    // double d= (double)o.getObj();
    // System.out.println(f);
    // System.out.println(s);
    // System.out.println(s);
    // System.out.println(b);
    // System.out.println(d);
    testObjectCast();
    }

}
