/**
 * 
 */
package com.junit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vikas.CSVFile;
import com.vikas.MaxShareDetails;

import static com.vikas.CompanyConstants.CSVState.*;

/**
 * @author Home
 *
 */
public class TestSuccess {

	private String fileName;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		if(fileName==null)
		{
		Properties prop = new Properties();
		FileInputStream fis=null;
	    try {
	    	String temp=System.getProperty("user.dir")+File.separator+"properties"+File.separator+"JUnit.properties";
	    	fis=new FileInputStream(temp);
	    	prop.load(fis);
	       fileName = prop.getProperty(TestSuccess.class.getSimpleName().toString());
	       fis.close();
	        } catch (IOException ex) {
	           ex.printStackTrace();
	      }
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	
	/**
	 * Test method for {@link com.vikas.CSVFile#findMaxShareValue()}.
	 */
	
	@Test
	public final void testFindMaxShareValue() {
		
		MaxShareDetails[] out_array = null;
		try {
			CSVFile obj = new CSVFile(fileName);
			assertNotNull(obj);
			assertEquals("Illegal State of CSV File",UNINITIALIZED,obj.getState());
			out_array=obj.findMaxShareValues();
			assertArrayEquals(out_array,obj.findMaxShareValues());
			assertArrayEquals(out_array,obj.findMaxShareValues());
			assertEquals("Illegal State of CSV File",SUCCESS,obj.getState());
			
			MaxShareDetails[] expected_array=new MaxShareDetails[5];  
			
			for(int i=0;i<5;i++)
			 expected_array[i]=new MaxShareDetails();
			 
			expected_array[0].setCompanyName("Company-A");	
			expected_array[0].setMaxShareValue(1000);
			expected_array[0].setMonth("Mar");
			expected_array[0].setYear(2000);
			
			expected_array[1].setCompanyName("Company-B");	
			expected_array[1].setMaxShareValue(986);
			expected_array[1].setMonth("Mar");
			expected_array[1].setYear(2007);
			
			expected_array[2].setCompanyName("Company-C");	
			expected_array[2].setMaxShareValue(995);
			expected_array[2].setMonth("Jun");
			expected_array[2].setYear(1993);
			
			expected_array[3].setCompanyName("Company-D");	
			expected_array[3].setMaxShareValue(999);
			expected_array[3].setMonth("Apr");
			expected_array[3].setYear(2002);
			
			expected_array[4].setCompanyName("Company-E");	
			expected_array[4].setMaxShareValue(997);
			expected_array[4].setMonth("Oct");
			expected_array[4].setYear(2008);
			
			
			for(int i=0;i<5;i++)
			{
				assertEquals("Wrong output Company name",expected_array[i].getCompanyName(),out_array[i].getCompanyName());	
				assertEquals("Wrong output Year",expected_array[i].getYear(),out_array[i].getYear());	
				assertEquals("Wrong output Month",expected_array[i].getMonth(),out_array[i].getMonth());	
				
				if(expected_array[i].getMaxShareValue()==out_array[i].getMaxShareValue());
				else assertNotNull("Wrong output MaxShareValue",null);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Test method for {@link com.vikas.CSVFile#findMaxShareValue()}.
	 * @throws FileNotFoundException 
	 */
	@Test
	(expected = NullPointerException.class)
	public final void nulltestFindMaxShareValue2() throws FileNotFoundException {
		CSVFile obj = new CSVFile(null);
		assertNull(obj);
	}
	
	
	/**
	 * Test method for {@link com.vikas.CSVFile#findMaxShareValue()}.
	 * @throws FileNotFoundException 
	 */
	@Test
	(expected = FileNotFoundException.class)
	public final void wrongfileNameTest() throws FileNotFoundException {
		CSVFile obj = new CSVFile(fileName+fileName);
		assertNull(obj);
	}
	

}
