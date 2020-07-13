package com.example.dan.Android_Chess;
import static com.example.dan.Android_Chess.MainActivity.Field;
public class FigureKing extends ChessFigure {
	byte count=0;

	public FigureKing(byte x, byte y, boolean color) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(true);
		this.setColor(color);
		if (color)
			this.setLabel('\u2654');
		else
			this.setLabel('\u265A');
	}
	@Override
	boolean CanMove(byte to_x, byte to_y) {
		byte x = this.getCoordinate_x();
		byte y = this.getCoordinate_y();
		System.out.println(x+1);
		System.out.println(y+1);
		System.out.println(to_x+1);
		System.out.println(to_y+1);
		if ( (!Field[to_x ][to_y].isActive||(Field[to_x ][to_y].getColor() != this.getColor()&&Field[to_x ][to_y].isActive)) ){
		if((x+1==to_x)&&(y+1==to_y)){count++;return true;}
		if((x-1==to_x)&&(y-1==to_y)){count++;return true;}
		if((y+1==to_y)&&(x==to_x)){count++;return true;}
		if((y-1>=to_y)&&(x==to_x)){count++;return true;}
		if((y==to_y)&&(x-1==to_x)){count++;return true;}
		if((y==to_y)&&(x+1==to_x)){count++;return true;}
		}
		if(this.count==0) {
			if ((y - to_y == 0 && to_y - y == 0) && (x - to_x == 2) && Field[0][0].rok() == 0)
				if (!Field[to_x][to_y].isActive && !Field[to_x + 1][to_y].isActive && !Field[to_x - 1][to_y].isActive) {
					Field[3][to_y] = Field[0][to_y];
					Field[3][to_y].Move((byte)3,to_y);
					Field[0][to_y] = new EmptyFigure((byte) 0, to_y);
					return true;
				}
			if ((y - to_y == 0 && to_y - y == 0) && (to_x - x == 2) && Field[7][0].rok() == 0)
				if(!Field[to_x][to_y].isActive && !Field[x+1][to_y].isActive){
					Field[5][to_y] = Field[7][to_y];
					Field[5][to_y].Move((byte)5,to_y);
					Field[7][to_y] = new EmptyFigure((byte) 0, to_y);
					return true;
				}
		}

		return false;
	}
	@Override
	void Move(byte to_x, byte to_y) {
		this.setCoordinate_x(to_x);
		this.setCoordinate_y(to_y);
	}
}
