package com.bdxh.kmsale.bean;

import com.bdxh.kmsale.utils.DateUtils;
import com.bdxh.kmsale.utils.Persistable;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractEntity implements Persistable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5317807969131838485L;
	

	@Override
	public abstract Long getId();

	public abstract void setId(final Long id);

	/** 创建人 */
	protected String createBy;

	/** 创建人用户编号 */
	protected Long createUid;

	/** 修改人 */
	protected String modifyBy;

	/** 修改人用户编号 */
	protected Long modifyUid;

	/** 创建时间 */
	protected Date createDate;

	/** 修改时间 */
	protected Date modifyDate;

	/** 版本号,用于数据库乐观锁 */
	@JsonIgnore
	protected Long version = -1L;

	protected String agentId;

	public void setTrackingModify() {
		setTrackingModify(null);
	}

	public void setTrackingModify(String modifyBy) {
		if (StringUtils.isNotBlank(modifyBy)) {
			this.modifyBy = modifyBy;
		}
		this.modifyDate = DateUtils.now();
	}

	public void setTrackingModify(String createBy, Long createUid) {
		setTrackingModify(modifyBy);
		this.createUid = createUid;
	}

	public void setTrackingSave(String createBy, String modifyBy) {
		Date now = DateUtils.now();
		setTrackingSave(createBy, now, modifyBy, now);
	}

	public void setTrackingSave(Long createUid) {
		setTrackingSave(createUid, DateUtils.now(), null, null);
	}

	public void setTrackingSave(String createBy, Date createDate, String modifyBy, Date modifyDate) {
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	public void setTrackingSave(Long createUid, Date createDate, Long modifyUid, Date modifyDate) {
		this.createUid = createUid;
		this.createDate = createDate;
		this.modifyUid = modifyUid;
		this.modifyDate = modifyDate;
	}

	@Override
	@JsonIgnore
	public boolean isNew() {
		return null == getId();
	}

	@Override
	public void beforPersist() {
		setCreateDate(new Date());
	}

	@Override
	public void afterPersist() {
	}

	@Override
	public void beforUpdate() {
		setModifyDate(new Date());
	}

	@Override
	public void afterUpdate() {
	}

	@Override
	public void beforRemove() {
	}

	@Override
	public void afterRemove() {
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getCreateUid() {
		return createUid;
	}

	public void setCreateUid(Long createUid) {
		this.createUid = createUid;
	}

	public Long getModifyUid() {
		return modifyUid;
	}

	public void setModifyUid(Long modifyUid) {
		this.modifyUid = modifyUid;
	}

	@Override
	public boolean equals(Object obj) {

		if (null == obj) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!getClass().equals(obj.getClass())) {
			return false;
		}

		AbstractEntity that = (AbstractEntity) obj;

		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {

		int hashCode = 17;

		hashCode += null == getId() ? 0 : getId().hashCode() * 31;

		return hashCode;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

}
