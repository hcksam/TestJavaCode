package Hibernate.model;

// Generated 2015�~6��23�� �U��07:41:21 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * LostId generated by hbm2java
 */
public class LostId implements java.io.Serializable {

	private Integer quantity;
	private String lostRemark;
	private String lostStatus;
	private Integer markUser;
	private Date lostDate;
	private Integer lastUpdateUser;
	private Date lastUpdateDate;
	private Integer shopId;
	private Integer supplierId;
	private Integer productId;

	public LostId() {
	}

	public LostId(String lostStatus) {
		this.lostStatus = lostStatus;
	}

	public LostId(Integer quantity, String lostRemark, String lostStatus,
			Integer markUser, Date lostDate, Integer lastUpdateUser,
			Date lastUpdateDate, Integer shopId, Integer supplierId,
			Integer productId) {
		this.quantity = quantity;
		this.lostRemark = lostRemark;
		this.lostStatus = lostStatus;
		this.markUser = markUser;
		this.lostDate = lostDate;
		this.lastUpdateUser = lastUpdateUser;
		this.lastUpdateDate = lastUpdateDate;
		this.shopId = shopId;
		this.supplierId = supplierId;
		this.productId = productId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getLostRemark() {
		return this.lostRemark;
	}

	public void setLostRemark(String lostRemark) {
		this.lostRemark = lostRemark;
	}

	public String getLostStatus() {
		return this.lostStatus;
	}

	public void setLostStatus(String lostStatus) {
		this.lostStatus = lostStatus;
	}

	public Integer getMarkUser() {
		return this.markUser;
	}

	public void setMarkUser(Integer markUser) {
		this.markUser = markUser;
	}

	public Date getLostDate() {
		return this.lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
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

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LostId))
			return false;
		LostId castOther = (LostId) other;

		return ((this.getQuantity() == castOther.getQuantity()) || (this
				.getQuantity() != null && castOther.getQuantity() != null && this
				.getQuantity().equals(castOther.getQuantity())))
				&& ((this.getLostRemark() == castOther.getLostRemark()) || (this
						.getLostRemark() != null
						&& castOther.getLostRemark() != null && this
						.getLostRemark().equals(castOther.getLostRemark())))
				&& ((this.getLostStatus() == castOther.getLostStatus()) || (this
						.getLostStatus() != null
						&& castOther.getLostStatus() != null && this
						.getLostStatus().equals(castOther.getLostStatus())))
				&& ((this.getMarkUser() == castOther.getMarkUser()) || (this
						.getMarkUser() != null
						&& castOther.getMarkUser() != null && this
						.getMarkUser().equals(castOther.getMarkUser())))
				&& ((this.getLostDate() == castOther.getLostDate()) || (this
						.getLostDate() != null
						&& castOther.getLostDate() != null && this
						.getLostDate().equals(castOther.getLostDate())))
				&& ((this.getLastUpdateUser() == castOther.getLastUpdateUser()) || (this
						.getLastUpdateUser() != null
						&& castOther.getLastUpdateUser() != null && this
						.getLastUpdateUser().equals(
								castOther.getLastUpdateUser())))
				&& ((this.getLastUpdateDate() == castOther.getLastUpdateDate()) || (this
						.getLastUpdateDate() != null
						&& castOther.getLastUpdateDate() != null && this
						.getLastUpdateDate().equals(
								castOther.getLastUpdateDate())))
				&& ((this.getShopId() == castOther.getShopId()) || (this
						.getShopId() != null && castOther.getShopId() != null && this
						.getShopId().equals(castOther.getShopId())))
				&& ((this.getSupplierId() == castOther.getSupplierId()) || (this
						.getSupplierId() != null
						&& castOther.getSupplierId() != null && this
						.getSupplierId().equals(castOther.getSupplierId())))
				&& ((this.getProductId() == castOther.getProductId()) || (this
						.getProductId() != null
						&& castOther.getProductId() != null && this
						.getProductId().equals(castOther.getProductId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		result = 37
				* result
				+ (getLostRemark() == null ? 0 : this.getLostRemark()
						.hashCode());
		result = 37
				* result
				+ (getLostStatus() == null ? 0 : this.getLostStatus()
						.hashCode());
		result = 37 * result
				+ (getMarkUser() == null ? 0 : this.getMarkUser().hashCode());
		result = 37 * result
				+ (getLostDate() == null ? 0 : this.getLostDate().hashCode());
		result = 37
				* result
				+ (getLastUpdateUser() == null ? 0 : this.getLastUpdateUser()
						.hashCode());
		result = 37
				* result
				+ (getLastUpdateDate() == null ? 0 : this.getLastUpdateDate()
						.hashCode());
		result = 37 * result
				+ (getShopId() == null ? 0 : this.getShopId().hashCode());
		result = 37
				* result
				+ (getSupplierId() == null ? 0 : this.getSupplierId()
						.hashCode());
		result = 37 * result
				+ (getProductId() == null ? 0 : this.getProductId().hashCode());
		return result;
	}

}
