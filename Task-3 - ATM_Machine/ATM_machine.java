import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;

class ATM_Operations {

    Scanner sc = new Scanner(System.in);

    public static double available_balance = 0;
    Calendar c;
    
    Map <Double, String> transaction_history = new HashMap<>();

    public void withdraw() {
        
        double withdraw_amount;
        
        System.out.println("Available Balance : " + available_balance);

        System.out.print("Enter the amount you want to withdraw : ");
        withdraw_amount = sc.nextDouble();

        if (withdraw_amount > available_balance) {
            System.out.println("Not enough balance!");
            System.out.println("Check Your Balance and try again.");
        } else {
            available_balance -= withdraw_amount;
            c = Calendar.getInstance();
            Date w_time = c.getTime();
            transaction_history.put(withdraw_amount, "Amount Withdrawn"  + " at "+ w_time);
            System.out.println(withdraw_amount + " Rs. withdrawn Successfully!");
        }
    }

    public void deposit() {
        double deposit_amount;
        System.out.println("Available Balance : " + available_balance);
        System.out.print("Enter the amount you want to deposit : ");
        deposit_amount = sc.nextDouble();
        available_balance += deposit_amount;
        c = Calendar.getInstance();
        Date d_time = c.getTime();
        transaction_history.put(deposit_amount, "Amount Deposited"  + " at "+ d_time);

        System.out.println(deposit_amount + " Rs. deposited successfully");
    }

    public void transfer() {
        double transfer_amount;
        BigInteger transfer_account;
        System.out.println("Available Balance : " + available_balance);
        System.out.print("Enter the account number to which you want to transfer : ");
        transfer_account = sc.nextBigInteger();
        System.out.print("Enter the amount to transfer :");
        transfer_amount = sc.nextDouble();

        if(transfer_amount > available_balance){
            System.out.println("Not enough balance!");
            System.out.println("Check Your Balance and try again.");
            return;
        } else {
            available_balance -= transfer_amount;
            c = Calendar.getInstance();
            Date t_time = c.getTime();
            System.out.println(transfer_amount+ " Rs. Successfully transferred to account : "+transfer_account);
            transaction_history.put(transfer_amount, "Amount Transferred to account :" + transfer_account + " at "+ t_time);
        }
    }

    public void check_balance() {
        System.out.println("\nAvailable Balance : " + available_balance);
    }
    
    public void transaction_history (){
        System.out.println("Your Account Transaction History : ");
        for(Map.Entry<Double, String> m:transaction_history.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

}

class ATM {

    public void atm_operate() {

        ATM_Operations user = new ATM_Operations();
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {

            System.out.println("\n\nChoose from the operations below :");
            System.out.println("1. Withdraw. \n2. Deposit. \n3. Transfer. \n4. Transaction History. \n5. Check Balance. \n6. Exit.");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            if (choice == 1) {
                user.withdraw();

            } else if (choice == 2) {
                user.deposit();

            } else if (choice == 3) {
                user.transfer();

            } else if (choice == 4) {
                user.transaction_history();
                
            } else if (choice == 5) {
                user.check_balance();

            } else if (choice == 6) {
                System.exit(0);
            }
            else {
                System.out.println("Enter Valid choice!!");
            }
            sc.close();
        }
    
        
    }
}

public class ATM_machine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int password;
        System.out.println("***ATM Machine***");

        
        System.out.println("Enter ATM pin : ");
        password = sc.nextInt();

        if (password == 1234) {
            ATM user = new ATM();
            user.atm_operate();
        } else {
            System.out.println("Enter Valid Password!");
            System.exit(0);
        }
        sc.close();
    }
}
