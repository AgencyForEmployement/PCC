package com.agency.pcc.dto;

import java.time.LocalDateTime;

public class CardRequestDto {
    public String pan;  //issuer, kupac
    public String securityCode;
    public String cardHolderName;
    public String dateExpiration;
    public String description; //sta se kupuje
    public double amount;
    public String panAcquirer; //prodavac, web shop, psp mu ga salje ?
    public int acquirerOrderId; //id transakcije, tip number 10 generisan na banci web shopa
    public LocalDateTime acquirerTimestamp;
}
