// Archivo: Enfermero.java (Subclase 2)
public class Enfermero extends Personal {
    private String pabellon;

    public Enfermero(String id, String nombre, String pabellon) {
        super(id, nombre);
        this.pabellon = pabellon;
    }

    public String getPabellon() { return pabellon; }

    @Override
    public String realizarTareaPrincipal() {
        return "Suministrando medicamentos y controlando signos vitales.";
    }
}