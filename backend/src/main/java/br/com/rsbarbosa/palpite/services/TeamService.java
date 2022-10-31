package br.com.rsbarbosa.palpite.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rsbarbosa.palpite.dto.TeamDTO;
import br.com.rsbarbosa.palpite.entities.Team;
import br.com.rsbarbosa.palpite.repositories.TeamRepository;
import br.com.rsbarbosa.palpite.services.exceptions.DatabaseException;
import br.com.rsbarbosa.palpite.services.exceptions.ResourceNotFoundException;

@Service
public class TeamService {

	@Autowired
	private TeamRepository repository;
	
	@Transactional(readOnly = true)
	public Page<TeamDTO> findAllPaged(Pageable pageable) {
		Page<Team> list = repository.findAll(pageable);
		return list.map(x -> new TeamDTO(x));
	}

	@Transactional(readOnly = true)
	public TeamDTO findById(Long id) {
		Optional<Team> obj = repository.findById(id);
		Team entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TeamDTO(entity);
	}

	@Transactional
	public TeamDTO insert(TeamDTO dto) {
		Team entity = new Team();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new TeamDTO(entity);
	}

	@Transactional
	public TeamDTO update(Long id, TeamDTO dto) {
		try {
			Team entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new TeamDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(TeamDTO dto, Team entity) {
		entity.setName(dto.getName());
		entity.setImgUrl(dto.getImgUrl());
	}
}
