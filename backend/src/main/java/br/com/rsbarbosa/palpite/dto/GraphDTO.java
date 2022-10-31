package br.com.rsbarbosa.palpite.dto;

import java.io.Serializable;

import br.com.rsbarbosa.palpite.entities.Team;

public class GraphDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Team winner;
	private Long vote_winner;
	private Team vice;
	private Long vote_vice;
	private Team third;
	private Long vote_third;
	
	public GraphDTO() {
		
	}

	public GraphDTO(Team winner, Long vote_winner) {
		
		this.winner = winner;
		this.vote_winner = vote_winner;
	}
	
	public GraphDTO(Team winner, Long vote_winner, Team vice, Long vote_vice, Team third, Long vote_third) {
		
		this.winner = winner;
		this.vote_winner = vote_winner;
		this.vice = vice;
		this.vote_vice = vote_vice;
		this.third = third;
		this.vote_third = vote_third;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public Long getVote_winner() {
		return vote_winner;
	}

	public void setVote_winner(Long vote_winner) {
		this.vote_winner = vote_winner;
	}

	public Team getVice() {
		return vice;
	}

	public void setVice(Team vice) {
		this.vice = vice;
	}

	public Long getVote_vice() {
		return vote_vice;
	}

	public void setVote_vice(Long vote_vice) {
		this.vote_vice = vote_vice;
	}

	public Team getThird() {
		return third;
	}

	public void setThird(Team third) {
		this.third = third;
	}

	public Long getVote_third() {
		return vote_third;
	}

	public void setVote_third(Long vote_third) {
		this.vote_third = vote_third;
	}

	@Override
	public String toString() {
		return "GraphDTO [winner=" + winner + ", vote_winner=" + vote_winner + ", vice=" + vice + ", vote_vice="
				+ vote_vice + ", third=" + third + ", vote_third=" + vote_third + "]";
	}
	
	
	
}
