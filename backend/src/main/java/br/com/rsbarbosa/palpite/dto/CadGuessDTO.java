package br.com.rsbarbosa.palpite.dto;

import java.io.Serializable;

public class CadGuessDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private Integer age;
	private Long winner;
	private Long vice;
	private Long third;

	public CadGuessDTO() {
		
	}

	public CadGuessDTO(Long id, String name, String email, Integer age, Long winner, Long vice, Long third) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

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
	
	
	
}
