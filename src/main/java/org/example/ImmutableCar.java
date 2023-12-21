package org.example;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ImmutableCar implements Comparable<ImmutableCar> {

    private final UUID id;

    private final String ownerFullName;

    private final LocalDateTime rentDate;

    public ImmutableCar(UUID id, String ownerFullName, LocalDateTime rentDate) {
        this.id = id;
        this.ownerFullName = ownerFullName;
        this.rentDate = rentDate;
    }

    public ImmutableCar(String ownerFullName, LocalDateTime rentDate) {
        this(UUID.randomUUID(), ownerFullName, rentDate);
    }

    public UUID getId() {
        return id;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    @Override
    public int compareTo(ImmutableCar o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableCar that = (ImmutableCar) o;
        return Objects.equals(id, that.id) && Objects.equals(ownerFullName, that.ownerFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerFullName);
    }

    @Override
    public String toString() {
        return "ownerFullName='" + ownerFullName + '\'' + ", rentDate=" + rentDate;
    }
}
