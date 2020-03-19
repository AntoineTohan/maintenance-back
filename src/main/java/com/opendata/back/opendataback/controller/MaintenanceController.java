package com.opendata.back.opendataback.controller;

import com.opendata.back.opendataback.entity.Maintenance;
import com.opendata.back.opendataback.repository.MaintenanceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Api(value="API pour le status de la maintenance.")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class MaintenanceController {
    @Autowired
    private MaintenanceRepository maintenanceRepository;
    Long id = (long)1;

    @ApiOperation(value = "Récupérer le status de la maintenance")
    @GetMapping("/maintenance/get-status")
    public Optional<Maintenance> getStatus () {
        Long id = (long)1;
        return maintenanceRepository.findById (id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        Maintenance maintenance = new Maintenance (id, false);
        maintenanceRepository.save (maintenance);
    }
}
