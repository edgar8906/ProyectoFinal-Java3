package com.edgarmor.proyectofinaljava3;
/**
 *
 * @author edgar
 */
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ControladorAutos {
    
    @RequestMapping (value = "/autos/{auto}/{costo}/{idAgencia}/{idProv}", method = RequestMethod.POST, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String auto, @PathVariable float costo, 
            @PathVariable int idAgencia, @PathVariable int idProv){
        
        try {
            DAOAutosImpl.insertar(new Autos(auto, costo, new Agencia(idAgencia), new Proveedores(idProv)));
            return "El registro se ha insertado correctamente";
        } catch (Exception e) {
            return "no existe";
        }
        
    }
    
    @RequestMapping (value = "/autos/{id}/{auto}/{costo}/{idAgencia}/{idProv}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int id, @PathVariable String auto, @PathVariable float costo, 
            @PathVariable int idAgencia, @PathVariable int idProv){
        
        try {
            DAOAutosImpl.actualizar(new Autos(id, auto, costo, new Agencia(idAgencia), new Proveedores(idProv)));
            return "El registro se ha actualizado correctamente";
        } catch (Exception e) {
            return "Error al actualizar el registro";
        }
    }
    
    @RequestMapping (value = "/autos/{id}/{auto}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id, @PathVariable String auto){
        
        try {
            DAOAutosImpl.borrar(new Autos(id,auto));
            return "El registro se ha eliminado";
        } catch (Exception e) {
            return "Error al borrar el registro";
        }
    }
    
    @RequestMapping (value = "/autos", method = RequestMethod.GET, headers = {"Accept=Application/jason"})
    public @ResponseBody String buscarTodos () throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOAutosImpl.buscarT());
    }
    
    @RequestMapping (value = "/autos/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId (@PathVariable int id){
        
        return DAOAutosImpl.buscarId(id).toString();
    }
    
}