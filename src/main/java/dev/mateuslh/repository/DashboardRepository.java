package dev.mateuslh.repository;

import dev.mateuslh.dto.response.DashboardDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DashboardRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<DashboardDTO> countCitiesByState() {
        Query query = entityManager.createQuery("SELECT c.estado.nome, COUNT(c) FROM Cidade c GROUP BY c.estado.nome");
        List<Object[]> result = query.getResultList();
        return result.stream()
                .map(row -> new DashboardDTO((String) row[0], (Long) row[1]))
                .collect(Collectors.toList());
    }
}
