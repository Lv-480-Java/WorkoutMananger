package com.softserve.workoutmanager.entity;

import java.util.Objects;

public class Kind {
    private long id;
    private String name;
    private long scheduleId;

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

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kind kind = (Kind) o;
        return id == kind.id &&
                scheduleId == kind.scheduleId &&
                Objects.equals(name, kind.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, scheduleId);
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scheduleId=" + scheduleId +
                '}';
    }
}
