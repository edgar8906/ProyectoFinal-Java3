package com.edgarmor.proyectofinaljava3;
/**
 *
 * @author T203
 */
import java.util.ArrayList; 
import org.hibernate.Criteria; 
import org.hibernate.Query; 

public class DAOAgenciaImpl extends DAO {
    
    public static void insertar(Agencia agencia){ 
         begin(); 
         getSession().save(agencia); 
         commit(); 
         close(); 
     } 
      
     public static void actualizar(Agencia agencia){ 
         begin(); 
         getSession().update(agencia); 
         commit(); 
         close(); 
     } 
      
     public static void borrar(Agencia agencia){ 
         begin(); 
         getSession().delete(agencia); 
         commit(); 
         close(); 
     } 
      
     public static ArrayList<Agencia> buscarT(){ 
         begin(); 
         Criteria c = getSession().createCriteria(Agencia.class); 
         ArrayList<Agencia> agen = (ArrayList<Agencia>) c.list(); 
         commit(); 
         close(); 
         return agen; 
     } 
      
     public static Agencia buscarId(int id){ 
         begin(); 
         Query q = getSession().createQuery("FROM Agencia WHERE idAgencia = :id"); 
         q.setInteger("id", id); 
         Agencia agen = (Agencia) q.uniqueResult(); 
         commit(); 
         close(); 
         return agen; 
     } 

    
}
