package com.cup.cardholder.model;

import java.util.ArrayList;
import java.util.List;

public class TravelModel {
	/**
	 * 卡等级
	 */
	private String cardLvl;
	/**
	 * 商旅等级名称
	 */
	private String trvlLvlNm;
	/**
	 * 商旅评分分数
	 */
	private String trvlScoreVal;
	/**
	 * 商旅评分全国排名（百分比）
	 */
	private String trvlScoreRank;
	/**
	 * 商旅评分击败人数
	 */
	private String trvlScoreBtNum;
	/**
	 * 地区排名之常驻地区名称
	 */
	private String residentAreaNm;
	/**
	 * 地区排名百分比
	 */
	private String areaRank;
	/**
	 * 银行排名之发卡行名称
	 */
	private String issBankNm;
	/**
	 * 银行排名百分比
	 */
	private String bankRank;
	/**
	 * 酒店等级名称
	 */
	private String htlLvlNm;
	/**
	 * 酒店交易次数
	 */
	private String htlTransTimes;
	/**
	 * 酒店交易金额
	 */
	private String htlTransSum;
	/**
	 * 酒店忠诚度
	 */
	private String htlConcentration;
	/**
	 * 商旅交易次数
	 */
	private String trvlTransTimes;
	/**
	 * 商旅交易金额
	 */
	private String trvlTransSum;
	/**
	 * 境外商旅交易次数
	 */
	private String crossTrvlTransTimes;
	/**
	 * 01月商旅交易次数
	 */
	private String trvlTransTimes01;
	/**
	 * 02月商旅交易次数
	 */
	private String trvlTransTimes02;
	/**
	 * 03月商旅交易次数
	 */
	private String trvlTransTimes03;
	/**
	 * 04月商旅交易次数
	 */
	private String trvlTransTimes04;
	/**
	 * 05月商旅交易次数
	 */
	private String trvlTransTimes05;
	/**
	 * 06月商旅交易次数
	 */
	private String trvlTransTimes06;
	/**
	 * 07月商旅交易次数
	 */
	private String trvlTransTimes07;
	/**
	 * 08月商旅交易次数
	 */
	private String trvlTransTimes08;
	/**
	 * 09月商旅交易次数
	 */
	private String trvlTransTimes09;
	/**
	 * 10月商旅交易次数
	 */
	private String trvlTransTimes10;
	/**
	 * 11月商旅交易次数
	 */
	private String trvlTransTimes11;
	/**
	 * 12月商旅交易次数
	 */
	private String trvlTransTimes12;
	/**
	 * 交易涉及城市个数
	 */
	private String transCityNum;
	/**
	 * 交易涉及省份个数
	 */
	private String transProvinceNum;
	/**
	 * 境外交易次数
	 */
	private String crossTransTimes;
	/**
	 * 境外交易金额
	 */
	private String crossTransSum;
	/**
	 * 境外交易常去地区名称
	 */
	private String crossAreaNm;
	/**
	 * 商旅迁徙之常驻地区名称（市）
	 */
	private String migrateAreaNmStart;
	/**
	 * 商旅迁徙之路线
	 */
	private String migrateRoute;
	
	private List<String> timesList = new ArrayList<String>();
	
	public List<String> getTimesList() {
		timesList.add(trvlTransTimes01);
		timesList.add(trvlTransTimes02);
		timesList.add(trvlTransTimes03);
		timesList.add(trvlTransTimes04);
		timesList.add(trvlTransTimes05);
		timesList.add(trvlTransTimes06);
		timesList.add(trvlTransTimes07);
		timesList.add(trvlTransTimes08);
		timesList.add(trvlTransTimes09);
		timesList.add(trvlTransTimes10);
		timesList.add(trvlTransTimes11);
		timesList.add(trvlTransTimes12);
		
		return timesList;
	}
	
	public String getCardLvl() {
		return cardLvl;
	}
	public void setCardLvl(String cardLvl) {
		this.cardLvl = cardLvl;
	}
	public String getTrvlLvlNm() {
		return trvlLvlNm;
	}
	public void setTrvlLvlNm(String trvlLvlNm) {
		this.trvlLvlNm = trvlLvlNm;
	}
	public String getTrvlScoreVal() {
		return trvlScoreVal;
	}
	public void setTrvlScoreVal(String trvlScoreVal) {
		this.trvlScoreVal = trvlScoreVal;
	}
	public String getTrvlScoreRank() {
		return trvlScoreRank;
	}
	public void setTrvlScoreRank(String trvlScoreRank) {
		this.trvlScoreRank = trvlScoreRank;
	}
	public String getTrvlScoreBtNum() {
		return trvlScoreBtNum;
	}
	public void setTrvlScoreBtNum(String trvlScoreBtNum) {
		this.trvlScoreBtNum = trvlScoreBtNum;
	}
	public String getResidentAreaNm() {
		return residentAreaNm;
	}
	public void setResidentAreaNm(String residentAreaNm) {
		this.residentAreaNm = residentAreaNm;
	}
	public String getAreaRank() {
		return areaRank;
	}
	public void setAreaRank(String areaRank) {
		this.areaRank = areaRank;
	}
	public String getIssBankNm() {
		return issBankNm;
	}
	public void setIssBankNm(String issBankNm) {
		this.issBankNm = issBankNm;
	}
	public String getBankRank() {
		return bankRank;
	}
	public void setBankRank(String bankRank) {
		this.bankRank = bankRank;
	}
	public String getHtlLvlNm() {
		return htlLvlNm;
	}
	public void setHtlLvlNm(String htlLvlNm) {
		this.htlLvlNm = htlLvlNm;
	}
	public String getHtlTransTimes() {
		return htlTransTimes;
	}
	public void setHtlTransTimes(String htlTransTimes) {
		this.htlTransTimes = htlTransTimes;
	}
	public String getHtlTransSum() {
		return htlTransSum;
	}
	public void setHtlTransSum(String htlTransSum) {
		this.htlTransSum = htlTransSum;
	}
	public String getHtlConcentration() {
		return htlConcentration;
	}
	public void setHtlConcentration(String htlConcentration) {
		this.htlConcentration = htlConcentration;
	}
	public String getTrvlTransTimes() {
		return trvlTransTimes;
	}
	public void setTrvlTransTimes(String trvlTransTimes) {
		this.trvlTransTimes = trvlTransTimes;
	}
	public String getTrvlTransSum() {
		return trvlTransSum;
	}
	public void setTrvlTransSum(String trvlTransSum) {
		this.trvlTransSum = trvlTransSum;
	}
	public String getCrossTrvlTransTimes() {
		return crossTrvlTransTimes;
	}
	public void setCrossTrvlTransTimes(String crossTrvlTransTimes) {
		this.crossTrvlTransTimes = crossTrvlTransTimes;
	}
	public String getTrvlTransTimes01() {
		return trvlTransTimes01;
	}
	public void setTrvlTransTimes01(String trvlTransTimes01) {
		this.trvlTransTimes01 = trvlTransTimes01;
	}
	public String getTrvlTransTimes02() {
		return trvlTransTimes02;
	}
	public void setTrvlTransTimes02(String trvlTransTimes02) {
		this.trvlTransTimes02 = trvlTransTimes02;
	}
	public String getTrvlTransTimes03() {
		return trvlTransTimes03;
	}
	public void setTrvlTransTimes03(String trvlTransTimes03) {
		this.trvlTransTimes03 = trvlTransTimes03;
	}
	public String getTrvlTransTimes04() {
		return trvlTransTimes04;
	}
	public void setTrvlTransTimes04(String trvlTransTimes04) {
		this.trvlTransTimes04 = trvlTransTimes04;
	}
	public String getTrvlTransTimes05() {
		return trvlTransTimes05;
	}
	public void setTrvlTransTimes05(String trvlTransTimes05) {
		this.trvlTransTimes05 = trvlTransTimes05;
	}
	public String getTrvlTransTimes06() {
		return trvlTransTimes06;
	}
	public void setTrvlTransTimes06(String trvlTransTimes06) {
		this.trvlTransTimes06 = trvlTransTimes06;
	}
	public String getTrvlTransTimes07() {
		return trvlTransTimes07;
	}
	public void setTrvlTransTimes07(String trvlTransTimes07) {
		this.trvlTransTimes07 = trvlTransTimes07;
	}
	public String getTrvlTransTimes08() {
		return trvlTransTimes08;
	}
	public void setTrvlTransTimes08(String trvlTransTimes08) {
		this.trvlTransTimes08 = trvlTransTimes08;
	}
	public String getTrvlTransTimes09() {
		return trvlTransTimes09;
	}
	public void setTrvlTransTimes09(String trvlTransTimes09) {
		this.trvlTransTimes09 = trvlTransTimes09;
	}
	public String getTrvlTransTimes10() {
		return trvlTransTimes10;
	}
	public void setTrvlTransTimes10(String trvlTransTimes10) {
		this.trvlTransTimes10 = trvlTransTimes10;
	}
	public String getTrvlTransTimes11() {
		return trvlTransTimes11;
	}
	public void setTrvlTransTimes11(String trvlTransTimes11) {
		this.trvlTransTimes11 = trvlTransTimes11;
	}
	public String getTrvlTransTimes12() {
		return trvlTransTimes12;
	}
	public void setTrvlTransTimes12(String trvlTransTimes12) {
		this.trvlTransTimes12 = trvlTransTimes12;
	}
	public String getTransCityNum() {
		return transCityNum;
	}
	public void setTransCityNum(String transCityNum) {
		this.transCityNum = transCityNum;
	}
	public String getTransProvinceNum() {
		return transProvinceNum;
	}
	public void setTransProvinceNum(String transProvinceNum) {
		this.transProvinceNum = transProvinceNum;
	}
	public String getCrossTransTimes() {
		return crossTransTimes;
	}
	public void setCrossTransTimes(String crossTransTimes) {
		this.crossTransTimes = crossTransTimes;
	}
	public String getCrossTransSum() {
		return crossTransSum;
	}
	public void setCrossTransSum(String crossTransSum) {
		this.crossTransSum = crossTransSum;
	}
	public String getCrossAreaNm() {
		return crossAreaNm;
	}
	public void setCrossAreaNm(String crossAreaNm) {
		this.crossAreaNm = crossAreaNm;
	}
	public String getMigrateAreaNmStart() {
		return migrateAreaNmStart;
	}
	public void setMigrateAreaNmStart(String migrateAreaNmStart) {
		this.migrateAreaNmStart = migrateAreaNmStart;
	}
	public String getMigrateRoute() {
		return migrateRoute;
	}
	public void setMigrateRoute(String migrateRoute) {
		this.migrateRoute = migrateRoute;
	}
}
