package time;

public class Time {

    private double road;
    private double speed;
    private double time;
    private double doubleMinutes;
    private int minutes;

   public Time(double road, double speed) {
        this.road = road;
        this.speed = speed;
        try {
            time = road / speed;
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        doubleMinutes = time * 60;
        minutes = (int)Math.round(doubleMinutes);
    }

    public int getMinutes() {
        return minutes;
    }
}
