package com.fmetin.payment.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentClientResponseDto {

    private String responseCode;
    private String responseMessage;
}
