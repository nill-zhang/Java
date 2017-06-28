import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sfzhang on 6/27/2017.
 */
public class Account {
        static double interestRate = 0.02;
        private String password;
        float bal;
        String name;
        String addr;

        Account(String ownername){
            this.name = ownername;
             System.out.printf("a new account for %s has been initialized\n", ownername);
         }

        Account(float balance, String ownername, String owneraddress){
            this.bal= balance;
            this.name = ownername;
            this.addr = owneraddress;
            this.password = "123456";
        }

        void deposit(float amount){
            this.bal += amount;
            System.out.printf("Account Balance: $%.2f\n", this.bal);

        }

        void withdraw(float amount) {
            if (amount > this.bal) {
                System.out.println("account insufficient");
                return;
            }
            this.bal -= amount;
            System.out.printf("Account Balance: $%.2f\n", this.bal);
        }

        void setPassword(String newPass){
            this.password = newPass;

        }

}


