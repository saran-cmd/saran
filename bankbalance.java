
// import java.util.Scanner;
// class acount_details{
//     public void acco_det(){
//         System.out.println("A.check bankbalance");
//         System.out.println("B.withdraw");
//         System.out.println("C.deposid");
//     } 
//     if(enterdet==A || enterdet==B||enterdet==c){
//         opti(enterdet);
//     } 
//     else{}  
// }
// class options extends acount_details{
//     int add_amount=0;
//     public void opti(String enterdet){
//         switch ((enterdet)) {
//             case "A":
//            check_bal();
//             break;

//             case "B":
//              System.out.println("enter your amount");
//             int add_amount= scanner.nextInt();
//             withd(add_amount);

//             break;
//             case "C":
//             System.out.println("enter your amount");
//             int add_amount=scanner.nextInt();
//             deposid(add_amount);

//             break;
        
            
//         }
//     }
// }
// class  withdraw extends options{
//     int current_accountbalance=10000;
//     public void withd(int add_amount){
//       current_accountbalance= current_accountbalance-add_amount;
//       System.out.println("current account balance"+current_accountbalance);

//     }
//     public void check_bal(){
//         System.out.println("current account balance"+current_accountbalance);
// }
//     public void deposid(int add_amount){
//         current_accountbalance= current_accountbalance+add_amount;
//         System.out.println("current account balance"+current_accountbalance);
//     }
// }

// public class bankbalance{
//     public static void main(String[] arg){
//        Scanner scanner=new Scanner(System.in);
//      int  account_number=123456789;
//      int account_password=12345;
//      int current_accountbalance=10000;
//      String saving;
//      int add_amount=0;
//      System.out.println("enter the account number");
//      int input_accountnumber=scanner.nextInt();
//      System.out.println("enter the pin number");
//      int input_accountpassword=scanner.nextInt();
//      if(account_number==input_accountnumber && account_password == input_accountpassword){
//         System.out.println("your accoundnumber is correct");
//         System.out.println("bussines accound");
//         int bussines=scanner.nextInt();
//         System.out.println("savings accounds");
//         String savings=scanner.next();
//         if(saving==savings){
//            System.out.println("enter the opitions");
//            String enterdet=scanner.next(); 
//          acco_detw ();
//         }
//      } 
//      else{
//         if(account_number !=input_accountnumber){
//             System.out.println("your account number is mismatch");
//         }
//         else if(account_password !=input_accountpassword){
//             System.out.println("your account password is mismatch");
//         }
//         else{}
//      }
  
//     }
// }

import java.util.Scanner;

class AccountDetails {
    public void acco_det() {
        System.out.println("A. Check bank balance");
        System.out.println("B. Withdraw");
        System.out.println("C. Deposit");
    }
}

class Options extends AccountDetails {
    public void opti(String enterdet, int add_amount, Scanner scanner, Withdraw withdraw) {
        switch (enterdet) {
            case "A":
                withdraw.check_bal();
                break;
            case "B":
                System.out.println("Enter your amount to withdraw:");
                add_amount = scanner.nextInt();
                withdraw.withd(add_amount);
                break;
            case "C":
                System.out.println("Enter your amount to deposit:");
                add_amount = scanner.nextInt();
                withdraw.deposid(add_amount);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}

class Withdraw extends Options {
    int current_accountbalance = 10000; // Initial balance

    public void withd(int add_amount) {
        current_accountbalance -= add_amount;
        System.out.println("Current account balance: " + current_accountbalance);
    }

    public void check_bal() {
        System.out.println("Current account balance: " + current_accountbalance);
    }

    public void deposid(int add_amount) {
        current_accountbalance += add_amount;
        System.out.println("Current account balance: " + current_accountbalance);
    }
}

public class bankbalance {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int account_number = 123456789;
        int account_password = 12345;
        int current_accountbalance = 10000;
        String saving;
        int add_amount = 0;

        System.out.println("Enter the account number:");
        int input_accountnumber = scanner.nextInt();
        System.out.println("Enter the pin number:");
        int input_accountpassword = scanner.nextInt();

        if (account_number == input_accountnumber && account_password == input_accountpassword) {
            System.out.println("Your account number is correct.");
            System.out.println("Business account selected.");
            System.out.println("Enter the option (A, B, or C):");
            
            AccountDetails accountDetails = new AccountDetails();
            accountDetails.acco_det();  // Show options
            
            String enterdet = scanner.next();
            Withdraw withdraw = new Withdraw(); // Create Withdraw object to access balance management
            
            Options options = new Options();
            options.opti(enterdet, add_amount, scanner, withdraw);  // Call appropriate option
            
        } else {
            if (account_number != input_accountnumber) {
                System.out.println("Your account number is incorrect.");
            } else if (account_password != input_accountpassword) {
                System.out.println("Your account password is incorrect.");
            } else {
                System.out.println("Invalid credentials.");
            }
        }
        scanner.close();
    }
}

