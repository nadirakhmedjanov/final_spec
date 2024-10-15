package model.builder;

import model.animal.Animal;
import model.animal.pack_animal.camel.Camel;
public class CamelBuilder extends AnimalBuilder<CamelBuilder> {
    private int numberOfHumps;

    public CamelBuilder(model.animal.IdGenerator idGenerator) {
        super(idGenerator);
    }

    public CamelBuilder withNumberOfHumps(int numberOfHumps) {
        this.numberOfHumps = numberOfHumps;
        return this;
    }

    @Override
    protected CamelBuilder self() {
        return this;
    }

    @Override
    public Animal build() {
        return new Camel(idGenerator, name, birthDate, numberOfHumps);
    }
}
