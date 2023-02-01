package com.agency.pcc.dto;


import com.agency.pcc.controller.TransactionStatus;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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
