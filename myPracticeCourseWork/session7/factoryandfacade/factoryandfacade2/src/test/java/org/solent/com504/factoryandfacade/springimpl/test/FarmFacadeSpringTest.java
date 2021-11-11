package org.solent.com504.factoryandfacade.springimpl.test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.springimpl.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author cgallen
 */
public class FarmFacadeSpringTest {

    @Test
    public void FarmFacadeTest() {

        FarmFacade farmFacade = AnimalObjectFactory.getFarmFacade();
        assertNotNull(farmFacade);
        
        List<Animal> animals = farmFacade.getAllAnimals();
        assertTrue(animals.isEmpty());
        
        // test create cat
        String catName = "fluffy";
        farmFacade.addCat(catName);
        
        animals = farmFacade.getAllAnimals();
        assertEquals(1, animals.size());
        
        assertEquals(catName, animals.get(0).getName());
        
        String duckName = "mallard";
        farmFacade.addDuck(duckName);
        animals = farmFacade.getAllAnimals();
        assertEquals(2, animals.size());
        
        assertEquals(duckName, animals.get(1).getName());
        assertEquals("Quack", animals.get(1).getSound());
        
        // WHAT TESTS WOULD YOU CREATE HERE TO SET UP AND TEST THE FARM FACADE?

    }
}
