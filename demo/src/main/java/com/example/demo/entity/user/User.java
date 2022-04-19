package com.example.demo.entity.user;

import com.example.demo.entity.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "user_name",unique = true,nullable = false)
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "full_name",nullable = false)
    private String fullName;
    @Column(name = "address",length = 511)
    private String address;
    @Column(name = "payment_id")
    private Long paymentId;
    @Column(name = "phone",unique = true)
    private String phone;
    @Column(name = "balance")
    private Long balance;
    @Column(name = "blocked")
    private Boolean blocked;

    @Column(columnDefinition = "varchar(255) default 'USER'")
    @Enumerated(EnumType.STRING)
    private UserRoleType role;

    @Column(name = "description")
    private String description;
    @Column(name = "avatar", length = 511)
    private String avatar;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> post;


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

    public List<Post> getPost() {
        return post;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public UserRoleType getRole() {
        return role;
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
        this.userName = userName.strip().replaceAll("\\s+", "");
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



    @JsonIgnore
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

    @JsonIgnore
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
