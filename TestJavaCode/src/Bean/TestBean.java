package Bean;

import java.util.Date;

public class TestBean {
	String name;
	Date runDate;
	double number;
	
	public TestBean(){
		
	}

	public TestBean(String name, Date runDate, double number) {
		super();
		this.name = name;
		this.runDate = runDate;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "TestBean [name=" + name + ", runDate=" + runDate + ", number=" + number + "]";
	}
}
