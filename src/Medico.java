// Archivo: Medico.java (Subclase 1)
public class Medico extends Personal {
    private String especialidad;

    public Medico(String id, String nombre, String especialidad) {
        super(id, nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }

    @Override
    public String realizarTareaPrincipal() {
        return "Atendiendo paciente y diagnosticando.";
    }
}