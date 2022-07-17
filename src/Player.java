public class Player {

	public String username;
	private int score;

	public Player(String username) {
		this.username = username;
		score = 0;
	}

	public String getUsername() {
		return this.username;
	}

	public int getScore() {
		return this.score;
	}

	public void updateScore(int delta) {
		this.score += delta;
	}
}
