package com.fmetin.payment.repository;

import com.fmetin.payment.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:30
 */
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, String> {

    @Modifying
    @Query(" Update PaymentTransaction " +
            "   Set status = :status" +
            " Where transactionId = :transactionId")
    void updatePaymentStatus(@Param("status") String status, @Param("transactionId") String transactionId);
}
