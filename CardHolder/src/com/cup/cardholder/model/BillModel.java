package com.cup.cardholder.model;

import java.util.ArrayList;
import java.util.List;

import com.cup.cardholder.service.DoubleUtil;
import com.cup.cardholder.service.StringUtil;

public class BillModel {
	/**
	 * 卡等级
	 */
	private String cardLvl;
	/**
	 * 卡属性
	 */
	private String cardAttr;
	/**
	 * 发卡行名称
	 */
	private String bankNm;
	/**
	 * 总交易金额
	 */
	private String sum;
	/**
	 * 总交易次数
	 */
	private String times;
	/**
	 * 01月交易次数
	 */
	private String monTimes01;
	/**
	 * 02月交易次数
	 */
	private String monTimes02;
	/**
	 * 03月交易次数
	 */
	private String monTimes03;
	/**
	 * 04月交易次数
	 */
	private String monTimes04;
	/**
	 * 05月交易次数
	 */
	private String monTimes05;
	/**
	 * 06月交易次数
	 */
	private String monTimes06;
	/**
	 * 07月交易次数
	 */
	private String monTimes07;
	/**
	 * 08月交易次数
	 */
	private String monTimes08;
	/**
	 * 09月交易次数
	 */
	private String monTimes09;
	/**
	 * 10月交易次数
	 */
	private String monTimes10;
	/**
	 * 11月交易次数
	 */
	private String monTimes11;
	/**
	 * 12月交易次数
	 */
	private String monTimes12;
	/**
	 * 01月交易金额
	 */
	private String monSum01;
	/**
	 * 02月交易金额
	 */
	private String monSum02;
	/**
	 * 03月交易金额
	 */
	private String monSum03;
	/**
	 * 04月交易金额
	 */
	private String monSum04;
	/**
	 * 05月交易金额
	 */
	private String monSum05;
	/**
	 * 06月交易金额
	 */
	private String monSum06;
	/**
	 * 07月交易金额
	 */
	private String monSum07;
	/**
	 * 08月交易金额
	 */
	private String monSum08;
	/**
	 * 09月交易金额
	 */
	private String monSum09;
	/**
	 * 10月交易金额
	 */
	private String monSum10;
	/**
	 * 11月交易金额
	 */
	private String monSum11;
	/**
	 * 12月交易金额
	 */
	private String monSum12;
	/**
	 * 商场类消费金额占比
	 */
	private String mallPct;
	/**
	 * 住宿类消费金额占比
	 */
	private String htlPct;
	/**
	 * 餐饮类消费金额占比
	 */
	private String cateringPct;
	/**
	 * 饮酒场所类消费金额占比
	 */
	private String drinkPct;
	/**
	 * 公共事业费类消费金额占比
	 */
	private String wtrElecGasPct;
	/**
	 * 日用必需品类消费金额占比
	 */
	private String dailyNecPct;
	/**
	 * 日用非必需品类消费金额占比
	 */
	private String dailyNonNecPct;
	/**
	 * 类奢侈类消费金额占比
	 */
	private String luxPct;
	/**
	 * 房产装修类消费金额占比
	 */
	private String houseDecPct;
	/**
	 * 汽车类消费金额占比
	 */
	private String carPct;
	/**
	 * 服装类消费金额占比
	 */
	private String dressPct;
	/**
	 * 医疗类消费金额占比
	 */
	private String medPct;
	/**
	 * 补充医疗类消费金额占比
	 */
	private String addiMedPct;
	/**
	 * 学前类消费金额占比
	 */
	private String babyPct;
	/**
	 * 中小学类消费金额占比
	 */
	private String chldEduPct;
	/**
	 * 大学类消费金额占比
	 */
	private String collEduPct;
	/**
	 * 女性类消费金额占比
	 */
	private String femalePct;
	/**
	 * 美容类消费金额占比
	 */
	private String cosmPct;
	/**
	 * 高端运动类消费金额占比
	 */
	private String highSprtPct;
	/**
	 * 大众运动类消费金额占比
	 */
	private String pubSprtPct;
	/**
	 * 文化类消费金额占比
	 */
	private String culPct;
	/**
	 * 休闲娱乐类消费金额占比
	 */
	private String entPct;
	/**
	 * 旅游类消费金额占比
	 */
	private String trvlPct;
	/**
	 * 交通运输类消费金额占比
	 */
	private String trfcPct;
	/**
	 * 免税店类消费金额占比
	 */
	private String dutyFreePct;
	/**
	 * 要出国类消费金额占比
	 */
	private String crossDistPct;
	/**
	 * 现金业务类消费金额占比
	 */
	private String cashPct;
	/**
	 * 金融服务类消费金额占比
	 */
	private String finServPct;
	/**
	 * 信息服务类消费金额占比
	 */
	private String infoServPct;
	/**
	 * 商业服务类消费金额占比
	 */
	private String bussServPct;
	/**
	 * 政府服务类消费金额占比
	 */
	private String govServPct;
	/**
	 * 批发类消费金额占比
	 */
	private String wholeSalePct;
	/**
	 * 其他类消费金额占比
	 */
	private String othersPct;
	/**
	 * POS渠道金额占比
	 */
	private String posChnlPct;
	/**
	 * ATM渠道金额占比
	 */
	private String atmChnlPct;
	/**
	 * 线上渠道金额占比
	 */
	private String olChnlPct;
	/**
	 * 柜台渠道金额占比
	 */
	private String cntChnlPct;
	/**
	 * 手机渠道金额占比
	 */
	private String phnChnlPct;
	/**
	 * 其他渠道金额占比
	 */
	private String othersChnlPct;
	/**
	 * 消费金额最高商户名称
	 */
	private String fstMchntNm;
	/**
	 * 消费金额最高MCC
	 */
	private String fstMcc;
	/**
	 * 最高消费金额
	 */
	private String fstSum;
	/**
	 * 消费金额第二高商户名称
	 */
	private String scdMchntNm;
	/**
	 * 消费金额第二高MCC
	 */
	private String scdMcc;
	/**
	 * 第二高消费金额
	 */
	private String scdSum;
	/**
	 * 消费金额第三高商户名称
	 */
	private String thrdMchntNm;
	/**
	 * 消费金额第三高MCC
	 */
	private String thrdMcc;
	/**
	 * 第三高消费金额
	 */
	private String thrdSum;
	/**
	 * 地区排名之常驻地区名称
	 */
	private String rsdntAreaNm;
	/**
	 * 地区排名百分比（总交易金额）
	 */
	private String areaRank;
	/**
	 * 工作日上班时间消费次数
	 */
	private String workDayWorkHrsTimes;
	/**
	 * 工作日下班时间消费次数
	 */
	private String workDayNonWorkHrsTimes;
	/**
	 * 工作日午夜时间消费次数
	 */
	private String workDayMidnightTimes;
	/**
	 * 非工作日正常时间消费次数
	 */
	private String nonWorkDayNormHrsTimes;
	/**
	 * 非工作日午夜时间消费次数
	 */
	private String nonWorkDayMidnightTimes;

	private List<String> sumList = new ArrayList<String>();
	private List<String> timesList = new ArrayList<String>();
	/**
	 * 行业
	 */
	private List<Industry> indList = new ArrayList<Industry>();
	/**
	 * 渠道
	 */
	private List<Industry> chnlList = new ArrayList<Industry>();
	
	private int[] timesArr = { StringUtil.string2Int(workDayWorkHrsTimes),
			StringUtil.string2Int(workDayNonWorkHrsTimes),
			StringUtil.string2Int(workDayMidnightTimes),
			StringUtil.string2Int(nonWorkDayNormHrsTimes),
			StringUtil.string2Int(nonWorkDayMidnightTimes) };

	public List<String> getSumList() {
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum01), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum02), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum03), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum04), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum05), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum06), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum07), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum08), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum09), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum10), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum11), 100) + "");
		sumList.add(DoubleUtil.div(StringUtil.string2Double(monSum12), 100) + "");

		return sumList;
	}

	public List<String> getTimesList() {
		timesList.add(monTimes01);
		timesList.add(monTimes02);
		timesList.add(monTimes03);
		timesList.add(monTimes04);
		timesList.add(monTimes05);
		timesList.add(monTimes06);
		timesList.add(monTimes07);
		timesList.add(monTimes08);
		timesList.add(monTimes09);
		timesList.add(monTimes10);
		timesList.add(monTimes11);
		timesList.add(monTimes12);

		return timesList;
	}

	public List<Industry> getIndList() {
		indList.add(new Industry("商场", mallPct));
		indList.add(new Industry("住宿", htlPct));
		indList.add(new Industry("餐饮", cateringPct));
		indList.add(new Industry("饮酒场所", drinkPct));
		indList.add(new Industry("公共事业费", wtrElecGasPct));
		indList.add(new Industry("日用必需品", dailyNecPct));
		indList.add(new Industry("日用非必需品", dailyNonNecPct));
		indList.add(new Industry("类奢侈", luxPct));
		indList.add(new Industry("房产装修", houseDecPct));
		indList.add(new Industry("汽车", carPct));
		indList.add(new Industry("服装", dressPct));
		indList.add(new Industry("医疗", medPct));
		indList.add(new Industry("补充医疗", addiMedPct));
		indList.add(new Industry("学前", babyPct));
		indList.add(new Industry("中小学", chldEduPct));
		indList.add(new Industry("大学", collEduPct));
		indList.add(new Industry("女性", femalePct));
		indList.add(new Industry("美容", cosmPct));
		indList.add(new Industry("高端运动", highSprtPct));
		indList.add(new Industry("大众运动", pubSprtPct));
		indList.add(new Industry("文化", culPct));
		indList.add(new Industry("休闲娱乐", entPct));
		indList.add(new Industry("旅游", trvlPct));
		indList.add(new Industry("交通运输", trfcPct));
		indList.add(new Industry(" 免税店", dutyFreePct));
		indList.add(new Industry("要出国", crossDistPct));
		indList.add(new Industry("现金业务", cashPct));
		indList.add(new Industry("金融服务", finServPct));
		indList.add(new Industry("信息服务", infoServPct));
		indList.add(new Industry("商业服务", bussServPct));
		indList.add(new Industry("政府服务", govServPct));
		indList.add(new Industry("批发", wholeSalePct));
		indList.add(new Industry("其他", othersPct));

		return indList;
	}

	public List<Industry> getChnlList() {
		chnlList.add(new Industry("POS", posChnlPct));
		chnlList.add(new Industry("ATM", atmChnlPct));
		chnlList.add(new Industry("在线", olChnlPct));
		chnlList.add(new Industry("柜台", cntChnlPct));
		chnlList.add(new Industry("手机", phnChnlPct));
		chnlList.add(new Industry("其他", othersChnlPct));

		return chnlList;
	}

	public List<Industry> getTop10Ind(List<Industry> indList) {
		List<Industry> top10Ind = new ArrayList<Industry>();
		int i = 0;

		for (; i < 10; i++) {
			if (StringUtil.string2Double(indList.get(i).getPct()) > 0) {
				top10Ind.add(indList.get(i));
			}
		}

		return top10Ind;
	}

	public int getMaxTimes() {
		int max=0;
		System.out.println("BillModel: getMaxTimes(): timesArr.length:" + timesArr.length);
		for(int i=0;i<timesArr.length;i++) {
			if(timesArr[i]>max) {
				System.out.println("BillModel: getMaxTimes(): timesArr:" + timesArr[i]);
				max = timesArr[i];
			}
		}
		
		return max;
	}
	
	public int getMaxIndex() {
		int index=0;
		double max = getMaxTimes();
		for(int i=0;i<timesArr.length;i++) {
			if(timesArr[i] == max) {
				index = i;
			}
		}
		
		return index;
	}

	public String getCardLvl() {
		return cardLvl;
	}

	public void setCardLvl(String cardLvl) {
		this.cardLvl = cardLvl;
	}
	
	public String getCardAttr() {
		return cardAttr;
	}

	public void setCardAttr(String cardAttr) {
		this.cardAttr = cardAttr;
	}

	public String getBankNm() {
		return bankNm;
	}

	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getMonTimes01() {
		return monTimes01;
	}

	public void setMonTimes01(String monTimes01) {
		this.monTimes01 = monTimes01;
	}

	public String getMonTimes02() {
		return monTimes02;
	}

	public void setMonTimes02(String monTimes02) {
		this.monTimes02 = monTimes02;
	}

	public String getMonTimes03() {
		return monTimes03;
	}

	public void setMonTimes03(String monTimes03) {
		this.monTimes03 = monTimes03;
	}

	public String getMonTimes04() {
		return monTimes04;
	}

	public void setMonTimes04(String monTimes04) {
		this.monTimes04 = monTimes04;
	}

	public String getMonTimes05() {
		return monTimes05;
	}

	public void setMonTimes05(String monTimes05) {
		this.monTimes05 = monTimes05;
	}

	public String getMonTimes06() {
		return monTimes06;
	}

	public void setMonTimes06(String monTimes06) {
		this.monTimes06 = monTimes06;
	}

	public String getMonTimes07() {
		return monTimes07;
	}

	public void setMonTimes07(String monTimes07) {
		this.monTimes07 = monTimes07;
	}

	public String getMonTimes08() {
		return monTimes08;
	}

	public void setMonTimes08(String monTimes08) {
		this.monTimes08 = monTimes08;
	}

	public String getMonTimes09() {
		return monTimes09;
	}

	public void setMonTimes09(String monTimes09) {
		this.monTimes09 = monTimes09;
	}

	public String getMonTimes10() {
		return monTimes10;
	}

	public void setMonTimes10(String monTimes10) {
		this.monTimes10 = monTimes10;
	}

	public String getMonTimes11() {
		return monTimes11;
	}

	public void setMonTimes11(String monTimes11) {
		this.monTimes11 = monTimes11;
	}

	public String getMonTimes12() {
		return monTimes12;
	}

	public void setMonTimes12(String monTimes12) {
		this.monTimes12 = monTimes12;
	}

	public String getMonSum01() {
		return monSum01;
	}

	public void setMonSum01(String monSum01) {
		this.monSum01 = monSum01;
	}

	public String getMonSum02() {
		return monSum02;
	}

	public void setMonSum02(String monSum02) {
		this.monSum02 = monSum02;
	}

	public String getMonSum03() {
		return monSum03;
	}

	public void setMonSum03(String monSum03) {
		this.monSum03 = monSum03;
	}

	public String getMonSum04() {
		return monSum04;
	}

	public void setMonSum04(String monSum04) {
		this.monSum04 = monSum04;
	}

	public String getMonSum05() {
		return monSum05;
	}

	public void setMonSum05(String monSum05) {
		this.monSum05 = monSum05;
	}

	public String getMonSum06() {
		return monSum06;
	}

	public void setMonSum06(String monSum06) {
		this.monSum06 = monSum06;
	}

	public String getMonSum07() {
		return monSum07;
	}

	public void setMonSum07(String monSum07) {
		this.monSum07 = monSum07;
	}

	public String getMonSum08() {
		return monSum08;
	}

	public void setMonSum08(String monSum08) {
		this.monSum08 = monSum08;
	}

	public String getMonSum09() {
		return monSum09;
	}

	public void setMonSum09(String monSum09) {
		this.monSum09 = monSum09;
	}

	public String getMonSum10() {
		return monSum10;
	}

	public void setMonSum10(String monSum10) {
		this.monSum10 = monSum10;
	}

	public String getMonSum11() {
		return monSum11;
	}

	public void setMonSum11(String monSum11) {
		this.monSum11 = monSum11;
	}

	public String getMonSum12() {
		return monSum12;
	}

	public void setMonSum12(String monSum12) {
		this.monSum12 = monSum12;
	}

	public String getMallPct() {
		return mallPct;
	}

	public void setMallPct(String mallPct) {
		this.mallPct = mallPct;
	}

	public String getHtlPct() {
		return htlPct;
	}

	public void setHtlPct(String htlPct) {
		this.htlPct = htlPct;
	}

	public String getCateringPct() {
		return cateringPct;
	}

	public void setCateringPct(String cateringPct) {
		this.cateringPct = cateringPct;
	}

	public String getDrinkPct() {
		return drinkPct;
	}

	public void setDrinkPct(String drinkPct) {
		this.drinkPct = drinkPct;
	}

	public String getWtrElecGasPct() {
		return wtrElecGasPct;
	}

	public void setWtrElecGasPct(String wtrElecGasPct) {
		this.wtrElecGasPct = wtrElecGasPct;
	}

	public String getDailyNecPct() {
		return dailyNecPct;
	}

	public void setDailyNecPct(String dailyNecPct) {
		this.dailyNecPct = dailyNecPct;
	}

	public String getDailyNonNecPct() {
		return dailyNonNecPct;
	}

	public void setDailyNonNecPct(String dailyNonNecPct) {
		this.dailyNonNecPct = dailyNonNecPct;
	}

	public String getLuxPct() {
		return luxPct;
	}

	public void setLuxPct(String luxPct) {
		this.luxPct = luxPct;
	}

	public String getHouseDecPct() {
		return houseDecPct;
	}

	public void setHouseDecPct(String houseDecPct) {
		this.houseDecPct = houseDecPct;
	}

	public String getCarPct() {
		return carPct;
	}

	public void setCarPct(String carPct) {
		this.carPct = carPct;
	}

	public String getDressPct() {
		return dressPct;
	}

	public void setDressPct(String dressPct) {
		this.dressPct = dressPct;
	}

	public String getMedPct() {
		return medPct;
	}

	public void setMedPct(String medPct) {
		this.medPct = medPct;
	}

	public String getAddiMedPct() {
		return addiMedPct;
	}

	public void setAddiMedPct(String addiMedPct) {
		this.addiMedPct = addiMedPct;
	}

	public String getBabyPct() {
		return babyPct;
	}

	public void setBabyPct(String babyPct) {
		this.babyPct = babyPct;
	}

	public String getChldEduPct() {
		return chldEduPct;
	}

	public void setChldEduPct(String chldEduPct) {
		this.chldEduPct = chldEduPct;
	}

	public String getCollEduPct() {
		return collEduPct;
	}

	public void setCollEduPct(String collEduPct) {
		this.collEduPct = collEduPct;
	}

	public String getFemalePct() {
		return femalePct;
	}

	public void setFemalePct(String femalePct) {
		this.femalePct = femalePct;
	}

	public String getCosmPct() {
		return cosmPct;
	}

	public void setCosmPct(String cosmPct) {
		this.cosmPct = cosmPct;
	}

	public String getHighSprtPct() {
		return highSprtPct;
	}

	public void setHighSprtPct(String highSprtPct) {
		this.highSprtPct = highSprtPct;
	}

	public String getPubSprtPct() {
		return pubSprtPct;
	}

	public void setPubSprtPct(String pubSprtPct) {
		this.pubSprtPct = pubSprtPct;
	}

	public String getCulPct() {
		return culPct;
	}

	public void setCulPct(String culPct) {
		this.culPct = culPct;
	}

	public String getEntPct() {
		return entPct;
	}

	public void setEntPct(String entPct) {
		this.entPct = entPct;
	}

	public String getTrvlPct() {
		return trvlPct;
	}

	public void setTrvlPct(String trvlPct) {
		this.trvlPct = trvlPct;
	}

	public String getTrfcPct() {
		return trfcPct;
	}

	public void setTrfcPct(String trfcPct) {
		this.trfcPct = trfcPct;
	}

	public String getDutyFreePct() {
		return dutyFreePct;
	}

	public void setDutyFreePct(String dutyFreePct) {
		this.dutyFreePct = dutyFreePct;
	}

	public String getCrossDistPct() {
		return crossDistPct;
	}

	public void setCrossDistPct(String crossDistPct) {
		this.crossDistPct = crossDistPct;
	}

	public String getCashPct() {
		return cashPct;
	}

	public void setCashPct(String cashPct) {
		this.cashPct = cashPct;
	}

	public String getFinServPct() {
		return finServPct;
	}

	public void setFinServPct(String finServPct) {
		this.finServPct = finServPct;
	}

	public String getInfoServPct() {
		return infoServPct;
	}

	public void setInfoServPct(String infoServPct) {
		this.infoServPct = infoServPct;
	}

	public String getBussServPct() {
		return bussServPct;
	}

	public void setBussServPct(String bussServPct) {
		this.bussServPct = bussServPct;
	}

	public String getGovServPct() {
		return govServPct;
	}

	public void setGovServPct(String govServPct) {
		this.govServPct = govServPct;
	}

	public String getWholeSalePct() {
		return wholeSalePct;
	}

	public void setWholeSalePct(String wholeSalePct) {
		this.wholeSalePct = wholeSalePct;
	}

	public String getOthersPct() {
		return othersPct;
	}

	public void setOthersPct(String othersPct) {
		this.othersPct = othersPct;
	}

	public String getPosChnlPct() {
		return posChnlPct;
	}

	public void setPosChnlPct(String posChnlPct) {
		this.posChnlPct = posChnlPct;
	}

	public String getAtmChnlPct() {
		return atmChnlPct;
	}

	public void setAtmChnlPct(String atmChnlPct) {
		this.atmChnlPct = atmChnlPct;
	}

	public String getOlChnlPct() {
		return olChnlPct;
	}

	public void setOlChnlPct(String olChnlPct) {
		this.olChnlPct = olChnlPct;
	}

	public String getCntChnlPct() {
		return cntChnlPct;
	}

	public void setCntChnlPct(String cntChnlPct) {
		this.cntChnlPct = cntChnlPct;
	}

	public String getPhnChnlPct() {
		return phnChnlPct;
	}

	public void setPhnChnlPct(String phnChnlPct) {
		this.phnChnlPct = phnChnlPct;
	}

	public String getOthersChnlPct() {
		return othersChnlPct;
	}

	public void setOthersChnlPct(String othersChnlPct) {
		this.othersChnlPct = othersChnlPct;
	}

	public String getFstMchntNm() {
		return fstMchntNm;
	}

	public void setFstMchntNm(String fstMchntNm) {
		this.fstMchntNm = fstMchntNm;
	}

	public String getFstMcc() {
		return fstMcc;
	}

	public void setFstMcc(String fstMcc) {
		this.fstMcc = fstMcc;
	}

	public String getFstSum() {
		return fstSum;
	}

	public void setFstSum(String fstSum) {
		this.fstSum = fstSum;
	}

	public String getScdMchntNm() {
		return scdMchntNm;
	}

	public void setScdMchntNm(String scdMchntNm) {
		this.scdMchntNm = scdMchntNm;
	}

	public String getScdMcc() {
		return scdMcc;
	}

	public void setScdMcc(String scdMcc) {
		this.scdMcc = scdMcc;
	}

	public String getScdSum() {
		return scdSum;
	}

	public void setScdSum(String scdSum) {
		this.scdSum = scdSum;
	}

	public String getThrdMchntNm() {
		return thrdMchntNm;
	}

	public void setThrdMchntNm(String thrdMchntNm) {
		this.thrdMchntNm = thrdMchntNm;
	}

	public String getThrdMcc() {
		return thrdMcc;
	}

	public void setThrdMcc(String thrdMcc) {
		this.thrdMcc = thrdMcc;
	}

	public String getThrdSum() {
		return thrdSum;
	}

	public void setThrdSum(String thrdSum) {
		this.thrdSum = thrdSum;
	}

	public String getRsdntAreaNm() {
		return rsdntAreaNm;
	}

	public void setRsdntAreaNm(String rsdntAreaNm) {
		this.rsdntAreaNm = rsdntAreaNm;
	}

	public String getAreaRank() {
		return areaRank;
	}

	public void setAreaRank(String areaRank) {
		this.areaRank = areaRank;
	}

	public String getWorkDayWorkHrsTimes() {
		return workDayWorkHrsTimes;
	}

	public void setWorkDayWorkHrsTimes(String workDayWorkHrsTimes) {
		this.workDayWorkHrsTimes = workDayWorkHrsTimes;
	}

	public String getWorkDayNonWorkHrsTimes() {
		return workDayNonWorkHrsTimes;
	}

	public void setWorkDayNonWorkHrsTimes(String workDayNonWorkHrsTimes) {
		this.workDayNonWorkHrsTimes = workDayNonWorkHrsTimes;
	}

	public String getWorkDayMidnightTimes() {
		return workDayMidnightTimes;
	}

	public void setWorkDayMidnightTimes(String workDayMidnightTimes) {
		this.workDayMidnightTimes = workDayMidnightTimes;
	}

	public String getNonWorkDayNormHrsTimes() {
		return nonWorkDayNormHrsTimes;
	}

	public void setNonWorkDayNormHrsTimes(String nonWorkDayNormHrsTimes) {
		this.nonWorkDayNormHrsTimes = nonWorkDayNormHrsTimes;
	}

	public String getNonWorkDayMidnightTimes() {
		return nonWorkDayMidnightTimes;
	}

	public void setNonWorkDayMidnightTimes(String nonWorkDayMidnightTimes) {
		this.nonWorkDayMidnightTimes = nonWorkDayMidnightTimes;
	}
	
	public void setTimesArr(int[] timesArr) {
		this.timesArr = timesArr;
	}
}
