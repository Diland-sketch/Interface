/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import entidades.Alojamiento;
import entidades.*;
import logica.Logica;
import persistencia.ICrudRegistroAlojamiento;
import persistencia.RegistroAlojamientoImplArrayList;

/**
 *
 * @author Jairo F
 */
public class Menu {

    private int opcionSeleccionada;
    private Scanner lector;
    private Logica logica;

    public Menu() {
        this.lector = new Scanner(System.in);
        this.logica = new Logica();
    }

    public void ejecutarMenu() {

        do {
            System.out.println("         MENU AGENCIA        ");
            System.out.println("-----------------------------");
            System.out.println("1. Registrar alojamiento     ");
            System.out.println("2. Cotizar alojamiento       ");
            System.out.println("3. Eliminar alojamiento      ");
            System.out.println("4. Listado de alojamientos   ");
            System.out.println("5. Finalizar");
//            do {
            System.out.println("-----------------------------");
            System.out.print("Seleccione: ");
            this.opcionSeleccionada = this.lector.nextInt();
//            } while (this.opcionSeleccionada < 1 || this.opcionSeleccionada > 5);

            this.evaluarOpcion();

        } while (this.opcionSeleccionada != 5);

    }

    private void evaluarOpcion() {
        switch (this.opcionSeleccionada) {
            case 1:
                this.ejecutarOpcion1();
                break;
            case 2:
                this.ejecutarOpcion2();
                break;
            case 3:
                this.ejecutarOpcion3();
                break;
            case 4:
                this.ejecutarOpcion4();
                break;
            case 5:
                System.out.println("Ejecucion finalizada...");
                break;
            default:
                System.out.println("[!! La opcion no es valida, intente nuevamente ¡¡]\n");

        }

    }

    private void ejecutarOpcion1() {
        System.out.println("");
        System.out.println("##  1. REGISTRO DE ALOJAMIENTO  ## ");
        System.out.println("-----------------------------------");
        Alojamiento alojamiento = null;
        System.out.printf("%-20s: ", "Codigo");
        int codigo = this.lector.nextInt();
        System.out.printf("%-20s: ", "Direccion");
        String dir = this.lector.next();
        System.out.printf("%-20s: ", "Ciudad");
        String ciudad = this.lector.next();
        System.out.printf("%-20s: ", "Pais");
        String pais = this.lector.next();
        int tipo, valor = 0;
        do {
            System.out.printf("%-30s: ", "Tipo[1-Habitacion][2-Cabaña]");
            tipo = this.lector.nextInt();
        } while (tipo != 1 && tipo != 2);
        switch (tipo) {
            case 1:
                System.out.printf("%-20s: ", "No max persona");
                valor = this.lector.nextInt();
                break;
            case 2:
                System.out.printf("%-20s: ", "No cuartos");
                valor = this.lector.nextInt();
                break;
        }
        
        alojamiento = this.logica.crearAlojamiento(codigo, dir, ciudad, pais, valor, tipo);

        int confirmar;
        do {
            System.out.print("¿ Desea confirmar el registro de alojamiento ? [1-Si][2-No]:");
            confirmar = this.lector.nextInt();

        } while (confirmar != 1 && confirmar != 2);

        if (confirmar == 1) {
            if (this.logica.registrarAlojamiento(alojamiento)) {
                System.out.println("!! Alojamiento registrado con exito ¡¡");
            }
        } else {
            System.out.println(" !! Registro cancelado ¡¡");
        }

        System.out.println("");
    }

    private void ejecutarOpcion2() {
        System.out.println("");
        System.out.println("##  2. COTIZACION DE ALOJAMIENTO  ## ");
        System.out.println("------------------------------------ ");
        System.out.printf("%-20s: ", "Codigo de alojamiento");
        int codigo = this.lector.nextInt();
        Alojamiento alojamiento = this.logica.buscarAlojamiento(codigo);
        if (alojamiento != null) {
            int dia, mes, anio;
            System.out.printf("%-20s: %n", "Fecha inicio");
            System.out.printf("%-10s: ", "dia");
            dia = this.lector.nextInt();
            System.out.printf("%-10s: ", "mes");
            mes = this.lector.nextInt();
            System.out.printf("%-10s: ", "año");
            anio = this.lector.nextInt();
            LocalDate inicio = LocalDate.of(anio, mes, dia);
            System.out.printf("%-20s: %n", "Fecha final");
            System.out.printf("%-10s: ", "dia");
            dia = this.lector.nextInt();
            System.out.printf("%-10s: ", "mes");
            mes = this.lector.nextInt();
            System.out.printf("%-10s: ", "año");
            anio = this.lector.nextInt();
            LocalDate fin = LocalDate.of(anio, mes, dia);
            System.out.println("--------------------------");
            Cotizacion cotizacion = this.logica.crearCotizacion(inicio, fin, alojamiento);
            System.out.println(cotizacion);
            
        } else {
            System.out.println("!! El alojamiento no se encuentra disponible ¡¡");
        }

    }

    private void ejecutarOpcion3() {
        System.out.println("");
        System.out.println("##  3. ELIMINAR ALOJAMIENTO  ## ");
        System.out.println("-----------------------------------");
        System.out.printf("%-20s: ", "Codigo de alojamiento");
        int codigo = this.lector.nextInt();
        Alojamiento alojamiento = this.logica.buscarAlojamiento(codigo);
        if(alojamiento != null){
            int confirmar;
            do {
                System.out.print("¿ Desea eliminar este alojamiento ? [1-Si][2-No]:");
                confirmar = this.lector.nextInt();
            } while (confirmar != 1 && confirmar != 2);
            if (confirmar == 1) {
                this.logica.eliminarAlojamiento(alojamiento);
                System.out.println("El alojamiento ha sido eliminado");
            }else{
            System.out.println("!!Operacion de eliminacion cancelada¡¡");
            }
        }else{
            System.out.println("El alojamiento no ha sido encontrado");
        }
    }

    private void ejecutarOpcion4() {
        System.out.println("");
        System.out.println("##  4. LISTADO DE ALOJAMIENTOS  ## ");
        System.out.println("-----------------------------------");
        for(Alojamiento a: this.logica.getListadoAlojamiento()){
            System.out.println(a);
        }
        System.out.println("-----------------------------------");
        System.out.println("La cantidad de alojamientos disponibles: " + this.logica.getListadoAlojamiento().size()) ;
    }

}
