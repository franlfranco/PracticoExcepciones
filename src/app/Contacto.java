package app;

public class Contacto {

	private String nombre;
	private String telefono;

	public Contacto() {
		super();
		setNombre("");
		setTelefono("");
	}

	public Contacto(String nombre, String telefono) {
		super();
		setNombre(nombre);
		setTelefono(telefono);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
