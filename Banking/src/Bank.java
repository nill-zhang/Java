import java.util.HashMap;

/**
 * Created by sfzhang on 6/27/2017.
 */
public class Bank {
    HashMap<String, Account[]> db = new HashMap<>();
    String name;

    /**
     * constructor
     * @param name bank name
     */
    Bank(String name){
        this.name = name;
    }

    /**
     * add a client to the bank
     * @param cname client name
     */
    void AddClient(String cname) {
        Account[] accounts = {new CheckingAccount(), new SavingsAccount(), new HighInterestAccount()};
        db.put(cname, accounts);
    }

    /**
     * add many clients all at once
     * @param names client names
     */
    void AddAll(String ... names){
        for (String x:names){
            AddClient(x);
        }
    }

    /**
     * returns client's total net worth
     * @param cname client name
     * @return
     */
    double GetTotalWorth(String cname){
        double total = 0;
        for(Account ac: db.get(cname)){
            total += ac.bal;
        }
        return total;

    }


}
