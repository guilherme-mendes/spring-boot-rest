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
@Entity(name = "COMMERCE_EMAIL")
@EntityListeners(AuditingEntityListener.class)
public class CommerceEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @OneToOne()
    @JsonBackReference
    private Commerce commerce;

}
