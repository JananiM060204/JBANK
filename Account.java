abstract class Account {
    protected String accountNumber;
    protected String accHolderName;
    protected double balance;

    public Account(String accountNumber, String accHolderName, double balance){ //Initializes the account values
        this.accountNumber=accountNumber;
        this.accHolderName=accHolderName;
        this.balance=balance;
    }

    public void deposit(double amount){ // To deposit amount
        balance+=amount;
        System.out.println("Amount Deposited Successfully | Available balance = "+ balance);
    }

    public abstract void withdraw(double amount);

    public String getAccountNumber(){
        return accountNumber;
    }
    public String getHolderName(){
        return accHolderName;
    }
    public double getBalance(){
        return balance;
    }
}
class Savings extends Account{
    private static final double min = 500;

    public Savings(String accountNumber, String accHolderName, double balance){
        super(accountNumber, accHolderName, balance);
    }

    @Override
    public void withdraw(double amount){
        if(balance-amount>=min){
            balance-=amount;
            System.out.println("Amount withdrawn Successfully = "+amount+" | Available balance = "+balance);
        }
        else{
            System.out.println("INSUFFICIENT FUNDS! MINIMUM BALANCE OF "+min+" IS REQUIRED FOR SAVINGS ACCOUNT!");
        }
    }
}

class Current extends Account{
    private static final double min=-10000;

    public Current(String accountNumber, String accHolderName, double balance){
        super(accountNumber, accHolderName, balance);
    }

    @Override
    public void withdraw(double amount){
        if(balance-amount>=min){
            balance-=amount;
            System.out.println("Amount withdrawn Successfully = "+amount+" | Available balance = "+balance);
        }
        else{
            System.out.println("OVERDRAFT LIMIT EXCEEDED FOR CURRENT ACCOUNT!");
        }
    }

}
