package com.edgarmor.proyectofinaljava3;
/**
 *
 * @author edgar
 */
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

public class DAOProveedoresImpl extends DAO{
    
    public static void insertar(Proveedores p){
        
        begin();
        getSession().save(p);
        commit();
        close();
        
    }
    
    public static void actualizar(Proveedores p){
        
        begin();
        getSession().update(p);
        commit();
        close();
        
    }
    
    public static void borrar(Proveedores p){
        
        begin();
        getSession().delete(p);
        commit();
        close();
        
    }
    
    public static ArrayList<Proveedores> buscarT(){
        
        begin();
        Criteria c = getSession().createCriteria(Proveedores.class);
        ArrayList<Proveedores> p = (ArrayList<Proveedores>) c.list();
        commit();
        close();
        return p;
        
    }
    
    public static Proveedores buscarId(int id){
        
        begin();
        Query q = getSession().createQuery("FROM Proveedores WHERE idProv = :id");
        q.setInteger("id", id);
        Proveedores p = (Proveedores) q.uniqueResult();
        commit();
        close();
        return p;
        
    }
    
}