package ar.ap.javaintermedio.rep_incidentes.controler;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ar.ap.javaintermedio.rep_incidentes.entidades.Cliente;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CrudCliente {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("rep_incidentes");
    private EntityManager em = factory.createEntityManager();
    
    
    
    public List<Cliente> listarTodos(){
    	
    	Query nativeQuery = this.em.createNativeQuery("SELECT * FROM clientes", Cliente.class);
    	
    	return nativeQuery.getResultList();
    	
    	
    }
    public Cliente buscaId(int id){
    	
    //	Query nativeQuery = this.em.createNativeQuery("SELECT * FROM tecnicos where id = ? ", Cliente.class);
    //	nativeQuery.setParameter(1, id);
    //	return (Cliente) nativeQuery.getSingleResult();
    	return em.find(Cliente.class, id);
    	
    }
    
    
    public void agregar(Cliente cli) {
    	
    	EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		em.persist(cli);
		tx.commit();
		    	
    } 
    
    
    public void eliminar(int id) {
    	EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		em.remove(em.find(Cliente.class, id));
		tx.commit();
    	
    }
    
    public void actualizar(Cliente cliAct) {
    	EntityTransaction tx = this.em.getTransaction();
    	tx.begin();
    	//Cliente Cli = em.find(Tecnico.class, tecAct.getId());
    	
    	/*
    	tec.setApellido(tecAct.getApellido());
    	tec.setNombre(tecAct.getNombre());
    	tec.setFn(tecAct.getFn());
    	tec.setTelefono(tecAct.getTelefono());
    	tec.setEmail(tecAct.getEmail());
    	tec.setMedioCOm(tecAct.getMedioCOm());
       	tec.setEspecialidades(tecAct.getEspecialidades());
    	*/
    	em.merge(cliAct);
    	    	
    	tx.commit();
    	
    	
    }
    
	
}
