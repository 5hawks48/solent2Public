package org.solent.com504.factoryandfacade.test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.impl.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {
   

    @Test
    public void FarmFacadeTest() {

        FarmFacade farmFacade = AnimalObjectFactory.getFarmFacade();
        assertNotNull(farmFacade);
        
        List<Animal> animals = farmFacade.getAllAnimals();
        assertTrue(animals.isEmpty());
        
        // test create cat
        String catName = "fluffy";
        farmFacade.addCat(catName);
        
        // test create dog
        String dogName = "Bruno";
        farmFacade.addDog(dogName);
        
        // test create cow
        String cowName = "Bessy";
        farmFacade.addCow(cowName);
        
        animals = farmFacade.getAllAnimals();
        
        assertEquals(3, animals.size());        
        assertEquals(catName, animals.get(0).getName());        
        // WHAT OTHER TESTS WOULD YOU CREATE HERE TO SET UP AND TEST THE FARM FACADE?
        assertEquals(dogName, animals.get(1).getName());
        assertEquals(cowName, animals.get(2).getName());

    }
}
