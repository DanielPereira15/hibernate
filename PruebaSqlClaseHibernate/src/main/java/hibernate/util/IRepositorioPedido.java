package hibernate.util;

import java.util.Date;
import java.util.List;

public interface IRepositorioPedido  extends IRepositorio<Pedido, Long>{
	List<Pedido> findByFecha(Date fecha);

}
