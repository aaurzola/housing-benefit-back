package com.aaurzola.housingbenefit.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "BENEFIT_APPLICATION")
public class BenefitApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BENEFIT_APPLICATION_SEQ")
    @SequenceGenerator(name = "BENEFIT_APPLICATION_SEQ", sequenceName = "BENEFIT_APPLICATION_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Column(name = "IS_APPROVED", insertable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
    private Character isApproved = 'N';

    @ManyToOne()
    @JoinColumn(name = "BENEFIT_TYPE_ID", referencedColumnName = "ID")
    private BenefitType benefitTypeId;

    @Column(name = "HOUSING_TYPE_ID")
    private String housingTypeId;

}
