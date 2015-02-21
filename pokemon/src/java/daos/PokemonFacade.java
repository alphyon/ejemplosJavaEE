/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Entidades.Pokemon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alphyon
 */
@Stateless
public class PokemonFacade extends AbstractFacade<Pokemon> {
    @PersistenceContext(unitName = "pokemonPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PokemonFacade() {
        super(Pokemon.class);
    }
    
}
