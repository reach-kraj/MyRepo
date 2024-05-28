package designPatternsVisitor;

public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}
