package br.com.sizer.model;

import java.util.List;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity
@Table(name = "company")
public class Company {
	@ApiModelProperty(value = "Id Empresa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ApiModelProperty(value = "Nome da Empresa")
    @Column(name = "name", length = 255)
    private String name;

	@ApiModelProperty(value = "Máximo de Lojas Permitidas")	
    @Column(name = "maxStores", length = 4)
    private int maxStores;

	@ApiModelProperty(value = "Criado por")
    @Column(name = "createdBy")
    private String createdBy;
    
    @OneToMany(mappedBy = "company")
    private List<Store> store;
    

}
