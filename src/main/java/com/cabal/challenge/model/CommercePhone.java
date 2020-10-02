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
@Entity(name = "COMMERCE_PHONE")
@EntityListeners(AuditingEntityListener.class)
public class CommercePhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "TYPE_NUMBER", nullable = false)
    private String typeNumber;

    @OneToOne
    @JsonBackReference
    private Commerce commerce;

    public void setNumber(String number) {
        this.number = number.replaceAll("[^a-zA-Z0-9]+", "");
    }

}
