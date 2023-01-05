package Backend.Uczelnia;

import java.util.ArrayList;
import java.util.HashSet;

public class CheckDuplicates {
    public static void removeDuplicatePeople() {
        HashSet<Integer> setNumeryIndeksow = new HashSet<>();
        Main.getStudenci().forEach(n -> {
            if(!setNumeryIndeksow.add(n.getNumerIndeksu())) {
                Main.getStudenci().remove(n);
                System.out.println("Usunięto studenta");
            }});

        HashSet<String> setNumeryPesel = new HashSet<>();
        Main.getNaukowcy().forEach(n -> {
            if(!setNumeryPesel.add(n.getPesel())) {
                Main.getNaukowcy().remove(n);
                System.out.println("Usunięto naukowca");
            }});

        setNumeryPesel.clear();
        Main.getAdministratorzy().forEach(n -> {
            if(!setNumeryPesel.add(n.getPesel())) {
                Main.getAdministratorzy().remove(n);
                System.out.println("Usunięto administratora");
            }});
    }

}
