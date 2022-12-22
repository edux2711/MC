package thesoccerleague;

import java.util.ArrayList;

public class SoccerLeagueTest {

	public static void main(String[] args) {
		Teams team1 = new Teams("Real Madrid");
		Teams team2 = new Teams("Barcelona");
		Teams team3 = new Teams("Atletico Madrid");
		Teams team4 = new Teams("Sevilla");
		
		
		Scheduler schedule = new Scheduler(team1, team2, team3, team4);
		schedule.scheduleGame();
		
		ArrayList<Teams> teams;
		teams = new ArrayList();
	    
		teams.add(team1);
	    teams.add(team2);
	    teams.add(team3);
	    teams.add(team4);

		//Games ola = new Games();
		//ola.selectRandomTeam(team1, team2, team3, team4);
		

		//System.out.println("Enter temperature: ");
		//schedule.printArray();
		
	}

}

 