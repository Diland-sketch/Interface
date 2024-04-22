/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallersistemaalojamiento;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
public class Ppal {

    static Scanner scanner = new Scanner(System.in);
           
    public static void main(String[] args) {
        
        ICrudRegistroAlojamiento registro = new ImpArrayListRegistroAlojamiento();
        
        // TODO code application logic here
//        Alojamiento hab = new Habitacion(2, 0, "Hotel sicarare", "Vpar", "Colombia");
//        Alojamiento cab = new Cabaña(4, 1, "Casa e campo", "Vpar", "Colombia");
//        
//        System.out.println("\nEjemplo de registro de alojamiento");
//        ICrudRegistroAlojamiento registro = new ImpArrayListRegistroAlojamiento();
//        registro.agregarAlojamiento(hab);
//        System.out.println(hab + " registrado");
//        registro.agregarAlojamiento(cab);
//        System.out.println(cab + " registrado");
//
//        System.out.println("\nEjemplo de busqueda y cotizacion de alojamiento");
//          Alojamiento buscado = registro.buscar(0);
//        if (buscado != null) {
//            Cotizacion cothab = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 20), buscado);
//            System.out.println(cothab);
//        } else {
//            System.out.println("El alojamiento no esta registrado");
//        }
//
//        System.out.println("\nEjemplo de eliminacion y cotizacion de alojamiento");
//        Alojamiento eliminar = registro.buscar(1);
//        registro.eliminar(eliminar);
//        buscado = registro.buscar(1);
//        if (buscado != null) {
//            Cotizacion cothab = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 20), buscado);
//            System.out.println(cothab);
//        } else {
//            System.out.println("El alojamiento no esta registrado");
//        }
//
//        System.out.println("\nCotizacion de todos los alojamientos");
//        for (Alojamiento a : registro.obtenerAlojamientos()) {
//            Cotizacion cotizacion = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 22), a);
//            System.out.println(cotizacion);
//        }

           
           
           int opcion = 0;
           
           do{   
                System.out.println("-----BIENVENIDO A SU AGENCIA DE CONFIANZA-----");
                System.out.println("1. AGREGAR HABITACION");
                System.out.println("2. AGREGAR CABAÑA");
                System.out.println("3. BUSCAR Y COTIZAR ALOJAMIENTO");
                System.out.println("4. ELIMINAR ALOJAMIENTO");
                System.out.println("5. LISTAR");
                System.out.println("6. SALIR");
                System.out.println("----------------------------------------------");
                System.out.println("POR FAVOR DIGITE LA OPCION QUE DESEE:");
                System.out.println("----------------------------------------------");
                opcion = scanner.nextInt();
                switch(opcion){
                    case 1: //Alojamiento habitacion = new Habitacion();
                            System.out.println("Ingrese el codigo de la habitacion: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            //habitacion.setCodigo(codigo);
                            System.out.println("Ingrese la direccion de la habitacion: ");
                            String direccion = scanner.nextLine();
                            //habitacion.setDireccion(direccion);
                            System.out.println("Ingrese la ciudad: ");
                            String ciudad = scanner.nextLine();
                            //habitacion.setCiudad(ciudad);
                            System.out.println("Ingrese el pais: ");
                            String pais = scanner.nextLine();
                            //habitacion.setPais(pais);
                            System.out.println("Ingrese la cantidad de personas: ");
                            int numPersonas = scanner.nextInt();
                            //habitacion.(codigo);
                            Alojamiento habitacion = new Habitacion(numPersonas, codigo, direccion, ciudad, pais); 
                            registro.agregarAlojamiento(habitacion);
                            System.out.println(habitacion + " registrado");
                        break;
                    case 2:
                            System.out.println("Ingrese el codigo de la cabaña: ");
                            codigo = scanner.nextInt();
                            scanner.nextLine();
                            //habitacion.setCodigo(codigo);
                            System.out.println("Ingrese la direccion de la cabaña: ");
                            direccion = scanner.nextLine();
                            //habitacion.setDireccion(direccion);
                            System.out.println("Ingrese la ciudad: ");
                            ciudad = scanner.nextLine();
                            //habitacion.setCiudad(ciudad);
                            System.out.println("Ingrese el pais: ");
                            pais = scanner.nextLine();
                            //habitacion.setPais(pais);
                            System.out.println("Ingrese el numero de cuartos de la cabaña: ");
                            int numCuartos = scanner.nextInt();
                            //habitacion.(codigo);
                            Alojamiento cabaña = new Cabaña(numCuartos, codigo, direccion, ciudad, pais);
                            //ICrudRegistroAlojamiento cb = new ImpArrayListRegistroAlojamiento();
                            registro.agregarAlojamiento(cabaña);
                            System.out.println(cabaña + " registrado");
                        break;
                    case 3: 
                            System.out.println("Ingrese el codigo del alojamiento que quiere buscar y cotizar: ");
                            codigo = scanner.nextInt();
                            Alojamiento buscado = registro.buscar(codigo);
                            if (buscado != null) {
                                Cotizacion cot = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 30), buscado);
                                System.out.println(cot);
                            } else {
                                System.out.println("El alojamiento no esta registrado");
                            }
                        break;
                    case 4:
                            System.out.println("Ingrese el codigo de alojamiento que desea eliminar: ");
                            codigo = scanner.nextInt();
                            Alojamiento eliminar = registro.buscar(codigo);                            
                            buscado = registro.buscar(codigo);
                            if (buscado != null) {
                                System.out.println("Alojamiento eliminado: "+ buscado);
                                registro.eliminar(eliminar);
                            } else {
                                System.out.println("El alojamiento no esta registrado");
                            }
                        break;
                    case 5:
                        for (Alojamiento a : registro.obtenerAlojamientos()) {
                            Cotizacion cotizacion = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 22), a);
                            System.out.println(cotizacion);
                        }
                        break;
                    case 6:
                        System.out.println("GRACIAS POR ELEGIR NUESTRA AGENCIA");
                        System.out.println("BY: DILAND LOPEZ, JAIRO SEOANES");
                        break;
                }
           }while(opcion!= 6);
           
    }

}
