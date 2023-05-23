package br.com.loja.fcs.domain.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Role(Long id) {
        this.id = id;
    }

}