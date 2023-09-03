package interfaces;

import javax.swing.text.View;

public interface ViewBuilderInterface {
	public abstract void build();
	public abstract void buildA();
	public abstract void buildB();
	public abstract View getResult();
}
