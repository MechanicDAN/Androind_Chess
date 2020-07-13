package com.example.dan.Android_Chess;
public class EmptyFigure extends ChessFigure {
	public EmptyFigure(byte x, byte y) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(false);
		this.setLabel('\u25A1');
	}

	@Override
	boolean CanMove(byte to_x, byte to_y) {
		System.out.println("False");return false;
	}
}
