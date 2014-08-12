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
public class ControladorAgencia {
    
    @RequestMapping(value = "/agencia/{agenciaas}", method = RequestMethod.POST  , headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String agenciaas){
        
        DAOAgenciaImpl.insertar(new Agencia(agenciaas));
        return "La nueva agencia se agrego correctamente";
    }
    
    @RequestMapping(value = "/agencia/{id}/{agenciaas}",method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int id, @PathVariable String agenciaas){
        
        DAOAgenciaImpl.actualizar(new Agencia(id, agenciaas));
        return "La agencia se actualizo";
    }
    
    @RequestMapping(value = "/agencia/{id}/{agenciaas}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id, @PathVariable String agenciaas){
        
        try {
            DAOAgenciaImpl.borrar(new Agencia(id, agenciaas));
            return "La agencia se elimino";
        } catch (Exception e) {
            return "Los datos de la agencia no coinciden";
        }
        
    }
    
    @RequestMapping(value = "/agencia", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody String buscarTodos() throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOAgenciaImpl.buscarT());
        
    }
    
    @RequestMapping(value = "/agencia/{id}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId(@PathVariable int id){
                
        return DAOAgenciaImpl.buscarId(id).toString();
    }
    
}
