package org.example.classes;

import java.util.*;

public class Car {                      // Класс машины

    String name;
    Vector details;

    Car(String str){
        details = new Vector(6);        // 4 - колеса, двигатель и топливный бак
        name = str;
    }

    void go(){                          // Метод ехать

    }
}
