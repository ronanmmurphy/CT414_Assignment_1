/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_Server;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BankInterface extends Remote {
    
    public class InvalidSession extends Exception{
    
    }
    public class InvalidLogin extends Exception{
    
    }
    public long login(String username, String password) throws RemoteException, InvalidLogin;

    public void deposit(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession;

    public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession, InsufficientFunds;

    public int inquiry(int accountnum, long sessionID) throws RemoteException, InvalidSession;

    public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession;

}