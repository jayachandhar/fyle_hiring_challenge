package com.github.jayachandhar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @Column(name = "ifsc")
    private String ifscCode;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "state")
    private String state;

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(ifscCode, bank.ifscCode) &&
                Objects.equals(bankName, bank.bankName) &&
                Objects.equals(branchName, bank.branchName) &&
                Objects.equals(branchAddress, bank.branchAddress) &&
                Objects.equals(city, bank.city) &&
                Objects.equals(district, bank.district) &&
                Objects.equals(state, bank.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ifscCode, bankName, branchName, branchAddress, city, district, state);
    }
}
