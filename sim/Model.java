package sim;

public class Model {
	TrafficLight lightOne;
	TrafficLight lightTwo;
	TrafficLight lightThree;
	Car carOne;
	Car carTwo;
	Car carThree;
	Time clock;

	
	
	/*
	 * //turns scoreboard on public synchronized void togglePower() { if(power)
	 * power = false; else { homeName = "HOME"; awayName = "AWAY"; homeScore = "0";
	 * awayScore = "0"; quarter = "1"; homeBonus = false; awayBonus = false;
	 * possessionArrow = "POSS - <"; } }
	 */
	
	public double getCarOneSpeed() {
		return carOne.getCurrentSpeed();
	}
	
	public double getCarTwoSpeed() {
		return carTwo.getCurrentSpeed();
	}
	
	public double getCarThreeSpeed() {
		return carThree.getCurrentSpeed();
	}
	
	/*
	 * public double getCarOnePosition() { return carOne.getPosition(); }
	 * 
	 * public double getCarTwoPosition() { return carTwo.getPosition(); }
	 * 
	 * public double getCarThreePosition() { return carThree.getPosition(); }
	 */
	public void setCarOne(Car carOne) {
		this.carOne = carOne;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
