package br.dsp.projeto.sglcspringjpa.entiity;

import java.util.Date;

import br.dsp.projeto.sglcspringjpa.entiity.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQueries({
		@NamedQuery(name = "pessoaPorCpf", query = "select p from Pessoa p where p.cpf = :cpf")
})
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoas")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 200, message = "O nome deve ter entre 3 e 200 caracteres")
    @Column(nullable = false)
    private String nome;

   /*  @NotNull(message = "A data de nascimento é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento; */

    @NotBlank(message = "Digite um e-maail válido")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 digitos")
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotNull(message = "O sexo é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name= "sexo", nullable = false)
    private Sexo sexo;

}