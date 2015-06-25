package Hibernate.model;

// Generated 2015�~6��23�� �U��07:41:21 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Productcompany generated by hbm2java
 */
public class Productcompany implements java.io.Serializable {

	private int productCompanyId;
	private String productCompanyName;
	private String productCompanyStatus;
	private Integer lastUpdateUser;
	private Date lastUpdateDate;
	private Set<Mobileproduct> mobileproducts = new HashSet<Mobileproduct>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Productcompany() {
	}

	public Productcompany(int productCompanyId, String productCompanyName) {
		this.productCompanyId = productCompanyId;
		this.productCompanyName = productCompanyName;
	}

	public Productcompany(int productCompanyId, String productCompanyName,
			String productCompanyStatus, Integer lastUpdateUser,
			Date lastUpdateDate, Set<Mobileproduct> mobileproducts,
			Set<Product> products) {
		this.productCompanyId = productCompanyId;
		this.productCompanyName = productCompanyName;
		this.productCompanyStatus = productCompanyStatus;
		this.lastUpdateUser = lastUpdateUser;
		this.lastUpdateDate = lastUpdateDate;
		this.mobileproducts = mobileproducts;
		this.products = products;
	}

	public int getProductCompanyId() {
		return this.productCompanyId;
	}

	public void setProductCompanyId(int productCompanyId) {
		this.productCompanyId = productCompanyId;
	}

	public String getProductCompanyName() {
		return this.productCompanyName;
	}

	public void setProductCompanyName(String productCompanyName) {
		this.productCompanyName = productCompanyName;
	}

	public String getProductCompanyStatus() {
		return this.productCompanyStatus;
	}

	public void setProductCompanyStatus(String productCompanyStatus) {
		this.productCompanyStatus = productCompanyStatus;
	}

	public Integer getLastUpdateUser() {
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser(Integer lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Set<Mobileproduct> getMobileproducts() {
		return this.mobileproducts;
	}

	public void setMobileproducts(Set<Mobileproduct> mobileproducts) {
		this.mobileproducts = mobileproducts;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
