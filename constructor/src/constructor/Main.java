package constructor;


class Main {
    public static void main(String args[]) {
    	System.out.println("-------------------------------------------");
    	NAZHANG nazhang = new NAZHANG();
        
        
        System.out.println("-------------------------------------------");
        YHCUI yhcui = new YHCUI();
       
        
        System.out.println("-------------------------------------------");
        NHZHANG nhzhang = new NHZHANG(7);


        System.out.println("-------------------------------------------");
        System.out.printf("jzzhang.age: %d%n", nhzhang.jzhang_age);
        System.out.printf("rzguo.address: %s%n", nhzhang.rzguo_address);
        System.out.printf("rzguo.weight: %f%n", nhzhang.rzguo_weight);
        System.out.printf("nhzhang.age: %d%n", nhzhang.nhzhang_age);
        System.out.println("-------------------------------------------");
        
        // Notes:
        // 
       
    	
    }
}
