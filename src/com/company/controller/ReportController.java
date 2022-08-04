package com.company.controller;


import com.company.dto.ReportDto;
import com.company.model.Store;
import com.company.service.ReportService;

import com.company.view.ReportView;

public class ReportController {

    public void execute(Store[] stores) {
        ReportService reportService = new ReportService(stores);
        ReportDto report = reportService.build();
        ReportView view = new ReportView();
        view.printDetails(report);
    }


}