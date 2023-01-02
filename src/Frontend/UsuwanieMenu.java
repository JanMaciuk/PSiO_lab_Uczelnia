package Frontend;

import Backend.Uczelnia.PracownikAdministracyjny;
import Backend.Uczelnia.PracownikBadawczoDydaktyczny;
import Backend.Uczelnia.Student;
import Backend.Uczelnia.Kurs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class UsuwanieMenu {
    protected static JFrame mainFrame = new JFrame("Usuwanie");
    public static int width = 300;
    public static int height = 400;
    protected static JTextField fraza = new JTextField("fraza do wyszukania");
    public static void defaultDisplay() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(width, height);
        mainFrame.getContentPane().add(fraza);
        mainFrame.getContentPane().setLayout(new GridLayout(11, 1));
        mainFrame.setVisible(true);
    }
    public static void usunNaukowca() {
        System.out.println("Usuwanie naukowca");
        defaultDisplay();
        ArrayList<PracownikBadawczoDydaktyczny> wynik = new ArrayList<>();
        JButton imie = new JButton("Imie");
        mainFrame.getContentPane().add(imie);
        imie.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getImie().equals(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton nazwisko = new JButton("Nazwisko");
        mainFrame.getContentPane().add(nazwisko);
        nazwisko.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getNazwisko().equals(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton pesel = new JButton("Pesel");
        mainFrame.getContentPane().add(pesel);
        pesel.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getPesel().equals(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton stanowisko = new JButton("Stanowisko");
        mainFrame.getContentPane().add(stanowisko);
        stanowisko.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getStanowisko().equals(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton stazPracy = new JButton("Staż pracy");
        mainFrame.getContentPane().add(stazPracy);
        stazPracy.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getStazPracy() == Integer.parseInt(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton pensja = new JButton("Pensja");
        mainFrame.getContentPane().add(pensja);
        pensja.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getPensja() == Integer.parseInt(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton wiek = new JButton("Wiek");
        mainFrame.getContentPane().add(wiek);
        wiek.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getWiek() == Integer.parseInt(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton plec = new JButton("Płeć");
        mainFrame.getContentPane().add(plec);
        plec.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getPlec().equals(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton jedzenie = new JButton("Jedzenie");
        mainFrame.getContentPane().add(jedzenie);
        jedzenie.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getJedzenie().equals(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });
        JButton liczbaPublikacji = new JButton("Liczba publikacji");
        mainFrame.getContentPane().add(liczbaPublikacji);
        liczbaPublikacji.addActionListener(e -> {
            for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
                if (naukowiec.getLiczbaPublikacji() == Integer.parseInt(fraza.getText())) {
                    wynik.add(naukowiec); }}
            DisplayArray.displayNaukowiec(wynik);
            wynik.clear();
        });



    }
    public static void usunAdministratora() {
        System.out.println("Usuwanie administratora");
        defaultDisplay();
        ArrayList<PracownikAdministracyjny> wynik = new ArrayList<>();
        JButton imie = new JButton("Wyszukaj po imieniu");
        mainFrame.getContentPane().add(imie);
        imie.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getImie().equals(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton nazwisko = new JButton("Wyszukaj po nazwisku");
        mainFrame.getContentPane().add(nazwisko);
        nazwisko.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getNazwisko().equals(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton pesel = new JButton("Wyszukaj po peselu");
        mainFrame.getContentPane().add(pesel);
        pesel.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getPesel().equals(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton stanowisko = new JButton("Wyszukaj po stanowisku");
        mainFrame.getContentPane().add(stanowisko);
        stanowisko.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getStanowisko().equals(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton stazPracy = new JButton("Wyszukaj po stażu pracy");
        mainFrame.getContentPane().add(stazPracy);
        stazPracy.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getStazPracy() == Integer.parseInt(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton pensja = new JButton("Wyszukaj po pensji");
        mainFrame.getContentPane().add(pensja);
        pensja.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getPensja() == Integer.parseInt(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton wiek = new JButton("Wyszukaj po wieku");
        mainFrame.getContentPane().add(wiek);
        wiek.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getWiek() == Integer.parseInt(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton plec = new JButton("Wyszukaj po płci");
        mainFrame.getContentPane().add(plec);
        plec.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getPlec().equals(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton jedzenie = new JButton("Wyszukaj po ulubionym jedzeniu");
        mainFrame.getContentPane().add(jedzenie);
        jedzenie.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getJedzenie().equals(fraza.getText())) {
                    wynik.add(admin); }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

        JButton liczbaNadgodzin = new JButton("Wyszukaj po liczbie nadgodzin");
        mainFrame.getContentPane().add(liczbaNadgodzin);
        liczbaNadgodzin.addActionListener(e -> {
            for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
                if (admin.getLiczbaNadgodzin() == Integer.parseInt(fraza.getText())) {
                    wynik.add(admin);
                }}
            DisplayArray.displayAdministrator(wynik);
            wynik.clear();
        });

    }
    public static void usunStudenta() {
        ArrayList<Student> wynik = new ArrayList<>();
        System.out.println("Usuwanie studenta");
        defaultDisplay();
        JButton imie = new JButton("Wyszukaj po imieniu");
        mainFrame.getContentPane().add(imie);
        imie.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                if (student.getImie().equals(fraza.getText())) {
                    wynik.add(student); }}

            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });

        JButton nazwisko = new JButton("Wyszukaj po nazwisku");
        mainFrame.getContentPane().add(nazwisko);
        nazwisko.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                if (student.getNazwisko().equals(fraza.getText())) {
                    wynik.add(student); }}
            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });

        JButton pesel = new JButton("Wyszukaj po peselu");
        mainFrame.getContentPane().add(pesel);
        pesel.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                if (student.getPesel().equals(fraza.getText())) {
                    wynik.add(student); }}
            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });

        JButton rokStudiow = new JButton("Wyszukaj po roku studiów");
        mainFrame.getContentPane().add(rokStudiow);
        rokStudiow.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                if (student.getRokStudiow() == Integer.parseInt(fraza.getText())) {
                    wynik.add(student); }}
            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });

        JButton wiek = new JButton("Wyszukaj po wieku");
        mainFrame.getContentPane().add(wiek);
        wiek.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                if (student.getWiek() == Integer.parseInt(fraza.getText())) {
                    wynik.add(student); }}
            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });

        JButton plec = new JButton("Wyszukaj po płci");
        mainFrame.getContentPane().add(plec);
        plec.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                if (student.getPlec().equals(fraza.getText())) {
                    wynik.add(student); }}
            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });

        JButton jedzenie = new JButton("Wyszukaj po ulubionym jedzeniu");
        mainFrame.getContentPane().add(jedzenie);
        jedzenie.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                if (student.getJedzenie().equals(fraza.getText())) {
                    wynik.add(student); }}
            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });

        JButton kursB = new JButton("Wyszukaj po nazwie kursu");
        mainFrame.getContentPane().add(kursB);
        kursB.addActionListener(e -> {
            for (Student student : Backend.Uczelnia.Main.getStudenci()) {
                for (Kurs kurs : student.getListaKursow()) {
                    if (kurs.getNazwaKursu().equals(fraza.getText())) {
                        wynik.add(student);
                    }}}
            DisplayArray.displayStudent(wynik);
            wynik.clear();
        });



    }
    public static void usunKurs() {
        System.out.println("Usuwanie kursu");
        defaultDisplay();
        ArrayList<Kurs> wynik = new ArrayList<>();
        JButton nazwaKursu = new JButton("Wyszukaj po nazwie kursu");
        mainFrame.getContentPane().add(nazwaKursu);
        nazwaKursu.addActionListener(e -> {
            for (Kurs kurs : Backend.Uczelnia.Main.getKursy()) {
                if (kurs.getNazwaKursu().equals(fraza.getText())) {
                    wynik.add(kurs); }}
            DisplayArray.displayKurs(wynik);
            wynik.clear();
        });
        JButton ECTS = new JButton("Wyszukaj po liczbie ECTS");
        mainFrame.getContentPane().add(ECTS);
        ECTS.addActionListener(e -> {
            for (Kurs kurs : Backend.Uczelnia.Main.getKursy()) {
                if (kurs.getLiczbaECTS() == Integer.parseInt(fraza.getText())) {
                    wynik.add(kurs); }}
            DisplayArray.displayKurs(wynik);
            wynik.clear();
        });
        JButton prowadzacy = new JButton("Po imieniu/nazwisku prowadzącego");
        mainFrame.getContentPane().add(prowadzacy);
        prowadzacy.addActionListener(e -> {
            for (Kurs kurs : Backend.Uczelnia.Main.getKursy()) {
                if (kurs.getProwadzacy().getImie().equals(fraza.getText()) || kurs.getProwadzacy().getNazwisko().equals(fraza.getText())) {
                    wynik.add(kurs); }}
            DisplayArray.displayKurs(wynik);
            wynik.clear();
        });
    }

}
