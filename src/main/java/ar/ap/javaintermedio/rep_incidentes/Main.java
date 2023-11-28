package ar.ap.javaintermedio.rep_incidentes;

import java.io.IOException;
import java.util.Scanner;

import ar.ap.javaintermedio.rep_incidentes.clases.EspecialidadEnum;
import ar.ap.javaintermedio.rep_incidentes.clases.MedioComEnum;
import ar.ap.javaintermedio.rep_incidentes.controler.CrudCliente;
import ar.ap.javaintermedio.rep_incidentes.controler.CrudIncidente;
import ar.ap.javaintermedio.rep_incidentes.controler.CrudTecnico;
import ar.ap.javaintermedio.rep_incidentes.entidades.Cliente;
import ar.ap.javaintermedio.rep_incidentes.entidades.Incidente;
import ar.ap.javaintermedio.rep_incidentes.entidades.Tecnico;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// INSTANCIA DE LOS CONTROLADORES DE LAS ENTIDADES
		CrudCliente crudcli = new CrudCliente();
		CrudIncidente crudinc = new CrudIncidente();
		CrudTecnico crudtec = new CrudTecnico();

		// crudinc.listarTodos().stream().forEach((x)-> System.out.println(x.toString())
		// );
		// crudinc.listarTodos().stream().forEach((x)->
		// x.verTecnicos(crudtec.listarTodos()) );

		// 1- CREAR TECNICO

		// Tecnico nuevoTec = new
		// Tecnico("Gerardo","Ramirez","10/10/86",MedioComEnum.EMAIL);

		// 1-1 - LE AGREGO LAS ESP

		// nuevoTec.cargarEsp(EspecialidadEnum.SAP);
		// nuevoTec.cargarEsp(EspecialidadEnum.WINDOWS);

		// 1-2- LO PERSISTO

		// crudtec.agregarTecnico(nuevoTec);

		// 1-3- ELIMINAR - con el id

		// crudtec.eliminarTecnico(0);

		// 1-4- PARA ACTUALIZAR - APLICA PARA CADA UNA DE LOS CRUD DE LAS ENTIDADES

		// 1-4-1 LO BUSCO Y LO ASIGNO A UNA VARIABLE

		// Tecnico tecAct = crudtec.buscaId(1);

		// 1-4-2 LO EDITO CON LOS SETTERS

		// tecAct.setApellido("Mendoza");

		// 1-4-3 LO ACTUALIZO

		// crudtec.actualizar(tecAct);

		
		
		// 2- CREAR CLIENTE

		// Cliente nuevoCli = new Cliente("PEREX COMP","2222222","lalala@lalal.com");

		// 2-1- LE AGREGO LOS SERVICIOS

		// nuevoCli.agregarServ(EspecialidadEnum.WINDOWS);
		// nuevoCli.agregarServ(EspecialidadEnum.TANGO);

		// 2-2- LO PERSISTO

		// crudcli.agregar(nuevoCli);

		// 2-3- ELIMINAR - con el id

		// crudcli.eliminar(0);

		
		
		// 3- ----- CREO INCIDENTE CON CLIENTE Y TECNICOS DE EN LA DB

		// Incidente inc = new
		// Incidente(crudcli.buscaId(2),EspecialidadEnum.MACOS,"FALLA CON LA
		// IMPRESORA");

		// 3-1 LISTO LOS TECNICOS QUE PUEDE CUMPLIR CON ESE SERVICIO

		// inc.verTecnicos(crudtec.listarTodos());

		// 3-2- RECUPERO EL TECNICO SEGUN SU id y lo ASIGNO A LA INCIDENCIA

		// inc.setTecnico(crudtec.buscaId(7));

		// 3-3- LO PERSISTO

		// crudinc.agregarIncidente(inc);

		// 3-4- ELIMINAR - con el id

		// crudinc.eliminarIncidente(10);

		
		
		
		// MENU PARA LISTAR
		Scanner entrada = new Scanner(System.in);
		String opcion = "";
		while (!opcion.equals("x")) {

			System.out.println("\n********* OPCIONES *********");
			System.out.println("\nPARA LISTAR LOS SERVICIOS PRESIONE 1 ");
			System.out.println("\nPARA LISTAR LOS TECNICOS PRESIONE 2 ");
			System.out.println("\nPARA LISTAR LOS CLIENTES PRESIONE 3 ");
			System.out.println("\nPARA SALIR PRESIONE x");

			opcion = entrada.next();

			if (opcion.equals("1")) {

				crudinc.listarTodos().stream().forEach((x) -> System.out.println(x.toString()));
				System.out.println("\nPRESION s PARA CONTINUAR");
				opcion = entrada.next();
			}

			else if (opcion.equals("2")) {

				crudtec.listarTodos().stream().forEach((x) -> System.out.println(x.toString()));
				System.out.println("\nPRESION s PARA CONTINUAR");
				opcion = entrada.next();
			}

			else if (opcion.equals("3")) {

				crudcli.listarTodos().stream().forEach((x) -> System.out.println(x.toString()));
				System.out.println("\nPRESION s PARA CONTINUAR");
				opcion = entrada.next();
			}

			else
				System.out.println("HASTA LA PROXIMA");

		}

	}

}
