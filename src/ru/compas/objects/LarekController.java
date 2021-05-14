package ru.compas.objects;

import ru.compas.MapLocation;

public class LarekController {
    public LarekController(MapLocation map) {
    }

    public static void createLarek(MapLocation map) {
        Larek larek = new Larek(1066,1847);
        map.add(larek);
    }

}
