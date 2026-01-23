package com.wipro.ptpms.main;

import java.util.ArrayList;
import com.wipro.ptpms.entity.*;
import com.wipro.ptpms.service.PassService;

public class Main {

    public static void main(String[] args) {

        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("P001", "Rohit Mehta", "rohit@gmail.com"));

        ArrayList<TravelPass> passes = new ArrayList<>();
        ArrayList<UsageLog> logs = new ArrayList<>();

        PassService service = new PassService(passengers, passes, logs);

        try {
            TravelPass tp = service.issuePass(
                    "PASS001",
                    "P001",
                    "MONTHLY",
                    "2025-08-01"
            );

            service.logUsage(
                    "L001",
                    "PASS001",
                    "2025-08-05",
                    "Metro Line 2"
            );

            service.renewPass("PASS001", "2025-09-01");

            System.out.println(service.generatePassSummary("PASS001"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
