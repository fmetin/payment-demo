package com.fmetin.payment.service;

import com.fmetin.payment.data.PaymentTransactionRequestDto;
import com.fmetin.payment.entity.PaymentTransaction;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:31
 */
public interface PaymentTransactionService {


    PaymentTransaction savePaymentTransaction(PaymentTransactionRequestDto request);

    void updatePaymentStatus(String status, String transactionId);
}
