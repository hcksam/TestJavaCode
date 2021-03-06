package Hibernate.model;

// Generated 2015�~6��23�� �U��07:41:21 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Supplierorder generated by hbm2java
 */
public class Supplierorder implements java.io.Serializable {

	private int orderId;
	private Shop shop;
	private Date orderDate;
	private Integer appraiseHkdtotalPrice;
	private Integer rmbtotalPrice;
	private Integer hkdtotalPrice;
	private String orderRemark;
	private String orderStatus;
	private int lastUpdateUser;
	private Date lastUpdateDate;
	private Set<Supplierorderline> supplierorderlines = new HashSet<Supplierorderline>(
			0);

	public Supplierorder() {
	}

	public Supplierorder(int orderId, String orderStatus, int lastUpdateUser,
			Date lastUpdateDate) {
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.lastUpdateUser = lastUpdateUser;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Supplierorder(int orderId, Shop shop, Date orderDate,
			Integer appraiseHkdtotalPrice, Integer rmbtotalPrice,
			Integer hkdtotalPrice, String orderRemark, String orderStatus,
			int lastUpdateUser, Date lastUpdateDate,
			Set<Supplierorderline> supplierorderlines) {
		this.orderId = orderId;
		this.shop = shop;
		this.orderDate = orderDate;
		this.appraiseHkdtotalPrice = appraiseHkdtotalPrice;
		this.rmbtotalPrice = rmbtotalPrice;
		this.hkdtotalPrice = hkdtotalPrice;
		this.orderRemark = orderRemark;
		this.orderStatus = orderStatus;
		this.lastUpdateUser = lastUpdateUser;
		this.lastUpdateDate = lastUpdateDate;
		this.supplierorderlines = supplierorderlines;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getAppraiseHkdtotalPrice() {
		return this.appraiseHkdtotalPrice;
	}

	public void setAppraiseHkdtotalPrice(Integer appraiseHkdtotalPrice) {
		this.appraiseHkdtotalPrice = appraiseHkdtotalPrice;
	}

	public Integer getRmbtotalPrice() {
		return this.rmbtotalPrice;
	}

	public void setRmbtotalPrice(Integer rmbtotalPrice) {
		this.rmbtotalPrice = rmbtotalPrice;
	}

	public Integer getHkdtotalPrice() {
		return this.hkdtotalPrice;
	}

	public void setHkdtotalPrice(Integer hkdtotalPrice) {
		this.hkdtotalPrice = hkdtotalPrice;
	}

	public String getOrderRemark() {
		return this.orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	public Set<Supplierorderline> getSupplierorderlines() {
		return this.supplierorderlines;
	}

	public void setSupplierorderlines(Set<Supplierorderline> supplierorderlines) {
		this.supplierorderlines = supplierorderlines;
	}

}
