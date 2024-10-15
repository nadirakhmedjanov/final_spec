package model.builder;

import model.animal.IdGenerator;
import model.animal.pet.cat.Cat;
public class CatBuilder extends AnimalBuilder<CatBuilder> {
    private String color;

    public CatBuilder(IdGenerator idGenerator) {
        super(idGenerator);
    }

    public CatBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    protected CatBuilder self() {
        return this;
    }

    @Override
    public Cat build() {
        return new Cat(idGenerator, name, birthDate, color);
    }
}
