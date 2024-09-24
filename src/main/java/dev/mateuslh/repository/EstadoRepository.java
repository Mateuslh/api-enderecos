package dev.mateuslh.repository;

import dev.mateuslh.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>, PagingAndSortingRepository<Estado, Long> {
}
