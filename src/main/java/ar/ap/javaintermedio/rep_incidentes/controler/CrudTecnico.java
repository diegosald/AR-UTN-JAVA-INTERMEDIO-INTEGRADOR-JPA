package ar.ap.javaintermedio.rep_incidentes.controler;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ar.ap.javaintermedio.rep_incidentes.entidades.Cliente;
import ar.ap.javaintermedio.rep_incidentes.entidades.Tecnico;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CrudTecnico {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("rep_incidentes");
    private EntityManager em = factory.createEntityManager();
    
    
    
    public List<Tecnico> listarTodos(){
    	
    	Query nativeQuery = this.em.createNativeQuery("SELECT * FROM tecnicos", Tecnico.class);
    	
    	return nativeQuery.getResultList();
    	
    	
    }
    public Tecnico buscaId(int id){
    	
    //	Query nativeQuery = this.em.createNativeQuery("SELECT * FROM tecnicos where id = ? ", Tecnico.class);
    //	nativeQuery.setParameter(1, id);
    //	return (Tecnico) nativeQuery.getSingleResult();
    	return em.find(Tecnico.class, id);
    	
    	
    }
    
    
    public void agregar(Tecnico tec) {
    	
    	EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		em.persist(tec);
		tx.commit();
		    	
    } 
    
    
    public void eliminar(int id) {
    	EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		em.remove(em.find(Tecnico.class, id));
		tx.commit();
    	
    }
    
    public void actualizar(Tecnico tecAct) {
    	EntityTransaction tx = this.em.getTransaction();
    	tx.begin();
    	//Tecnico tec = em.find(Tecnico.class, tecAct.getId());
    	
    	/*
    	tec.setApellido(tecAct.getApellido());
    	tec.setNombre(tecAct.getNombre());
    	tec.setFn(tecAct.getFn());
    	tec.setTelefono(tecAct.getTelefono());
    	tec.setEmail(tecAct.getEmail());
    	tec.setMedioCOm(tecAct.getMedioCOm());
       	tec.setEspecialidades(tecAct.getEspecialidades());
    	*/
    	em.merge(tecAct);
    	    	
    	tx.commit();
    	
    	
    }
    
	
}
