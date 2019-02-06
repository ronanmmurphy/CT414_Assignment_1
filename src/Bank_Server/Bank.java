/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author MacdaraDay
 */
public class Bank extends UnicastRemoteObject implements BankInterface {
    private List<Account> accounts;
    private HashMap<Long, Date> usersloggedOn;
    private HashMap<String, String> loginDetails;
    
    public Bank() throws RemoteException{
	super();
        loginDetails = getLoginDetails();
	accounts = setAccounts(); // Setting up 5 user accounts
	usersloggedOn = new HashMap<Long, Date>();	// Create HashMap for storing what users are logged on currently
    }
    
    public static void main(String args[]) throws Exception {
        
        System.setSecurityManager(new SecurityManager());
        try {
		String name = "BankServer";
		BankInterface engine = new Bank();
		Naming.rebind(name, engine);						//Bind object to registry
		System.out.println("Bank Server Started");		
		}
	catch(Exception e){
		System.err.println("Bank Server Exception!");
		e.printStackTrace();
	}

    // initialise Bank server - see sample code in the notes and online RMI tutorials for details

    }


    //private List<Account> accounts; // users accounts
    //HashMap<Integer, String> login = new HashMap<Integer, String>();
    private List<Account> setAccounts() {
	
	Account acc1 = new Account(1000, 1000);
	Account acc2 = new Account(1001, 4000);
	Account acc3 = new Account(1002, 5000);
	Account acc4 = new Account(1003, 6000);
	Account acc5 = new Account(1004, 8000);
	List<Account> accounts = new ArrayList<Account>();
	accounts.add(acc1);
	accounts.add(acc2);
	accounts.add(acc3);
	accounts.add(acc4);
	accounts.add(acc5);
	return accounts;
    }
    private HashMap<String, String> getLoginDetails() {

	HashMap<String, String> loginDetails = new HashMap<String, String>();
	loginDetails.put("Ronan", "Password1");
	loginDetails.put("Joe", "Password2");
	loginDetails.put("Derek", "Password3");
        loginDetails.put("Mark", "Password4");
        loginDetails.put("David", "Password5");
	return loginDetails;
	
    }
    private long sessionID() {
	Random randomGenerator = new Random();
	boolean notUnique = true;
	long unique = 0;
	while(notUnique){								//Loop until a new unique key is found
		unique = randomGenerator.nextLong();
		if (unique < 0){							//Want a positive sessionID number
			unique *= -1;
		}
		if (!usersloggedOn.containsKey(unique)){		//Check if sessionID already exists
			usersloggedOn.put(unique, new Date());	//Store sessionID and creation time
			notUnique = false;						//Unique sessionID has now been found
		}
	}
	System.out.println(unique);
	return unique;
}
    private Account findAccount(List<Account> accounts, int accNum) {
	for (Account acc : accounts){
		if (acc.getAccNum() == accNum){
			return acc;
		}
	}
	return null;
}
    public long login(String username, String password) throws RemoteException, InvalidLogin {
        if(loginDetails.containsKey(username)){			//Check if username is recognised
		System.out.println("True");
		String pword = loginDetails.get(username);	
		if (password.equals(pword)){				//Check if entered password matches true password
			long uniqueID = sessionID();		//unique number assigned to user session
			return uniqueID;
		}
		else{ throw new InvalidLogin("Invalid Login"); }			//Incorrect password entered, prompt user to try again
	}
	return 0L;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param accountnum
     * @param amount
     * @param sessionID
     * @throws RemoteException
     * @throws InvalidSession
     * @throws InvalidLogin
     */
    @Override
    public void deposit(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession, InvalidLogin {
        boolean sessionExp = sessionExpired(sessionID);			// Must check if sessionID is still valid
	    if (sessionExp == true){								// Throw InvalidSession exception where ID has timed out
	    	throw new InvalidSession("Session Timed Out");
	    }
		Account acc = findAccount(accounts, accountnum);			// Check if user entered account exists
		if (acc != null){
			acc.deposit(amount);								// Method deposits money into referenced account
		}
		else throw new InvalidLogin("Invalid Login");
    }

    public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession, InsufficientFunds {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int inquiry(int accountnum, long sessionID) throws RemoteException, InvalidSession {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean sessionExpired(long sessionID) throws InvalidSession {
        throw new InvalidSession("Session not longer valid");
    }
}
