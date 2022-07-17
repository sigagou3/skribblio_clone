import java.util.ArrayList;
import java.util.List;

public class PlayerHandler {
	
	public List<Player> players;
	
	public PlayerHandler() {
		players = new ArrayList<>();
	}
	
	public void addPlayer(String username) {
		players.add(new Player(username));
	}
	
	public Player getPlayer(String playerName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).username == playerName) {
				return players.get(i);
			}
		}
		return null;
	}
}
