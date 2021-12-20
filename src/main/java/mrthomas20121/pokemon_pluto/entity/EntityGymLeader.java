package mrthomas20121.pokemon_pluto.entity;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.world.World;

/**
 * EntityGymLeader.java
 * Gym Leader Entity
 */
public class EntityGymLeader extends EntityTrainer {

    public EntityGymLeader(String entityName) {
        super(entityName);
    }

    public EntityGymLeader(GameLocation registryName) {
        super(registryName);
    }

    @Override
    public void performAction(World world) {

    }

    @Override
    public void onTalk(World world) {
        // todo: send a message based on the location
    }
}
