package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import org.example.classes.Car;
import org.example.classes.Wheel;
import org.example.classes.Engine;
import org.example.classes.FuelTank;


public class Controller {

    Car car = new Car("Mashina");

    @FXML
    private Label labelWheel4;

    @FXML
    private Label labelGo;

    @FXML
    private Label labelWheel1;

    @FXML
    private Label labelWheel3;

    @FXML
    private Label labelWheel2;

    @FXML
    private Label labelFuel;

    @FXML
    private Label labelEngineStart;

    @FXML
    private Label labelEngineWork;

    @FXML
    private Button buttonGo;

    @FXML
    private Button buttonAddFuel;

    @FXML
    void initialize () {
        buttonGo.setOnAction(event -> {
            if(!car.flagGo){
                car.go();
            }
            else{
                car.stop();
            }
            updateCar(car.flagGo);
        });
        buttonAddFuel.setOnAction(event -> {
            ((FuelTank)car.getTank()).addFuel(1 * FuelTank.L);        // Доабавляем литр
            updateCar(car.flagGo);
        });
    }

    void updateCar(boolean flag) {
        if (flag){
            labelGo.setText("Едем");
            labelEngineWork.setText("Работает");
            labelEngineStart.setText("Заведен");
            buttonGo.setText("Стоп");
        }
        else{
            labelGo.setText("Не Едем");
            labelEngineWork.setText("Не работает");
            labelEngineStart.setText("Не заведен");
            buttonGo.setText("Ехать");
        }
        labelWheel1.setText(((Wheel)car.getWheel1()).status());
        labelWheel2.setText(((Wheel)car.getWheel2()).status());
        labelWheel3.setText(((Wheel)car.getWheel3()).status());
        labelWheel4.setText(((Wheel)car.getWheel4()).status());
        labelFuel.setText(String.valueOf(((FuelTank)car.getTank()).fuel));
    }

}