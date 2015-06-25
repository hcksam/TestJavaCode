package Hibernate.model;

// Generated 2015�~6��23�� �U��07:41:21 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * LogisticsorderlineId generated by hbm2java
 */
public class LogisticsorderlineId implements java.io.Serializable {

	private Integer quantity;
	private Integer receiveQuantity;
	private String logisticsOrderProductStatus;
	private Integer lastUpdateUser;
	private Date lastUpdateDate;
	private Integer logisticsOrderId;
	private Integer supplierId;
	private Integer productId;

	public LogisticsorderlineId() {
	}

	public LogisticsorderlineId(String logisticsOrderProductStatus) {
		this.logisticsOrderProductStatus = logisticsOrderProductStatus;
	}

	public LogisticsorderlineId(Integer quantity, Integer receiveQuantity,
			String logisticsOrderProductStatus, Integer lastUpdateUser,
			Date lastUpdateDate, Integer logisticsOrderId, Integer supplierId,
			Integer productId) {
		this.quantity = quantity;
		this.receiveQuantity = receiveQuantity;
		this.logisticsOrderProductStatus = logisticsOrderProductStatus;
		this.lastUpdateUser = lastUpdateUser;
		this.lastUpdateDate = lastUpdateDate;
		this.logisticsOrderId = logisticsOrderId;
		this.supplierId = supplierId;
		this.productId = productId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getReceiveQuantity() {
		return this.receiveQuantity;
	}

	public void setReceiveQuantity(Integer receiveQuantity) {
		this.receiveQuantity = receiveQuantity;
	}

	public String getLogisticsOrderProductStatus() {
		return this.logisticsOrderProductStatus;
	}

	public void setLogisticsOrderProductStatus(
			String logisticsOrderProductStatus) {
		this.logisticsOrderProductStatus = logisticsOrderProductStatus;
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

	public Integer getLogisticsOrderId() {
		return this.logisticsOrderId;
	}

	public void setLogisticsOrderId(Integer logisticsOrderId) {
		this.logisticsOrderId = logisticsOrderId;
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
		if (!(other instanceof LogisticsorderlineId))
			return false;
		LogisticsorderlineId castOther = (LogisticsorderlineId) other;

		return ((this.getQuantity() == castOther.getQuantity()) || (this
				.getQuantity() != null && castOther.getQuantity() != null && this
				.getQuantity().equals(castOther.getQuantity())))
				&& ((this.getReceiveQuantity() == castOther
						.getReceiveQuantity()) || (this.getReceiveQuantity() != null
						&& castOther.getReceiveQuantity() != null && this
						.getReceiveQuantity().equals(
								castOther.getReceiveQuantity())))
				&& ((this.getLogisticsOrderProductStatus() == castOther
						.getLogisticsOrderProductStatus()) || (this
						.getLogisticsOrderProductStatus() != null
						&& castOther.getLogisticsOrderProductStatus() != null && this
						.getLogisticsOrderProductStatus().equals(
								castOther.getLogisticsOrderProductStatus())))
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
				&& ((this.getLogisticsOrderId() == castOther
						.getLogisticsOrderId()) || (this.getLogisticsOrderId() != null
						&& castOther.getLogisticsOrderId() != null && this
						.getLogisticsOrderId().equals(
								castOther.getLogisticsOrderId())))
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
				+ (getReceiveQuantity() == null ? 0 : this.getReceiveQuantity()
						.hashCode());
		result = 37
				* result
				+ (getLogisticsOrderProductStatus() == null ? 0 : this
						.getLogisticsOrderProductStatus().hashCode());
		result = 37
				* result
				+ (getLastUpdateUser() == null ? 0 : this.getLastUpdateUser()
						.hashCode());
		result = 37
				* result
				+ (getLastUpdateDate() == null ? 0 : this.getLastUpdateDate()
						.hashCode());
		result = 37
				* result
				+ (getLogisticsOrderId() == null ? 0 : this
						.getLogisticsOrderId().hashCode());
		result = 37
				* result
				+ (getSupplierId() == null ? 0 : this.getSupplierId()
						.hashCode());
		result = 37 * result
				+ (getProductId() == null ? 0 : this.getProductId().hashCode());
		return result;
	}

}
