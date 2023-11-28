package ar.ap.javaintermedio.rep_incidentes.entidades;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
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
import ar.ap.javaintermedio.rep_incidentes.clases.MedioComEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tecnicos")
public class Tecnico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String fn;
	@Column
	private String telefono;
	@Column
	private String email;
	@Column
	@Enumerated(EnumType.STRING)
	private MedioComEnum medioCOm;
	@ElementCollection(targetClass = EspecialidadEnum.class)
	@JoinTable(name = "especialidades", joinColumns = @JoinColumn(name = "idtec"))
	@Column(name = "especialidad", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<EspecialidadEnum> especialidades;
	
	
	
	// private EstadoTec estado;

	
	
	public Tecnico(int id, String nombre, String apellido, String fn, MedioComEnum medioCOm) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fn = fn;
		this.medioCOm = medioCOm;
		this.especialidades = new ArrayList<>();
		// this.estado = new EstadoTecLibre();
	}
	
	public Tecnico(String nombre, String apellido, String fn, MedioComEnum medioCOm) {

		
		this.nombre = nombre;
		this.apellido = apellido;
		this.fn = fn;
		this.medioCOm = medioCOm;
		this.especialidades = new ArrayList<>();
		// this.estado = new EstadoTecLibre();
	}
	

	public void cargarEsp(EspecialidadEnum esp) {

		this.especialidades.add(esp);

	}

	public void verEsp() {

		System.out.println(this.especialidades);
	}

	/*
	 * @Override public String toString() { return "Tecnico [Especialidades=" +
	 * especialidades + ", medioCOm=" + medioCOm + ", estado=" + estado.verEstado()
	 * + "]"; }
	 * 
	 */
	@Override
	public String toString() {
		return "Tecnico [ Id = " + id + " Apellido y Nombre="+ apellido + " " + nombre +" Especialidades=" + especialidades + ", medioCOm=" + medioCOm + "]";
	}

	

}
