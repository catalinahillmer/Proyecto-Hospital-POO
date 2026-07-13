import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HospitalGUI extends JFrame {
    private ArrayList<Personal> listaPersonal = new ArrayList<>();

    private JTextField txtId, txtNombre, txtDatoEspecifico;
    private JComboBox<String> cbTipoPersonal;
    private JTextArea txtAreaConsola;
    private JLabel lblDatoEspecifico;

    public HospitalGUI() {
        setTitle("Gestión de Personal Médico - Hospital");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Registro de Personal"));

        panelFormulario.add(new JLabel("Tipo de Personal:"));
        cbTipoPersonal = new JComboBox<>(new String[]{"Médico", "Enfermero"});
        panelFormulario.add(cbTipoPersonal);

        panelFormulario.add(new JLabel("ID / Rut:"));
        txtId = new JTextField();
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Nombre Completo:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        lblDatoEspecifico = new JLabel("Especialidad:");
        panelFormulario.add(lblDatoEspecifico);
        txtDatoEspecifico = new JTextField();
        panelFormulario.add(txtDatoEspecifico);

        JButton btnAgregar = new JButton("Registrar / Ingresar");
        panelFormulario.add(btnAgregar);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBorder(BorderFactory.createTitledBorder("Visualización y Comportamiento Polimórfico"));

        txtAreaConsola = new JTextArea();
        txtAreaConsola.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaConsola);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        JButton btnListar = new JButton("Procesar Lista con 'instanceof'");
        panelCentral.add(btnListar, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);

        cbTipoPersonal.addActionListener(e -> {
            if (cbTipoPersonal.getSelectedItem().equals("Médico")) {
                lblDatoEspecifico.setText("Especialidad:");
            } else {
                lblDatoEspecifico.setText("Pabellón / Sector:");
            }
        });

        btnAgregar.addActionListener(e -> {
            String id = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String dato = txtDatoEspecifico.getText().trim();

            if (id.isEmpty() || nombre.isEmpty() || dato.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cbTipoPersonal.getSelectedItem().equals("Médico")) {
                listaPersonal.add(new Medico(id, nombre, dato));
                JOptionPane.showMessageDialog(this, "Médico registrado con éxito.");
            } else {
                listaPersonal.add(new Enfermero(id, nombre, dato));
                JOptionPane.showMessageDialog(this, "Enfermero registrado con éxito.");
            }

            txtId.setText("");
            txtNombre.setText("");
            txtDatoEspecifico.setText("");
        });

        btnListar.addActionListener(e -> {
            txtAreaConsola.setText("");
            if (listaPersonal.isEmpty()) {
                txtAreaConsola.setText("La lista está vacía. Registre personal primero.");
                return;
            }

            txtAreaConsola.append("=== PROCESANDO PERSONAL CON INSTANCEOF ===\n\n");

            for (Personal p : listaPersonal) {
                txtAreaConsola.append("ID: " + p.getId() + " | Nombre: " + p.getNombre() + "\n");
                txtAreaConsola.append(" -> Tarea General: " + p.realizarTareaPrincipal() + "\n");

                if (p instanceof Medico) {
                    Medico m = (Medico) p;
                    txtAreaConsola.append(" -> [ROL MÉDICO] Especialidad registrada: " + m.getEspecialidad() + "\n");
                }
                else if (p instanceof Enfermero) {
                    Enfermero enf = (Enfermero) p;
                    txtAreaConsola.append(" -> [ROL ENFERMERÍA] Asignado al pabellón: " + enf.getPabellon() + "\n");
                }

                txtAreaConsola.append("-----------------------------------------------------------------------\n");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HospitalGUI().setVisible(true);
        });
    }
}