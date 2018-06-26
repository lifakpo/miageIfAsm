package fr.dauphine.miageIfAsm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TauxChangeRepository extends JpaRepository<TauxChange, Long> {
	TauxChange findBySourceAndDest(String source, String dest);
}