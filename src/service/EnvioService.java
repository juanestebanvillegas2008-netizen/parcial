package service;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class EnvioService {
    private List<Envio> listaEnvios;

    public EnvioService() {
        this.listaEnvios = new ArrayList<>();
    }

    public boolean agregarEnvio(String tipo, String codigo, String cliente, double peso, double distancia) {
        // Verificar si el código ya existe
        if (buscarPorCodigo(codigo) != null) {
            return false;
        }

        Envio nuevoEnvio = null;
        switch (tipo) {
            case "Terrestre":
                nuevoEnvio = new EnvioTerrestre(codigo, cliente, peso, distancia);
                break;
            case "Aéreo":
            case "Aereo":
                nuevoEnvio = new EnvioAereo(codigo, cliente, peso, distancia);
                break;
            case "Marítimo":
            case "Maritimo":
                nuevoEnvio = new EnvioMaritimo(codigo, cliente, peso, distancia);
                break;
        }

        if (nuevoEnvio != null) {
            listaEnvios.add(nuevoEnvio);
            return true;
        }
        return false;
    }

    public boolean eliminarEnvio(String codigo) {
        Envio envio = buscarPorCodigo(codigo);
        if (envio != null) {
            listaEnvios.remove(envio);
            return true;
        }
        return false;
    }

    public Envio buscarPorCodigo(String codigo) {
        for (Envio e : listaEnvios) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }
        return null;
    }

    public List<Envio> obtenerTodos() {
        return listaEnvios;
    }
}