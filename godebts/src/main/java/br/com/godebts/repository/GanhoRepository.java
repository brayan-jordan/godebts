package br.com.godebts.repository;

import br.com.godebts.model.Ganho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GanhoRepository extends JpaRepository<Ganho, Long> {
}
