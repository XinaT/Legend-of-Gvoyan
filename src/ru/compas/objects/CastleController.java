package ru.compas.objects;

import ru.compas.MapLocation;

public class CastleController {
    public CastleController(MapLocation map) {
    }

    public static void createCastle(MapLocation map) {
        Castle castle = new Castle(1952,1500);
        map.add(castle);
    }

}
