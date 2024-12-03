package com.campusdual.classroom;

public class Exercise12 {
    public static void main(String[] args) {
        Car miCoche = new Car();
        miCoche.setBrand("Porsche");
        miCoche.setModel("911 Carrera 4 GTS");
        miCoche.setFuel("Gasolina");
        
        miCoche.start();
        miCoche.start();

        miCoche.stop();

        miCoche.start();

        miCoche.accelerate();

        for (int i = 0; i < 25; i++) {
            miCoche.accelerate();
        }

        miCoche.brake();
        for (int i = 0; i < 25; i++) {
            miCoche.brake();
        }

        miCoche.turnAngleOfWheels(45);
        miCoche.turnAngleOfWheels(-30);
        miCoche.turnAngleOfWheels(-70);

        miCoche.stop();

        miCoche.setReverse(true);
        miCoche.setReverse(false);

        miCoche.start();

        miCoche.accelerate();

        miCoche.setReverse(true);
    }

}