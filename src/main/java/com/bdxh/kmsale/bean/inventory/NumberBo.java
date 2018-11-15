package com.bdxh.kmsale.bean.inventory;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.bdxh.kmsale.bean.Result;

public class NumberBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NumberType level_type;
	private String svcNumber;
	private String simNumber;
	private Date insertDate;
	private BigInteger[] simNumbers;
	private BigInteger[] svcNumbers;
	private NumberInPo numberin;
	private String operId;
	private String branchId;
	private String operator;
	private File svcNumberFile;
	private String svcNumberFileFileName;
	private String svcNumberFileContentType;
	private Result result;
	private BigDecimal successCount;
	private Integer cardType;
	private String operType;
	public String getSvcNumber() {
		return svcNumber;
	}
	
	public NumberType getLevel_type() {
		return level_type;
	}

	public void setLevel_type(NumberType level_type) {
		this.level_type = level_type;
	}

	public void setSvcNumber(String svcNumber) {
		this.svcNumber = svcNumber;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public BigInteger[] getSimNumbers() {
		return simNumbers;
	}
	public void setSimNumbers(BigInteger[] simNumbers) {
		this.simNumbers = simNumbers;
	}
	public BigInteger[] getSvcNumbers() {
		return svcNumbers;
	}
	public void setSvcNumbers(BigInteger[] svcNumbers) {
		this.svcNumbers = svcNumbers;
	}
	public NumberInPo getNumberin() {
		return numberin;
	}
	public void setNumberin(NumberInPo numberin) {
		this.numberin = numberin;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public File getSvcNumberFile() {
		return svcNumberFile;
	}
	public void setSvcNumberFile(File svcNumberFile) {
		this.svcNumberFile = svcNumberFile;
	}
	public String getSvcNumberFileFileName() {
		return svcNumberFileFileName;
	}
	public void setSvcNumberFileFileName(String svcNumberFileFileName) {
		this.svcNumberFileFileName = svcNumberFileFileName;
	}
	public String getSvcNumberFileContentType() {
		return svcNumberFileContentType;
	}
	public void setSvcNumberFileContentType(String svcNumberFileContentType) {
		this.svcNumberFileContentType = svcNumberFileContentType;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public BigDecimal getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(BigDecimal successCount) {
		this.successCount = successCount;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
