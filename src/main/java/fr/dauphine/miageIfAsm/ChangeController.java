package fr.dauphine.miageIfAsm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private TauxChangeRepository repository;

	@GetMapping("/devise-change/source/{source}/dest/{dest}")
	public TauxChange retrouveTauxChange(@PathVariable String source, @PathVariable String dest) {
		TauxChange tauxChange = repository.findBySourceAndDest(source.toUpperCase(), dest.toUpperCase());
		return tauxChange;
	}
}