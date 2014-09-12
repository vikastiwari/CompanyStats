package com.vikas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static com.vikas.CompanyConstants.CSVState.*;
import au.com.bytecode.opencsv.CSVReader;


/**
 *  CalulateShareValue class have method findMaxShareValue(String fileName) to calculate details 
 * (CompanyName,maxShareValue,year,month)
 *  for each company for its maximum share value for the csv file passed to this method
 */
public class CSVFile implements CompanyConstants {
	private CSVReader csvReader;
	private MaxShareDetails[] output;
	private CSVState state=UNINITIALIZED;
	
	/**
	 *  Constructor for CSVFile class.It takes filename canonical path and initialize the 
	 *  CSVReader object.It throws FileNotFoundException if CSVReader object cannot be created.
	 *  It throws nullPointerException when fileName is null
	 */

	public CSVFile(String fileName) throws FileNotFoundException
	{
		/**
		 *  As Java doesn’t support parsing of CSV files natively, we have to rely on
		 *  third party library. Opencsv is one of the best library available for this 
		 *  purpose. It’s open source and is shipped with Apache 2.0 licence which makes 
		 *  it possible for commercial use.			
		 */	

		csvReader = new CSVReader(new FileReader(fileName));
		
	}

	
	/**
	 * @return the state of CSVFile
	 */
	public CSVState getState() {
		return state;
	}


	/**
	 * findMaxShareValue(String fileName) method will return the details (CompanyName,maxShareValue,year,month)
	 *  for each company for its maximum share value for the csv file passed to this method.
	 *  
	 *  This method will return null in case Exception/Error occurs or Company name is not present
	 *  or unequal columns or Negative maxShareValue,year value in csv file or 
	 *  Negative maxShareValue,year indicates that share data is unavailable.
	 *  The reason of null value can be determined from the state field of CSVFile
	 *  
	 *  CSVFile state variable will be UNINITIALIZED ,if findMaxShareValues() is not yet called.
	 *  It will be SUCCESS in case of Successfull completion of findMaxShareValues().
	 *  In case of null return, state will determine the root cause of null value  
	 *  IN case of multiple exception/error CSVFile state variable will determine the last occurred exception/error.
	 *  
	 */

	public  MaxShareDetails[] findMaxShareValues()
	{	
		if(state==SUCCESS)
			return output;
		
		else if(state==COMPANY_NAME_MISSING||state==NEGATIVE_VALUE||state==UNEQUAL_COLUMN_ROW_LENGTH
				|| state==IO_EXCEPTION || state==OTHER_EXCEPTION_ERROR||state==NUMBER_FORMAT_EXCEPTION)
           return null;
		
		try {

			String[] row = null;
			int column=0;

			/**
			 * Accessing only first row of csv file
			 */
           
			if((row = csvReader.readNext()) != null) 
			{
				column=row.length;

				/**
				 * if(column<=SHARE_INDEX), only year and month is present,companyName  is missing
				 */
				if(column<=SHARE_INDEX)
				{
				    state=COMPANY_NAME_MISSING;
					return null;
				}
				else
					column=column-CompanyConstants.SHARE_INDEX; 

				output=new MaxShareDetails[column];


				/**
				 * Save CompanyName for each company 			  
				 */
				for(int i=0;i<column;i++)
				{
					output[i]=new MaxShareDetails();

					String tempCompanyName=row[i+SHARE_INDEX].trim();

					if(tempCompanyName.isEmpty())
					{
					    state=COMPANY_NAME_MISSING;
						return null;
					}

					output[i].setCompanyName(tempCompanyName);

				}
			}


			/**
			 * Calulate max share value and year and month			  
			 */
			while((row = csvReader.readNext()) != null) 
			{
				/**
				 * Share data is missing.		  
				 */
				if(row.length-SHARE_INDEX!=column)
				{
				    state=UNEQUAL_COLUMN_ROW_LENGTH;
					return null;
				}

				for(int i=0;i<column;i++)
				{
					// A NumberFormatException may occur  
					double temp= Double.parseDouble(row[i+SHARE_INDEX].trim());
					int year=Integer.parseInt(row[YEAR_INDEX].trim());
					
					if(year<YEAR_MIN_VALUE || temp<SHARE_MIN_VALUE)
					{
					    state=NEGATIVE_VALUE;
						return null;
					}
					
					if(temp>output[i].getMaxShareValue())
					{   output[i].setMaxShareValue(temp);
						output[i].setMonth(row[MONTH_INDEX].trim());
						output[i].setYear(year);
					}
				}

			}

		} 
		catch (NumberFormatException e)
		{
			e.printStackTrace();
			state=NUMBER_FORMAT_EXCEPTION;
			return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			state=OTHER_EXCEPTION_ERROR;
			return null;
		}
		catch (Error e)
		{
			e.printStackTrace();
			state=OTHER_EXCEPTION_ERROR;
			return null;
		}
		
		finally
		{
			try {
				csvReader.close();
				} catch (IOException e) {
				e.printStackTrace();
				state=IO_EXCEPTION;
				return null;
			}
		}

		state=SUCCESS;
		return output;
	}


}

