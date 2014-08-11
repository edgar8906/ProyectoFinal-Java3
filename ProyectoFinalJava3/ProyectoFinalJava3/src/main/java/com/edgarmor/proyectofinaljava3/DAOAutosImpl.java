package com.edgarmor.proyectofinaljava3;
/**
 *
 * @author edgar
 */
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOAutosImpl extends DAO{
    
    public static void insertar(Autos p){ 
          
         begin(); 
         getSession().save(p); 
         commit(); 
         close(); 
          
     } 
      
     public static void actualizar(Autos p){ 
          
        begin(); 
         getSession().update(p); 
         commit(); 
         close(); 
          
     } 
      
     public static void borrar(Autos p){ 
          
         begin(); 
         getSession().delete(p); 
         commit(); 
         close(); 
          
     } 
      
     public static ArrayList<Autos> buscarT(){ 
          
         begin(); 
         Criteria c = getSession().createCriteria(Autos.class); 
         ArrayList<Autos> p = (ArrayList<Autos>) c.list(); 
         commit(); 
         close(); 
         return p; 
          
     } 
      
     public static Autos buscarId(int id){ 
          
         begin(); 
         Query q = getSession().createQuery("FROM Autos WHERE idAuto = :id"); 
         q.setInteger("id", id); 
         Autos p = (Autos) q.uniqueResult(); 
         commit(); 
         close(); 
         return p; 
          
     } 

    
}
