/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Alojamiento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jairo F
 */
public class RegistroAlojamientoImplMaps implements ICrudRegistroAlojamiento {
    
    private Map<Integer, Alojamiento> mapsAlojamiento;

    public RegistroAlojamientoImplMaps() {
        this.mapsAlojamiento = new HashMap();
    }
       

    @Override
    public boolean agregarAlojamiento(Alojamiento a) {
        this.mapsAlojamiento.put(a.getCodigo(), a);
        return true;
    }

    @Override
    public Alojamiento buscar(int codigo) {
        return this.mapsAlojamiento.get(codigo);
    }

    @Override
    public boolean eliminar(Alojamiento a) {
         return this.mapsAlojamiento.remove(a.getCodigo(), a);
    }

    @Override
    public ArrayList<Alojamiento> obtenerAlojamientos() {
        return  new ArrayList(this.mapsAlojamiento.values());
        
    }
    
}
