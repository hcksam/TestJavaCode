package Hibernate.model;

// Generated 2015�~6��23�� �U��07:41:21 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Supplierproductline generated by hbm2java
 */
public class Supplierproductline implements java.io.Serializable {

	private SupplierproductlineId id;
	private Product product;
	private Supplier supplier;
	private Integer rmbprice;
	private Integer hkdprice;
	private String supplierProductRemark;
	private byte[] supplierProductStatus;
	private int lastUpdateUser;
	private Date lastUpdateDate;
	private Set<Logisticsorderline> logisticsorderlines = new HashSet<Logisticsorderline>(
			0);
	private Set<Lend> lends = new HashSet<Lend>(0);
	private Set<Supplierpreorderline> supplierpreorderlines = new HashSet<Supplierpreorderline>(
			0);
	private Set<Lost> losts = new HashSet<Lost>(0);
	private Set<Inventory> inventories = new HashSet<Inventory>(0);
	private Set<Supplierorderline> supplierorderlines = new HashSet<Supplierorderline>(
			0);
	private Set<Sales> saleses = new HashSet<Sales>(0);

	public Supplierproductline() {
	}

	public Supplierproductline(SupplierproductlineId id, Product product,
			Supplier supplier, byte[] supplierProductStatus,
			int lastUpdateUser, Date lastUpdateDate) {
		this.id = id;
		this.product = product;
		this.supplier = supplier;
		this.supplierProductStatus = supplierProductStatus;
		this.lastUpdateUser = lastUpdateUser;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Supplierproductline(SupplierproductlineId id, Product product,
			Supplier supplier, Integer rmbprice, Integer hkdprice,
			String supplierProductRemark, byte[] supplierProductStatus,
			int lastUpdateUser, Date lastUpdateDate,
			Set<Logisticsorderline> logisticsorderlines, Set<Lend> lends,
			Set<Supplierpreorderline> supplierpreorderlines, Set<Lost> losts,
			Set<Inventory> inventories,
			Set<Supplierorderline> supplierorderlines, Set<Sales> saleses) {
		this.id = id;
		this.product = product;
		this.supplier = supplier;
		this.rmbprice = rmbprice;
		this.hkdprice = hkdprice;
		this.supplierProductRemark = supplierProductRemark;
		this.supplierProductStatus = supplierProductStatus;
		this.lastUpdateUser = lastUpdateUser;
		this.lastUpdateDate = lastUpdateDate;
		this.logisticsorderlines = logisticsorderlines;
		this.lends = lends;
		this.supplierpreorderlines = supplierpreorderlines;
		this.losts = losts;
		this.inventories = inventories;
		this.supplierorderlines = supplierorderlines;
		this.saleses = saleses;
	}

	public SupplierproductlineId getId() {
		return this.id;
	}

	public void setId(SupplierproductlineId id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Integer getRmbprice() {
		return this.rmbprice;
	}

	public void setRmbprice(Integer rmbprice) {
		this.rmbprice = rmbprice;
	}

	public Integer getHkdprice() {
		return this.hkdprice;
	}

	public void setHkdprice(Integer hkdprice) {
		this.hkdprice = hkdprice;
	}

	public String getSupplierProductRemark() {
		return this.supplierProductRemark;
	}

	public void setSupplierProductRemark(String supplierProductRemark) {
		this.supplierProductRemark = supplierProductRemark;
	}

	public byte[] getSupplierProductStatus() {
		return this.supplierProductStatus;
	}

	public void setSupplierProductStatus(byte[] supplierProductStatus) {
		this.supplierProductStatus = supplierProductStatus;
	}

	public int getLastUpdateUser() {
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser(int lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Set<Logisticsorderline> getLogisticsorderlines() {
		return this.logisticsorderlines;
	}

	public void setLogisticsorderlines(
			Set<Logisticsorderline> logisticsorderlines) {
		this.logisticsorderlines = logisticsorderlines;
	}

	public Set<Lend> getLends() {
		return this.lends;
	}

	public void setLends(Set<Lend> lends) {
		this.lends = lends;
	}

	public Set<Supplierpreorderline> getSupplierpreorderlines() {
		return this.supplierpreorderlines;
	}

	public void setSupplierpreorderlines(
			Set<Supplierpreorderline> supplierpreorderlines) {
		this.supplierpreorderlines = supplierpreorderlines;
	}

	public Set<Lost> getLosts() {
		return this.losts;
	}

	public void setLosts(Set<Lost> losts) {
		this.losts = losts;
	}

	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Set<Supplierorderline> getSupplierorderlines() {
		return this.supplierorderlines;
	}

	public void setSupplierorderlines(Set<Supplierorderline> supplierorderlines) {
		this.supplierorderlines = supplierorderlines;
	}

	public Set<Sales> getSaleses() {
		return this.saleses;
	}

	public void setSaleses(Set<Sales> saleses) {
		this.saleses = saleses;
	}

}
