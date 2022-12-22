package thesoccerleague;

import java.util.Scanner;
import java.util.Random;

public class Scheduler {
	static final int participantTeams = 4;
	public int temp;
	Teams team1, team2, team3, team4;
	String[] teams = new String[participantTeams];
	Scanner in = new Scanner(System.in);
	Random rndNum = new Random();

	//constructor
	public Scheduler(Teams team1, Teams team2,Teams team3,Teams team4) {
		this.team1 = team1;
		this.team2 = team2;
		this.team3 = team3;
		this.team4 = team4;
		fillArray();
		printArray();
	}
	
	//Methods
	public void scheduleGame() {
		System.out.println("Enter temperature: ");
		temp = in.nextInt();
		
		if (temp > 0) {
			System.out.println("Warm enough to play.");
			Games game = new Games(selectRandomTeam(), selectRandomTeam(), temp, randomScore(), randomScore());
		}
		else {
			System.out.println("Too cold to play.");
		}
	}
	public void checkTeamSelection() {
		while (team1 == team2) {
			team2 = selectRandomTeam();
		}
	}
	public Teams selectRandomTeam() {
	    int randomNum1 = rndNum.nextInt(4)+1;

	    if(randomNum1 == 1) {
	    	return team1;
	    }
	    else if(randomNum1 == 2) {
	    	return team2;
	    }
	    else if(randomNum1 == 3) {
	    	return team3;
	    }
	    else 
	    	return team4;
	}
	
	public int randomScore() {
		int randomNum2 = rndNum.nextInt(6);
		return randomNum2;
	}
	
	public void printArray() {
		for (int i = 0; i < teams.length; i++) {
			System.out.println(teams[i]);
		}
	}
	
	public void fillArray() {
		teams[0] = team1.getTeamName();
		teams[1] = team2.getTeamName();
		teams[2] = team3.getTeamName();
		teams[3] = team4.getTeamName();
	}

	
}
	/*
	 * 
	 * for (int i = 0; i < teams.length; i++) {
			
	   }
*/
