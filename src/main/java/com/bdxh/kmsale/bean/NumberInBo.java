package com.bdxh.kmsale.bean;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class NumberInBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5324004369804779693L;
	
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

	public void setSvcNumber(String svcNumber) {
		this.svcNumber = svcNumber;
	}

	public String getSvcNumber() {
		return this.svcNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getSimNumber() {
		return this.simNumber;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setSimNumbers(BigInteger[] simNumbers) {
		this.simNumbers = simNumbers;
	}

	public BigInteger[] getSimNumbers() {
		return this.simNumbers;
	}

	public void setNumberin(NumberInPo numberin) {
		this.numberin = numberin;
	}

	public NumberInPo getNumberin() {
		return this.numberin;
	}

	public void setSvcNumbers(BigInteger[] svcNumbers) {
		this.svcNumbers = svcNumbers;
	}

	public BigInteger[] getSvcNumbers() {
		return this.svcNumbers;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return this.result;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperId() {
		return this.operId;
	}

	public File getSvcNumberFile() {
		return this.svcNumberFile;
	}

	public void setSvcNumberFile(File svcNumberFile) {
		this.svcNumberFile = svcNumberFile;
	}

	public String getSvcNumberFileFileName() {
		return this.svcNumberFileFileName;
	}

	public void setSvcNumberFileFileName(String svcNumberFileFileName) {
		this.svcNumberFileFileName = svcNumberFileFileName;
	}

	public String getSvcNumberFileContentType() {
		return this.svcNumberFileContentType;
	}

	public void setSvcNumberFileContentType(String svcNumberFileContentType) {
		this.svcNumberFileContentType = svcNumberFileContentType;
	}

	public BigDecimal getSuccessCount() {
		return this.successCount;
	}

	public void setSuccessCount(BigDecimal successCount) {
		this.successCount = successCount;
	}

	public Integer getCardType() {
		return this.cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchId() {
		return this.branchId;
	}

	public String getOperType() {
		return this.operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}
}
