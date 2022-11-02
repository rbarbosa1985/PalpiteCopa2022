package br.com.rsbarbosa.palpite.dto;

import java.io.Serializable;

public class GraphDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String[] winner;
	private Long[] vote_winner;
	private String[] vice;
	private Long[] vote_vice;
	private String[] third;
	private Long[] vote_third;
	
	public GraphDTO() {
		
	}

	public GraphDTO(String[] winner, Long[] vote_winner, String[] vice, Long[] vote_vice, String[] third,
			Long[] vote_third) {
		this.winner = winner;
		this.vote_winner = vote_winner;
		this.vice = vice;
		this.vote_vice = vote_vice;
		this.third = third;
		this.vote_third = vote_third;
	}

	public String[] getWinner() {
		return winner;
	}

	public void setWinner(String[] winner) {
		this.winner = winner;
	}

	public Long[] getVote_winner() {
		return vote_winner;
	}

	public void setVote_winner(Long[] vote_winner) {
		this.vote_winner = vote_winner;
	}

	public String[] getVice() {
		return vice;
	}

	public void setVice(String[] vice) {
		this.vice = vice;
	}

	public Long[] getVote_vice() {
		return vote_vice;
	}

	public void setVote_vice(Long[] vote_vice) {
		this.vote_vice = vote_vice;
	}

	public String[] getThird() {
		return third;
	}

	public void setThird(String[] third) {
		this.third = third;
	}

	public Long[] getVote_third() {
		return vote_third;
	}

	public void setVote_third(Long[] vote_third) {
		this.vote_third = vote_third;
	}
	
	
	
}
