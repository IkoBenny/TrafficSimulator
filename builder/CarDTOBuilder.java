package builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interfaces.ThreadWrapperInterface;
import interfaces.WrapperBuilderInterface;
import sim.Mediator;
import wrappers.CarDTO;

public class CarDTOBuilder implements WrapperBuilderInterface {
	private CarDTO dto;
	private static Logger log = LoggerFactory.getLogger(CarDTOBuilder.class);
	private int id;
	private Mediator mvc;
	
	public CarDTOBuilder(Mediator mvc) {
		log.info("Inside CarDTOBuilder() {}...");
		this.mvc = mvc;
		log.info("Leaving CarDTOBuilder() {}...");
	}
	
	@Override
	public void build() {
		dto = getNewCarDTO();
	}

	@Override
	public void buildA() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildB() {
		// TODO Auto-generated method stub

	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public ThreadWrapperInterface getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	private CarDTO getNewCarDTO() {
		return new CarDTO(mvc, mvc.getM().getCar(id).getCurrentSpeed(),
				mvc.getM().getCar(id).getPositionAsString(), id);
	}
	
	public static void main(String [] args) {
		//CarDTOBuilder c = new CarDTOBuilder();
		//c.build();
	}
}
