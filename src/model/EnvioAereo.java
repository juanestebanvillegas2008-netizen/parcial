package model;

public class EnvioAereo extends Envio {
    public EnvioAereo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * 5000) + (getPeso() * 4000); //[cite: 1]
    }

    @Override
    public String getTipo() {
        return "Aéreo";
    }
}