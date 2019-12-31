package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		/*
		 * M�todo deleteAllInBatch de la interfaz JpaRepository -> (es m�s eficiente)
		 * delete from Noticias
		 
		 */
		
		/*
		 * M�todo deleteAll de la interfaz CrudRepository -> (no es muy eficiente)
		 * delete from Noticias where id = ?
		 * delete from Noticias where id = ?
		 * delete from Noticias where id = ?
		 
		 */
		
		repo.deleteAllInBatch();
		
		context.close();

	}

}
