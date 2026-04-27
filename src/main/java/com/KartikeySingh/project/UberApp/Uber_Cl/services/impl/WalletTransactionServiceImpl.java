package com.KartikeySingh.project.UberApp.Uber_Cl.services.impl;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.WalletTransaction;
import com.KartikeySingh.project.UberApp.Uber_Cl.repositories.WalletTransactionRepository;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;
    @Override
    public void CreateNewWalletTransaction(WalletTransaction walletTransaction) {

        walletTransactionRepository.save(walletTransaction);

    }
}
