package ar.ap.javaintermedio.rep_incidentes.controler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ar.ap.javaintermedio.rep_incidentes.entidades.Incidente;
import ar.ap.javaintermedio.rep_incidentes.entidades.Tecnico;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CrudIncidente {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("rep_incidentes");
	private EntityManager em = factory.createEntityManager();

	public List<Incidente> listarTodos() {

		Query nativeQuery = this.em.createNativeQuery("SELECT * FROM incidente", Incidente.class);

		return nativeQuery.getResultList();

	}

	public void agregar(Incidente inc) {

		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		em.persist(inc);
		tx.commit();
		inc.enviarNotificacion();

	}

	public void eliminar(int id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		em.remove(em.find(Incidente.class, id));
		tx.commit();

	}
	
	
	public void actualizar(Incidente incAct) {
    	EntityTransaction tx = this.em.getTransaction();
    	
    	tx.begin();
    	
    	em.merge(incAct);
    	    	
    	tx.commit();
    	
    	
    }
	
}
