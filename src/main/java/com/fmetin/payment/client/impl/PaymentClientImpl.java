package com.fmetin.payment.client.impl;

import com.fmetin.payment.client.PaymentClient;
import com.fmetin.payment.data.PaymentClientRequestDto;
import com.fmetin.payment.data.PaymentClientResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Author: Fatih Metin
 * Date: 12.04.2022
 * Time: 20:37
 */
@Service
public class PaymentClientImpl implements PaymentClient {
    @Value("${payment.url:http://localhost:8888/v1/payment}")
    private String url;


    @Override
    public PaymentClientResponseDto transfer(PaymentClientRequestDto requestDto) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PaymentClientResponseDto> response;
        try {
            URI uri = new URI(url);
            response = restTemplate.postForEntity(uri, requestDto, PaymentClientResponseDto.class);
        } catch (Exception e) {
            return new PaymentClientResponseDto(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()), HttpStatus.SERVICE_UNAVAILABLE.toString());
        }

        return response.getBody();

    }


}
