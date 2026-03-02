package com.KartikeySingh.project.UberApp.Uber_Cl.dto;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.TransactionMethod;
import com.KartikeySingh.project.UberApp.Uber_Cl.entities.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class WalletTransactionDTO {
    private Long id;
    private Double amount;
    private TransactionType transactiontype;
    private TransactionMethod transactionMethod;
    private RideDTO ride;
    private String transactionId;
    private WalletDTO wallet;
    private LocalDateTime timestamp;
}
