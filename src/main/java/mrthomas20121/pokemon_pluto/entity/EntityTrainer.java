package mrthomas20121.pokemon_pluto.entity;

import mrthomas20121.pokemon_pluto.api.helper.GameLocation;
import mrthomas20121.pokemon_pluto.world.World;

public class EntityTrainer extends Entity {

    public EntityTrainer(String entityName) {
        super(entityName);
    }

    public EntityTrainer(GameLocation registryName) {
        super(registryName);
    }

    public void performAction(World world) {

    }

    public boolean isFacingPlayer(World world) {
        Pos.Facing facing = this.pos.getFace();
        return world.getPlayer().pos.equalsOR(this.pos);
    }

    public void onTalk(World world) {
        performAction(world);
    }

    /**
     * default view sight for a trainer is 5 tile.
     * @return the number of tile the entity can see
     */
    public int getViewSight() {
        return 5;
    }

}
