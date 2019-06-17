package app;

import java.util.TreeMap;

public class Libreta {

	TreeMap<String, Contacto> libreta;
	private int cantidadEntradas;

	public Libreta() {
		libreta = new TreeMap<String, Contacto>();
	}

	public void agregarContacto(Contacto c) throws ClaveDuplicadaException {
		if (existeClave(c.getNombre())) {
			throw new ClaveDuplicadaException("El nombre ya fue ingresado. Pruebe otro");
		} else if (existeClave(c.getTelefono())) {
			throw new ClaveDuplicadaException("El telefono ya fue ingresado. Pruebe otro");
		} else {
			libreta.put(c.getNombre(), c);
			libreta.put(c.getTelefono(), c);
			cantidadEntradas++;
		}
	}

	public int getCantidadEntradas() {
		return cantidadEntradas;
	}

	public Contacto getContacto(String clave) {
		return libreta.get(clave);
	}

	public Contacto getContactoConExcepciones(String clave) throws ClaveNoExisteExcecption, ClaveVaciaExcecption {
		if (clave.isEmpty()) {
			throw new ClaveVaciaExcecption("La clave esta vacia");
		}
		if (!existeClave(clave)) {
			throw new ClaveNoExisteExcecption("La clave no existe", clave);
		} else {
			return libreta.get(clave);
		}
	}

	public boolean existeClave(String clave) {
		return libreta.containsKey(clave);
	}

	public void eliminarContacto(String clave) throws NoCoincidenContactosException {
		if (!existeClave(clave)) {
			throw new NoCoincidenContactosException("Clave inexistente", clave);
		} else {
			Contacto contacto = libreta.get(clave);
			libreta.remove(contacto.getNombre());
			libreta.remove(contacto.getTelefono());
			cantidadEntradas--;
		}
	}

	public void modificarContacto(String clave, String telefono, String nombre) throws NoCoincidenContactosException {
		if (!existeClave(clave)) {
			throw new NoCoincidenContactosException("Clave inexistente", clave);
		} else {
			Contacto contacto = getContacto(clave);
			contacto.setNombre(nombre);
			contacto.setTelefono(telefono);
		}
	}
}
