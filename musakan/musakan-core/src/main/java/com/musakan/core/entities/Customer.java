package com.musakan.core.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customers")

@Access(AccessType.FIELD)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "CustomerName", length = 50)
    @Size(max = 50)
    private String customerName;

    @Column(name = "ContactName", length = 50)
    @Size(max = 50)
    private String contactName;

    @Column(name = "Address", length = 50)
    @Size(max = 50)
    private String address;

    @Column(name = "City", length = 20)
    @Size(max = 20)
    private String city;

    @Column(name = "PostalCode", length = 10)
    @Size(max = 10)
    private String postalCode;

    @Column(name = "Country", length = 15)
    @Size(max = 15)
    private String country;

    // Parametresiz constructor
    public Customer() {}

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
