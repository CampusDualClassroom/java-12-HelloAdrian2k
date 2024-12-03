package com.campusdual.classroom;

public class Car {

    //ATRIBUTOS

    //CONSTANTES

    public final int MAX_SPEED = 120;
    public final int REVERSE_TOP_SPEED = 20;

    //VARIABLES

    private String brand;
    private String model;
    private String fuel;
    private boolean reverse;
    //atributos public para que el test pueda acceder a ellos
    public int speedometer;
    public int tachometer;
    public String gear = "N";
    public int wheelsAngle;

    //CONSTRUCTORES

    public Car() {
    }

    public Car(String brand, String model, String fuel) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    //GETTERS Y SETTERS

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(final String fuel) {
        this.fuel = fuel;
    }

    public int getTachometer() {
        return tachometer;
    }

    public void setTachometer(final int tachometer) {
        this.tachometer = tachometer;
    }

    public int getSpeedometer() {
        return speedometer;
    }

    public void setSpeedometer(final int speedometer) {
        this.speedometer = speedometer;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(final String gear) {
        this.gear = gear;
    }

    public int getWheelsAngle() {
        return wheelsAngle;
    }

    public void setWheelsAngle(final int wheelsAngle) {
        this.wheelsAngle = wheelsAngle;
    }


    //MÉTODOS CONDICIONALES

    private boolean isReverse() {
        return this.reverse;
    }

    private boolean isOff() {
        return this.getTachometer() == 0;
    }

    public boolean isTachometerGreaterThanZero() {
        return this.getTachometer() > 0;
    }

    public boolean isTachometerEqualToZero() {
        return this.getTachometer() == 0;
    }

    //MÉTODOS DE ENCENDIDO Y APAGADO

    public void start() {
        if (isTachometerEqualToZero()) {
            this.setTachometer(1000);
            System.out.println("Vehículo encendido.");
        } else {
            System.out.println("El vehículo ya está encendido.");
        }
    }

    public void stop() {
        if (this.getSpeedometer() == 0) {
            this.setTachometer(0);
            System.out.println("Vehículo apagado.");
        } else {
            System.out.println("El vehículo no se puede apagar, vehículo en marcha.");
        }
    }

    //MÉTODOS DE ACELERAR Y FRENAR

    public void accelerate() {
        if (this.getSpeedometer() == this.MAX_SPEED) {
            System.out.println("Velocidade máxima alcanzada");
        } else {
            if (this.isReverse() && this.getSpeedometer() == 25) {
                System.out.println("El vehículo alcanzó la máxima velocidad marcha atrás.");
            } else {
                if (isTachometerGreaterThanZero()) {
                    this.setSpeedometer(this.getSpeedometer() + 5);
                    System.out.println("La nueva velocidad es " + this.getSpeedometer());
                } else {
                    System.out.println("No se puede acelerar. El vehículo está apagado.");
                }
            }
        }
    }

    public void brake() {
        if (this.getSpeedometer() == 0) {
            System.out.println("El vehículo ya está detenido.");
        } else {
            this.setSpeedometer(this.getSpeedometer() - 5);
            System.out.println("La nueva velocidad es " + this.getSpeedometer());
        }
    }

    //MÉTODOS DE MARCHAS

    public void setReverse(boolean reverse) {
        if (this.isReverse() != reverse) {
            if (this.getSpeedometer() == 0) {
                this.setGear(reverse ? "R" : "N");
                this.reverse = reverse;
                System.out.println("La marcha engranada es " + this.getGear());
            } else {
                System.out.println("El vehículo debe estar detenido para cambiar la marcha.");
            }
        } else {
            System.out.println("El vehículo ya tiene la marcha " + this.getGear() + " engranada.");
        }
    }

    //MÉTODOS RELACIONADOS CON EL GIRO DEL VOLANTE

    public void turnAngleOfWheels(int angle) {
        this.setWheelsAngle((this.getWheelsAngle() + angle <= 45 && this.getWheelsAngle() + angle >= -45) ?
                this.getWheelsAngle() + angle : (this.getWheelsAngle() + angle > 45) ? 45 : -45);
        System.out.println("Giro actual del volante: " + this.getWheelsAngle());
    }

    //MÉTODOS DE VISUALIZACIÓN DE DATOS

    public String showSteeringWheelDetail() {
        StringBuilder builder = new StringBuilder();
        builder.append("O volante está ");

        if (this.getWheelsAngle() == 0) {
            builder.append("no centro.");
        } else if (this.getWheelsAngle() > 0) {
            builder.append("xirado á dereita.");
        } else {
            builder.append("xirado á esquerda.");
        }
        builder.append(" O ángulo de xiro do volante é " + this.getWheelsAngle() + "º");

        return builder.toString();
    }

    public void showDetails() {
        System.out.println("\nDATOS DEL VEHÍCULO:\n");
        System.out.println("El " + this.getBrand() + " " + this.getModel() + " tiene una velocidad de " +
                this.getSpeedometer() + " km/h");
        System.out.println("Revoluciones: " + this.getTachometer());
        System.out.println("Marcha engranada: " + this.getGear());
        System.out.println(this.showSteeringWheelDetail());

    }
}