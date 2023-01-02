package Backend.Komparatory;

import Backend.Uczelnia.Osoba;

import java.util.Comparator;

public class KomparatorNazwiskoImie implements Comparator<Osoba> {

    public int compare(Osoba o1, Osoba o2) {
        if (o1.getNazwisko().equals(o2.getNazwisko())) {
            return o1.getImie().compareTo(o2.getImie());
        } else {
            return o1.getNazwisko().compareTo(o2.getNazwisko());
        }
    }
}

