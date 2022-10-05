package model;

public class VideoGameController{

    private Player[] players;
    private Treasure[] treasures;
    private Enemy[] enemies;
    private Level[] levels;

    public VideoGameController() {
        this.players = new Player[20];
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
        this.levels = new Level[10];
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

    public boolean createdLvl(int num,int score){
        Level level = new Level(num, score);

        for (int i=0; i<levels.length; i++ ){
            if (levels[i]==null){
                levels[i]=level;
                return true;
            }
        }

        return false;
    }

    public String showLevel() {
		String lev = "";

		for (int i = 0; i < levels.length; i++) {
			if (levels[i] != null) {
				lev += levels[i].toString();
			}
		}

		if (lev.equals("")) {
			lev = "No Player registered yet\n ";
		}

		return lev;
	}

    public String showTEnm() {
        String msg = "";
        for (int i=0; i<Type.values().length; i++){
           msg += "\n" + (i+1) + ". " + Type.values()[i];
        }

        return msg;
    }

    public boolean registerEnemy(String name, int type, int subtrScr, int sumScr){
        Enemy newEnemy = new Enemy(name, type, subtrScr, sumScr, subtrScr, sumScr);

        for (int i=0; i<enemies.length; i++){
            if (enemies[i]==null){
                enemies[i] = newEnemy;
                return true;
            }
        }

        return false;
    }

    public String showEnemy() {
		String enem = "";

		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i] != null) {
				enem += enemies[i].toString();
			}
		}

		if (enem.equals("")) {
			enem = "No Player registered yet\n ";
		}

		return enem;
	}

    public String addEnemyToLevel(String EnmName, int numLvL) {
		Enemy nmy = null;
		Level lv = null;
		boolean found = false;
		String addEL = "";
		for (int i = 0; i < enemies.length && !found; i++) {
			if (enemies[i] != null && enemies[i].getName().equals(EnmName)) {
				nmy = enemies[i];
				found = true;
			}
		}
		found = false;
		for (int i = 0; i < levels.length && !found; i++) {
			if (levels[i] != null && levels[i].getNum()==numLvL) {
				lv = levels[i];
				found = true;
			}
		}
		if (nmy != null && lv != null) {
			lv.addEnemy(nmy);
			addEL = "Enemy added to level successfully";
		} else if (nmy == null || lv == null) {
			addEL = "Enemy wasn't add to a level";
		}

		return addEL;
	}

	public boolean registerTreasure(String name, String url, int givSc){
        Treasure newTreasure = new Treasure(name, url, givSc);

        for (int i=0; i<enemies.length; i++){
            if (treasures[i]==null){
                treasures[i] = newTreasure;
                return true;
            }
        }

        return false;
    }

	public String addTreasureToLevel(String TrName, int numLvL, int times) {
		Treasure tr = null;
		Level lv = null;
		boolean found = false;
		boolean find = false;
		String addTL = "";
		for (int i = 0; i < treasures.length && !found; i++) {
			if (treasures[i] != null && treasures[i].getName().equals(TrName)) {
				tr = treasures[i];
				found = true;
			}
		}
		for (int i = 0; i < levels.length && !found; i++) {
			if (levels[i] != null && levels[i].getNum()==numLvL) {
				lv = levels[i];
				find = true;
			}
		}

		for (int i=0; i<times; i++){
			if (tr != null && lv != null) {
				lv.addTreasure(tr);
				addTL = "Treasure(s) added to level successfully";
			} else if (tr == null || lv == null) {
				addTL = "Treasure wasn't add to a level";
			}
		}

		return addTL;
	}
}