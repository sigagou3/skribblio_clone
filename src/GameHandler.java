import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameHandler {

	private List<Player> players;
	private Timer timer;
	
	public GameHandler() {
		players = new ArrayList<>();
		timer = new Timer();
	}

	public List<Player> selectOrder() {
		List<Player> orderedPlayers = new ArrayList<>();
		Random rng = new Random();
		for (int i = 0; i < players.size(); i++) {
			int playerIndex = rng.nextInt(players.size());
			orderedPlayers.add(players.remove(playerIndex));
		}
		return orderedPlayers;
	}
	
	public void update() {
		
	}
	
	public void startTimer() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				update();
			}
		}, 60);
	}
	
	public int getSecondsLeft() {
		return 60; 
	}
	
	public int getPlayerScore() {
		return getSecondsLeft() * 100;
	}
}
