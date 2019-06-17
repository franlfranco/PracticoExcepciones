package app;

public class NoCoincidenContactosException extends Exception {

	private String clave;

	public NoCoincidenContactosException(String msg, String clave) {
		super(msg);
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + ", la clave ingresada fue: " + getClave();
	}
}
