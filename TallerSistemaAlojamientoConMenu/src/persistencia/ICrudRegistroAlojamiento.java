/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Alojamiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public interface ICrudRegistroAlojamiento {
    
     boolean agregarAlojamiento(Alojamiento a);
     Alojamiento buscar(int codigo);
     boolean eliminar(Alojamiento a);
     List<Alojamiento> obtenerAlojamientos();
    
}
