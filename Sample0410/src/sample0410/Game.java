package sample0410;

//ゲームの実行・進行を行うクラス
public class Game {
	// フィールド
	private Board board;
	private Display display;
	private PlaceInput input; // ネーミング（他のメソッドも）→変更
	private Player player;

	// ゲーム実行処理→初期化・メイン・終了処理の構成に変更
	public void run() {
		// 初期化処理
		initialize();

		// メイン処理
		mainProcess();

		// 終了処理
		finish();

	}

	// 初期化処理
	public void initialize() {
		board = new Board();
		display = new Display();
		input = new PlaceInput();
		player = Player.o;

	}

	// メイン処理(終了条件を満たすまでループ)→メソッド名変更
	private void mainProcess() {
		// stateを定義
		GameState state = GameState.ONGOING;

		// stateがONGOINGの間ループ→勝敗判定と継続条件を１本化
		while (state == GameState.ONGOING) {
			// 表示→入力→配置までの処理
			playTurn();

			// 勝敗・継続判定更新
			state = board.checkWin(player);

			// プレイヤー切り替え
			if (state == GameState.ONGOING) {
				switchPlayer();

			}

		}
	}

	// 1ターン分のメソッド
	private void playTurn() {
		// 現在のプレイヤーのターンを表示
		display.showTurnInfo(player);

		// 盤面表示
		display.printBoard(board);
		display.showNewLine();

		// 入力受付・バリデーション
		Position pos = input.inputPosition(board);

		// 指定された位置に現在のプレイヤーのマークを配置
		board.placeMark(pos.getRow(), pos.getColumn(), player);

	}

	// プレイヤー切り替えメソッド
	private void switchPlayer() {
		if (player == Player.o) {
			player = Player.x;
		} else {
			player = Player.o;
		}
	}

	// 終了処理メソッド
	private void finish() {
		// 終了後の盤面表示
		display.printBoard(board);

		// 結果を表示
		display.showResult(board.getWinner());

	}
}
