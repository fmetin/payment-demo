package com.fmetin.payment.data;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:35
 */
@Data
public class PaymentClientRequestDto {
    private String transactionId;
    private BigDecimal amount;
}
