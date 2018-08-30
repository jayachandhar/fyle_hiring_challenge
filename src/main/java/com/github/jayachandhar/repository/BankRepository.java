package com.github.jayachandhar.repository;

import com.github.jayachandhar.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Serializable> {
    List<Bank> getBanksByBankNameContainingAndCity(String bankName, String city);
}
