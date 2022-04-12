package com.fmetin.payment.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:22
 */

@Entity
@Data
@Table(name = "payment_transaction")
public class PaymentTransaction {
    @Id
    @NotEmpty
    @NotNull
    @Length(min = 36, max = 36)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private String transactionId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "amount")
    private BigDecimal amount;

    @NotEmpty
    @NotNull
    @Column(name = "user_id")
    private String userId;

    @Column(name = "status")
    private String status;
}
