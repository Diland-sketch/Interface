/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallersistemaalojamiento;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Jairo F
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Alojamiento hab = new Habitacion(2, 0, "Hotel sicarare", "Vpar", "Colombia");
        Alojamiento cab = new Cabaña(4, 1, "Casa e campo", "Vpar", "Colombia");
        
        System.out.println("\nEjemplo de registro de alojamiento");
        ICrudRegistroAlojamiento registro = new ImpArrayListRegistroAlojamiento();
        registro.agregarAlojamiento(hab);
        System.out.println(hab + " registrado");
        registro.agregarAlojamiento(cab);
        System.out.println(cab + " registrado");

        System.out.println("\nEjemplo de busqueda y cotizacion de alojamiento");
        Alojamiento buscado = registro.buscar(0);
        if (buscado != null) {
            Cotizacion cothab = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 20), buscado);
            System.out.println(cothab);
        } else {
            System.out.println("El alojamiento no esta registrado");
        }

        System.out.println("\nEjemplo de eliminacion y cotizacion de alojamiento");
        Alojamiento eliminar = registro.buscar(1);
        registro.eliminar(eliminar);
        buscado = registro.buscar(1);
        if (buscado != null) {
            Cotizacion cothab = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 20), buscado);
            System.out.println(cothab);
        } else {
            System.out.println("El alojamiento no esta registrado");
        }

        System.out.println("\nCotizacion de todos los alojamientos");
        for (Alojamiento a : registro.obtenerAlojamientos()) {
            Cotizacion cotizacion = new Cotizacion(LocalDate.now(), LocalDate.of(2024, Month.APRIL, 22), a);
            System.out.println(cotizacion);
        }
    }

}
