/**
 *
 *  @author Kowalski Robert S18290
 *
 */

package zad1;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

public class Calc {
	BigDecimal one;
	BigDecimal two;
	BigDecimal oneToCount;
	BigDecimal twoToCount;
	
	String[] test;
	LinkedHashMap<String,String> whatToDo = new LinkedHashMap<String, String>();
	
	
	public String doCalc(String in) {
		try {		
		test = in.split("\\s+");
		this.one = new BigDecimal(test[0]);
		this.two = new BigDecimal(test[2]);
		whatToDo.put("/","DivMet");
		whatToDo.put("*","MulMet");
		whatToDo.put("+","AddMet");
		whatToDo.put("-","MinMet");	
			Method method = this.getClass().getMethod(whatToDo.get(test[1]));
			return method.invoke(this).toString();	
				
		//} catch (IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
		} catch (Exception e) {
			return "Invalid command to calc";
		}
		
		
	}
	public Calc() {
		super();
	}		
	public String DivMet() {
		return one.divide(two,7, RoundingMode.HALF_UP).stripTrailingZeros().toString();
	}
	public String MulMet() {
		return one.multiply(two).toString();
	}
	public String AddMet() {
		return one.add(two).toString();
	}
	public String MinMet() {
		//return one.add(two.negate()).toString();
		return one.subtract(two).toString();
	}
	//LinkedHashMap<String,BigDecimal> whatToDo = new LinkedHashMap<String, BigDecimal>();
	//whatToDo.put("/",one.divide(two,7, RoundingMode.HALF_UP).stripTrailingZeros());
	//	whatToDo.put("*",one.multiply(two).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros());
	//	whatToDo.put("+",one.add(two).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros());
	//	whatToDo.put("-",one.add(two.negate()).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros());
	//	System.out.println(whatToDo.toString());
	//System.out.println(method.toString());
	//	method.in
	
	
	
	
}  
