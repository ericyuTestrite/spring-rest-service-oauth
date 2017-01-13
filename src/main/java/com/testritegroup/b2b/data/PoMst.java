package com.testritegroup.b2b.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PO_MST")
public class PoMst {
	@Column(name = "HUB_ID", nullable = false)
	private String hubId;
	
	public String getHubId() {
		return hubId;
	}

	public void setHubId(String hubId) {
		this.hubId = hubId;
	}

	public String getCompanyId() {
		return companyNo;
	}

	public void setCompanyId(String companyId) {
		this.companyNo = companyId;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	public String getVendorNo() {
		return vendorNo;
	}

	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}

	public String getOrderDept() {
		return orderDept;
	}

	public void setOrderDept(String orderDept) {
		this.orderDept = orderDept;
	}

	public Long getOldPoNo() {
		return oldPoNo;
	}

	public void setOldPoNo(Long oldPoNo) {
		this.oldPoNo = oldPoNo;
	}

	@Column(name = "COMPANY_NO", nullable = false)
	private String companyNo;
	
	@Column(name = "PURCHASE_ID", nullable = false)
	private String purchaseId;
	
	@Id
	@Column(name = "PO_NO", nullable = false)
	private String poNo;
	
	@Column(name = "ORDER_DATE", nullable = false)
	private Date orderDate;
	
	@Column(name = "PO_TYPE", nullable = false)
	private String poType;
	
	@Column(name = "VENDOR_NO", nullable = false)
	private String vendorNo;
	
	@Column(name = "ORDER_DEPT", nullable = false)
	private String orderDept;
	
	@Column(name = "OLD_PO_NO", nullable = false)
	private Long oldPoNo;
	
}
