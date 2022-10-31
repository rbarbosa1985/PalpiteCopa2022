package br.com.rsbarbosa.palpite.dto;

import java.io.Serializable;

import br.com.rsbarbosa.palpite.entities.Guess;

public class GuessDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private ClientDTO client;
	private TeamDTO winner;
	private TeamDTO vice;
	private TeamDTO third;
	
	public GuessDTO() {
		
	}

	public GuessDTO(Long id, ClientDTO client, TeamDTO winner, TeamDTO vice, TeamDTO third) {
		this.id = id;
		this.client = client;
		this.winner = winner;
		this.vice = vice;
		this.third = third;
	}
	
	public GuessDTO(Guess entity) {
		id = entity.getId();
		client = new ClientDTO(entity.getClient());
		winner = new TeamDTO(entity.getWinner());
		vice = new TeamDTO(entity.getVice());
		third = new TeamDTO(entity.getThird());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public TeamDTO getWinner() {
		return winner;
	}

	public void setWinner(TeamDTO winner) {
		this.winner = winner;
	}

	public TeamDTO getVice() {
		return vice;
	}

	public void setVice(TeamDTO vice) {
		this.vice = vice;
	}

	public TeamDTO getThird() {
		return third;
	}

	public void setThird(TeamDTO third) {
		this.third = third;
	}

}
