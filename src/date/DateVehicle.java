package date;

import time.VehicleTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateVehicle {

    private LocalDateTime now;
    private LocalDateTime endTrip;

    public DateVehicle(VehicleTime truckTime) {
        now = LocalDateTime.now();
        endTrip = now.plusMinutes(truckTime.getAllMinutes());
    }

    public String endOfTrip(){

        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String finishedTrip = endTrip.format(dataFormat);
        return "Jak wyruszy teraz to dotrze na miejsce: " + finishedTrip;
    }
}
