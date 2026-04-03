package com.insurance_policy.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Client_dto {

    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\s[A-Z][a-z]+$", message = "First letter capital, space between first and last name")
    private String name;

    @NotNull(message = "Date of birth cannot be null")
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/([0-9]{4})$", message = "Date format dd/MM/yyyy")
    private String dob;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^(0|91)?[7-9][0-9]{9}$", message = "Enter valid phone number")
    private String phoneNo;

    @NotNull(message = "Address cannot be null")
    @Valid
    private Address address;

    private List<Integer> policy_No;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Integer> getPolicy_No() { return policy_No; }
    public void setPolicy_No(List<Integer> policy_No) { this.policy_No = policy_No; }
}