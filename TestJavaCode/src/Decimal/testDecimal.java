package Decimal;

import java.math.BigDecimal;

public class testDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal bd = new BigDecimal(0);
		BigDecimal bd2 = new BigDecimal("9999999999999.99");
		BigDecimal bd3 = new BigDecimal("9999999999999.99");
		BigDecimal bd4 = new BigDecimal("-9999999999999.99");
		bd = bd.add(bd2);
		bd = bd.add(bd3);
		bd = bd.add(bd4);
		System.out.println(bd);
	}

}
