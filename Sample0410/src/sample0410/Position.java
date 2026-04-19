package sample0410;

//座標を管理するクラス
public class Position {
	// フィールド
	private int row;
	private int column;

	// コンストラクタ
	public Position(int row, int column) {
		this.row = row;
		this.column = column;

	}

	// 行のゲッターメソッド
	public int getRow() {
		return row;

	}

	// 列のゲッターメソッド
	public int getColumn() {
		return column;
	}
}
