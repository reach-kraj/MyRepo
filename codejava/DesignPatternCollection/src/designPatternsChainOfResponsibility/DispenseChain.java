package designPatternsChainOfResponsibility;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}
