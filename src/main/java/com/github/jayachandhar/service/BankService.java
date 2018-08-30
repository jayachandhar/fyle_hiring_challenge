package com.github.jayachandhar.service;

import com.github.jayachandhar.exception.GenericRunTimeException;
import com.github.jayachandhar.model.Bank;
import com.github.jayachandhar.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public Bank getDetailsByIfscCode(String ifscCode) {
        if (StringUtils.isEmpty(ifscCode) || ifscCode.length() != 11)
            throw new GenericRunTimeException("4005", "Invalid IFSC code");
        Bank bank = bankRepository.findOne(ifscCode);
        if (bank != null)
            return bank;
        else
            throw new GenericRunTimeException("4004", "No Record available");
    }

    public List<Bank> getBanksByNameCity(String bankName, String city) {
        if (StringUtils.isEmpty(city))
            throw new GenericRunTimeException("4005", "Invalid City name");
        if (StringUtils.isEmpty(bankName))
            throw new GenericRunTimeException("4005", "Invalid Bank name");
        bankName = bankName.toUpperCase().replace("\"", "");
        city = city.toUpperCase().replace("\"", "");
        List<Bank> banks = bankRepository.getBanksByBankNameContainingAndCity(bankName, city);
        if (banks != null && banks.size() != 0)
            return banks;
        else
            throw new GenericRunTimeException("4004", "No Record available");
    }

    public String getIfscCode(String bankName, String branchName) {
        if (StringUtils.isEmpty(branchName))
            throw new GenericRunTimeException("4005", "Invalid Branch name");
        if (StringUtils.isEmpty(bankName))
            throw new GenericRunTimeException("4005", "Invalid Bank name");
        bankName = bankName.toUpperCase().replace("\"", "");
        branchName = branchName.toUpperCase().replace("\"", "");
        Bank bank = bankRepository.getBankByBankNameContainingAndBranchNameContaining(bankName, branchName);
        if (bank != null && bank.getIfscCode().length() != 0)
            return bank.getIfscCode();
        else
            throw new GenericRunTimeException("4004", "No Record available");
    }

    public String validateIfsc(String ifscCode) {
        if (StringUtils.isEmpty(ifscCode) || ifscCode.length() != 11)
            throw new GenericRunTimeException("4005", "Invalid IFSC code");
        if (bankRepository.exists(ifscCode))
            return "exists";
        else
            return "not exists";

    }
}
