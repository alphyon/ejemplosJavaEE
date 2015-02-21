/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Personales;

/**
 *
 * @author alphyon
 */
public class Mpersonales {

    public int guardarPersonales(Personales per) {
        int estado = 0;
        EntityManager em = JpaUtil.entityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(per);
            em.getTransaction().commit();
            estado = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            estado = 0;
        } finally {
            em.close();
        }
        return estado;
    }

    public Personales consultaPersonales(int codigo) {
        EntityManager em = JpaUtil.entityManagerFactory().createEntityManager();
        Personales per = null;
        em.getTransaction().begin();
        try {
            em.find(Personales.class, codigo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return per;
    }
    
    public List consultaFullPersonales(){
        List<Personales> listaPer = null;
        EntityManager em = JpaUtil.entityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Query consulta = em.createQuery("SELECT p FROM Personales p");
            em.getTransaction().commit();
            listaPer = consulta.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listaPer;
    }
}
