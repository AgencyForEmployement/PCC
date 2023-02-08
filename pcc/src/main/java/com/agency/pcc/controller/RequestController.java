package com.agency.pcc.controller;

import com.agency.pcc.dto.BankTransactionRequestDto;
import com.agency.pcc.dto.CardRequestDto;
import com.agency.pcc.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/requests")
@AllArgsConstructor
public class RequestController {
    private final RequestService requestService;
    private RestTemplate restTemplate;

    @PostMapping
    //banka 1 gadja ovaj api za zahtev placanja, i onda pcc salje banci 2, ona mu vraca odgovor i ovaj salje na banku 1
    public ResponseEntity<String> cardTransactionRequest(@RequestBody CardRequestDto cardRequestDto) {

        if (requestService.processPaymentRequest(cardRequestDto) != null) {

            BankTransactionRequestDto bankTransaction = restTemplate.postForObject(requestService.getAcquirerBankUrl(cardRequestDto.pan), cardRequestDto, BankTransactionRequestDto.class); //salje na banku kupca?

            //gadja prvu banku da prosledi odgovor
            String  urlBank1 = requestService.getAcquirerBankUrl(bankTransaction.getAcquirerPan());
           HttpStatus response =  restTemplate.postForObject("http://localhost:8083/payment/transaction", bankTransaction, HttpStatus.class); //prosledjuje odgovor banci prodavca

            return new ResponseEntity<>(HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}