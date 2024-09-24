package dev.mateuslh.repository;

import dev.mateuslh.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>, PagingAndSortingRepository<Cidade, Long> {
}
