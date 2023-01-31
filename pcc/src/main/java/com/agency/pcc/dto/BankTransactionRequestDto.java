package com.agency.pcc.dto;


import com.agency.pcc.controller.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class BankTransactionRequestDto {
    private TransactionStatus transactionStatus;
    private int merchantOrderId;
    private int acquirerOrderId;
    private LocalDateTime acquirerTimestamp;
    private int issuerOrderId;
    private LocalDateTime issuerOrderTimestamp;
    private int paymentId;
    private double amount;
    private String description;
    private String payer;
    private String acquirerPan;
}
