package model.builder;

import java.time.LocalDate;

public abstract class AnimalBuilder<T extends AnimalBuilder<T>> {
    protected model.animal.IdGenerator idGenerator;
    protected String name;
    protected LocalDate birthDate;

    public AnimalBuilder(model.animal.IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public T withName(String name) {
        this.name = name;
        return self();
    }

    public T withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return self();
    }

    protected abstract T self();

    public abstract model.animal.Animal build();
}
