package model;

public class EnvioMaritimo extends Envio {
    public EnvioMaritimo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * 800) + (getPeso() * 1000); //[cite: 1]
    }

    @Override
    public String getTipo() {
        return "Marítimo";
    }
}