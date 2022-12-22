package thesoccerleague;

import java.util.Scanner;

public class Teams {
	//fields
	private String teamName;
	private int winTotal,
	            lossTotal, 
	            tieTotal,
	            goalsTotal,
	            allowedTotal;
	
	//constructor
	public Teams(String name) {
		this.teamName = name;
	}
	
	//Methods
	
	
	
	//getter
	public String getTeamName() {
        return teamName;
	}
	//setters
	public void setWintTotal(int w) {
		this.winTotal = w;
    }
	public void setLossTotal(int l) {
		this.lossTotal = l;
	} 	
	public void setTieTotal(int t) {
		this.tieTotal = t;
    }
	public void setGoalsTotal(int g) {
		this.goalsTotal = g;
	} 	
	public void setAllowedTotal(int a) {
		this.allowedTotal = a;
    }
}
