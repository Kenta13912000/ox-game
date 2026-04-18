package sample0410;

public class Position {
	//フィールド
	private int row;
	private int column;
	
	//コンストラクタ
	public Position (int row, int column) {
		this.row = row;
		this.column = column;
		
	}
	
	public int getRow() {
		return row;
			
	}
	
	public int getColumn() {
		return column;
	}
}
