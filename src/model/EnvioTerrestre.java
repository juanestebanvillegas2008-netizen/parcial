package model;

public class EnvioTerrestre extends Envio {
    public EnvioTerrestre(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * 1500) + (getPeso() * 2000); //[cite: 1]
    }

    @Override
    public String getTipo() {
        return "Terrestre";
    }
}