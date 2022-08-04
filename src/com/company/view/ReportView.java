package com.company.view;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;
import com.company.model.product.Product;

public class ReportView {

    public static final String DESCRIPTION = "REPORT DATA: ";

    public void printDetails(ReportDto report) {
        int dash = 50;
        System.out.println("=".repeat(dash));
        System.out.println(DESCRIPTION + report.getName());
        System.out.println("=".repeat(dash));

        System.out.println("name\t\t\tcount\t\t\tsum");
        System.out.println("=".repeat(dash));

        for (BuyingDto buyingDto : report.getData()) {
            String cost = Math.round(buyingDto.getSum()) + " uah";
            System.out.printf("%-15s %-14s %-14s\n", buyingDto.getName(), buyingDto.getCount(), cost);

            System.out.println("-".repeat(dash));
        }
        System.out.println("=".repeat(dash));
        System.out.printf("%-30s %-4s %-4s\n", "Total sum: ", report.getTotalSum(), "uah");
    }


}
