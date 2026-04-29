package sample0410;

/**
 * 〇×ゲームの実行・進行を行うクラス
 */
public class Game {
	// フィールド
	private Board board;
	private Display display;
	private PositionInput input;
	private Player player;
	private Position pos;

	/**
	 * コンストラクタ
	 */
	public Game() {
		// 初期化処理
		initialize();
	}

	/**
	 * ゲーム実行処理
	 * メイン処理→終了処理の順で実行
	 */
	public void run() {
		// メイン処理
		mainProcess();

		// 終了処理
		finish();

	}

	/**
	 * 初期化処理
	 * 盤面・表示・入力・プレイヤーを初期状態にリセットする
	 */
	private void initialize() {
		board = new Board();
		display = new Display();
		input = new PositionInput();
		player = Player.o;

	}

	/**
	 * メイン処理
	 */
	private void mainProcess() {
		// stateを初期化
		GameState state = GameState.ONGOING;

		// stateがONGOINGの間ループ
		while (state == GameState.ONGOING) {
			// 表示→入力→配置までの処理
			playTurn();

			// 勝敗・継続判定更新
			state = board.checkWin2(pos, player);

			// プレイヤー切り替え
			if (state == GameState.ONGOING) {
				switchPlayer();

			}

		}
	}

	/**
	 * 1ターン分のメソッド
	 * 表示→入力→配置まで行う
	 */
	private void playTurn() {
		// 現在のプレイヤーのターンを表示
		display.showTurnInfo(player);

		// 盤面表示
		display.printBoard(board);
		display.showNewLine();

		// 入力受付・バリデーション
		pos = input.inputPosition(board, display);

		// 指定された位置に現在のプレイヤーのマークを配置
		board.placeMark(pos.getRow(), pos.getColumn(), player);

	}

	/**
	 * プレイヤー切り替えメソッド
	 */
	private void switchPlayer() {
		if (player == Player.o) {
			player = Player.x;
		} else {
			player = Player.o;
		}
	}

	/**
	 * 終了処理メソッド
	 */
	private void finish() {
		// 終了後の盤面表示
		display.printBoard(board);

		// 結果を表示
		display.showResult(board.getWinner());

	}
}
