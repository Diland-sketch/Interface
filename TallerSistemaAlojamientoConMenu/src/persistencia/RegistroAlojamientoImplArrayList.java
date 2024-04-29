/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Alojamiento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jairo F
 */
public class RegistroAlojamientoImplArrayList implements ICrudRegistroAlojamiento{
    
    private List<Alojamiento> listAlojamiento;
    //private Map<String, Alojamiento>listAlojamiento = new HashMap();

    public RegistroAlojamientoImplArrayList() {
        this.listAlojamiento = new ArrayList();
    }

    public List<Alojamiento> getListAlojamiento() {
        return listAlojamiento;
    }

    public void setListAlojamiento(ArrayList<Alojamiento> listAlojamiento) {
        this.listAlojamiento = listAlojamiento;
    }
    
    @Override
    public boolean agregarAlojamiento(Alojamiento a){
        return this.listAlojamiento.add(a);
    }
    
    @Override
    public Alojamiento buscar(int codigo){
        for(Alojamiento a: this.listAlojamiento){
            if(a.getCodigo()==codigo){
                return a;
            }
        }
        return null;
        
//        return this.listAlojamiento.stream()
//                .filter((o) -> o.getCodigo()==codigo)
//                .findFirst()
//                .orElse(null);
    }
    
    @Override
    public boolean eliminar(Alojamiento a){
        return this.listAlojamiento.remove(a);
    }
    
    @Override
    public List<Alojamiento> obtenerAlojamientos(){
        return this.listAlojamiento;
    }
    
    
    
}
