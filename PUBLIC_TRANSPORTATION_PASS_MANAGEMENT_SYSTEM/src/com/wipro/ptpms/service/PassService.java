package com.wipro.ptpms.service;

import java.util.ArrayList;

import com.wipro.ptpms.entity.Passenger;
import com.wipro.ptpms.entity.TravelPass;
import com.wipro.ptpms.entity.UsageLog;
import com.wipro.ptpms.util.InvalidPassOperationException;
import com.wipro.ptpms.util.PassNotFoundException;
import com.wipro.ptpms.util.PassengerNotFoundException;

public class PassService {

    private ArrayList<Passenger> passengers;
    private ArrayList<TravelPass> passes;
    private ArrayList<UsageLog> logs;

    public PassService(ArrayList<Passenger> passengers,
                       ArrayList<TravelPass> passes,
                       ArrayList<UsageLog> logs) {
        this.passengers = passengers;
        this.passes = passes;
        this.logs = logs;
    }

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    public Passenger findPassenger(String passengerId)
            throws PassengerNotFoundException {

        for (Passenger p : passengers) {
            if (p.getPassengerId().equals(passengerId)) {
                return p;
            }
        }
        throw new PassengerNotFoundException("Passenger not found :"+ passengerId);
    }


    public TravelPass issuePass(String passId, String passengerId,
                                String passType, String startDate)
            throws PassengerNotFoundException, InvalidPassOperationException {

        Passenger passenger = findPassenger(passengerId);

     
        for (TravelPass tp : passes) {
            if (tp.getPassengerId().equals(passengerId)
                    && tp.getPassType().equals(passType)
                    && tp.isActive()) {
                throw new InvalidPassOperationException(
                        "Passenger already has an active pass");
            }
        }

        TravelPass pass = new TravelPass(passId,   passengerId, passType,startDate,"2025-08-31",true,1000 );

        passes.add(pass);
        return pass;
    }

    public TravelPass findPass(String passId)
            throws PassNotFoundException {

        for (TravelPass tp : passes) {
            if (tp.getPassId().equals(passId)) {
                return tp;
            }
        }
        throw new PassNotFoundException("Pass not found");
    }

    public void logUsage(String logId, String passId,
                         String date, String routeName)
            throws PassNotFoundException, InvalidPassOperationException {

        TravelPass pass = findPass(passId);

        if (!pass.isActive()) {
            throw new InvalidPassOperationException("Pass is inactive");
        }

        UsageLog log = new UsageLog(logId, passId, date, routeName);
        logs.add(log);
    }

    public void renewPass(String passId, String newStartDate)
            throws PassNotFoundException {

        TravelPass pass = findPass(passId);

        
        pass.setStartDate(newStartDate);

        pass.setEndDate("2025-09-30");

        
        pass.setActive(true);



        pass.setFee(pass.getFee() + 1000);
    }


    public ArrayList<TravelPass> getPassesByPassenger(String passengerId) {

        ArrayList<TravelPass> result = new ArrayList<>();

        for (TravelPass tp : passes) {
            if (tp.getPassengerId().equals(passengerId)) {
                result.add(tp);
            }
        }
        return result;
    }

 
    public String generatePassSummary(String passId) {
        try {
            TravelPass pass = findPass(passId);
            Passenger passenger = findPassenger(pass.getPassengerId());

            StringBuilder sb = new StringBuilder();
            sb.append("Pass ID: ").append(pass.getPassId()).append("\n");
            sb.append("Passenger: ").append(passenger.getName())
              .append(" (").append(passenger.getPassengerId()).append(")\n");
            sb.append("Type: ").append(pass.getPassType()).append("\n");
            sb.append("Start Date: ").append(pass.getStartDate()).append("\n");
            sb.append("End Date: ").append(pass.getEndDate()).append("\n");
            sb.append("Fee: ").append(pass.getFee()).append("\n");
            sb.append("Active: ").append(pass.isActive()).append("\n");
            sb.append("Usage Logs:\n");

            for (UsageLog log : logs) {
                if (log.getPassId().equals(passId)) {
                    sb.append("   ")
                      .append(log.getLogId()).append(" | ")
                      .append(log.getDate()).append(" | ")
                      .append(log.getRouteName()).append("\n");
                }
            }

            return sb.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
