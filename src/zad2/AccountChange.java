package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccountChange implements PropertyChangeListener  {

	@Override
	public void propertyChange(PropertyChangeEvent changer) {
		
		if(Double.compare((double) changer.getNewValue(), 0) < 0)
			try {
				Method m = changer.getSource().getClass().getMethod("getNum");
				
				System.out.println(m.invoke(changer.getSource())+": Value changed from " + 
						changer.getOldValue() + " to " + changer.getNewValue() + ", balance < 0!");
			} catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				Method m = changer.getSource().getClass().getMethod("getNum");
				System.out.println(m.invoke(changer.getSource())+": Value changed from " + 
						changer.getOldValue() + " to " + changer.getNewValue());
			} catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

	

}
