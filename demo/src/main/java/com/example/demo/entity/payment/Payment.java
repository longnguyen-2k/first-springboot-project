package com.example.demo.entity.payment;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name =  "payment")
public class Payment implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "request_id")
    private Long requestId;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name="type_transfer",columnDefinition = "enum('ADMIN','USER')")
    @Enumerated(EnumType.STRING)
    private TypeTransfer typeTransfer;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "phone")
    private String phone;
    @Column(name = "account_balance")
    private Long accountBalance;
    @Column(name = "message")
    private String message;
    @Column(name = "result_code")
    private Integer resultCode;
    @Column(name = "display_name")
    private String displayName;
    public Payment() {
    }
    public Payment(Long id, Long requestId, Long orderId, Long amount, String phone, Long accountBalance, String message, Integer resultCode, String displayName, TypeTransfer typeTransfer) {
        this.id = id;
        this.requestId = requestId;
        this.orderId = orderId;
        this.amount = amount;
        this.phone = phone;
        this.accountBalance = accountBalance;
        this.message = message;
        this.resultCode = resultCode;
        this.displayName = displayName;
        this.typeTransfer = typeTransfer;
    }



    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TypeTransfer getTypeTransfer() {
        return typeTransfer;
    }

    public void setTypeTransfer(TypeTransfer typeTransfer) {
        this.typeTransfer = typeTransfer;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
