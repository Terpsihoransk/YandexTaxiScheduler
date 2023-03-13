package ru.example.yandextaxischeduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {

    public String longititude;
    public String latitude;

    @Override
    public String toString() {
        return longititude + "," + latitude;
    }
}
