package com.example.dan.Android_Chess;
import static com.example.dan.Android_Chess.MainActivity.Field;
public class FigureKnight extends ChessFigure {

	public FigureKnight(byte x, byte y, boolean color) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(true);
		this.setColor(color);
		if (color)
			this.setLabel('\u2658');
		else
			this.setLabel('\u265E');
	}
	@Override
	boolean CanMove(byte to_x, byte to_y) {
		byte x = this.getCoordinate_x();
		byte y = this.getCoordinate_y();
		if ( (!Field[to_x ][to_y].isActive||(Field[to_x ][to_y].getColor() != this.getColor()&&Field[to_x ][to_y].isActive)) )
			if((x-to_x==1&&to_y-y==2)||(to_x-x==1&&to_y-y==2)||(to_x-x==2&&to_y-y==1)||(to_x-x==2&&y-to_y==1)||(x-to_x==2&&to_y-y==1)||(x-to_x==2&&y-to_y==1)||
					(x-to_x==1&&y-to_y==2)||(to_x-x==1&&y-to_y==2))return true;
		return false;
	}
	@Override
	void Move(byte to_x, byte to_y) {
		this.setCoordinate_x(to_x);
		this.setCoordinate_y(to_y);
	}
}
