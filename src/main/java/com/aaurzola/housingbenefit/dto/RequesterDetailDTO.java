package com.aaurzola.housingbenefit.dto;

public interface RequesterDetailDTO {
    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPhoneNumber();
    String getIsPropertyOwner();
    String getHasHousingSubsidyFund();
    String getHasHousingSubsidyGov();
    String getHasInterestSubsidy();
}
