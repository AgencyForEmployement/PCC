package com.agency.pcc.controller;

import com.agency.pcc.dto.BankTransactionRequestDto;
import com.agency.pcc.dto.CardRequestDto;
import com.agency.pcc.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
@RequestMapping("/requests")
@AllArgsConstructor
public class RequestController {
    private final RequestService requestService;
    private RestTemplate restTemplate;

    @PostMapping
    public void cardTransactionRequest(@RequestBody CardRequestDto cardRequestDto) throws Exception {
        try {
            if (requestService.processPaymentRequest(cardRequestDto) != null)
                restTemplate.postForObject(requestService.getAcquirerBankUrl(cardRequestDto.panAcquirer), cardRequestDto, cardRequestDto.getClass()); //salje na banku prodavca
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @PostMapping("/final-payment")
    public void bankTransactionFinis(@RequestBody BankTransactionRequestDto transactionRequestDto) throws Exception {
          restTemplate.postForObject(requestService.getAcquirerBankUrl(requestService.getAcquirerBankUrl(transactionRequestDto.getAcquirerPan())),
                  transactionRequestDto, BankTransactionRequestDto.class); //prosledjuje odgovor banci prodavca
    }
}
