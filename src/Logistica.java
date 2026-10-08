
import controller.EnvioController;
import service.EnvioService;
import view.EnvioView;

public class Logistica {
    public static void main(String[] args) {
        // Inicialización de componentes MVC + Service
        EnvioService servicio = new EnvioService();
        EnvioView vista = new EnvioView();
        EnvioController controlador = new EnvioController(vista, servicio);

        // Cargar algunos datos iniciales del enunciado para prueba
        servicio.agregarEnvio("Terrestre", "10001", "Polimeros Col", 1200.0, 400.0); //[cite: 1]
        servicio.agregarEnvio("Terrestre", "10002", "Textiles Pepalfa", 500.0, 600.0); //[cite: 1]
        servicio.agregarEnvio("Aéreo", "10003", "Flores Colombi", 1500.0, 2000.0); //[cite: 1]

        // Mostrar interfaz
        vista.setVisible(true);
    }
}