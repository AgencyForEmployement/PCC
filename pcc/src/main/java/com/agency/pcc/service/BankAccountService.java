package com.agency.pcc.service;

import com.agency.pcc.model.BankAccount;
import com.agency.pcc.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccount findByPan(String pan){return bankAccountRepository.findByPan(pan);}
}
