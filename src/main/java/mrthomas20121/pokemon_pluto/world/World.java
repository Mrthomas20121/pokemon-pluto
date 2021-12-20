package mrthomas20121.pokemon_pluto.world;

import mrthomas20121.pokemon_pluto.entity.EntityPlayer;

public class World {

    // there can only be 1 player unless a co-op mod is on
    private final EntityPlayer player = new EntityPlayer("player");

    public EntityPlayer getPlayer() {
        return player;
    }
}
