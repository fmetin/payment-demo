package com.fmetin.payment.service.impl;

import com.fmetin.payment.client.PaymentClient;
import com.fmetin.payment.data.PaymentClientRequestDto;
import com.fmetin.payment.data.PaymentClientResponseDto;
import com.fmetin.payment.data.PaymentTransactionRequestDto;
import com.fmetin.payment.entity.PaymentTransaction;
import com.fmetin.payment.exceptions.PaymentException;
import com.fmetin.payment.service.PaymentService;
import com.fmetin.payment.service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.fmetin.payment.constant.PaymentServiceConstants.SUCCESS_CODE;
import static com.fmetin.payment.constant.PaymentServiceConstants.SUCCESS_STATUS;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 21:31
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentTransactionService paymentTransactionService;
    private PaymentClient paymentClient;

    @Autowired
    public PaymentServiceImpl(PaymentTransactionService paymentTransactionService, PaymentClient paymentClient) {
        this.paymentTransactionService = paymentTransactionService;
        this.paymentClient = paymentClient;
    }

    @Override
    public PaymentClientResponseDto transfer(PaymentTransactionRequestDto request) throws PaymentException {
        PaymentTransaction paymentTransaction = paymentTransactionService.savePaymentTransaction(request);

        PaymentClientRequestDto paymentClientRequestDto = createPaymentRequest(paymentTransaction);

        PaymentClientResponseDto paymentClientResponseDto = paymentClient.transfer(paymentClientRequestDto);

        if (paymentClientResponseDto.getResponseCode().equals(SUCCESS_CODE)) {
            paymentTransactionService.updatePaymentStatus(SUCCESS_STATUS, paymentTransaction.getTransactionId());
            return paymentClientResponseDto;
        } else {
            paymentTransactionService.updatePaymentStatus(paymentClientResponseDto.getResponseMessage(), paymentTransaction.getTransactionId());
            throw new PaymentException(paymentClientResponseDto.getResponseMessage());
        }

    }

    private PaymentClientRequestDto createPaymentRequest(PaymentTransaction paymentTransaction) {
        PaymentClientRequestDto paymentClientRequestDto = new PaymentClientRequestDto();
        paymentClientRequestDto.setTransactionId(paymentTransaction.getTransactionId());
        paymentClientRequestDto.setAmount(paymentTransaction.getAmount());
        return paymentClientRequestDto;
    }
}
