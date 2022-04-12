package com.fmetin.payment.service.impl;

import com.fmetin.payment.constant.PaymentServiceConstants;
import com.fmetin.payment.data.PaymentTransactionRequestDto;
import com.fmetin.payment.entity.PaymentTransaction;
import com.fmetin.payment.repository.PaymentTransactionRepository;
import com.fmetin.payment.service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:33
 */
@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    public PaymentTransactionServiceImpl(PaymentTransactionRepository paymentTransactionRepository) {
        this.paymentTransactionRepository = paymentTransactionRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PaymentTransaction savePaymentTransaction(PaymentTransactionRequestDto request) {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setName(request.getName());
        paymentTransaction.setSurname(request.getSurname());
        paymentTransaction.setAmount(request.getAmount());
        paymentTransaction.setUserId(UUID.randomUUID().toString());
        paymentTransaction.setStatus(PaymentServiceConstants.WAITING_FOR_RESPONSE_STATUS);
        paymentTransactionRepository.save(paymentTransaction);
        return paymentTransaction;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePaymentStatus(String status, String transactionId) {
        paymentTransactionRepository.updatePaymentStatus(status, transactionId);
    }
}
