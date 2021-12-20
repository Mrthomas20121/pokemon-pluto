package mrthomas20121.pokemon_pluto.entity;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;

public class EntityPlayer extends Entity {

    public EntityPlayer(String entityName) {
        super(entityName);
    }

    public EntityPlayer(GameLocation registryName) {
        super(registryName);
    }
}
