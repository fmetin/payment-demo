package com.fmetin.payment.data;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:32
 */
@Data
public class PaymentTransactionRequestDto {

    private String name;
    private String surname;
    private BigDecimal amount;
}
