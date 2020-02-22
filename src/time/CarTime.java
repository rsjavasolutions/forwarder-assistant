package time;

import java.time.Duration;

public class CarTime implements VehicleTime {

    private int minutes;
    private int hours;
    private int partMinutes;
    private int allMinutes;

   public CarTime(Time time) {
        this.minutes = time.getMinutes();
        Duration duration = Duration.ofMinutes(this.minutes);
        hours = (int) duration.toHours();
        partMinutes = duration.toMinutesPart();
        allMinutes = (int) duration.toMinutes();
    }

    @Override
    public int getAllMinutes() {
        return allMinutes;
    }

    @Override
    public String timeOfDuration() {

        return "Do przejechania tej trasy potrzeba\n "
                + hours + " godzin "
                + partMinutes + " minut ciągłej jazdy";
    }
}
