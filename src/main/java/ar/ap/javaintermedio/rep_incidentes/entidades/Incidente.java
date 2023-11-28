package ar.ap.javaintermedio.rep_incidentes.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ar.ap.javaintermedio.rep_incidentes.clases.EspecialidadEnum;
import ar.ap.javaintermedio.rep_incidentes.clases.MedioComEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table()
public class Incidente {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	@Column
	@Enumerated(EnumType.STRING)
	private EspecialidadEnum servicio;
	@Column
	private String descripcion;
	
	@ManyToOne
	@JoinColumn
	private Tecnico tecnico;
	
	public Incidente(Cliente cliente, EspecialidadEnum serv,String des) {
		
		this.cliente = cliente;
		this.servicio = serv;
		this.descripcion = des;
	}
	
	public void verTecnicos(List<Tecnico> tec) {
		
		tec.stream()
	        .filter((x)-> x.getEspecialidades().stream().anyMatch((l) -> l.equals(this.servicio)))
	        .forEach((k) -> System.out.println(k.toString()));
				
	}
	
	
    public void enviarNotificacion() {
		
		if (this.tecnico.getMedioCOm().equals(MedioComEnum.WHATSAPP)) {
			System.out.println("WHATSAPP SE INFORMA NUEVO INCIDENTE N: " 
				+ this.getId() + " CLIENTE: " + this.getCliente().getRazonSocial() +  " Descripcion: " + this.getDescripcion());
		}
		else {
			System.out.println("EMAIL SE INFORMA NUEVO INCIDENTE N: " 
					+ this.getId() + " CLIENTE: " + this.getCliente().getRazonSocial() +  " Descripcion: " + this.getDescripcion());
		}
		
				
	}
	
        
	@Override
	public String toString() {
		return "Incidente [id=" + id + ", cliente=" + cliente.getRazonSocial() + ", servicio=" + servicio + ", descripcion="
				+ descripcion + ", tecnico=" + tecnico.getNombre() + "]";
	}

	
	
	
	
	
	
	
}
