package com.agency.pcc.service;

import com.agency.pcc.dto.CardRequestDto;
import com.agency.pcc.model.BankAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestService {

    private final BankAccountService bankAccountService;

    public CardRequestDto processPaymentRequest(CardRequestDto cardRequestDto) {
        if(bankAccountService.findByPan(cardRequestDto.pan) != null
                && bankAccountService.findByPan(cardRequestDto.panAcquirer) != null){
            return cardRequestDto; //oba racuna pronadjena
        }
        return null;
    }

    public String getAcquirerBankUrl(String panAcquirer){
        return bankAccountService.findByPan(panAcquirer).getBankUrl();
    }
}
