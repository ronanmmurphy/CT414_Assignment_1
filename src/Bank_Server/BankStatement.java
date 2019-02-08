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
public class BankStatement implements Statement{
    public int accnum;
    public Date startDate;
    public Date endDate;
    public String accName;
    public List<Transaction> transactions;
    public BankStatement(List<Transaction> tran, Date start, Date end,int accnum){
        this.accnum = accnum;
        this.startDate = start;
        this.endDate = end;
        this.transactions = tran;
        
    }
    
    @Override
    public int getAccountnum() {
        return accnum;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String getAccoutName() {
        return accName;
    }

    @Override
    public List<Transaction> getTransations() {
        return transactions;
    }
}
