package Frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DodawanieMenu {
    protected static JFrame mainFrame = new JFrame("Dodawanie");
    public static int width = 300;
    public static int height = 600;
    public static void defaultDisplay() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(width, height);
        mainFrame.getContentPane().setLayout(new GridLayout(11, 1));
        mainFrame.setVisible(true);
    }
    public static void dodajNaukowca() {
        System.out.println("Dodawanie naukowca");
        defaultDisplay();
        JTextField imie = new JTextField("Imie");
        mainFrame.getContentPane().add(imie);
        JTextField nazwisko = new JTextField("Nazwisko");
        mainFrame.getContentPane().add(nazwisko);
        JTextField pesel = new JTextField("Pesel");
        mainFrame.getContentPane().add(pesel);
        JTextField stanowisko = new JTextField("Stanowisko");
        mainFrame.getContentPane().add(stanowisko);
        JTextField staz = new JTextField("Staż pracy");
        mainFrame.getContentPane().add(staz);
        JTextField pensja = new JTextField("Pensja");
        mainFrame.getContentPane().add(pensja);
        JTextField wiek = new JTextField("Wiek");
        mainFrame.getContentPane().add(wiek);
        JTextField plec = new JTextField("Płeć (M/K)");
        mainFrame.getContentPane().add(plec);
        JTextField jedzenie = new JTextField("Ulubione jedzenie");
        mainFrame.getContentPane().add(jedzenie);
        JTextField liczbaPublikacji = new JTextField("Liczba publikacji");
        mainFrame.getContentPane().add(liczbaPublikacji);
        JButton button = new JButton("Dodaj");
        mainFrame.getContentPane().add(button);
        button.addActionListener(e -> Backend.Uczelnia.Main.getNaukowcy().add(new Backend.Uczelnia.PracownikBadawczoDydaktyczny(stanowisko.getText(), Integer.parseInt(staz.getText()), Integer.parseInt(pensja.getText()), imie.getText(), nazwisko.getText(), pesel.getText(), Integer.parseInt(wiek.getText()), plec.getText(), jedzenie.getText(), Integer.parseInt(liczbaPublikacji.getText()))));

    }
    public static void dodajAdministratora() {
        System.out.println("Dodawanie administratora");
        defaultDisplay();
        JTextField imie = new JTextField("Imie");
        mainFrame.getContentPane().add(imie);
        JTextField nazwisko = new JTextField("Nazwisko");
        mainFrame.getContentPane().add(nazwisko);
        JTextField pesel = new JTextField("Pesel");
        mainFrame.getContentPane().add(pesel);
        JTextField stanowisko = new JTextField("Stanowisko");
        mainFrame.getContentPane().add(stanowisko);
        JTextField staz = new JTextField("Staż pracy");
        mainFrame.getContentPane().add(staz);
        JTextField pensja = new JTextField("Pensja");
        mainFrame.getContentPane().add(pensja);
        JTextField wiek = new JTextField("Wiek");
        mainFrame.getContentPane().add(wiek);
        JTextField plec = new JTextField("Płeć (M/K)");
        mainFrame.getContentPane().add(plec);
        JTextField jedzenie = new JTextField("Ulubione jedzenie");
        mainFrame.getContentPane().add(jedzenie);
        JTextField liczbaNadgodzin = new JTextField("Liczba nadgodzin");
        mainFrame.getContentPane().add(liczbaNadgodzin);
        JButton button = new JButton("Dodaj");
        mainFrame.getContentPane().add(button);
        button.addActionListener(e -> Backend.Uczelnia.Main.getAdministratorzy().add(new Backend.Uczelnia.PracownikAdministracyjny(stanowisko.getText(), Integer.parseInt(staz.getText()), Integer.parseInt(pensja.getText()), imie.getText(), nazwisko.getText(), pesel.getText(), Integer.parseInt(wiek.getText()), plec.getText(), jedzenie.getText(),Integer.parseInt(liczbaNadgodzin.getText()))));
    }
    public static void dodajStudenta() {
        System.out.println("Dodawanie studenta");
        defaultDisplay();
        ArrayList<Backend.Uczelnia.Kurs> kursyStudenta = new ArrayList();
        mainFrame.getContentPane().setLayout(new GridLayout(15, 1));
        JTextField imie = new JTextField("Imie");
        mainFrame.getContentPane().add(imie);
        JTextField nazwisko = new JTextField("Nazwisko");
        mainFrame.getContentPane().add(nazwisko);
        JTextField pesel = new JTextField("Pesel");
        mainFrame.getContentPane().add(pesel);
        JTextField numerIndeksu = new JTextField("Numer indeksu");
        mainFrame.getContentPane().add(numerIndeksu);
        JTextField rokStudiow = new JTextField("Rok studiów");
        mainFrame.getContentPane().add(rokStudiow);
        JTextField wiek = new JTextField("Wiek");
        mainFrame.getContentPane().add(wiek);
        JTextField plec = new JTextField("Płeć (M/K)");
        mainFrame.getContentPane().add(plec);
        JTextField jedzenie = new JTextField("Ulubione jedzenie");
        mainFrame.getContentPane().add(jedzenie);
        JCheckBox erasmus = new JCheckBox("Erasmus");
        mainFrame.getContentPane().add(erasmus);
        JCheckBox pierwszyStopien = new JCheckBox("Pierwszy stopień");
        mainFrame.getContentPane().add(pierwszyStopien);
        JCheckBox stacjonarne = new JCheckBox("Studia stacjonarne");
        mainFrame.getContentPane().add(stacjonarne);
        JTextField kursID = new JTextField("numer kursu do dodania");
        mainFrame.getContentPane().add(kursID);
        JButton wyswietlKursy = new JButton("Wyswietl kursy");
        mainFrame.getContentPane().add(wyswietlKursy);
        wyswietlKursy.addActionListener(e -> DisplayArray.displayKurs(Backend.Uczelnia.Main.getKursy()));
        JButton dodajKurs = new JButton("Dodaj kurs");
        mainFrame.getContentPane().add(dodajKurs);
        dodajKurs.addActionListener(e -> kursyStudenta.add(Backend.Uczelnia.Main.getKursy().get(Integer.parseInt(kursID.getText()))));
        JButton dodajStudenta = new JButton("Dodaj studenta");
        mainFrame.getContentPane().add(dodajStudenta);
        dodajStudenta.addActionListener(e -> Backend.Uczelnia.Main.getStudenci().add(new Backend.Uczelnia.Student(Integer.parseInt(numerIndeksu.getText()), Integer.parseInt(rokStudiow.getText()), erasmus.isSelected(), pierwszyStopien.isSelected(), stacjonarne.isSelected(), imie.getText(), nazwisko.getText(), pesel.getText(), Integer.parseInt(wiek.getText()), plec.getText(), jedzenie.getText(), kursyStudenta)));



    }
    public static void dodajKurs() {
        System.out.println("Dodawanie kursu");
        defaultDisplay();
        JTextField nazwa = new JTextField("Nazwa");
        mainFrame.getContentPane().add(nazwa);
        JTextField ECTS = new JTextField("liczba ECTS");
        mainFrame.getContentPane().add(ECTS);
        JTextField idProwadzacego = new JTextField("numer prowadzącego");
        mainFrame.getContentPane().add(idProwadzacego);
        JButton showProwadzacy = new JButton("Pokaż listę prowadzących");
        mainFrame.getContentPane().add(showProwadzacy);
        showProwadzacy.addActionListener(e -> DisplayArray.displayNaukowiec(Backend.Uczelnia.Main.getNaukowcy()));
        JButton button = new JButton("Dodaj");
        mainFrame.getContentPane().add(button);
        button.addActionListener(e -> Backend.Uczelnia.Main.getKursy().add(new Backend.Uczelnia.Kurs(nazwa.getText(),Backend.Uczelnia.Main.getNaukowcy().get(Integer.parseInt(idProwadzacego.getText())),Integer.parseInt(ECTS.getText()))));
    }
}
