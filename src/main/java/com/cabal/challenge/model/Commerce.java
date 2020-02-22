package com.cabal.challenge.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "COMMERCE")
@EntityListeners(AuditingEntityListener.class)
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 20, max = 100)
    @Column(name = "NAME", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String name;

    @CNPJ
    @Column(name = "CPNJ", nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "commerce", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<CommercePhone> commercePhones;

    @OneToOne(mappedBy = "commerce", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private CommerceAddress commerceAddresses;

    @OneToMany(mappedBy = "commerce", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<CommerceEmail> commerceEmails;

    public Commerce(long id) {
        this.setId(id);
    }
}
