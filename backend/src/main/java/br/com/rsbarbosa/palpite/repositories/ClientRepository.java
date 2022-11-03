package br.com.rsbarbosa.palpite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rsbarbosa.palpite.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
