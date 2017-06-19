package Bean;

import java.util.Date;

public class TestBean2 {
	String NAME;
	Date RUNDATE;
	double NUMBER;
	
	public TestBean2(){
		
	}

	public TestBean2(String nAME, Date rUNDATE, double nUMBER) {
		super();
		NAME = nAME;
		RUNDATE = rUNDATE;
		NUMBER = nUMBER;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Date getRUNDATE() {
		return RUNDATE;
	}

	public void setRUNDATE(Date rUNDATE) {
		RUNDATE = rUNDATE;
	}

	public double getNUMBER() {
		return NUMBER;
	}

	public void setNUMBER(double nUMBER) {
		NUMBER = nUMBER;
	}

	@Override
	public String toString() {
		return "TestVariable2 [NAME=" + NAME + ", RUNDATE=" + RUNDATE + ", NUMBER=" + NUMBER + "]";
	}
}
