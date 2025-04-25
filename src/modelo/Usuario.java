package modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String usuario;
    private String clave;
    private String rol;
    private boolean estado;
    private String correo;

    // Constructor completo (para lecturas desde BD y autenticación)
    public Usuario(int id, String nombre, String usuario, String clave, String rol, boolean estado, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.estado = estado;
        this.correo = correo;
    }

    // Constructor de conveniencia (id, nombre, correo)
    public Usuario(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Constructor vacío
    public Usuario() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
