package com.fmetin.payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 21:54
 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class PaymentException extends Exception {
    public PaymentException(String errorMessage) {
        super(errorMessage);
    }
}
