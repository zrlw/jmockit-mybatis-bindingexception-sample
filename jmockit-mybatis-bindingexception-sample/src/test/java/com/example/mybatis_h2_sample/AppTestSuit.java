package com.example.mybatis_h2_sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * TestSuit to Reproduce BindingException.  
 * run Junit Test should add jmockit javaagent like this (version 1.49 as example):
 *     -javaagent:<replace maven local repository directory here>/org/jmockit/jmockit/1.49/jmockit-1.49.jar
 * at:
 *     run as - Run Configurations - JUnit - new launch configuration - arguments - VM arguments 
 *
 *
 */
@SuiteClasses({AppTestOk.class, AppTestExceptionIfRunJUnitAfterTestOk.class})
@RunWith(Suite.class)
public class AppTestSuit {

}
