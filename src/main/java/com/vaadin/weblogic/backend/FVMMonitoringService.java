package com.vaadin.weblogic.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FVMMonitoringService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FVMMonitoring> findAll() {
        return jdbcTemplate.query("SELECT titel as t, beschreibung as b FROM fvm_monitoring", (rs, rowNum) -> {
            FVMMonitoring fvmMonitoring = new FVMMonitoring();
            fvmMonitoring.setTitel(rs.getString("t"));
            fvmMonitoring.setBeschreibung(rs.getString("b"));
            return fvmMonitoring;
        });
    }
}
