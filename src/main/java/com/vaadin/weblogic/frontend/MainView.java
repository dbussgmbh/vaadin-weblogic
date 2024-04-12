package com.vaadin.weblogic.frontend;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.weblogic.backend.FVMMonitoring;
import com.vaadin.weblogic.backend.FVMMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "")
public class MainView extends VerticalLayout {

    @Autowired
    public MainView(FVMMonitoringService fvmMonitoringService) {
        setHeight("100%");
        Grid<FVMMonitoring> grid = new Grid<>();
        grid.addColumn(FVMMonitoring::getTitel).setHeader("Titel");
        grid.addColumn(FVMMonitoring::getBeschreibung).setHeader("Beschreibung");
        grid.setItems(fvmMonitoringService.findAll());
        grid.getColumns().forEach(column -> column.setAutoWidth(true).setResizable(true));
        add(grid);
    }
}
