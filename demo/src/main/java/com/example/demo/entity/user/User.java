package com.example.demo.entity.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "address")
    private String address;
    @Column(name = "payment_id")
    private Long paymentId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "balance")
    private Long balance;
    @Column(name = "blocked")
    private Boolean blocked;

    @Column(columnDefinition = "enum('ADMIN','USER')")
    @Enumerated(EnumType.STRING)
    private UserRoleType role;

    private String description;
    private String avatar;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getRole() {
        return role.name();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User(){

    }

    public User( String userName, String password, String email, String fullName, String address, Long paymentId, String phone, Long balance,String description, String avatar) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.paymentId = paymentId;
        this.phone = phone;
        this.balance = balance;
        this.description = description;
        this.avatar = avatar;
        this.blocked = false;
        this.role = UserRoleType.USER;
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", full_name='" + fullName + '\'' +
                '}';
    }

    public String getFull_name() {
        return fullName;
    }

    public void setFull_name(String full_name) {
        this.fullName = full_name;
    }






}
