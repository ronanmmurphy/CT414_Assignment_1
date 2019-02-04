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
public class Transaction {
    
    private int accNum;
    private Date startDate;
    private Date endDate;
    private Date Date;
    private String type;
    private double amount;
    
    public Transaction(int accNum, Date Date, String type, double amount){
        this.accNum = accNum;
        this.Date = Date;
        this.type = type;
        this.amount = amount;
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
}
