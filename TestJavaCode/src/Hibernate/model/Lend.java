package Hibernate.model;

// Generated 2015�~6��23�� �U��07:41:21 by Hibernate Tools 4.3.1

/**
 * Lend generated by hbm2java
 */
public class Lend implements java.io.Serializable {

	private LendId id;
	private Supplierproductline supplierproductline;

	public Lend() {
	}

	public Lend(LendId id) {
		this.id = id;
	}

	public Lend(LendId id, Supplierproductline supplierproductline) {
		this.id = id;
		this.supplierproductline = supplierproductline;
	}

	public LendId getId() {
		return this.id;
	}

	public void setId(LendId id) {
		this.id = id;
	}

	public Supplierproductline getSupplierproductline() {
		return this.supplierproductline;
	}

	public void setSupplierproductline(Supplierproductline supplierproductline) {
		this.supplierproductline = supplierproductline;
	}

}
