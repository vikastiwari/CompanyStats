package com.vikas;

import java.io.FileNotFoundException;


/*  RunCSVFile class main will execute the findMaxShareValues() method of class CSVFile 
 *  print results
 */
public class RunCSVFile {
	
	
	public static void main(String... arg)
	{
		
        /* Printing result for Success Case*/
		System.out.println("Printing Success Output");
		String fileName=null;
		MaxShareDetails[] out_array = null;
	    try {
	    	fileName="SampleData\\test_shares_data.csv";
	    	CSVFile obj = new CSVFile(fileName);
	    	out_array=obj.findMaxShareValues();
	    	
	       	System.out.println("State of CSV File : "+obj.getState());
	    	
	    	if(out_array!=null)
	    	for(MaxShareDetails temp:out_array)
	    	{
	    		System.out.println("Company Name : "+temp.getCompanyName());	
	    		System.out.println("Max Share Value : "+temp.getMaxShareValue());	
	    		System.out.println("Year : "+temp.getYear());	
	    		System.out.println("Month : "+temp.getMonth()+"\n");	
	    		
	    	}
	    	
	        } catch (Throwable ex) {
	          System.out.println("Error Occurred");
	        	ex.printStackTrace();
	      }	
	    
	    
	    /* Printing result for Negative Value*/  
	    System.out.println("Printing Negative Value Output"); 
	    try {
	    	fileName="SampleData\\negative.csv";
	    	CSVFile obj = new CSVFile(fileName);
	    	out_array=obj.findMaxShareValues();
	    	
	    	System.out.println("State of CSV File : "+obj.getState()+"\n");
	    	
	    	if(out_array!=null)
	    	for(MaxShareDetails temp:out_array)
	    	{
	    		System.out.println("Company Name : "+temp.getCompanyName());	
	    		System.out.println("Max Share Value : "+temp.getMaxShareValue());	
	    		System.out.println("Year : "+temp.getYear());	
	    		System.out.println("Month : "+temp.getMonth()+"\n");	
	    		
	    	}
	    	
	        } catch (Throwable ex) {
	          System.out.println("Error Occurred");
	        	ex.printStackTrace();
	      }	
	    
	    
        /* Printing result for CompanyNameMissing Value*/  
	    System.out.println("Printing CompanyNameMissing Output");
	    try {
	    	fileName="SampleData\\company_name.csv";
	    	CSVFile obj = new CSVFile(fileName);
	    	out_array=obj.findMaxShareValues();
	    	
	    	
	    	System.out.println("State of CSV File : "+obj.getState()+"\n");
	    	
	    	if(out_array!=null)
	    	for(MaxShareDetails temp:out_array)
	    	{
	    		System.out.println("Company Name : "+temp.getCompanyName());	
	    		System.out.println("Max Share Value : "+temp.getMaxShareValue());	
	    		System.out.println("Year : "+temp.getYear());	
	    		System.out.println("Month : "+temp.getMonth()+"\n");	
	    		
	    	}
	    	
	        } catch (Throwable ex) {
	          System.out.println("Error Occurred");
	        	ex.printStackTrace();
	      }	
		
 	    
           /* Printing result for UnequalLength*/ 
	    System.out.println("Printing UnequalLength Output");
	    try {
	    	fileName="SampleData\\unequal_length.csv";
	    	CSVFile obj = new CSVFile(fileName);
	    	out_array=obj.findMaxShareValues();
	    	
	    	System.out.println("State of CSV File : "+obj.getState()+"\n");
	    	
	    	if(out_array!=null)
	    	for(MaxShareDetails temp:out_array)
	    	{
	    		System.out.println("Company Name : "+temp.getCompanyName());	
	    		System.out.println("Max Share Value : "+temp.getMaxShareValue());	
	    		System.out.println("Year : "+temp.getYear());	
	    		System.out.println("Month : "+temp.getMonth()+"\n");	
	    		
	    	}
	    	
	        } catch (Throwable ex) {
	          System.out.println("Error Occurred");
	        	ex.printStackTrace();
	      }	
	    
	    
	    /* Printing result for NumberFormatException*/ 
	    System.out.println("Printing NumberFormatException Output"); 
	    try {
	    	fileName="SampleData\\number_format.csv";
	    	CSVFile obj = new CSVFile(fileName);
	    	out_array=obj.findMaxShareValues();
	    	
	    	System.out.println("State of CSV File : "+obj.getState()+"\n");
	    	
	    	if(out_array!=null)
	    	for(MaxShareDetails temp:out_array)
	    	{
	    		System.out.println("Company Name : "+temp.getCompanyName());	
	    		System.out.println("Max Share Value : "+temp.getMaxShareValue());	
	    		System.out.println("Year : "+temp.getYear());	
	    		System.out.println("Month : "+temp.getMonth()+"\n");	
	    		
	    	}
	    	
	        } catch (Throwable ex) {
	        	 System.out.println("Error Occurred");
	        	ex.printStackTrace();
			}	
		
	    
	    
	}
}
