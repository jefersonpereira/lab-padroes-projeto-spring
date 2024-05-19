package br.com.sizer.model;

import java.util.List;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "store")
public class Store {
	@ApiModelProperty(value = "Id Loja")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ApiModelProperty(value = "Nome da Loja")
    @Column(name = "name", length = 255)
    private String name;

	@ApiModelProperty(value = "URL da Loja")
    @Column(name = "url", length = 255)
    private String url;

	@ApiModelProperty(value = "Limite de Produtos Permitido")
    @Column(name = "maxProducts", length = 7)
    private int maxProducts;

	@ApiModelProperty(value = "Criado por")
    @Column(name = "createdBy")
    private String createdBy;
    
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    
    private Company company;
    
    @OneToMany(mappedBy = "store")
    private List<Product> product;



    public Store(String name, String url, int maxProducts, String createdBy, Company company) {
		super();
		this.name = name;
		this.url = url;
		this.maxProducts = maxProducts;
		this.createdBy = createdBy;
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMaxProducts() {
        return maxProducts;
    }

    public void setMaxProducts(int maxProducts) {
        this.maxProducts = maxProducts;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String author) {
        this.createdBy = author;
    }

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", url=" + url + ", maxProducts=" + maxProducts + ", createdBy="
				+ createdBy + ", company=" + company + "]";
	}
    
    
}
