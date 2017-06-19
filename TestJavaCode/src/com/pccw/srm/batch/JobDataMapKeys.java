package com.pccw.srm.batch;

import java.text.SimpleDateFormat;

public class JobDataMapKeys{
	//jar.pwf.service com.pccw.pwf.batch
	public static final String NEXT_JOB = "nextJob";
    public static final String LAST_PROCESS_DATETIME = "lastProcessDateTime";
    public static final String PROCESS_DATETIME = "processDatetime";
    public static final String JOB_CHAIN = "jobChain";
    public static final String IS_FIRST_JOB = "isFirstJob";
    public static final String RUN_ID = "runId";
    public static final String IS_ADHOC = "isAdHoc";
    public static final String IS_RERUN = "isReRun";
    public static final String SHELL_CMD = "shellCmd";
    public static final String SHELL_FOLDER = "shellFolder";
    
	// common use
    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat DATE_FORMAT_YYMMDD = new SimpleDateFormat("yyMMdd");
    
    // job tag
    public static final String RUN_DATE = "RunDate";
}
