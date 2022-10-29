package br.com.rsbarbosa.palpite.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_guess")
public class Guess  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Long client;*/
	
	@ManyToOne
	@JoinColumn(name = "winner_id")
	private Long winner;
	
	@ManyToOne
	@JoinColumn(name = "vice_id")
	private Long vice;
	
	@ManyToOne
	@JoinColumn(name = "third_id")
	private Long third;
	
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	public Guess() {
		
	}

	public Guess(Long id, Long client, Long winner, Long vice, Long third) {
		this.id = id;
		//this.client = client;
		this.winner = winner;
		this.vice = vice;
		this.third = third;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//
//	public Long getClient() {
//		return client;
//	}
//
//	public void setClient(Long client) {
//		this.client = client;
//	}

	public Long getWinner() {
		return winner;
	}

	public void setWinner(Long winner) {
		this.winner = winner;
	}

	public Long getVice() {
		return vice;
	}

	public void setVice(Long vice) {
		this.vice = vice;
	}

	public Long getThird() {
		return third;
	}

	public void setThird(Long third) {
		this.third = third;
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guess other = (Guess) obj;
		return Objects.equals(id, other.id);
	}
	
}
