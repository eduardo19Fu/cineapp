package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeywordBetween {

	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		// Ejemplo de busqueda entre un rango de fechas utilizando between
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Noticia> lista = repo.findByFechaBetween(formato.parse("2017-09-03"),formato.parse("2017-09-06"));
		
		for(Noticia n : lista) {
			System.out.println(n);
		}
		
		
		context.close();

	}

}
