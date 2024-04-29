/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Alojamiento;
import entidades.Cabaña;
import entidades.Cotizacion;
import entidades.Habitacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import persistencia.ICrudRegistroAlojamiento;
import persistencia.RegistroAlojamientoImplArrayList;

/**
 *
 * @author ESTUDIANTES
 */
public class Logica {
    
    private ICrudRegistroAlojamiento persistencia;
    
    public Logica(){
        this.persistencia = new RegistroAlojamientoImplArrayList();
    }
    
    public Alojamiento crearAlojamiento(int codigo, String dir, String ciudad, String pais, int valor, int tipo){
        
        switch (tipo) {
            case 1:
                return new Habitacion(valor, codigo, dir, ciudad, pais);
            case 2:
                return new Cabaña(valor, codigo, dir, ciudad, pais);
            default:
                return null;
        }
        
    }
    
    public boolean registrarAlojamiento(Alojamiento alojamiento){
        
        return this.persistencia.agregarAlojamiento(alojamiento);
        
    }
    
    public Alojamiento buscarAlojamiento(int codigo){
        
        return this.persistencia.buscar(codigo);
        
    }
    
    public Cotizacion crearCotizacion(LocalDate incion, LocalDate fin, Alojamiento alojamiento){
        
        return new Cotizacion(fin, fin, alojamiento);
        
    }
    
    public boolean eliminarAlojamiento(Alojamiento a){
        
        return this.persistencia.eliminar(a);
        
    }
    
    public List<Alojamiento> getListadoAlojamiento(){
        
        return this.persistencia.obtenerAlojamientos();
        
    }
    
}
