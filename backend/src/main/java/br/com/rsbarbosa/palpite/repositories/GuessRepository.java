package br.com.rsbarbosa.palpite.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.rsbarbosa.palpite.dto.ResultDTO;
import br.com.rsbarbosa.palpite.entities.Guess;

public interface GuessRepository extends JpaRepository<Guess, Long> {
	
	@Query(value = "SELECT new br.com.rsbarbosa.palpite.dto.ResultDTO (winner, COUNT(winner_id) as vote) "
			+ "FROM Guess "
			+ "GROUP BY winner_id "
			+ "ORDER BY vote DESC"
			)
	List<ResultDTO> winner();
	
	@Query(value = "SELECT new br.com.rsbarbosa.palpite.dto.ResultDTO (vice, COUNT(vice_id) as vote) "
			+ "FROM Guess "
			+ "GROUP BY vice_id "
			+ "ORDER BY vote DESC"
			)
	List<ResultDTO> vice();
	
	@Query(value = "SELECT new br.com.rsbarbosa.palpite.dto.ResultDTO (third, COUNT(third_id) as vote) "
			+ "FROM Guess "
			+ "GROUP BY third_id "
			+ "ORDER BY vote DESC"
			)
	List<ResultDTO> third();
}
