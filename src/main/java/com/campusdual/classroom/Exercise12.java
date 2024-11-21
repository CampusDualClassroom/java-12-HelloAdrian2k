package com.campusdual.classroom;

public class Exercise12 {
    public static void main(String[] args) {
        Car miCoche = new Car("Porsche", "911 Carrera 4 GTS", "Gasolina");
        miCoche.start();
        miCoche.start();

        miCoche.stop();

        miCoche.start();

        miCoche.accelerate();

        for(int i = 0; i < 25; i++){
            miCoche.accelerate();
        }

        miCoche.brake();
        for (int i = 0; i < 25; i++){
            miCoche.brake();
        }

        miCoche.turnAngleOfWheels(20);
        miCoche.turnAngleOfWheels(-30);
        miCoche.turnAngleOfWheels(-40);

        miCoche.stop();

        miCoche.setReverse(true);
        miCoche.setReverse(false);

        miCoche.start();

        miCoche.accelerate();

        miCoche.setReverse(true);
    }

}