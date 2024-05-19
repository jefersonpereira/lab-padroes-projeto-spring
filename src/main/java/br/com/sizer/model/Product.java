package br.com.sizer.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "productId", length = 7)
    private int productId;

    @Column(name = "skuId", length = 7)
    private int skuId;

    // busto
    @Column(name = "bust", length = 3)
    private int bust;

    // cintura
    @Column(name = "waist", length = 3)
    private int waist;

    // quadril
    @Column(name = "hip", length = 3)
    private int hip;

    // comprimento
    @Column(name = "length", length = 3)
    private int length;

    
    @Column(name = "createdBy")
    private String createdBy;
    
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    
    private Store store;
    
    

	public Product(String name, int productId, int skuId, int bust, int waist, int hip, int length, String createdBy,
			Store store) {
		super();
		this.name = name;
		this.productId = productId;
		this.skuId = skuId;
		this.bust = bust;
		this.waist = waist;
		this.hip = hip;
		this.length = length;
		this.createdBy = createdBy;
		this.store = store;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public int getBust() {
		return bust;
	}

	public void setBust(int bust) {
		this.bust = bust;
	}

	public int getWaist() {
		return waist;
	}

	public void setWaist(int waist) {
		this.waist = waist;
	}

	public int getHip() {
		return hip;
	}

	public void setHip(int hip) {
		this.hip = hip;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productId=" + productId + ", skuId=" + skuId + ", bust="
				+ bust + ", waist=" + waist + ", hip=" + hip + ", length=" + length + ", createdBy=" + createdBy
				+ ", store=" + store + "]";
	}
    
}
