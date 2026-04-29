package sample0410;

/**
 * プレイヤーを表すenum型
 */
public enum Player {
  // 各プレイヤーと表示用のマークを定義
  o("o"),
  x("x");

  // フィールド
  private final String mark;

  /**
   * コンストラクタ
   * 
   * @param mark マーク(o or x)
   */
  Player(String mark) {
    this.mark = mark;

  }

  /**
   * 表示用のマークのゲッターメソッド
   * 
   * @return マーク(o or x)を返す
   */
  public String getmark() {
    return mark;
  }
}
