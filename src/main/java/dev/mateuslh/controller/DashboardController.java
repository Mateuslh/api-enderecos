package dev.mateuslh.controller;

import dev.mateuslh.dto.response.DashboardDTO;
import dev.mateuslh.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping()
    public ResponseEntity<List<DashboardDTO>> getCitiesGroupedByState() {
        List<DashboardDTO> result = dashboardService.getCountCitiesByState();
        return ResponseEntity.ok(result);
    }
}
