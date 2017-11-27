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

	public boolean equals(TestBean testBean) {
		boolean equals = true;
		if (equals){
			equals = name.equals(testBean.getName());
		}
		if (equals){
			equals = runDate.equals(testBean.getRunDate());
		}
		if (equals){
			equals = number == testBean.getNumber();
		}
		return equals;
	}

	@Override
	public String toString() {
		return "TestBean [name=" + name + ", runDate=" + runDate + ", number=" + number + "]";
	}
}
