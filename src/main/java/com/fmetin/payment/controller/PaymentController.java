package com.fmetin.payment.controller;

import com.fmetin.payment.data.PaymentClientResponseDto;
import com.fmetin.payment.data.PaymentTransactionRequestDto;
import com.fmetin.payment.exceptions.PaymentException;
import com.fmetin.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:08
 */
@RestController
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/v1/transfer")
    @ResponseBody
    public ResponseEntity<PaymentClientResponseDto> transfer(@Valid @RequestBody PaymentTransactionRequestDto request) throws PaymentException {
        return ResponseEntity.ok(paymentService.transfer(request));
    }

}
