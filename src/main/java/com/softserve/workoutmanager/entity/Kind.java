package com.softserve.workoutmanager.entity;

import java.util.Objects;

public class Kind {
    private long id;
    private String name;
    private long categoryId;

    public Kind() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kind kind = (Kind) o;
        return id == kind.id &&
                categoryId == kind.categoryId &&
                Objects.equals(name, kind.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, categoryId);
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
