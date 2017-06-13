package it.polito.tdp.borders.model;

public class Contiguity {
	
	private Country stateUno;
	private Country stateDue;
	
	public Contiguity(Country stateUno, Country stateDue) {
		
		this.stateUno = stateUno;
		this.stateDue = stateDue;
	}

	/**
	 * @return the stateUno
	 */
	public Country getStateUno() {
		return stateUno;
	}

	/**
	 * @return the stateDue
	 */
	public Country getStateDue() {
		return stateDue;
	}

	/**
	 * @param stateUno the stateUno to set
	 */
	public void setStateUno(Country stateUno) {
		this.stateUno = stateUno;
	}

	/**
	 * @param stateDue the stateDue to set
	 */
	public void setStateDue(Country stateDue) {
		this.stateDue = stateDue;
	}
	
	
	
	

}
