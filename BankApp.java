import java.net.SocketPermission;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        register accRegister = new register();
        boolean running= true;

        while(running){
            System.out.println("WELCOME TO JBANK : YOUR SAFETY AND CONVENIENCE IS OUR GUARANTEE!\nChoose the action you want to perform:\n(Kindly enter as number)");
            System.out.println("1) Create an Account \n2) Withdraw \n3) Deposit \n4) Check Balance \n5) Exit");
            int choice = in.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter your Account Number: ");
                    String accNumber=in.next();
                    System.out.println("Enter your username: ");
                    String accHolderName = in.next();
                    System.out.println("Initial Balance = ");
                    double balance = in.nextDouble();
                    System.out.println("\t \t\t\t\t ===TYPE OF ACCOUNT=== \nEnter 1 for 'savings' account and 2 for 'current' account = ");
                    int type=in.nextInt();

                    if(type==1){
                        accRegister.addAccount(new Savings(accNumber, accHolderName, balance));
                    }
                    else{
                        accRegister.addAccount(new Current(accNumber, accHolderName, accHolderName));
                    }
                    System.out.println("Account created successfully!\n");
                    break;

                case 2:
                    System.out.println("Kindly enter your account number: ");
                    String waN = in.next();
                    Account wdAccount = accRegister.findAccount(waN);
                    if (wdAccount != null) {
                        System.out.println("Enter amount to withdraw: ");
                        double wdA = in.nextDouble();
                        wdAccount.withdraw(wdA);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.println("Kindly enter your account number: ");
                    String daN=in.next();
                    Account depAccount = accRegister.findAccount(daN);
                    if(depAccount!=null){
                        System.out.println("Enter amount to deposit: ");
                        double depAmount=in.nextDouble();
                        depAccount.deposit(depAmount);
                    }else{
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.println("Kindly enter your account number: ");
                    String baN=in.next();
                    Account balanceAccount = accRegister.findAccount(baN);
                    if(balanceAccount!=null){
                        balanceAccount.getBalance();
                    }else{
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    running = false;
            }
        }
        
    }
}