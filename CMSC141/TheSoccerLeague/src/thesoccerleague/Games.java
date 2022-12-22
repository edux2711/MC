package thesoccerleague;


public class Games {
	static  int gameId = 0;
	private int teamScore;
	private int temp;
	Teams team1, team2;
	Scheduler schedule;
	
	//constructor
	public Games(Teams team1, Teams team2, int temp, int teamScore1, int teamScore2) {
		gameId++;
		
		this.team1 = team1;
		this.team2 = team2;
		this.temp = temp;
		this.teamScore = teamScore;
	}
	
	//method
	
	public void playGame(Teams team1, Teams team2) {
		
	    //int randomNum = rndNum.nextInt(5);
	    gameId++;
	    System.out.println("Game #"        + gameId              + "\n"
	    		         + "Temperature: " + temp                + "\n"
	    		         + "Away team: "   + team2.getTeamName() + "\n");
		
	}
	
	//setter
	public void setTemp(int t) {
		this.temp = t;
	}
}
