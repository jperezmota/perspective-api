package com.jonathanperez.perspective.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<T> {
	
	interface AuditLogValidation {

	}

	@Column(name = "created_by")
	@NotNull(groups = AuditLogValidation.class)
	@CreatedBy
	private T createdBy;
	
	@Column(name = "created_date")
	@NotNull(groups = AuditLogValidation.class)
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "last_modified_by")
	@LastModifiedBy
	private T lastModifiedBy;
	
	@Column(name = "last_modified_date")
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@Column(name = "deleted")
	private boolean isDeleted;
	
	@Column(name = "deleted_by")
	private String deletedBy;
	
	@Column(name = "deleted_date")
	private Date deletedDate;

	public T getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(T createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public T getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(T lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}
	
}
