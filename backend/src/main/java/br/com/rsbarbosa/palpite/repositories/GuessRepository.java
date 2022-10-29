package br.com.rsbarbosa.palpite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rsbarbosa.palpite.entities.Guess;

public interface GuessRepository extends JpaRepository<Guess, Long> {
}
