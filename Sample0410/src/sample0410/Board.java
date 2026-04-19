package sample0410;

//盤面の制御を担当するクラス
public class Board {
	// フィールド
	private String[][] board;
	private static final int SIZE = 3;

	// コンストラクタで初期化
	public Board() {
		board = new String[][] { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };
	}

	// getterメソッド
	public String getCell(int row, int column) {
		return board[row][column];

	}

	// 勝敗判定メソッド
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

	// 3つのマスがすべて同じマークか判定するメソッド
	private boolean isSame(String a, String b, String c, Player player) {
		return a.equals(player.getmark()) && b.equals(player.getmark()) && c.equals(player.getmark());

	}

	// 勝者を返すメソッド（いなければnull）
	public String getWinner() {
		if (checkWin(Player.o) == GameState.WIN) {
			return "o";
		} else if (checkWin(Player.x) == GameState.WIN) {
			return "x";
		} else {
			return null;
		}
	}

	// 引き分け判定メソッド
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

	// 配置メソッド
	public void placeMark(int row, int column, Player player) {
		board[row][column] = player.getmark();

	}

	// 空白チェックメソッド
	public boolean isEmpty(int row, int column) {
		return board[row][column].equals(" ");

	}

}
