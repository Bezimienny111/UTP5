package zad2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;




public class Account {
	private double ballance; // bounded,constrained
	private VetoableChangeSupport liberumVeto = new  VetoableChangeSupport(this);
	private PropertyChangeSupport warWarNeverChange = new PropertyChangeSupport(this);
	//private String accNumber;
	static int couter = 0;
	int accNum = 0;
	
	
	public Account () {
		this.ballance = 0;	
		Account.couter=Account.couter+1;
		this.accNum = Account.couter;
		
		}
	
	
	public Account (double in) {
		this.ballance = in;	
	//	char[] arr = this.getClass().getCanonicalName().toCharArray();
		//System.out.println(this.getClass().getCanonicalName().toString());
		Account.couter=Account.couter+1;
		this.accNum = Account.couter;
		
	}
	
	public synchronized void setBallance(double newIn) throws PropertyVetoException {
		Double oldBallance = this.ballance;
		liberumVeto.fireVetoableChange("Ballance", oldBallance, newIn);
		this.ballance = newIn;
		warWarNeverChange.firePropertyChange("Ballance",oldBallance,newIn);
	}
	
	
	public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
		liberumVeto.addVetoableChangeListener(l);
	}
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		warWarNeverChange.addPropertyChangeListener(l);
	}
	
	public synchronized void removeVetoableChangeListener(VetoableChangeListener l) {
		liberumVeto.removeVetoableChangeListener(l);
	}
	
	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		warWarNeverChange.removePropertyChangeListener(l);
	}

	public void deposit(int wplata) throws PropertyVetoException {
		double nowyBallance = this.ballance + new Double(wplata);
		setBallance(nowyBallance);
	}

	public void withdraw(int wypłata) throws PropertyVetoException {
			double nowyBallance = this.ballance - new Double(wypłata);
			setBallance(nowyBallance);
		}

	public void transfer(Account gdzie, int ile) throws PropertyVetoException {
		double nowyBallance = this.ballance - new Double(ile);
		setBallance(nowyBallance);
		double nowyBallanceNaDrugim = gdzie.ballance + new Double(ile);
		gdzie.setBallance(nowyBallanceNaDrugim);
	}
	
	public double getBallance() {
		return this.ballance;
	}
	
	public int getNum() {
		return this.accNum;
	}
	
	public String toString() {
		return "Acc "+ accNum +": "+ getBallance();
	}
	
}
	
	
	
	
	
	
	
	
	

