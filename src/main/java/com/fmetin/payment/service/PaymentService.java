package com.fmetin.payment.service;

import com.fmetin.payment.data.PaymentClientResponseDto;
import com.fmetin.payment.data.PaymentTransactionRequestDto;
import com.fmetin.payment.exceptions.PaymentException;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 21:31
 */
public interface PaymentService {
    PaymentClientResponseDto transfer(PaymentTransactionRequestDto request) throws PaymentException;
}
