package builder;

import interfaces.DirectorInterface;
import interfaces.WrapperBuilderInterface;

public class WrapperBuilderDirector implements DirectorInterface {
	WrapperBuilderInterface builder;
	
	public WrapperBuilderDirector(WrapperBuilderInterface builder) {
		this.builder = builder;
	}
	
	@Override
	public void construct() {
		builder.build();
		builder.buildA();
		builder.buildB();
	}

}
