package controller;

import model.Envio;
import service.EnvioService;
import view.EnvioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvioController implements ActionListener {
    private EnvioView vista;
    private EnvioService servicio;

    public EnvioController(EnvioView vista, EnvioService servicio) {
        this.vista = vista;
        this.servicio = servicio;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnEliminarHeader.addActionListener(this);
        this.vista.btnAgregarHeader.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardarEnvio();
        } else if (e.getSource() == vista.btnCancelar) {
            vista.limpiarCampos();
        } else if (e.getSource() == vista.btnEliminarHeader) {
            eliminarEnvio();
        } else if (e.getSource() == vista.btnAgregarHeader) {
            vista.txtCodigo.requestFocus();
        }
    }

    private void guardarEnvio() {
        try {
            String codigo = vista.txtCodigo.getText().trim();
            String cliente = vista.txtCliente.getText().trim();
            String tipo = (String) vista.cbTipo.getSelectedItem();
            double peso = Double.parseDouble(vista.txtPeso.getText().trim());
            double distancia = Double.parseDouble(vista.txtDistancia.getText().trim());

            if (codigo.isEmpty() || cliente.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.");
                return;
            }

            boolean exito = servicio.agregarEnvio(tipo, codigo, cliente, peso, distancia);
            if (exito) {
                actualizarTabla();
                vista.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "El código del envío ya existe.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Por favor ingrese valores numéricos válidos para peso y distancia.");
        }
    }

    private void eliminarEnvio() {
        int filaSeleccionada = vista.tablaEnvios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String codigo = (String) vista.modeloTabla.getValueAt(filaSeleccionada, 1);
            servicio.eliminarEnvio(codigo);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un envío de la tabla para eliminar.");
        }
    }

    private void actualizarTabla() {
        vista.modeloTabla.setRowCount(0);
        for (Envio envio : servicio.obtenerTodos()) {
            // Se ejecuta polimórficamente el método calcularTarifa()
            Object[] fila = {
                envio.getTipo(),
                envio.getCodigo(),
                envio.getCliente(),
                envio.getPeso(),
                envio.getDistancia(),
                envio.calcularTarifa()
            };
            vista.modeloTabla.addRow(fila);
        }
    }
}