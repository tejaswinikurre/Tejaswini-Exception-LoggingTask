package com.epam.loggingdemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
interface Interest{
	void calculateInterest(double principal,double timeperiod,double rateofinterest);
}

interface PrintData{
	void printData();
}
class ReadData{
	private static final Logger LOGGER = LogManager.getLogger(ReadData.class);
	double getData(){
		LOGGER.debug("Entered into ReadData.getData() Method");
		double value = 2.0;
		LOGGER.debug("Returning the value....");
			return value;
		
	}
}
class SimpleInterest implements Interest,PrintData{
	
	private double finalInterest = 0.0;

	private static final Logger LOGGER = LogManager.getLogger(SimpleInterest.class);
	public void calculateInterest(double principal,double timeperiod,double rateofinterest)
	{
		LOGGER.debug("Entered into SimpleInterest class ");
		LOGGER.info("Calculating Simple Interest......");
		finalInterest = (principal*timeperiod*rateofinterest)/100;
	
	}

	public void printData(){
		LOGGER.info("Output Calculated Simple Interest");
		LOGGER.debug("Simple Interest :%.3f\n",finalInterest);
	}
}
class CompoundInterest implements Interest,PrintData{
	private double finalInterest =0.0;
	
	private static final Logger LOGGER = LogManager.getLogger(CompoundInterest.class);
	public void calculateInterest(double p,double t,double r)
	{
		LOGGER.debug("Entered into CompoundInterest class ");
		LOGGER.info("Calculating Compound Interest......");
		finalInterest = p*Math.pow((1+r/100),t) - p;
	}
	
	
	public void printData(){
		LOGGER.info("Output Calculated Compound Interest");
		LOGGER.debug("Compound Interest :%.3f\n",finalInterest);
	}
}
public class InterestTask {

	private static final Logger LOGGER = LogManager.getLogger(SimpleAndCompoundInterest.class);
	public static void main(String[] args) {
		
				LOGGER.info("Execution Started !!!");
				
				LOGGER.info("Reading Data Started !!!");
				
				ReadData rd = new ReadData();
				LOGGER.info("Enter the Principal Amount : ");
			
				double principal = rd.getData();
				LOGGER.debug("Received Principal Amount");
				
				
				LOGGER.info("\nEnter the Time period(in Years : ");
				double timePeriod = rd.getData();
				LOGGER.debug("Received TimePeriod Amount");
				
				LOGGER.info("\nEnter the Rate Of Interest : ");
				double rate = rd.getData();
				LOGGER.debug("Received Rate of Interest");
				
				SimpleInterest si = new SimpleInterest();
				LOGGER.info("Object Created for SimpleInterest class");
				si.calculateInterest(principal,timePeriod,rate);
				si.printData();
				
				LOGGER.info("Object Created for CompoundInterest class");
				CompoundInterest ci = new CompoundInterest();
				ci.calculateInterest(principal,timePeriod,rate);
				ci.printData();
				
				LOGGER.debug("Program Terminated Successfully");
	}

}