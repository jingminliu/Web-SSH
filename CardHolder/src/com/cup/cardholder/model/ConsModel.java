package com.cup.cardholder.model;

public class ConsModel {
	/**
	 * 交易代码
	 */
	private String transId;
	/**
	 * 卡号
	 */
	private String cardNum;
	/**
	 * 发卡行机构代码
	 */
	private String issInsIdCd;
	/**
	 * 商户代码
	 */
	private String mchntCd;
	/**
	 * 商户名称
	 */
	private String mchntNm;
	/**
	 * 商户类型
	 */
	private String mchntTp;
	/**
	 * 发送机构代码
	 */
	private String fwdInsIdCd;
	/**
	 * 受理机构代码
	 */
	private String acptInsIdCd;
	/**
	 * 转入账户
	 */
	private String tfrInAcctNo;
	/**
	 * 转出账户
	 */
	private String tfrOutAcctNo;
	/**
	 * 交易金额
	 */
	private String transAt;
	/**
	 * 交易货币代码
	 */
	private String transCurrCd;
	/**
	 * 交易渠道
	 */
	private String transChnl;
	/**
	 * 是否参加清算
	 */
	private String stiTakeoutIn;
	/**
	 * 传输日期时间
	 */
	private String tfrDtTm;
	/**
	 * 交易日期
	 */
	private String locTransDt;
	/**
	 * 交易时间
	 */
	private String locTransTm;
	/**
	 * 交易状态标识
	 */
	private String cuTransSt;
	
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getIssInsIdCd() {
		return issInsIdCd;
	}
	public void setIssInsIdCd(String issInsIdCd) {
		this.issInsIdCd = issInsIdCd;
	}
	public String getMchntCd() {
		return mchntCd;
	}
	public void setMchntCd(String mchntCd) {
		this.mchntCd = mchntCd;
	}
	public String getMchntNm() {
		return mchntNm;
	}
	public void setMchntNm(String mchntNm) {
		this.mchntNm = mchntNm;
	}
	public String getMchntTp() {
		return mchntTp;
	}
	public void setMchntTp(String mchntTp) {
		this.mchntTp = mchntTp;
	}
	public String getFwdInsIdCd() {
		return fwdInsIdCd;
	}
	public void setFwdInsIdCd(String fwdInsIdCd) {
		this.fwdInsIdCd = fwdInsIdCd;
	}
	public String getAcptInsIdCd() {
		return acptInsIdCd;
	}
	public void setAcptInsIdCd(String acptInsIdCd) {
		this.acptInsIdCd = acptInsIdCd;
	}
	public String getTfrInAcctNo() {
		return tfrInAcctNo;
	}
	public void setTfrInAcctNo(String tfrInAcctNo) {
		this.tfrInAcctNo = tfrInAcctNo;
	}
	public String getTfrOutAcctNo() {
		return tfrOutAcctNo;
	}
	public void setTfrOutAcctNo(String tfrOutAcctNo) {
		this.tfrOutAcctNo = tfrOutAcctNo;
	}
	public String getTransAt() {
		return transAt;
	}
	public void setTransAt(String transAt) {
		this.transAt = transAt;
	}
	public String getTransCurrCd() {
		return transCurrCd;
	}
	public void setTransCurrCd(String transCurrCd) {
		this.transCurrCd = transCurrCd;
	}
	public String getTransChnl() {
		return transChnl;
	}
	public void setTransChnl(String transChnl) {
		this.transChnl = transChnl;
	}
	public String getStiTakeoutIn() {
		return stiTakeoutIn;
	}
	public void setStiTakeoutIn(String stiTakeoutIn) {
		this.stiTakeoutIn = stiTakeoutIn;
	}
	public String getTfrDtTm() {
		return tfrDtTm;
	}
	public void setTfrDtTm(String tfrDtTm) {
		this.tfrDtTm = tfrDtTm;
	}
	public String getLocTransDt() {
		return locTransDt;
	}
	public void setLocTransDt(String locTransDt) {
		this.locTransDt = locTransDt;
	}
	public String getLocTransTm() {
		return locTransTm;
	}
	public void setLocTransTm(String locTransTm) {
		this.locTransTm = locTransTm;
	}
	public String getCuTransSt() {
		return cuTransSt;
	}
	public void setCuTransSt(String cuTransSt) {
		this.cuTransSt = cuTransSt;
	}
}
