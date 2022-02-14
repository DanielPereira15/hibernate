package hibernate.util;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Direccion {
	@Getter
	@Setter
	@Column(name = "calle", length = 200, nullable = false)
	private String calle;
	@Getter
	@Setter
	@Column(name = "municipio", length = 45, nullable = false)
	private String municipio;
	@Getter
	@Setter
	@Column(name = "provincia", length = 45, nullable = false)
	private String provincia;

	/**
	 * 
	 */
	public Direccion() {
	}

	/**
	 * Constructor con todos los campos obligatorios
	 * 
	 * @param calle
	 * @param municipio
	 * @param provincia
	 */
	public Direccion(String calle, String municipio, String provincia) {
		super();
		this.calle = calle;
		this.municipio = municipio;
		this.provincia = provincia;
	}

	/**
	 * sobreescribimos el toString para mostrar los datos ordenados
	 * 
	 * @return los datos de direccion
	 */
	@Override
	public String toString() {
		return "Calle: " + this.calle + ", municipio: " + this.municipio + " y provincia: " + this.provincia;
	}

}
