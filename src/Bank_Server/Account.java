/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_Server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MacdaraDay
 */
public class Account {
    private int accNum;
    private double openingBal;
    private double balance;
    
    public Account(int accNum, double openingBal){
        this.accNum = accNum;
        this.openingBal = openingBal;
    }
    
    public int getAccountNum(){
        return accNum;
    }
    public double getOpeningBal(){
        return openingBal;
    }
    public void desopit(int amount){
        balance = balance+amount;
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        //Transaction transaction = new Transaction(accNum, date, "Deposit",amount);
    }
    public double getBalance(){
        return balance;
    }

    void deposit(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getAccNum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}