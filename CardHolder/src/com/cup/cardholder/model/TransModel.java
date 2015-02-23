package com.cup.cardholder.model;

public class TransModel {
	/**
	 * 交易名称
	 */
	private String transNm;
	/**
	 * 商户名称
	 */
	private String mchntNm;
	/**
	 * 商户类型
	 */
	private String mcnhtTp;
	/**
	 * 交易渠道
	 */
	private String transChnnl;
	/**
	 * 交易时间
	 */
	private String time;
	/**
	 * 交易金额
	 */
	private String sum;
	
	public String getMchntNm() {
		return mchntNm;
	}
	public void setMchntNm(String mchntNm) {
		this.mchntNm = mchntNm;
	}
	public String getTransNm() {
		return transNm;
	}
	public void setTransNm(String transNm) {
		this.transNm = transNm;
	}
	public String getMcnhtTp() {
		return mcnhtTp;
	}
	public void setMcnhtTp(String mcnhtTp) {
		this.mcnhtTp = mcnhtTp;
	}
	public String getTransChnnl() {
		return transChnnl;
	}
	public void setTransChnnl(String transChnnl) {
		this.transChnnl = transChnnl;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
}
