package com.musakan.core.entities.concretes;


import com.musakan.core.entities.abstracts.BaseEntitiy;



//@Entity
//@Table(name = "customers")
public class Customer implements BaseEntitiy {
    public Customer(String customerName) {
        this.customerName = customerName;
    }

    //    @Column(length = 50, name = "CustomerName")
    private String customerName;



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }
}
