package ar.ap.javaintermedio.rep_incidentes.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import ar.ap.javaintermedio.rep_incidentes.clases.EspecialidadEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.AUTO)
	 private int id ;
	@Column
	 private String razonSocial;
	@Column
	 private String cuit;
	//@Column
	//private String email;
	@ElementCollection(targetClass = EspecialidadEnum.class)
	@JoinTable(name = "cli_serv", joinColumns = @JoinColumn(name = "idserv"))
	@Column(name = "cli_serv", nullable = false)
	@Enumerated(EnumType.STRING)
	 private List<EspecialidadEnum> servicios;
	
	 
	 public Cliente( String razonSocial, String cuit,String email) {
		
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	 //   this.email = email;
		this.servicios = new ArrayList<>();
		
	}
    
	public void agregarServ(EspecialidadEnum serv) {
		this.servicios.add(serv);
		
	}
    
	public void verServ() {
		
		System.out.println(this.servicios);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", razonSocial=" + razonSocial + ", cuit=" + cuit + ", servicios=" + servicios
				+ "]";
	}


}
