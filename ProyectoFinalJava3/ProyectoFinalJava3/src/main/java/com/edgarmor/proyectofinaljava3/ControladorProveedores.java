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
public class ControladorProveedores {
    
    @RequestMapping (value = "/proveedores/{proveedor}", method = RequestMethod.POST, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String proveedor){
        
        DAOProveedoresImpl.insertar(new Proveedores(proveedor));
        return "El nuevo proveedor se ha registrado correctamente";
    }
    
    @RequestMapping (value = "/proveedores/{id}/{proveedor}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar (@PathVariable int id, @PathVariable String proveedor){
        
        try {
            DAOProveedoresImpl.actualizar(new Proveedores(id, proveedor));
            return "El registro se ha modificado correctamente";    
        } catch (Exception e) {
            return "El registro solicitado no existe";
        }
        
    }
    
    @RequestMapping (value = "/proveedores/{id}/{proveedor}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar (@PathVariable int id, @PathVariable String proveedor){
        
        try {
            DAOProveedoresImpl.borrar(new Proveedores(id, proveedor));
            return "El registro se ha eliminado correctamente";    
        } catch (Exception e) {
            return "El registro solicitado no existe";
        }
        
    }
    
    @RequestMapping (value = "/proveedores", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody String buscarTodos() throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOProveedoresImpl.buscarT());
    }
    
    @RequestMapping (value = "/proveedores/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId(@PathVariable int id){
        
        return DAOProveedoresImpl.buscarId(id).toString();
    }
    
}