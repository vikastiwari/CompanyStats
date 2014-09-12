package com.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


// Test Suite to run all test units
@RunWith(Suite.class)
@SuiteClasses({ TestCompanyNameMissing.class, TestNegativeValue.class,
		TestNumberFormatException.class, TestSuccess.class,
		TestUnequalLength.class })
public class AllTests {

}
