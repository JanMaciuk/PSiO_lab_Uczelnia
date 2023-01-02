package Backend.Komparatory;

import Backend.Uczelnia.Osoba;

import java.util.Comparator;

public class KomparatorNazwisko implements Comparator<Osoba> {

    public int compare(Osoba o1, Osoba o2) {

            return o1.getNazwisko().compareTo(o2.getNazwisko());

    }
}

