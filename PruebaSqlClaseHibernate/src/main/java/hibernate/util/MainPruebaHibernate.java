package hibernate.util;

import java.util.Date;

public class MainPruebaHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositorioHibernatePedido repo = new RepositorioHibernatePedido();
		RepositorioHibernateCliente repoCl = new RepositorioHibernateCliente();

		Cliente c1 = new Cliente("12345678K", "Paco", new Direccion("hola que dise", "Carabanchel", "España"));

		Pedido p1 = new Pedido(1, new Date("15/12/2021"), c1);

		System.out.println("Borrando todos los clientes de la base de datos");
		repoCl.deleteAll();
		
		System.out.println("Haciendo count antes de guardar");
		System.out.println(repoCl.count());

		System.out.println("Guardando cliente");
		repoCl.save(c1);
		
		System.out.println("Haciendo count despues de guardar");
		System.out.println(repoCl.count());
		
		System.out.println("Comprobando si existe Cliente " + repoCl.existsById((long)16));
		
		System.out.println("Cogiendo Cliente por id: " + repoCl.getById((long)20));
		
		System.out.println("Cogiendo Clientes en un List");
		System.out.println(repoCl.findAll());
		
		System.out.println("Cogiendo Clientes en un Mapa");
		System.out.println(repoCl.getMapAll());
		
		
		System.out.println("Cogiendo Clientes por provincia en un List");
		System.out.println(repoCl.findByProvincia("España"));


	}

}
