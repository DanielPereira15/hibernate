package hibernate.util;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Pedido")
public class Pedido {

	@Getter
	@Setter
	@Id
	@NaturalId
	private int idPedido;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPedido;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "idCliente", foreignKey = @ForeignKey(name = "FK_idCliente_Pedido"))
	private Cliente cliente;

	/**
	 * @param idPedido
	 * @param fechaPedido
	 * @param cliente
	 */
	public Pedido(int idPedido, Date fechaPedido, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.cliente = cliente;
	}

}
//departamento=Cliente