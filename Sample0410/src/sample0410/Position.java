package sample0410;

/**
 * 座標を管理するクラス
 */
public class Position {
	// フィールド
	private int row;
	private int column;

	/**
	 * コンストラクタ
	 * 
	 * @param row    行
	 * @param column 列
	 */
	public Position(int row, int column) {
		this.row = row;
		this.column = column;

	}

	/**
	 * 行のゲッターメソッド
	 * 
	 * @return 行を返す
	 */
	public int getRow() {
		return row;

	}

	/**
	 * 列のゲッターメソッド
	 * 
	 * @return 列を返す
	 */
	public int getColumn() {
		return column;
	}
}
