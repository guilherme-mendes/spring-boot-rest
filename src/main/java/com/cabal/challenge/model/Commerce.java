package com.cabal.challenge.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COMMERCES")
@EntityListeners(AuditingEntityListener.class)
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 20, max = 100)
    @Column(name = "NAME", nullable = false)
    private String name;

    @CNPJ
    @Column(name = "CPNJ", nullable = false)
    private String cnpj;

    @OneToOne(mappedBy = "commerce", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private CommerceAddress commerceAddress;

    @OneToMany(mappedBy = "commerce", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<CommerceEmail> commerceEmails;

    @OneToMany(mappedBy = "commerce", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<CommercePhone> commercePhones;

}
