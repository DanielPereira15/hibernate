package hibernate.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity(name = "Cliente")
public class Cliente {

	@Getter
	@Setter
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente", nullable = false)
	private Long idCliente;

	@Getter
	@Setter
	@NaturalId
	@Column(name = "dni", nullable = false, unique = true)
	private String dni;

	@Getter
	@Setter
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Getter
	@Setter
	@Column(name = "apellido", length = 100, nullable = true)
	protected String apellido;

	@Embedded
	private Direccion direccion;

	/**
	 * 
	 */
	public Cliente() {
		super();
	}

	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 */
	public Cliente(String dni, String nombre, String apellido, Direccion direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}

	public Cliente(String dni, String nombre, Direccion direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = "";
		this.direccion = direccion;
	}

	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
		pedido.setCliente(this);
	}

	public void removeEmpleado(Pedido pedido) {
		this.pedidos.remove(pedido);
		pedido.setCliente(null);
	}

	/**
	 * Sobreescribimos el metodo toString para mostrar los datos de forma ordenada
	 * 
	 * @return cliente
	 */

	@Override
	public String toString() {
		String cliente = "El dni es: " + this.dni + ", el nombre es: " + this.nombre + " y los apellidos: "
				+ this.apellido + " y direccion: " + this.direccion;
		return cliente;
	}

}
