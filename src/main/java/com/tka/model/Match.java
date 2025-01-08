package com.tka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Matches")
public class Match {
	@Id
	private int matchId;
	private String teamOneName;
	private String teamTwoName;
	//@Column(name = "match_date")
	private String date;
	private String venue;
	private String result;
	
	public Match() {
	
	}

	public Match(int matchId, String teamOneName, String teamTwoName, String date, String venue, String result) {
		super();
		this.matchId = matchId;
		this.teamOneName = teamOneName;
		this.teamTwoName = teamTwoName;
		this.date = date;
		this.venue = venue;
		this.result = result;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getTeamOneName() {
		return teamOneName;
	}

	public void setTeamOneName(String teamOneName) {
		this.teamOneName = teamOneName;
	}

	public String getTeamTwoName() {
		return teamTwoName;
	}

	public void setTeamTwoName(String teamTwoName) {
		this.teamTwoName = teamTwoName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", teamOneName=" + teamOneName + ", teamTwoName=" + teamTwoName + ", date="
				+ date + ", venue=" + venue + ", result=" + result + "]";
	}

	

}
