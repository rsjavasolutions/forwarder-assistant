package time;

import time.Time;
import time.VehicleTime;

import java.time.Duration;

public class TruckTime implements VehicleTime {

    private int minutes;
    private int hours;
    private int partMinutes;
    private int allMinutes;

    public TruckTime(Time time) {
        this.minutes = time.getMinutes();
        Duration duration = Duration.ofMinutes(minutesWithBreaks(this.minutes));
        hours = (int) duration.toHours();
        partMinutes = (int) duration.toMinutesPart();
        allMinutes = (int) duration.toMinutes();
    }

    @Override
    public int getAllMinutes() {
        return allMinutes;
    }

    @Override
    public String timeOfDuration() {
        if (minutes > 2700){
            return "Tygodniowy czas jazdy przekroczony";
        } else {
            return "Auto ciężarowe przejedzie tą droge w ciągu "
                    + hours + " godzin "
                    + partMinutes + " minut";
        }
    }

    private int minutesWithBreaks(int minutes) {
        if (minutes > 2700) {
            minutes = minutes;
        } else {
            if (minutes < 270) {
                minutes = minutes;
            } else if (minutes < 540) { // 1 dzien
                minutes += shortBreak();
            } else if (minutes < 810) { // 1,5 dnia
                minutes += shortBreak() + nineHoursBreak();
            } else if (minutes < 1080) { //2 dzien
                minutes += shortBreak() * 2 + nineHoursBreak();
            } else if (minutes < 1350) {  //2,5 dnia
                minutes += shortBreak() * 2 + nineHoursBreak() * 2;
            } else if (minutes < 1620) { // 3 dzien
                minutes += shortBreak() * 3 + nineHoursBreak() * 2;
            } else if (minutes < 1890) { //3,5 dnia
                minutes += shortBreak() * 3 + nineHoursBreak() * 2 + elevenHoursBreak();
            } else if (minutes < 2160) { // 4 dzien
                minutes += shortBreak() * 4 + nineHoursBreak() * 2 + elevenHoursBreak();
            } else if (minutes < 2430) { //4,5 dnia
                minutes += shortBreak() * 4 + nineHoursBreak() * 2 + elevenHoursBreak() * 2;
            } else if (minutes < 2700) { //5 dzien
                minutes += shortBreak() * 5 + nineHoursBreak() * 2 + elevenHoursBreak() * 2;
            } else minutes = 0;
        }
        return minutes;
    }

   public String timeAndPauses() {

        String pauses = null;

        if (minutes > 2700) {
            pauses = "Tygodniowy czas jazdy przekroczony";
        } else {
            if (minutes < 270) {
                pauses = "";
            } else if (minutes < 540) { // 1 dzien
                pauses = "W tym 45 minut pauzy";
            } else if (minutes < 810) { // 1,5 dnia
                pauses = "W tym 45 minut pauzy i jedna 9 godzinna pauza dobowa";
            } else if (minutes < 1080) { //2 dzien
                pauses = "W tym dwie 45 minutowe pauzy i jedna 9 godzinna pauza dobowa";
            } else if (minutes < 1350) {  //2,5 dnia
                pauses = "W tym dwie 45 minutowe pauzy i dwie 9 godzinne pauzy dobowe";
            } else if (minutes < 1620) { // 3 dzien
                pauses = "W tym trzy 45 minutowe pauzy i dwie 9 godzinne pauzy dobowe";
            } else if (minutes < 1890) { //3,5 dnia
                pauses = "W tym trzy 45 minutowe pauzy,"
                        + "\n" + "dwie 9 godzinne pauzy dobowe skrócone "
                        + " \n"
                        + "i  jedna 11 godzinna regularna pauza dobowa";
            } else if (minutes < 2160) { // 4 dzien
                pauses = "W tym cztery 45 minutowe pauzy, "
                        + "\n" + "dwie 9 godzinne pauzy dobowe skrócone "
                        + "\n"
                        + "i jedna 11 godzinna regularna pauza dobowa";
            } else if (minutes < 2430) { //4,5 dnia
                pauses = "W tym cztery 45 minutowe pauzy,"
                        + "\n" + "dwie 9 godzinne pauzy dobowe skrócone "
                        +"\n"
                        + "oraz dwie 11 godzinne regularne pauzy dobowe";
            } else if (minutes < 2700) { //5 dzien
                pauses = "W tym pięć 45 minutowych pauz,"
                        + "\n" + "dwie 9 godzinne pauzy dobowe skrócone "
                        +"\n"
                        + "oraz dwie 11 godzinne regularne pauzy dobowe";
            }
        }
        return pauses;
    }

    private int shortBreak() {
        return 45;
    }

    private int nineHoursBreak() {
        return 540;
    }

    private int elevenHoursBreak() {
        return 660;
    }
}
