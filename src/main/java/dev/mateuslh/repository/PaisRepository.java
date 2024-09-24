package dev.mateuslh.repository;

import dev.mateuslh.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>, PagingAndSortingRepository<Pais, Long> {
}
