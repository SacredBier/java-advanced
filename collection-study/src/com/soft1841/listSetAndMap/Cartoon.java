package com.soft1841.listSetAndMap;

public class Cartoon {
    private String name;
    private Double point;
    private Integer volume;

    public Cartoon() {
    }

    public Cartoon(String name, Double point, Integer volume) {
        this.name = name;
        this.point = point;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return name + "\t\t\t" + point + "\t\t\t" + volume;
    }
}
