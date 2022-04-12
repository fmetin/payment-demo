package com.fmetin.payment.client;

import com.fmetin.payment.data.PaymentClientRequestDto;
import com.fmetin.payment.data.PaymentClientResponseDto;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:35
 */
public interface PaymentClient {

    PaymentClientResponseDto transfer(PaymentClientRequestDto requestDto);
}
