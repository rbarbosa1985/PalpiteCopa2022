package br.com.rsbarbosa.palpite.dto;

import java.io.Serializable;

import br.com.rsbarbosa.palpite.entities.Team;

public class ResultDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Team team;
	private Long vote;

	public ResultDTO() {
		
	}

	public ResultDTO(Team team, Long vote) {
		this.team = team;
		this.vote = vote;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Long getVote() {
		return vote;
	}

	public void setVote(Long vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "ResultDTO [team=" + team + ", vote=" + vote + "]";
	}
	
}
