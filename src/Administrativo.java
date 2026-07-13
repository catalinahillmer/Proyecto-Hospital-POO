// Archivo: Administrativo.java (Subclase 3)
public class Administrativo extends Personal {
    private String area;

    public Administrativo(String id, String nombre, String area) {
        super(id, nombre);
        this.area = area;
    }

    public String getArea() { return area; }

    @Override
    public String realizarTareaPrincipal() {
        return "Gestionando agendas médicas y documentos.";
    }
}