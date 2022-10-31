package br.com.rsbarbosa.palpite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rsbarbosa.palpite.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
