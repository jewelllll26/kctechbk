package com.kctech.kctechbk.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ordertbl")
public class Order {

    @Id
    @GeneratedValue 
    private long id;
    private long userid;
    private double totalAmount;
    private String status;

    Order(){}

    public Order(long userid, double totalAmount, String status) {
        this.userid = userid;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    //Getters
    public long getId() {
        return id;
    }

    public long getUserid() {
        return userid;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    //Setters
    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}