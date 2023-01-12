package Backend.Komparatory;

import Backend.Uczelnia.Osoba;

import java.util.Comparator;

public class KomparatorNazwiskoWiek implements Comparator<Osoba> {

    public int compare(Osoba o1, Osoba o2) {
        if (o1.getNazwisko().equals(o2.getNazwisko())) {
            return -1*Integer.compare(o1.getWiek(),o2.getWiek());
        } else {
            return o1.getNazwisko().compareTo(o2.getNazwisko());
        }
    }
}

