package br.com.rsbarbosa.palpite.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rsbarbosa.palpite.dto.GraphDTO;
import br.com.rsbarbosa.palpite.dto.GuessDTO;
import br.com.rsbarbosa.palpite.services.GuessService;

@RestController
@RequestMapping(value = "/guess")
public class GuessResource {

	@Autowired
	private GuessService service;
	
	@GetMapping
	public ResponseEntity<Page<GuessDTO>> findAll(Pageable pageable) {
		Page<GuessDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<GuessDTO> findById(@PathVariable Long id) {
		GuessDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/partial")
	public ResponseEntity<GraphDTO> findPartial() {
		GraphDTO dto = service.findGraph();
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<GuessDTO> insert(@RequestBody GuessDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<GuessDTO> update(@PathVariable Long id, @RequestBody GuessDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
} 
