package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccountLimitator implements VetoableChangeListener  {

	double itsOver8000;
	String justAName = "Ballance";
	
	public AccountLimitator(double noLimit) {
		this.itsOver8000 = noLimit;
	}
	
	
	@Override
	public void vetoableChange(PropertyChangeEvent vetoVetoVeto) throws PropertyVetoException {
		
	
	//	String out = (String) m.invoke(vetoVetoVeto);
		
		if ((vetoVetoVeto.getPropertyName().equals(justAName)) && ((Double.compare((double) vetoVetoVeto.getNewValue(),itsOver8000) < 0))) {
			try {
				Method m = vetoVetoVeto.getSource().getClass().getMethod("getNum");
				throw new PropertyVetoException(m.invoke(vetoVetoVeto.getSource())+": Unacceptable value change: " + vetoVetoVeto.getNewValue(),vetoVetoVeto);
			} catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
					
		
	}

}
