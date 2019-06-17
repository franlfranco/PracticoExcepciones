package app;

public class Main {

	public static void main(String[] args) {

		Libreta miLibreta = new Libreta();
		
		try {
			miLibreta.agregarContacto(new Contacto("Francisco", "123"));
			miLibreta.agregarContacto(new Contacto("Fernando", "456"));
			miLibreta.agregarContacto(new Contacto("Felipe", "789"));
		} catch (ClaveDuplicadaException e1) {
			e1.getMessage();
		}
		
		System.out.println("Hay " + miLibreta.getCantidadEntradas() + " contactos en su libreta");
		
		Contacto contacto;
		
		try {
			contacto = miLibreta.getContactoConExcepciones("juan");
		} catch (ClaveNoExisteExcecption e) {
			System.out.println(e.getMessage());
		} catch (ClaveVaciaExcecption e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Este va siempre jeje");
		}
		
		try {
			miLibreta.eliminarContacto("Felipe");
		} catch (NoCoincidenContactosException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Hay " + miLibreta.getCantidadEntradas() + " contactos en su libreta");
	}

}
