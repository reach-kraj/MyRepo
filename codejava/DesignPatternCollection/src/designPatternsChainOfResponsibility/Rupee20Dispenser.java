package designPatternsChainOfResponsibility;

public class Rupee20Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}
	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" Rs.20 note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}
}
