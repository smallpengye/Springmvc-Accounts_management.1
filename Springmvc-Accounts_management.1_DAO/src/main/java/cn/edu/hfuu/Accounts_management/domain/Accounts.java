package cn.edu.hfuu.Accounts_management.domain;

import java.util.Date;

/**
 * Created by 志鹏 on 2016/8/2.
 */
public class Accounts {
    public String userName;
    public float income;
    public String incomersource;
    public float pay;
    public String payfor;
    public float total;
    public Date date;

    public float getAlltotal() {
        return alltotal;
    }

    public void setAlltotal(float alltotal) {
        this.alltotal = alltotal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public String getIncomersource() {
        return incomersource;
    }

    public void setIncomersource(String incomersource) {
        this.incomersource = incomersource;
    }

    public String getPayfor() {
        return payfor;
    }

    public void setPayfor(String payfor) {
        this.payfor = payfor;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float alltotal;
}
