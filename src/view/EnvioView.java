package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EnvioView extends JFrame {
    public JTextField txtCodigo, txtCliente, txtPeso, txtDistancia;
    public JComboBox<String> cbTipo;
    public JButton btnGuardar, btnCancelar, btnAgregarHeader, btnEliminarHeader;
    public JTable tablaEnvios;
    public DefaultTableModel modeloTabla;

    public EnvioView() {
        setTitle("Operador Logístico"); //[cite: 1]
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Barra Superior / Botones de acción
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnAgregarHeader = new JButton("+ Envió");
        btnEliminarHeader = new JButton("- Envío");
        panelHeader.add(btnAgregarHeader);
        panelHeader.add(btnEliminarHeader);
        add(panelHeader, BorderLayout.NORTH);

        // Formulario Central
        JPanel panelCenter = new JPanel(new BorderLayout());
        JPanel panelForm = new JPanel(new GridLayout(3, 4, 5, 5));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Número:"));
        txtCodigo = new JTextField();
        panelForm.add(txtCodigo);

        panelForm.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Terrestre", "Aéreo", "Marítimo"}); //[cite: 1]
        panelForm.add(cbTipo);

        panelForm.add(new JLabel("Cliente:"));
        txtCliente = new JTextField();
        panelForm.add(txtCliente);

        panelForm.add(new JLabel("Distancia en Km:")); //[cite: 1]
        txtDistancia = new JTextField();
        panelForm.add(txtDistancia);

        panelForm.add(new JLabel("Peso:"));
        txtPeso = new JTextField();
        panelForm.add(txtPeso);

        JPanel panelBotonesForm = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelBotonesForm.add(btnGuardar);
        panelBotonesForm.add(btnCancelar);

        panelForm.add(panelBotonesForm);

        panelCenter.add(panelForm, BorderLayout.NORTH);

        // Tabla de datos
        String[] columnas = {"Tipo", "Código", "Cliente", "Peso", "Distancia", "Costo"}; //[cite: 1]
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEnvios = new JTable(modeloTabla);
        panelCenter.add(new JScrollPane(tablaEnvios), BorderLayout.CENTER);

        add(panelCenter, BorderLayout.CENTER);
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistancia.setText("");
        cbTipo.setSelectedIndex(0);
    }
}