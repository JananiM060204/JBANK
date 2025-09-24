import java.util.*;
public class register{
private ArrayList<Account> accounts = new ArrayList<>();

public void addAccount(Account account){
    accounts.add(account);
}

public Account findAccount(String accountNumber){
    for(Account acc:accounts){
        if(acc.getAccountNumber().equals(accountNumber)){
            return acc;
        }
    }
    return null;
  }
}
