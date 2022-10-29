package br.com.rsbarbosa.palpite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rsbarbosa.palpite.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
