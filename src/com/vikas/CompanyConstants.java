package com.vikas;

/**
 *  CompanyConstants interface defines the company constants.
 *  At present only year and month is present along with company share values.
 *  But in future a date or any other data field may be added to the csv file
 */

public interface CompanyConstants {	
	
	/**
	 *  SHARE_INDEX field stores the starting index of share values
	 */
	int YEAR_INDEX=0;
	int MONTH_INDEX=1;	
	int SHARE_INDEX=2;
	int YEAR_MIN_VALUE=0;
	int SHARE_MIN_VALUE=0;
	int RANDOM=78;
	
	/**
	 *  CSVState defines 8 different states of CSVFile
	 */	
	public enum CSVState {UNINITIALIZED,COMPANY_NAME_MISSING,UNEQUAL_COLUMN_ROW_LENGTH,
		NEGATIVE_VALUE,NUMBER_FORMAT_EXCEPTION,IO_EXCEPTION,OTHER_EXCEPTION_ERROR,SUCCESS}
	
}
