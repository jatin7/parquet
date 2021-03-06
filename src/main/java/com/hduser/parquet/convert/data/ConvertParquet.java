package com.hduser.parquet.convert.data;

import org.apache.spark.sql.AnalysisException;
/*
 * Import data from RDBMS to HDFS
 * Config connection string to RDBMS and HDFS in ImportConf class
 */
public class ConvertParquet {
	public ConvertParquet() {

		try {
//			ImportConf conf = new ImportConf();
			
			importAll();
		} catch (AnalysisException e) {
			e.printStackTrace();
		}
	}
	public void importAll() throws AnalysisException {
		
		ImportConf conf = new ImportConf();
		
		conf.importTable("PERIODS");
		//timesheet
		conf.importTable("TA_WORKING_SHIFTS");
		conf.importTable("TA_WORKING_TYPES");
		conf.importTable("TA_EMPLOYEE_TIMESHEETS","EMPLOYEE_ID","EMPLOYEE_TIMESHEET_ID","WORKING_DATE","TIME_IN","TIME_OUT","ACTUAL_SHIFT_ID","APPROVED_WORKING_TYPE_ID","APPROVED","COUNT_APPROVE");
		//OT
		conf.importTable("TA_OVERTIME_SETTING");
		conf.importTable("TA_EMPLOYEE_OVERTIMES","EMPLOYEE_TIMESHEET_ID","OT_INCOME_ID","APPROVED_HOURS","APPROVED","COUNT_APPROVE");
		//Latein
		conf.importTable("TA_EMPLOYEE_LATE_IN_EARLY_OUT","EMPLOYEE_TIMESHEET_ID","APPROVED_LATE_IN_HOURS","APPROVED_LATE_IN","APPROVED_EARLY_OUT_HOURS","APPROVED_EARLY_OUT","COUNT_APPROVE");
		//Trip
//		conf.importTable("TRIP_REQUESTS","TRIP_REQUEST_ID","EMPLOYEE_ID","START_DATE","END_DATE","NO_OF_WORKING_DAYS","TRIP_REQUEST_STATUS_ID");
//		conf.importTable("APPROVAL_TRIPCOSTS","EMPLOYEE_ID","DATE","IS_HALF_DAY","ALLOWANCE_ID","TOTAL","IS_APPROVAL","TRIP_REQUEST_ID");
//		conf.importTable("TRIP_COST_LOCATION");
		//Leave
//		conf.importTable("LEAVE_REQUESTS","LEAVE_REQUEST_ID","LEAVE_TYPE_ID","EMPLOYEE_ID","START_DATE","END_DATE","NO_OF_WORKING_DAYS","NO_OF_CALENDAR_DAYS","LEAVE_REQUEST_STATUS_ID","COUNT_APPROVE");
			
		//Dependent
		conf.importTable("EMPLOYEES","EMPLOYEE_ID","PROBATION_END_DATE");
		conf.importTable("EMPLOYEE_DEPENDANTS");
		conf.importTable("EMPLOYEE_RELATIVES");
		//Tax
		conf.importTable("TAXES");
		conf.importTable("INCOME_CONFIGS","INCOME_CONFIG_ID","EMPLOYEE_ID","INCOME_ID","CUSTOM_VALUE","START_DATE","END_DATE");
		
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new ConvertParquet();
		long stop = System.currentTimeMillis();
		System.out.println(stop-start);
	}

}
