package model;

public class VideoGameController{

    private Player[] players;
    private Treasure[] treasures;
    private Enemy[] enemies;

    public VideoGameController() {
        this.players = new Player[20];
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
    }

    public boolean registerPlayer(String nickname, String name){
        Player newPlayer = new Player(nickname, name);

        for (int i=0; i<players.length; i++){
            if(players[i]==null){
                players[i] = newPlayer;

                return true;
            }
        }

        return false;
    }

    public String showPlayer() {
		String playe = "";

		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				playe += players[i].toString();
			}
		}

		if (playe.equals("")) {
			playe = "No Player registered yet\n ";
		}

		return playe;
	}
}