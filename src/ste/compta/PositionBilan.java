package ste.compta;

public enum PositionBilan {	A ('A'),B ('B'),C ('C'),D ('D');
private char pos;
	private PositionBilan(char c){
		pos = c;
	}
	public char charOf(){
		return pos;
	}
}
