package com.github.jayachandhar.controller;

import com.github.jayachandhar.exception.ErrorResponse;
import com.github.jayachandhar.exception.GenericRunTimeException;
import com.github.jayachandhar.model.Bank;
import com.github.jayachandhar.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping(value = "/{ifscCode}", produces = {"application/json"})
    public ResponseEntity getBankByCode(@PathVariable String ifscCode) {
        try {
            Bank bank = bankService.getDetailsByIfscCode(ifscCode);
            return new ResponseEntity(bank, HttpStatus.OK);
        } catch (GenericRunTimeException ex) {
            return new ResponseEntity(new ErrorResponse(ex.getErrorCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "nearbybanks", produces = {"application/json"})
    public ResponseEntity getBanksByCityBankName(@RequestParam("bankname") String bankName, @RequestParam("city") String city) {
        try {
            List<Bank> banks = bankService.getBanksByNameCity(bankName, city);
            return new ResponseEntity(banks, HttpStatus.OK);

        } catch (GenericRunTimeException ex) {
            return new ResponseEntity(new ErrorResponse(ex.getErrorCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
