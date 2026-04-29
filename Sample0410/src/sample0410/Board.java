package sample0410;

import java.time.format.SignStyle;

/**
 * 盤面の制御を担当するクラス
 */
public class Board {
	// フィールド
	private String[][] board;
	private static final int SIZE = 3;

	/**
	 * コンストラクタ
	 * 盤面を初期化
	 */
	public Board() {
		board = new String[][] { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };
	}

	/**
	 * getterメソッド
	 * 
	 * @param row    行
	 * @param column 列
	 * @return 引数で受け取った行・列のマスのマークを返す
	 */
	public String getCell(int row, int column) {
		return board[row][column];

	}

	/**
	 * 勝敗判定メソッド
	 * 
	 * @param player プレイヤー(o or x)
	 * @return 引数で受け取ったプレイヤーの結果(勝利・引き分け・未決着)を返す
	 */
	public GameState checkWin(Player player) {
		// 横の判定
		for (int i = 0; i < SIZE; i++) {
			if (isSame(board[i][0], board[i][1], board[i][2], player)) {
				return GameState.WIN;
			}
		}

		// 縦の判定
		for (int j = 0; j < SIZE; j++) {
			if (isSame(board[0][j], board[1][j], board[2][j], player)) {
				return GameState.WIN;
			}
		}

		// 斜めの判定①
		if (isSame(board[0][0], board[1][1], board[2][2], player)) {
			return GameState.WIN;

		}

		// 斜めの判定②
		if (isSame(board[0][2], board[1][1], board[2][0], player)) {
			return GameState.WIN;
		}

		// 引き分け
		if (!hasEmptyCells()) {
			return GameState.DRAW;
		}

		// 未決着
		return GameState.ONGOING;

	}

	/**
	 * 勝敗判定メソッド（改善版）
	 * 最後に配置した座標を受けとって、その座標をもとに勝敗を判定する
	 * 
	 * @param position 座標情報
	 * @param player   プレイヤー(o or x)
	 * @return
	 */
	public GameState checkWin2(Position position, Player player) {
		// 縦の判定
		boolean winFlag = true;
		for (int i = 0; i < SIZE; i++) {
			if (!board[i][position.getColumn()].equals(player.getmark())) {
				winFlag = false;
			}
		}

		if (winFlag) {
			return GameState.WIN;
		}

		// 横の判定
		winFlag = true;
		for (int i = 0; i < SIZE; i++) {
			if (!board[position.getRow()][i].equals(player.getmark())) {
				winFlag = false;
			}
		}

		if (winFlag) {
			return GameState.WIN;
		}

		// 斜めの判定①
		winFlag = true;
		for (int i = 0; i < SIZE; i++) {
			if (!board[i][i].equals(player.getmark())) {
				winFlag = false;
			}
		}

		if (winFlag) {
			return GameState.WIN;
		}

		// 斜めの判定②
		winFlag = true;
		for (int i = 0; i < SIZE; i++) {
			if (!board[i][SIZE - i - 1].equals(player.getmark())) {
				winFlag = false;
			}
		}

		if (winFlag) {
			return GameState.WIN;
		}

		// 判定結果
		if (!hasEmptyCells()) { // 引き分け判定
			return GameState.DRAW;
		} else {
			return GameState.ONGOING;
		}
	}

	/**
	 * 3つのマークがすべて同じマークか判定するメソッド
	 * 
	 * @param a      1マス目のマーク
	 * @param b      2マス目のマーク
	 * @param c      3マス目のマーク
	 * @param player プレイヤー(o or x)
	 * @return 同じならtrue、違ったらfalseを返す
	 */
	private boolean isSame(String a, String b, String c, Player player) {
		return a.equals(player.getmark()) && b.equals(player.getmark()) && c.equals(player.getmark());

	}

	/**
	 * 勝者を返すメソッド
	 * 
	 * @return 勝者がいたら勝者のマーク、いなければnullを返す
	 */
	public String getWinner() {
		if (checkWin(Player.o) == GameState.WIN) {
			return "o";
		} else if (checkWin(Player.x) == GameState.WIN) {
			return "x";
		} else {
			return null;
		}
	}

	/**
	 * 盤面全体で空白マスがあるか判定する(引き分け判定)メソッド
	 * 空白マスがあるかチェック→なければ引き分け
	 * 
	 * @return 空白があればtrue、なければfalseを返す
	 */
	public boolean hasEmptyCells() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j].equals(" ")) {
					return true; // 空きあり
				}
			}
		}

		return false; // 空きなし = 引き分け
	}

	/**
	 * 配置メソッド
	 * 引数で受け取った行・列のマスにプレイヤーのマークを置く
	 * 
	 * @param row    行
	 * @param column 列
	 * @param player プレイヤー(o or x)
	 */
	public void placeMark(int row, int column, Player player) {
		board[row][column] = player.getmark();

	}

	/**
	 * 空白チェックメソッド
	 * 引数で受け取った行・列のマスが空白かチェックする
	 * 
	 * @param row    行
	 * @param column 列
	 * @return 空白ならtrue、空白以外ならfalse
	 */
	public boolean isEmpty(int row, int column) {
		return board[row][column].equals(" ");

	}

}
