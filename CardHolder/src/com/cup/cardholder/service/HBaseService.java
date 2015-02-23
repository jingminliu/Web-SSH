package com.cup.cardholder.service;

import java.io.IOException;
import java.util.ConcurrentModificationException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import com.cup.bigtable.scan.bean.ReturnField;
import com.cup.cardholder.model.BillModel;
import com.cup.cardholder.model.Constant;
import com.cup.cardholder.model.LoginModel;
import com.cup.cardholder.model.TransModel;
import com.cup.cardholder.model.TravelModel;

public class HBaseService {
	private static final long WRITE_BUFFER_SIZE = 1024 * 1024 * 12;

	private static Configuration config = HBaseConfiguration.create();

	private String table = "";
	private HTable hTable = null;
	private Object tableLock = new Object();
	
	public Result get(String table, String key, String columnFamily) {
		Result result;
		Get get;

		if (!table.equals(this.table)) {
			hTable = null;

			try {
				getHTable(table);
				this.table = table;
			} catch (IOException e) {
				System.err.println("Error accessing HBase table:" + e);
				return null;
			}
		}

		try {
			get = new Get(Bytes.toBytes(key));
			get.addFamily(columnFamily.getBytes());
			result = hTable.get(get);

		} catch (Exception e) {
			System.err.println("HBaseService: Error doing get: " + e);
			return null;
		}

		return result;
	}
	
	public ResultScanner scan(String table) {
		ResultScanner rs;
		Scan scan;

		if (!table.equals(this.table)) {
			hTable = null;

			try {
				getHTable(table);
				this.table = table;
			} catch (IOException e) {
				System.err.println("Error accessing HBase table:" + e);
				return null;
			}
		}

		try {
			scan = new Scan();
			rs = hTable.getScanner(scan);

		} catch (IOException e) {
			System.err.println("Error doing scan: " + e);
			return null;

		} catch (ConcurrentModificationException e) {
			return null;
		}

		return rs;
	}
	
	public BillModel setBillModel(Result res) {
		BillModel model = new BillModel();
		
		model.setCardLvl(getValue(res, Constant.CARD_LVL));
		model.setCardAttr(getValue(res, Constant.CARD_ATTR));		
		model.setBankNm(getValue(res, Constant.ISS_BANK_NM));
		model.setSum(getValue(res, Constant.TOTAL_TRANS_SUM));
		model.setTimes(getValue(res, Constant.TOTAL_TRANS_TIMES));
		model.setMonSum01(getValue(res, Constant.MON_SUM_01));
		model.setMonSum02(getValue(res, Constant.MON_SUM_02));
		model.setMonSum03(getValue(res, Constant.MON_SUM_03));
		model.setMonSum04(getValue(res, Constant.MON_SUM_04));
		model.setMonSum05(getValue(res, Constant.MON_SUM_05));
		model.setMonSum06(getValue(res, Constant.MON_SUM_06));
		model.setMonSum07(getValue(res, Constant.MON_SUM_07));
		model.setMonSum08(getValue(res, Constant.MON_SUM_08));
		model.setMonSum09(getValue(res, Constant.MON_SUM_09));
		model.setMonSum10(getValue(res, Constant.MON_SUM_10));
		model.setMonSum11(getValue(res, Constant.MON_SUM_11));
		model.setMonSum12(getValue(res, Constant.MON_SUM_12));
		model.setMonTimes01(getValue(res, Constant.MON_TIMES_01));
		model.setMonTimes02(getValue(res, Constant.MON_TIMES_02));
		model.setMonTimes03(getValue(res, Constant.MON_TIMES_03));
		model.setMonTimes04(getValue(res, Constant.MON_TIMES_04));
		model.setMonTimes05(getValue(res, Constant.MON_TIMES_05));
		model.setMonTimes06(getValue(res, Constant.MON_TIMES_06));
		model.setMonTimes07(getValue(res, Constant.MON_TIMES_07));
		model.setMonTimes08(getValue(res, Constant.MON_TIMES_08));
		model.setMonTimes09(getValue(res, Constant.MON_TIMES_09));
		model.setMonTimes10(getValue(res, Constant.MON_TIMES_10));
		model.setMonTimes11(getValue(res, Constant.MON_TIMES_11));
		model.setMonTimes12(getValue(res, Constant.MON_TIMES_12));
		model.setMallPct(getValue(res, Constant.MALL_SUM_PCT));
		model.setHtlPct(getValue(res, Constant.HTL_SUM_PCT));
		model.setCateringPct(getValue(res, Constant.CATERING_SUM_PCT));
		model.setDrinkPct(getValue(res, Constant.DRINK_SUM_PCT));
		model.setWtrElecGasPct(getValue(res, Constant.WTR_ELC_GAS_SUM_PCT));
		model.setDailyNecPct(getValue(res, Constant.DAILY_NEC_SUM_PCT));
		model.setDailyNonNecPct(getValue(res, Constant.DAILY_NON_NEC_SUM_PCT));
		model.setLuxPct(getValue(res, Constant.LUX_SUM_PCT));
		model.setHouseDecPct(getValue(res, Constant.HOUSE_DEC_SUM_PCT));
		model.setCarPct(getValue(res, Constant.CAR_SUM_PCT));
		model.setDressPct(getValue(res, Constant.DRESS_SUM_PCT));
		model.setMedPct(getValue(res, Constant.MED_SUM_PCT));
		model.setAddiMedPct(getValue(res, Constant.ADDI_MED_SUM_PCT));
		model.setBabyPct(getValue(res, Constant.BABY_SUM_PCT));
		model.setChldEduPct(getValue(res, Constant.CHLD_EDU_SUM_PCT));
		model.setCollEduPct(getValue(res, Constant.COLL_EDU_SUM_PCT));
		model.setFemalePct(getValue(res, Constant.FEMALE_SUM_PCT));
		model.setCosmPct(getValue(res, Constant.COSM_SUM_PCT));
		model.setHighSprtPct(getValue(res, Constant.HIGH_SP_SUM_PCT));
		model.setPubSprtPct(getValue(res, Constant.PUB_SP_SUM_PCT));
		model.setCulPct(getValue(res, Constant.CUL_SUM_PCT));
		model.setEntPct(getValue(res, Constant.ENT_SUM_PCT));
		model.setTrvlPct(getValue(res, Constant.TRVL_SUM_PCT));
		model.setTrfcPct(getValue(res, Constant.TRFC_SUM_PCT));
		model.setDutyFreePct(getValue(res, Constant.DUTY_FREE_SUM_PCT));
		model.setCrossDistPct(getValue(res, Constant.CROSS_DIST_SUM_PCT));
		model.setCashPct(getValue(res, Constant.CASH_SUM_PCT));
		model.setFinServPct(getValue(res, Constant.FIN_SERV_SUM_PCT));
		model.setInfoServPct(getValue(res, Constant.INFO_SERV_SUM_PCT));
		model.setBussServPct(getValue(res, Constant.BUSS_SERV_SUM_PCT));
		model.setGovServPct(getValue(res, Constant.GOV_SERV_SUM_PCT));
		model.setWholeSalePct(getValue(res, Constant.WHOLE_SALE_SUM_PCT));
		model.setOthersPct(getValue(res, Constant.OHTERS_SUM_PCT));
		model.setPosChnlPct(getValue(res, Constant.POS_CHNL_SUM_PCT));
		model.setAtmChnlPct(getValue(res, Constant.ATM_CHNL_SUM_PCT));
		model.setOlChnlPct(getValue(res, Constant.OL_CHNL_SUM_PCT));
		model.setCntChnlPct(getValue(res, Constant.CNT_CHNL_SUM_PCT));
		model.setPhnChnlPct(getValue(res, Constant.PHN_CHNL_SUM_PCT));
		model.setOthersChnlPct(getValue(res, Constant.OHTERS_CHNL_SUM_PCT));
		model.setFstMchntNm(getValue(res, Constant.HIGHEST_SUM_MCHNT_NM));
		model.setFstMcc(getValue(res, Constant.HIGHEST_SUM_MCC));
		model.setFstSum(getValue(res, Constant.HIGHEST_SUM));
		model.setScdMchntNm(getValue(res, Constant.SECOND_SUM_MCHNT_NM));
		model.setScdMcc(getValue(res, Constant.SECOND_SUM_MCC));
		model.setScdSum(getValue(res, Constant.SECOND_SUM));
		model.setThrdMchntNm(getValue(res, Constant.THIRD_SUM_MCHNT_NM));
		model.setThrdMcc(getValue(res, Constant.THIRD_SUM_MCC));
		model.setThrdSum(getValue(res, Constant.THIRD_SUM));
		model.setRsdntAreaNm(getValue(res, Constant.RESIDENT_AREA_NM));
		model.setAreaRank(getValue(res, Constant.AREA_RANK));
		model.setWorkDayWorkHrsTimes(getValue(res, Constant.WORK_DAY_WORK_HRS_TIMES));
		model.setWorkDayNonWorkHrsTimes(getValue(res, Constant.WORK_DAY_NON_WORK_HRS_TIMES));
		model.setWorkDayMidnightTimes(getValue(res, Constant.WORK_DAY_MIDNIGHT_TIMES));
		model.setNonWorkDayNormHrsTimes(getValue(res, Constant.NON_WORK_DAY_NORM_HRS_TIMES));
		model.setNonWorkDayMidnightTimes(getValue(res, Constant.NON_WORK_DAY_MIDNIGHT_TIMES));
		
		int[] timesArr = { StringUtil.string2Int(getValue(res, Constant.WORK_DAY_WORK_HRS_TIMES)),
				StringUtil.string2Int(getValue(res, Constant.WORK_DAY_NON_WORK_HRS_TIMES)),
				StringUtil.string2Int(getValue(res, Constant.WORK_DAY_MIDNIGHT_TIMES)),
				StringUtil.string2Int(getValue(res, Constant.NON_WORK_DAY_NORM_HRS_TIMES)),
				StringUtil.string2Int(getValue(res, Constant.NON_WORK_DAY_MIDNIGHT_TIMES)) };
		model.setTimesArr(timesArr);

		return model;
	}
	
	public LoginModel getLoginModel(Result res) {
		LoginModel model = new LoginModel();
		
		model.setUserNm(getValue(res, Constant.USER_NAME));
		model.setUserPwd(getValue(res, Constant.USER_PWD));
		
		return model;
	}
	
	public TravelModel getTravelModel(Result res) {
		TravelModel model = new TravelModel();
		
		model.setCardLvl(getValue(res, Constant.CARD_LVL));
		model.setTrvlLvlNm(getValue(res, Constant.TRVL_LVL_NM));
		model.setTrvlScoreVal(getValue(res, Constant.TRVL_SCORE_VAL));
		model.setTrvlScoreRank(getValue(res, Constant.TRVL_SCORE_RANK));
		model.setTrvlScoreBtNum(getValue(res, Constant.TRVL_SCORE_BT_NUM));
		model.setResidentAreaNm(getValue(res, Constant.RESIDENT_AREA_NM));
		model.setAreaRank(getValue(res, Constant.AREA_RANK));
		model.setIssBankNm(getValue(res, Constant.ISS_BANK_NM));
		model.setBankRank(getValue(res, Constant.BANK_RANK));
		model.setHtlLvlNm(getValue(res, Constant.HTL_LVL_NM));
		model.setHtlTransTimes(getValue(res, Constant.HTL_TRANS_TIMES));
		model.setHtlTransSum(getValue(res, Constant.HTL_TRANS_SUM));
		model.setHtlConcentration(getValue(res, Constant.HTL_CONCENTRATION));
		model.setTrvlTransSum(getValue(res, Constant.TRVL_TRANS_SUM));
		model.setTrvlTransTimes(getValue(res, Constant.TRVL_TRANS_TIMES));
		model.setCrossTrvlTransTimes(getValue(res, Constant.CROSS_TRVL_TRANS_TIMES));
		model.setTrvlTransTimes01(getValue(res, Constant.TRVL_TRANS_TIMES_01));
		model.setTrvlTransTimes02(getValue(res, Constant.TRVL_TRANS_TIMES_02));
		model.setTrvlTransTimes03(getValue(res, Constant.TRVL_TRANS_TIMES_03));
		model.setTrvlTransTimes04(getValue(res, Constant.TRVL_TRANS_TIMES_04));
		model.setTrvlTransTimes05(getValue(res, Constant.TRVL_TRANS_TIMES_05));
		model.setTrvlTransTimes06(getValue(res, Constant.TRVL_TRANS_TIMES_06));
		model.setTrvlTransTimes07(getValue(res, Constant.TRVL_TRANS_TIMES_07));
		model.setTrvlTransTimes08(getValue(res, Constant.TRVL_TRANS_TIMES_08));
		model.setTrvlTransTimes09(getValue(res, Constant.TRVL_TRANS_TIMES_09));
		model.setTrvlTransTimes10(getValue(res, Constant.TRVL_TRANS_TIMES_10));
		model.setTrvlTransTimes11(getValue(res, Constant.TRVL_TRANS_TIMES_11));
		model.setTrvlTransTimes12(getValue(res, Constant.TRVL_TRANS_TIMES_12));
		model.setTransCityNum(getValue(res, Constant.TRANS_CITY_NUM));
		model.setTransProvinceNum(getValue(res, Constant.TRANS_PROVINCE_NUM));
		model.setCrossTransSum(getValue(res, Constant.CROSS_TRANS_SUM));
		model.setCrossTransTimes(getValue(res, Constant.CROSS_TRANS_TIMES));
		model.setCrossAreaNm(getValue(res, Constant.CROSS_AREA_NM));
		model.setMigrateAreaNmStart(getValue(res, Constant.MIGRATE_AREA_NM_START));
		model.setMigrateRoute(getValue(res, Constant.MIGRATE_ROUTE));
		
		return model;
	}
	
	public TransModel getTransModel(ReturnField ret) {
		TransModel model = new TransModel();
		
		
		return model;
	}
	
	private void getHTable(String table) throws IOException {
		synchronized (tableLock) {
			hTable = new HTable(config, table);
			hTable.setAutoFlush(false);
			hTable.setWriteBufferSize(WRITE_BUFFER_SIZE);
		}
	}
	
	private String getValue(Result res, String qualifier) {
		return Bytes.toString(res.getValue(
				Constant.COLUMNFAMILY.getBytes(), qualifier.getBytes()));
	}
	
}
