package com.cursoceat.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Controller {
static Scanner entrada = new Scanner(System.in);
static ArrayList<Aspirante> aspirantes=new ArrayList<Aspirante>(); 
static boolean salir=true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuPrincipal();
	}
	
	public static void menuPrincipal(){
        int opcion;
        System.out.println("MENÚ REGISTRO ASPIRANTES");
        System.out.println("Elige una opción: ");
        System.out.println("1. Registrar aspirante: ");
        System.out.println("2. Eliminar aspirante: ");
        System.out.println("3. Modificar aspirante: ");
        System.out.println("4. Consultar registro: ");
        System.out.println("5. Salir del menú");
        opcion=entrada.nextInt();
        
        switch(opcion) {
        case 1:
        	registrarAspirante();
        	break;
        	
        case 2:
        	eliminarAspirante();
        	break;
        	
        case 3:
            modificarAspirante();
            break;
            
        case 4:
        	consultarRegistro();
        	break;
        	
        case 5:
        	salirMenu();
        	break;
        	
        default:
        	System.err.println("Opción incorrecta");
        	System.err.println("Saliendo al menú...");
            menuPrincipal();
        	break;
        	
        	
        }
        
        }
	
	
	public static void registrarAspirante() {
		System.out.println("Introduce el nombre del aspirante: ");
		String nombreAspirante=entrada.next();
		System.out.println("Introduce la edad del aspirante: ");
		int edadAspirante=entrada.nextInt();
		
		Aspirante miAspirante=new Aspirante();
		miAspirante.setNombre(nombreAspirante);
		miAspirante.setEdad(edadAspirante);
	    aspirantes.add(miAspirante);
	    menuPrincipal();

	}
	
	public static void eliminarAspirante() {
		System.out.println("Introduce el nombre del aspirante: ");
		String nombreAspirante=entrada.next();
		
		Iterator<Aspirante> it=aspirantes.iterator();
		
		while(it.hasNext()) {
			Aspirante miAspirante=it.next();
			if(miAspirante.getNombre().equals(nombreAspirante)) {
				it.remove();
			}
			menuPrincipal();
		}
		

}
	
	public static void modificarAspirante() {
		 System.out.println("Introduce el nombre del aspirante a modificar: ");
		 String nombre=entrada.next();
		  System.out.println("Introduce el nuevo nombre del aspirante: ");
		  String nombre2=entrada.next();
		  System.out.println("Introduce la nueva edad del aspirante: ");
		  int edad2=entrada.nextInt();
		  
		  Iterator<Aspirante> it=aspirantes.iterator();
		  
		  while(it.hasNext()) {
			  Aspirante miAspirante=it.next();
			  if(miAspirante.getNombre().equals(nombre)) {
				  miAspirante.setNombre(nombre2);
				  miAspirante.setEdad(edad2);
				  
			  }
		  }
		  menuPrincipal();
	}
	
	public static void consultarRegistro() {
		for(Aspirante miAspirante: aspirantes) {
			System.out.println("Datos aspirantes: Nombre aspirante: " + miAspirante.getNombre()+" Edad: " + miAspirante.getEdad());
		}
		menuPrincipal();
		
	}
	
	public static void salirMenu() {
		System.out.println("Saliendo al menú principal...");
		salir=false;
		menuPrincipal();
		
	}
}



