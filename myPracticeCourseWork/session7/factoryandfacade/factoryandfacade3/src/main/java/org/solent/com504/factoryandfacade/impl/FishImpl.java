package org.solent.com504.factoryandfacade.impl;

import org.solent.com504.factoryandfacade.model.Fish;

public class FishImpl extends AbstractAnimal implements Fish {

    @Override
    public String getSound() {
        return Fish.SOUND;
    }

    @Override
    public String getAnimalType() {
        return Fish.ANIMAL_TYPE;
    }

}
