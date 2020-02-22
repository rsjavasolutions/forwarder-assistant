package date;

import time.VehicleTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDateVehicle {

    private LocalDateTime userData;
    private LocalDateTime endTrip;

    public UserDateVehicle(VehicleTime vehicleTime, int day, int mont, int year, int hour, int minute) {

        userData = LocalDateTime.of(year,mont,day, hour, minute);
        endTrip = userData.plusMinutes(vehicleTime.getAllMinutes());
    }

   public String endOfTrip(){

        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String startTrip = userData.format(dataFormat);
        String finishedTrip = endTrip.format(dataFormat);
        return "Jak wyruszy " + startTrip +  "\n to dotrze na miejsce: " + finishedTrip;
    }
}

