package com.cabal.challenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COMMERCE_ADDRESS")
@EntityListeners(AuditingEntityListener.class)
public class CommerceAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "PUBLIC_PLACE", nullable = false)
    private String publicPlace;

    @Column(name = "DISTRICT", nullable = false)
    private String district;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "UF", nullable = false)
    private String uf;

    @Column(name = "ADDITIONAL_ADDRESS")
    private String additionalAddress;

    @OneToOne()
    @JsonBackReference
    private Commerce commerce;

    public void setCep(String cep) {
        this.cep = cep.replaceAll("[^a-zA-Z0-9]+", "");
    }

}
