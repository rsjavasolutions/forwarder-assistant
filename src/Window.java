import date.DateVehicle;
import date.UserDateVehicle;
import time.CarTime;
import time.Time;
import time.TruckTime;
import time.VehicleTime;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame implements ActionListener {

    int enterRoad;
    int enterSpeed;

    int day, mont, year, hour, minute;

    private JLabel road;
    private JLabel speed;
    private JLabel smallCarInputDate;
    private JLabel slash;
    private JLabel slash2;
    private JLabel slash3;
    private JLabel smallCarInputHour;
    private JLabel ownerLabel;

    private JTextField roadText;
    private JTextField speedText;
    private JTextField dayText;
    private JTextField monthText;
    private JTextField yearText;
    private JTextField hourText;
    private JTextField minuteText;

    private JButton smallCar;
    private JButton oneDriverTruck;
    private JButton smallCarArrive;
    private JButton oneDriverTruckArrive;
    private JButton smallCarUserArrive;
    private JButton truckUserArrive;

    private JTextArea smallResult;
    private JTextArea truckResult;
    private JTextArea smallResultDate;
    private JTextArea truckResultDate;
    private JTextArea smallResultUserDate;
    private JTextArea truckResultUserDate;

    Window() throws HeadlessException {

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("actros.jpg")))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        pack();
        setVisible(false);
        setSize(1200, 700); // ustaw rozmiar
        setTitle("Asystent Spedytora 1.0"); // ustaw tytuł
        setLayout(null);

        road = new JLabel("Kilometry", JLabel.CENTER); // opis, tytuł, wyrównanie
        road.setBounds(10, 5, 70, 20);

        speed = new JLabel("Średnia prędkość", JLabel.CENTER); // opis, tytuł, wyrównanie
        speed.setBounds(10, 60, 120, 20);

        roadText = new JTextField();
        roadText.setBounds(10, 30, 100, 30); //ustaw położenie i wymiary
        roadText.setToolTipText("Wpisz dystans "); //dymek

        speedText = new JTextField();
        speedText.setBounds(10, 80, 100, 30);
        speedText.setToolTipText("Wpisz średnią prędkość");

        dayText = new JTextField();
        dayText.setBounds(10, 30, 100, 30); //ustaw położenie i wymiary
        dayText.setToolTipText("Wpisz dystans "); //dymek

        smallCar = new JButton("Auto osobowe / bus do 3.5 T");
        smallCar.setBounds(300, 10, 220, 30);
        smallCar.addActionListener(this);//dodanie action listenera do ramki

        oneDriverTruck = new JButton("Auto Ciężarowe");
        oneDriverTruck.setBounds(700, 10, 220, 30);
        oneDriverTruck.addActionListener(this);//dodanie action listenera do ramki

        smallCarArrive = new JButton("Data przyjazdu (liczona od teraz)");
        smallCarArrive.setBounds(300, 180, 220, 30);
        smallCarArrive.addActionListener(this);//dodanie action listenera do ramki

        oneDriverTruckArrive = new JButton("Data przyjazdu (liczona od teraz)");
        oneDriverTruckArrive.setBounds(700, 180, 220, 30);
        oneDriverTruckArrive.addActionListener(this);//dodanie action listenera do ramki

        smallCarInputDate = new JLabel("Wpisz datę wyjazdu");
        smallCarInputDate.setBounds(10, 360, 220, 30);

        smallResult = new JTextArea();
        smallResult.setBounds(300, 40, 380, 120);
        smallResult.setToolTipText("Bez tachografu");

        truckResult = new JTextArea();
        truckResult.setBounds(700, 40, 380, 120);
        truckResult.setToolTipText("Z tachografem");

        smallResultDate = new JTextArea();
        smallResultDate.setBounds(300, 210, 380, 120);
        smallResultDate.setToolTipText("Bez tachografu");

        truckResultDate = new JTextArea();
        truckResultDate.setBounds(700, 210, 380, 120);
        truckResultDate.setToolTipText("Z tachografem");

        dayText = new JTextField();
        dayText.setBounds(10, 390, 30, 20); //ustaw położenie i wymiary
        dayText.setToolTipText("Dzień"); //dymek

        monthText = new JTextField();
        monthText.setBounds(60, 390, 30, 20); //ustaw położenie i wymiary
        monthText.setToolTipText("Miesiąc(bez zera na początku)"); //dymek

        yearText = new JTextField();
        yearText.setBounds(120, 390, 60, 20); //ustaw położenie i wymiary
        yearText.setToolTipText("Rok"); //dymek

        slash = new JLabel("/");
        slash.setBounds(50, 390, 20, 20);

        slash2 = new JLabel("/");
        slash2.setBounds(100, 390, 20, 20);

        smallCarInputHour = new JLabel("Wpisz czas wyjazdu");
        smallCarInputHour.setBounds(10, 420, 120, 20);

        hourText = new JTextField();
        hourText.setBounds(10, 440, 30, 20); //ustaw położenie i wymiary
        hourText.setToolTipText("Godzina"); //dymek

        slash3 = new JLabel(":");
        slash3.setBounds(50, 440, 20, 20);

        minuteText = new JTextField();
        minuteText.setBounds(60, 440, 30, 20); //ustaw położenie i wymiary
        minuteText.setToolTipText("Minuty"); //dymek

        smallCarUserArrive = new JButton("Oblicz datę i godzinę przyjazdu");
        smallCarUserArrive.setBounds(300, 360, 220, 30);
        smallCarUserArrive.addActionListener(this);//dodanie action listenera do ramki

        truckUserArrive = new JButton("Oblicz datę i godzinę przyjazdu");
        truckUserArrive.setBounds(700, 360, 220, 30);
        truckUserArrive.addActionListener(this);//dodanie action listenera do ramki

        smallResultUserDate = new JTextArea();
        smallResultUserDate.setBounds(300, 390, 380, 120);
        smallResultUserDate.setToolTipText("Data użytkownika (pojazd bez tachografu)");

        truckResultUserDate = new JTextArea();
        truckResultUserDate.setBounds(700, 390, 380, 120);
        truckResultUserDate.setToolTipText("Data użytkownika (pojazd z tachografem)");

        ownerLabel = new JLabel("RS Java Solutions. All rights reserved");
        ownerLabel.setBounds(10, 580, 500, 100);

        add(road);
        add(speed);
        add(roadText);
        add(speedText);
        add(smallCar);
        add(oneDriverTruck);
        add(smallResult);
        add(truckResult);
        add(smallCarArrive);
        add(oneDriverTruckArrive);
        add(smallResultDate);
        add(truckResultDate);
        add(smallCarInputDate);
        add(dayText);
        add(slash);
        add(monthText);
        add(slash2);
        add(yearText);
        add(smallCarInputHour);
        add(hourText);
        add(slash3);
        add(minuteText);
        add(smallCarUserArrive);
        add(smallResultUserDate);
        add(truckResultUserDate);
        add(truckUserArrive);
        add(ownerLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        enterRoad = Integer.parseInt(roadText.getText());
        enterSpeed = Integer.parseInt(speedText.getText());

        Time time = new Time(enterRoad, enterSpeed);
        CarTime carTime = new CarTime(time);
        TruckTime truckTime = new TruckTime(time);

        Object source = e.getSource();
        if (source == smallCar) {
            smallResult.setWrapStyleWord(true);
            smallResult.setText(carTime.timeOfDuration());
        } else if (source == oneDriverTruck) {
            String allDatas = truckTime.timeOfDuration()
                    + "\n\n" + truckTime.timeAndPauses();
            truckResult.setWrapStyleWord(true);
            truckResult.setText(allDatas);
        } else if (source == smallCarArrive) {
            DateVehicle dateVehicle = new DateVehicle(carTime);
            smallResultDate.setText(dateVehicle.endOfTrip());
        } else if (source == oneDriverTruckArrive) {
            DateVehicle dateVehicle = new DateVehicle(truckTime);
            truckResultDate.setText(dateVehicle.endOfTrip());
        } else if (source == smallCarUserArrive) {
            UserDateVehicle userDateVehicle = getUserDate(carTime);
            smallResultUserDate.setText(userDateVehicle.endOfTrip());
        } else if (source == truckUserArrive) {
            UserDateVehicle userDateVehicle = getUserDate(truckTime);
            truckResultUserDate.setText(userDateVehicle.endOfTrip());
        }
    }

    private UserDateVehicle getUserDate(VehicleTime vehicleTime) {
        day = (Integer.parseInt(dayText.getText()));
        mont = (Integer.parseInt(monthText.getText()));
        year = (Integer.parseInt(yearText.getText()));
        hour = (Integer.parseInt(hourText.getText()));
        minute = (Integer.parseInt(minuteText.getText()));
        return new UserDateVehicle(vehicleTime, day, mont, year, hour, minute);
    }
}
