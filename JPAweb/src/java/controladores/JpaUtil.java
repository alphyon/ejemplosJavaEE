/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alphyon
 */
public class JpaUtil {
   private static final EntityManagerFactory emf;
   static{
       try {
           emf = Persistence.createEntityManagerFactory("JPAwebPU");
       } catch (Throwable ex) {
           throw new ExceptionInInitializerError(ex);
       }
   }
   
   public static EntityManagerFactory entityManagerFactory(){
       return emf;
   }
   
}
