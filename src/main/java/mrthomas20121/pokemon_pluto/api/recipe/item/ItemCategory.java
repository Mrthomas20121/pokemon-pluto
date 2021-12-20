package mrthomas20121.pokemon_pluto.api.recipe.item;

public record ItemCategory(String name) implements IItemCategory {

    @Override
    public String getID() {
        return this.name;
    }
}
