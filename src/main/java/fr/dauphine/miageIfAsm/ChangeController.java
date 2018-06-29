package fr.dauphine.miageIfAsm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private TauxChangeRepository repository;

	@PostMapping("/devise-change")
	public TauxChange saveTauxChange(@RequestBody TauxChange tauxChange) {
		return repository.save(tauxChange);
	}

	@GetMapping("/devise-change")
	public List<TauxChange> findAllTauxChange() {
		return repository.findAll();
	}

	@GetMapping("/devise-change/source/{source}/dest/{dest}")
	public TauxChange findTauxChange(@PathVariable String source, @PathVariable String dest) {
		return repository.findBySourceAndDest(source.toUpperCase(), dest.toUpperCase());
	}

	@PostMapping("/devise-change/{id}")
	public TauxChange updateTauxChange(@RequestBody TauxChange tauxChange, @PathVariable Long id) {
		tauxChange.setId(id);
		return repository.saveAndFlush(tauxChange);
	}

	@DeleteMapping("/devise-change/{id}")
	public void deleteTauxChange(@PathVariable Long id) {
		repository.deleteById(id);
	}
}