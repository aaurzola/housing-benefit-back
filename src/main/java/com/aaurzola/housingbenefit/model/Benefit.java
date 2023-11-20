package com.aaurzola.housingbenefit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "BENEFIT")
public class Benefit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;


    @Column(name = "BENEFIT_APPLICATION_ID")
    private Long benefitApplicationId;

    @JoinColumn(name = "BENEFIT_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BenefitType benefitTypeId;
}
