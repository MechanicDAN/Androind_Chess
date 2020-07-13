package com.example.dan.Android_Chess;
import static com.example.dan.Android_Chess.MainActivity.Field;

public class FigureBishop extends ChessFigure {

	public FigureBishop(byte x, byte y, boolean color) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(true);
		this.setColor(color);
		if (color)
			this.setLabel('\u2657');
		else
			this.setLabel('\u265D');
	}
	@Override
	boolean CanMove(byte to_x, byte to_y) {
		byte x = this.getCoordinate_x();
		byte y = this.getCoordinate_y();
		if ( (!Field[to_x ][to_y].isActive||(Field[to_x ][to_y].getColor() != this.getColor()&&Field[to_x ][to_y].isActive))&&Pust(x,y,to_x,to_y) )
			if((x-to_x==y-to_y)||(to_x-x==to_y-y)||(x-to_x==to_y-y)||(to_x-x==y-to_y)) return true;
		return false;
	}
	@Override
	void Move(byte to_x, byte to_y) {
		this.setCoordinate_x(to_x);
		this.setCoordinate_y(to_y);
	}
	boolean Pust(byte x,byte y,byte to_x,byte to_y){
		if(x<to_x&&y<to_y)
			for(int i=x+1,j=y+1;i<to_x&&j<to_y;i++,j++)
				if(Field[i][j].isActive)return false;
		if(x<to_x&&y>to_y)
			for(int i=x+1,j=y-1;i<to_x&&j>to_y;i++,j--)
				if(Field[i][j].isActive)return false;
		if(x>to_x&&y<to_y)
			for(int i=x-1,j=y+1;i>to_x&&j<to_y;i--,j++)
				if(Field[i][j].isActive)return false;
		if(x>to_x&&y>to_y)
			for(int i=x-1,j=y-1;i>to_x&&j>to_y;i--,j--)
				if(Field[i][j].isActive)return false;
		return true;
	}
}
