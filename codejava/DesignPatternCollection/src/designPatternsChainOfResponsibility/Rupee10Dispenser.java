package designPatternsChainOfResponsibility;

public class Rupee10Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 10){
			int num = cur.getAmount()/10;
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing "+num+" Rs.10 note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}
}
