/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MacdaraDay
 */
public class Bank extends UnicastRemoteObject implements BankInterface {

    private List<Account> accounts; // users accounts
    private List<Account> getAccounts() {
	Account acc1 = new Account(1001, 500);
	Account acc2 = new Account(1001, 1000);
	Account acc3 = new Account(1002, 2000);
	Account acc4 = new Account(1003, 5000);
	Account acc5 = new Account(1004, 8000);
	accounts  = new ArrayList<Account>();
	accounts.add(acc1);
	accounts.add(acc2);
	accounts.add(acc3);
	accounts.add(acc4);
	accounts.add(acc5);
        
	return accounts;
}
    
    public Bank() throws RemoteException{

    }

    public void deposit(int account, int amount) throws RemoteException, InvalidSession {
    // implementation code

    }

    public void withdraw(int account, int amount) throws RemoteException, InvalidSession {

    // implementation code

    }

    public void /*int*/ inquiry(int account) throws RemoteException, InvalidSession {
        //return balance;
    // implementation code

    }
    /**
     *
     * @param from
     * @param to
     * @throws RemoteException
     * @throws InvalidSession
     */
    public Statement getStatement(Date from, Date to) throws RemoteException, InvalidSession {
        return statement;
    // implementation code

    }

    public static void main(String args[]) throws Exception {

    // initialise Bank server - see sample code in the notes and online RMI tutorials for details

    }

    @Override
    public long login(String username, String password) throws RemoteException, InvalidLogin {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deposit(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inquiry(int accountnum, long sessionID) throws RemoteException, InvalidSession {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
