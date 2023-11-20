package com.aaurzola.housingbenefit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "INDIVIDUAL")
public class Individual implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;

    @Basic(optional = false)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Basic(optional = false)
    @Column(name = "INCOME")
    private BigDecimal income;

    @Basic(optional = false)
    @Column(name = "IS_PROPERTY_OWNER")
    private Character isPropertyOwner;

    @Basic(optional = false)
    @Column(name = "HAS_HOUSING_SUBSIDY_FUND")
    private Character hasHousingSubsidyFund;

    @Basic(optional = false)
    @Column(name = "HAS_HOUSING_SUBSIDY_GOV")
    private Character hasHousingSubsidyGov;

    @Basic(optional = false)
    @Column(name = "HAS_INTEREST_SUBSIDY")
    private Character hasInterestSubsidy;

}
