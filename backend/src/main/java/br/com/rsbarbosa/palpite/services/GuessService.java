package br.com.rsbarbosa.palpite.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rsbarbosa.palpite.dto.CadGuessDTO;
import br.com.rsbarbosa.palpite.dto.GraphDTO;
import br.com.rsbarbosa.palpite.dto.GuessDTO;
import br.com.rsbarbosa.palpite.dto.ResultDTO;
import br.com.rsbarbosa.palpite.entities.Client;
import br.com.rsbarbosa.palpite.entities.Guess;
import br.com.rsbarbosa.palpite.entities.Team;
import br.com.rsbarbosa.palpite.repositories.ClientRepository;
import br.com.rsbarbosa.palpite.repositories.GuessRepository;
import br.com.rsbarbosa.palpite.repositories.TeamRepository;
import br.com.rsbarbosa.palpite.services.exceptions.DatabaseException;
import br.com.rsbarbosa.palpite.services.exceptions.ResourceNotFoundException;

@Service
public class GuessService {

	@Autowired
	private GuessRepository repository;

	@Autowired
	private ClientRepository repositoryClient;

	@Autowired
	private TeamRepository repositoryTeam;

	@Transactional(readOnly = true)
	public Page<GuessDTO> findAllPaged(Pageable pageable) {
		Page<Guess> list = repository.findAll(pageable);
		return list.map(x -> new GuessDTO(x));
	}

	@Transactional(readOnly = true)
	public GuessDTO findById(Long id) {
		Optional<Guess> obj = repository.findById(id);
		Guess entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new GuessDTO(entity);
	}

	@Transactional
	public GuessDTO insert(CadGuessDTO dto) {
		Guess entity = new Guess();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new GuessDTO(entity);
	}

	@Transactional
	public GuessDTO update(Long id, CadGuessDTO dto) {
		try {
			Guess entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new GuessDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	public GraphDTO findGraph() {
		GraphDTO dto = new GraphDTO();
		List<ResultDTO> winner = repository.winner();
		List<ResultDTO> vice = repository.vice();
		List<ResultDTO> third = repository.third();
		int i = 0;
		
		String[] win = new String[3];
		Long[] v_win = new Long[3];
		
		for (ResultDTO result : winner) {
			if (i <= 3) {
				win[i] = result.getTeam().getName();
				v_win[i] = result.getVote();
			}
		}
		i=0;
		String[] vic = new String[3];
		Long[] v_vic = new Long[3];

		for (ResultDTO result : vice) {
			if (i <= 3) {
				vic[i] = result.getTeam().getName();
				v_vic[i] = result.getVote();
			}
		}
		
		i=0;
		
		String[] thi = new String[3];
		Long[] v_thi = new Long[3];

		for (ResultDTO result : third) {
			if (i <= 3) {
				thi[i] = result.getTeam().getName();
				v_thi[i] = result.getVote();
			}
		}

		dto.setWinner(win);
		dto.setVice(vic);
		dto.setThird(thi);
		dto.setVote_winner(v_win);
		dto.setVote_vice(v_vic);
		dto.setVote_third(v_thi);

		return dto;
	}

	private void copyDtoToEntity(CadGuessDTO dto, Guess entity) {
		Client cli = new Client(dto.getName(), dto.getEmail(), dto.getAge());

		cli = repositoryClient.save(cli);

		Team winner = repositoryTeam.getOne(dto.getWinner());
		Team vice = repositoryTeam.getOne(dto.getVice());
		Team third = repositoryTeam.getOne(dto.getThird());

		entity.setClient(cli);
		entity.setWinner(winner);
		entity.setVice(vice);
		entity.setThird(third);
	}

}
