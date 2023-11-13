package com.aaurzola.housingbenefit.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "BENEFIT_TYPE")
public class BenefitType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;

    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
}