package dev.mateuslh.service;

import dev.mateuslh.dto.response.DashboardDTO;
import dev.mateuslh.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public List<DashboardDTO> getCountCitiesByState() {
        return dashboardRepository.countCitiesByState();
    }
}

