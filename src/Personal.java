// Archivo: Personal.java (Superclase)
public abstract class Personal implements Trabajador {
    private String id;
    private String nombre;

    public Personal(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
}