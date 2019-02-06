/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank_Server;

import java.util.Date;
import java.util.List;

/**
 *
 * @author MacdaraDay
 */
public class Transaction{
    
    private int accNum;
    private Date startDate;
    private Date endDate;
    private Date Date;
    private String type;
    private double amount;
    private double balance;
    
    public Transaction(int accNum, Date Date, String type, double amount, int balance){
        this.accNum = accNum;
        this.Date = Date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }
    
    public Transaction(int accNum, Date startDate, Date endDate){
        this.accNum = accNum;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    private List<Transaction> transactions;
    
    public void addTransaction(){
        transactions.add(this);
    }
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public void setAccNum(int accNum){
        this.accNum = accNum;
    }
    public int getAccNum(){
        return accNum;
    }
    public void setDate(Date Date){
        this.Date = Date;
    }    
    public Date getDate(){
        return Date;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
}
