package ru.compas.objects;

import java.util.ArrayList;

public class DomikController {
    public static ArrayList<Domik> createDomik() {
        ArrayList<Domik> domiki = new ArrayList<>();
        Domik domiki1 = new Domik(1850, 2000);
        domiki.add(domiki1);

        Domik domiki2 = new Domik(1700, 2000);
        domiki.add(domiki2);

        Domik domiki3 = new Domik(1550, 2000);
        domiki.add(domiki3);

        Domik domiki4 = new Domik(2500, 3000);
        domiki.add(domiki4);

        Domik domiki5 = new Domik(2000, 2000);
        domiki.add(domiki5);

        Domik domiki6 = new Domik(250, 2000);
        domiki.add(domiki6);

        Domik domiki7 = new Domik(10, 10);
        domiki.add(domiki7);

        Domik domiki8 = new Domik(10, 11);
        domiki.add(domiki8);

        Domik domiki9 = new Domik(10, 12);
        domiki.add(domiki9);

        Domik domiki10 = new Domik(10, 13);
        domiki.add(domiki10);

        return domiki;
    }
}
