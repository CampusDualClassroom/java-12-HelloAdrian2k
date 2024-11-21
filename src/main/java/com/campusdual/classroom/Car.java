package com.campusdual.classroom;

public class Car {

    //ATRIBUTOS
    
    //CONSTANTES
    
    public final int MAX_SPEED = 120;
    public final int REVERSE_TOP_SPEED = 20;

    //VARIABLES
    
    String brand;
    String model;
    String fuel;
    int speedometer;
    int tachometer;
    String gear = "N";
    boolean reverse;
    int wheelsAngle;
    
    //CONSTRUCTORES

    public Car() {
        this.brand = "Porsche";
        this.model = "911 Carrera 4 GTS";
        this.fuel = "Gasolina";
    }

    //MÉTODOS CONDICIONALES

    private boolean isReverse() {
        return this.reverse;
    }

    private boolean isOff(){
        return this.tachometer == 0;
    }

    public boolean isTachometerGreaterThanZero(){
        return this.tachometer > 0;
    }

    public boolean isTachometerEqualToZero(){
        return this.tachometer == 0;
    }

    //MÉTODOS DE ENCENDIDO Y APAGADO

    public void start(){
        if (isTachometerEqualToZero()){
            this.tachometer = 1000;
            System.out.println("Vehículo encendido.");
        }else{
            System.out.println("El vehículo ya está encendido.");
        }
    }

    public void stop(){
        if (this.speedometer == 0){
            this.tachometer = 0;
            System.out.println("Vehículo apagado.");
        }else{
            System.out.println("El vehículo no se puede apagar, vehículo en marcha.");
        }
    }

    //MÉTODOS DE ACELERAR Y FRENAR

    public void accelerate() {
        if (this.speedometer == this.MAX_SPEED) {
            System.out.println("Velocidade máxima alcanzada");
        } else {
            if (this.isReverse() && this.speedometer == 25) {
                System.out.println("El vehículo alcanzó la máxima velocidad marcha atrás.");
            } else {
                if(isTachometerGreaterThanZero()){
                    this.speedometer +=5;
                    System.out.println("La nueva velocidad es " + this.speedometer);
                }else{
                    System.out.println("No se puede acelerar. El vehículo está apagado.");
                }
            }
        }
    }

    public void brake() {
        if (this.speedometer == 0) {
            System.out.println("El vehículo ya está detenido.");
        } else {
            this.speedometer -= 5;
            System.out.println("La nueva velocidad es " + this.speedometer);
        }
    }

    //MÉTODOS DE MARCHAS

    public void setReverse(boolean reverse) {
        if(this.isReverse() != reverse){
            if(this.speedometer == 0){
                if(reverse){
                    this.gear = "R";
                }else{
                    this.gear = "N";
                }
                this.reverse = reverse;
                System.out.println("La marcha engranada es " + this.gear);
            }else{
                System.out.println("El vehículo debe estar detenido para cambiar la marcha.");
            }
        }else{
            System.out.println("El vehículo ya tiene la marcha " + this.gear + " engranada.");
        }
    }

    //MÉTODOS RELACIONADOS CON EL GIRO DEL VOLANTE

    public void turnAngleOfWheels(int angle) {
        if (this.wheelsAngle+angle <= 45 && this.wheelsAngle+angle >= -45) {
            this.wheelsAngle += angle;
        } else {
//            System.out.println("No se puede girar más.");
            if(this.wheelsAngle+angle > 45){
                this.wheelsAngle = 45;
            }else{
                this.wheelsAngle = -45;
            }
        }
        System.out.println("Giro actual del volante: " + this.wheelsAngle);
    }

    //MÉTODOS DE VISUALIZACIÓN DE DATOS

    public String showSteeringWheelDetail() {
        StringBuilder builder = new StringBuilder();
        builder.append("O volante está ");

        if (this.wheelsAngle == 0) {
            builder.append("no centro.");
        } else if (this.wheelsAngle > 0) {
            builder.append("xirado á dereita.");
        } else {
            builder.append("xirado á esquerda.");
        }
        builder.append(" O ángulo de xiro do volante é " + this.wheelsAngle + "º");

        return builder.toString();
    }

    public void showDetails() {
        System.out.println("\nDATOS DEL VEHÍCULO:\n");
        System.out.println("El " + this.brand + " " + this.model + " tiene una velocidad de " + this.speedometer +
                " km/h");
        System.out.println("Revoluciones: " + this.tachometer);
        System.out.println("Marcha engranada: " + this.gear);
        System.out.println(this.showSteeringWheelDetail());

    }
}
