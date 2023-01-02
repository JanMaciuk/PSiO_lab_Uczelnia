package Backend.Uczelnia;

import Backend.Komparatory.KomparatorKursy;
import Backend.Komparatory.KomparatorNazwiskoImie;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    protected static ArrayList<PracownikBadawczoDydaktyczny> Naukowcy = new ArrayList<>();
    protected static ArrayList<PracownikAdministracyjny> Administracja = new ArrayList<>();
    protected static ArrayList<Student> Studenci = new ArrayList<>();
    protected static ArrayList<Kurs> Kursy = new ArrayList<>();

    public static void deserializujWszystko() {
        Naukowcy = deserializujNaukowcow("Naukowcy.txt");
        Administracja = deserializujAdministratorow("Administracja.txt");
        Studenci = deserializujStudentow("Studenci.txt");
        Kursy = deserializujKursy("Kursy.txt");
    }

    public static void serializujWszystko() {
        serializujNaukowcow(Naukowcy,"Naukowcy.txt");
        serializujAdministratorow(Administracja,"Administracja.txt");
        serializujStudentow(Studenci,"Studenci.txt");
        serializujKursy(Kursy,"Kursy.txt");
    }

    public static void dodajDomyslne(){
        inicjalizujPracownikow();
        inicjalizujKursy();
        inicjalizujStudentow();
    }


    //Inicjalizacja obiektów:
    public static void inicjalizujPracownikow(){
        //Naukowcy
        Naukowcy.add(new PracownikBadawczoDydaktyczny("Profesor zwyczajny", 10, 75000, "Jan", "Kowalski", "183116788", 50, "M", "Pierogi", 15));
        Naukowcy.add(new PracownikBadawczoDydaktyczny("Adiunkt", 5, 4000, "Janina", "Bąk", "980651121", 40, "K", "Pierogi", 2));
        Naukowcy.add(new PracownikBadawczoDydaktyczny("Wykładowca", 1, 3000, "Karol", "Kowalski", "785556788", 50, "M", "Słodycze", 10));
        Naukowcy.add(new PracownikBadawczoDydaktyczny("Profesor nadzwyczajny", 30, 8500, "Magda", "Mądra", "683416558", 70, "K", "Kurczak", 35));
        // Pracownicy administracji
        Administracja.add(new PracownikAdministracyjny("Specjalista", 20, 10000, "Janusz", "Nosacz", "199556789", 50, "M", "Kurczak", 15));
        Administracja.add(new PracownikAdministracyjny("Referent", 2, 2500, "Kasia", "Dąb", "10265937592", 20, "K", "Pierogi", 1));
        }
    public static void inicjalizujStudentow(){ // Studenci
            ArrayList<Kurs> KursyStudenta1 = new ArrayList<>(Kursy); // ten student jest zapisany na wszystkie kursy, ambitnie.
            Studenci.add(new Student(21242, 1, false, true, true, "Jan", "Maciuk", "183116788", 20, "M", "Pierogi",KursyStudenta1));

            ArrayList<Kurs> KursyStudenta2 = new ArrayList<>();
            KursyStudenta2.add(Kursy.get(0));
            KursyStudenta2.add(Kursy.get(1));
            KursyStudenta2.add(Kursy.get(2));
            Studenci.add(new Student(21255, 2, true, true, false, "Karol", "Jękalski", "993116781", 22, "M", "Pierogi", KursyStudenta2));

            ArrayList<Kurs> KursyStudenta3 = new ArrayList<>();
            KursyStudenta3.add(Kursy.get(0));
            KursyStudenta3.add(Kursy.get(3));
            KursyStudenta3.add(Kursy.get(4));
            KursyStudenta3.add(Kursy.get(5));
            KursyStudenta3.add(Kursy.get(6));
            Studenci.add(new Student(25266, 2, false, false, true, "Kasia", "Kowalska", "383119122", 29, "K", "Pierogi",KursyStudenta3));

            ArrayList<Kurs> KursyStudenta4 = new ArrayList<>(); // ten student nie jest obecnie zapisany na żadne kursy, nie zapisał się w systemie.
            Studenci.add(new Student(31351, 2, false, true, false, "Karol", "Mały", "981116311", 22, "M", "Pierogi",KursyStudenta4 ));

            ArrayList<Kurs> KursyStudenta5 = new ArrayList<>(Kursy); // ten student jest zapisany na wszystkie kursy, ambitnie.
            Studenci.add(new Student(31232, 1, false, true, true, "Jan", "Duda", "222156918", 20, "M", "Pierogi",KursyStudenta5));
        }
    public static void inicjalizujKursy(){
        Kursy.add(new Kurs("Programowanie", Naukowcy.get(0), 4));
        Kursy.add(new Kurs("Matematyka ogólna", Naukowcy.get(1), 8));
        Kursy.add(new Kurs("Fizyka 1", Naukowcy.get(2), 6));
        Kursy.add(new Kurs("Analiza matematyczna", Naukowcy.get(3), 8));
        Kursy.add(new Kurs("Statystyka", Naukowcy.get(3), 6));
        Kursy.add(new Kurs("Teoria prawdopodobieństwa", Naukowcy.get(3), 1));
        Kursy.add(new Kurs("Projektowanie maszyn", Naukowcy.get(2), 4));}

    //Wyszukiwanie:
    public static ArrayList<PracownikBadawczoDydaktyczny> szukajNaukowcow(String fraza, String selektor)  {
        ArrayList<PracownikBadawczoDydaktyczny> wynik = new ArrayList<>();
        switch(selektor) {
            case "imie":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getImie().equals(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "nazwisko":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getNazwisko().equals(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "pesel":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getPesel().equals(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "stanowisko":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getStanowisko().equals(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "staż pracy":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (fraza.equals(Integer.toString(naukowiec.getStazPracy()))) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "pensja":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getPensja() == Integer.parseInt(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "wiek":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getWiek() == Integer.parseInt(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "liczba publikacji":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getLiczbaPublikacji() == Integer.parseInt(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "ulubione jedzenie":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getJedzenie().equals(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            case "płeć":
                for (PracownikBadawczoDydaktyczny naukowiec : Naukowcy) {
                    if (naukowiec.getPlec().equals(fraza)) {
                        wynik.add(naukowiec);
                    }
                }
                break;
            }
        return wynik;
    }

    public static ArrayList<PracownikAdministracyjny> szukajAdministracji(String fraza, String selektor) {
        ArrayList<PracownikAdministracyjny> wynik = new ArrayList<>();
        switch(selektor) {
            case "imie":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getImie().equals(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;
            case "nazwisko":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getNazwisko().equals(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;
            case "pesel":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getPesel().equals(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;
            case "stanowisko":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getStanowisko().equals(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;
            case "staż pracy":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (fraza.equals(Integer.toString(admin.getStazPracy()))) {
                        wynik.add(admin);
                    }
                }
                break;
            case "pensja":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getPensja() == Integer.parseInt(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;
            case "wiek":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getWiek() == Integer.parseInt(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;
            case "ulubione jedzenie":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getJedzenie().equals(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;

            case "płeć":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (admin.getPlec().equals(fraza)) {
                        wynik.add(admin);
                    }
                }
                break;
            case "nadgodziny":
                for (PracownikAdministracyjny admin : Administracja) {
                    if (fraza.equals(Integer.toString(admin.getLiczbaNadgodzin()))) {
                        wynik.add(admin);
                    }
                }
                break;
            }

        return wynik;
    }

    public static ArrayList<Student> szukajStudentow(String fraza, String selektor) {
        ArrayList<Student> wynik = new ArrayList<>();
        switch(selektor) {
            case "imie":
                for (Student student : Studenci) {
                    if (student.getImie().equals(fraza)) {
                        wynik.add(student);
                    }
                }
                break;
            case "nazwisko":
                for (Student student : Studenci) {
                    if (student.getNazwisko().equals(fraza)) {
                        wynik.add(student);
                    }
                }
                break;
            case "pesel":
                for (Student student : Studenci) {
                    if (student.getPesel().equals(fraza)) {
                        wynik.add(student);
                    }
                }
                break;
            case "rok studiów":
                for (Student student : Studenci) {
                    if (fraza.equals(Integer.toString(student.getRokStudiow()))) {
                        wynik.add(student);
                    }
                }
                break;
            case "wiek":
                for (Student student : Studenci) {
                    if (student.getWiek() == Integer.parseInt(fraza)) {
                        wynik.add(student);
                    }
                }
                break;
            case "ulubione jedzenie":
                for (Student student : Studenci) {
                    if (student.getJedzenie().equals(fraza)) {
                        wynik.add(student);
                    }
                }
                break;

            case "płeć":
                for (Student student : Studenci) {
                    if (student.getPlec().equals(fraza)) {
                        wynik.add(student);
                    }
                }
                break;
            case "kurs":
                for (Student student : Studenci) {
                    for (Kurs kurs : student.getListaKursow()) {
                        if (kurs.getNazwaKursu().equals(fraza)) {
                            wynik.add(student);
                        }
                    }
                }
                break;
            }

        return wynik;
    }

    public static ArrayList<Kurs> szukajKursow(String fraza, String selektor) {
        ArrayList<Kurs> wynik = new ArrayList<>();
        switch(selektor) {
            case "nazwa kursu":
                for (Kurs kurs : Kursy) {
                    if (kurs.getNazwaKursu().equals(fraza)) {
                        wynik.add(kurs);
                    }
                }
                break;
            case "ECTS":
                for (Kurs kurs : Kursy) {
                    if (fraza.equals(Integer.toString(kurs.getLiczbaECTS()))) {
                        wynik.add(kurs);
                    }
                }
                break;
            case "prowadzący":
                for (Kurs kurs : Kursy) {
                    if (kurs.getProwadzacy().getImie().equals(fraza) || kurs.getProwadzacy().getNazwisko().equals(fraza)) {
                        wynik.add(kurs);
                    }
                }
                break;

            }
        return wynik;
    }

   // Print:
    public static void printAdministracja(ArrayList<PracownikAdministracyjny> lista) {
        System.out.println("Żądana lista pracowników administracyjnych:");
        for (PracownikAdministracyjny admin : lista) {
            System.out.println(admin.getImie() + " " + admin.getNazwisko() + ", " + admin.getPesel() + ", " + admin.getStanowisko() + ", Staż: " + admin.getStazPracy() + " miesięcy, " + admin.getPensja() + ", " + admin.getWiek() + ", " + admin.getJedzenie() + ", " + admin.getPlec() + ", " + admin.getLiczbaNadgodzin() + " nadgodzin");
        }
        System.out.println();
    }
    public static void printNaukowcy(ArrayList<PracownikBadawczoDydaktyczny> lista) {
        System.out.println("Żądana lista pracowników naukowych:");
        for (PracownikBadawczoDydaktyczny naukowiec : lista) {
            System.out.println(naukowiec.getImie() + " " + naukowiec.getNazwisko() + ", " + naukowiec.getPesel() + ", " + naukowiec.getStanowisko() + ", Staż: " + naukowiec.getStazPracy() + " miesięcy, " + naukowiec.getPensja() + ", " + naukowiec.getWiek() + ", " + naukowiec.getJedzenie() + ", " + naukowiec.getPlec() + ", liczba publikacji: " + naukowiec.getLiczbaPublikacji());
        }
        System.out.println();
    }

    public static void printStudenci(ArrayList<Student> lista) {
        System.out.println("Żądana lista studentów:");
        for (Student student : lista) {

            System.out.println(student.getImie() + " " + student.getNazwisko() + ", " + student.getPesel() + ", " + student.getRokStudiow() + "r. wiek: " + student.getWiek() + ", " + student.getJedzenie() + ", " + student.getPlec()+ ", liczba kursów: " + student.getListaKursow().size());
        }
        System.out.println();
    }

    public static void printKursy(ArrayList<Kurs> lista) {
        System.out.println("Żądana lista kursów:");
        for (Kurs kurs : lista) {
            System.out.println(kurs.getNazwaKursu() + " " + kurs.getLiczbaECTS() + " ECTS, Prowadzący: " + kurs.getProwadzacy().getImie() + " " + kurs.getProwadzacy().getNazwisko());
        }
        System.out.println();
    }

    //Input użytkownika:
    public static void dodajObiektyInput() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int wybor;
        while (run) {
            System.out.println("""
                    0 - wyjdź\s
                    1 - dodaj naukowca\s
                    2 - dodaj administratora\s
                    3 - dodaj studenta\s
                    4 - dodaj kurs\s
                    5 - wyszukiwanie\s
                    6 - usuwanie\s""");
            wybor = scanner.nextInt();
            scanner.nextLine();
            try { switch (wybor) {
                case 0:
                    run = false;
                    break;
                case 1:
                    //("Profesor zwyczajny", 10, 75000, "Jan", "Kowalski", "183116788", 50, "M", "Pierogi", 15));
                    System.out.println("Podaj stanowisko");
                    String stanowiskoN = scanner.nextLine();
                    System.out.println("Podaj imię");
                    String imieN = scanner.nextLine();
                    System.out.println("Podaj nazwisko");
                    String nazwiskoN = scanner.nextLine();
                    System.out.println("Podaj pesel");
                    String peselN = scanner.nextLine();
                    System.out.println("Podaj staż pracy");
                    int stazN = scanner.nextInt();
                    System.out.println("Podaj pensję");
                    int pensjaN = scanner.nextInt();
                    System.out.println("Podaj wiek");
                    int wiekN = scanner.nextInt();
                    System.out.println("Podaj płeć (M/K)");
                    scanner.nextLine();
                    String plecN = scanner.nextLine();
                    System.out.println("Podaj ulubione jedzenie");
                    String jedzenieN = scanner.nextLine();
                    System.out.println("Podaj liczbę publikacji");
                    int publikacjeN = scanner.nextInt();
                    Naukowcy.add(new PracownikBadawczoDydaktyczny(stanowiskoN, stazN, pensjaN, imieN, nazwiskoN, peselN, wiekN, plecN, jedzenieN, publikacjeN));
                    System.out.println("dodano naukowca");
                    break;
                case 2:
                    //("Specjalista", 20, 10000, "Janusz", "Nosacz", "199556789", 50, "M", "Kurczak", 15));
                    System.out.println("Podaj stanowisko");
                    String stanowiskoA = scanner.nextLine();
                    System.out.println("Podaj imię");
                    String imieA = scanner.nextLine();
                    System.out.println("Podaj nazwisko");
                    String nazwiskoA = scanner.nextLine();
                    System.out.println("Podaj pesel");
                    String peselA = scanner.nextLine();
                    System.out.println("Podaj staż pracy");
                    int stazA = scanner.nextInt();
                    System.out.println("Podaj pensję");
                    int pensjaA = scanner.nextInt();
                    System.out.println("Podaj wiek");
                    int wiekA = scanner.nextInt();
                    System.out.println("Podaj płeć (M/K)");
                    scanner.nextLine();
                    String plecA = scanner.nextLine();
                    System.out.println("Podaj ulubione jedzenie");
                    String jedzenieA = scanner.nextLine();
                    System.out.println("Podaj liczbę nadgodzin");
                    int nadgodzinyA = scanner.nextInt();
                    Administracja.add(new PracownikAdministracyjny(stanowiskoA, stazA, pensjaA, imieA, nazwiskoA, peselA, wiekA, plecA, jedzenieA, nadgodzinyA));
                    System.out.print("dodano administratora");
                    break;
                case 3:
                    //Student(31351, 2, false, true, false, "Karol", "Mały", "981116311", 22, "M", "Pierogi",KursyStudenta4 ));
                    System.out.println("Podaj numer indeksu");
                    int indeksS = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj rok studiów");
                    int rokS = Integer.parseInt(scanner.nextLine());
                    System.out.println("erasmus? (true/false)");
                    boolean erasmusS = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("pierwszy stopień studiów? (true/false)");
                    boolean pierwszyS = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("studia stacjonarne? (true/false)");
                    boolean stacjonarneS = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("Podaj imię");
                    String imieS = scanner.nextLine();
                    System.out.println("Podaj nazwisko");
                    String nazwiskoS = scanner.nextLine();
                    System.out.println("Podaj pesel");
                    String peselS = scanner.nextLine();
                    System.out.println("Podaj wiek");
                    int wiekS = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj płeć (M/K)");
                    String plecS = scanner.nextLine();
                    System.out.println("Podaj ulubione jedzenie");
                    String jedzenieS = scanner.nextLine();
                    boolean dodawanieKursow = true;
                    ArrayList<Kurs> KursyS = new ArrayList<>();
                    while (dodawanieKursow) {
                        System.out.println("Wybierz kurs z poniższych (numer od 0)");
                        printKursy(Kursy);
                        int wyborKursu = Integer.parseInt(scanner.nextLine());
                        KursyS.add(Kursy.get(wyborKursu));
                        System.out.println("Aby dodać kolejny kurs wpisz 'dodaj')");
                        if (!scanner.nextLine().equals("dodaj")) {dodawanieKursow = false;}
                    }
                    Studenci.add(new Student(indeksS, rokS, erasmusS, pierwszyS, stacjonarneS, imieS, nazwiskoS, peselS, wiekS, plecS, jedzenieS, KursyS));
                    break;
                case 4:
                    //Kurs("Programowanie", Naukowcy.get(0), 4));
                    System.out.println("Podaj nazwę kursu");
                    String nazwaK = scanner.nextLine();
                    System.out.println("Podaj liczbę ECTS");
                    int ectsK = Integer.parseInt(scanner.nextLine());
                    System.out.println("Wybierz prowadzącego z pośród następujących (numer od 0)");
                    printNaukowcy(Naukowcy);
                    int prowadzacyK = Integer.parseInt(scanner.nextLine());
                    Kursy.add(new Kurs(nazwaK,Naukowcy.get(prowadzacyK),ectsK));
                    break;
                case 5:
                    szukajUser();
                    break;
                case 6:
                    usunUser();
                    break;
            }}
            catch ( java.util.InputMismatchException | NumberFormatException e) {
                System.out.println("Wpisałeś błędny typ danych!");
                scanner.nextLine();
            }



        }
    }
    public static void szukajUser() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int wybor;
        while (run) {
            System.out.println("""
                    0 - wyjdź\s
                    1 - wyszukaj naukowców\s
                    2 - wyszukaj administratorów\s
                    3 - wyszukaj studentów\s
                    4 - wyszukaj kursy\s
                    5 - wyświetl wszystkich""");
            wybor = scanner.nextInt();
            scanner.nextLine();
            String selektor;
            String fraza;
            try { switch (wybor) {
                case 0:
                    run = false;
                    break;
                case 1:
                    System.out.println("Wyszukaj naukowców po:");
                    selektor = scanner.nextLine();
                    System.out.println("Fraza do wyszukania:");
                    fraza = scanner.nextLine();
                    printNaukowcy(szukajNaukowcow(fraza,selektor));
                    break;
                case 2:
                    System.out.println("Wyszukaj administratorów po:");
                    selektor = scanner.nextLine();
                    System.out.println("Fraza do wyszukania:");
                    fraza = scanner.nextLine();
                    printAdministracja(szukajAdministracji(fraza,selektor));
                    break;
                case 3:
                    System.out.println("Wyszukaj studentów po:");
                    selektor = scanner.nextLine();
                    System.out.println("Fraza do wyszukania:");
                    fraza = scanner.nextLine();
                    printStudenci(szukajStudentow(fraza,selektor));
                    break;
                case 4:
                    System.out.println("Wyszukaj kursy po:");
                    selektor = scanner.nextLine();
                    System.out.println("Fraza do wyszukania:");
                    fraza = scanner.nextLine();
                    printKursy(szukajKursow(fraza,selektor));
                    break;
                case 5:
                    System.out.println("========================================");
                    System.out.println("Wszyscy i wszystko:");
                    printNaukowcy(Naukowcy);
                    printAdministracja(Administracja);
                    printStudenci(Studenci);
                    printKursy(Kursy);
                    break;


            }}
            catch ( java.util.InputMismatchException | NumberFormatException e) {
                System.out.println("Wpisałeś błędny typ danych!");
                scanner.nextLine();
            }
        }}
    public static void usunUser() {
            Scanner scanner = new Scanner(System.in);
            boolean run = true;
            int wybor;
            while (run) {
                System.out.println("""
                    0 - wyjdź\s
                    1 - usuń naukowców\s
                    2 - usuń administratorów\s
                    3 - usuń studentów\s
                    4 - usuń kursy""");
                wybor = scanner.nextInt();
                scanner.nextLine();
                String selektor;
                String fraza;
                try { switch (wybor) {
                    case 0:
                        run = false;
                        break;
                    case 1:
                        System.out.println("Wyszukaj naukowców po:");
                        selektor = scanner.nextLine();
                        System.out.println("Fraza do wyszukania:");
                        fraza = scanner.nextLine();
                        Naukowcy.removeAll(szukajNaukowcow(fraza,selektor));
                        System.out.println("Lista po usuwaniu:");
                        printNaukowcy(Naukowcy);
                        break;
                    case 2:
                        System.out.println("Wyszukaj administratorów po:");
                        selektor = scanner.nextLine();
                        System.out.println("Fraza do wyszukania:");
                        fraza = scanner.nextLine();
                        Administracja.removeAll(szukajAdministracji(fraza,selektor));
                        System.out.println("Lista po usuwaniu:");
                        printAdministracja(Administracja);
                        break;
                    case 3:
                        System.out.println("Wyszukaj studentów po:");
                        selektor = scanner.nextLine();
                        System.out.println("Fraza do wyszukania:");
                        fraza = scanner.nextLine();
                        Studenci.removeAll(szukajStudentow(fraza,selektor));
                        System.out.println("Lista po usuwaniu:");
                        printStudenci(Studenci);
                        break;
                    case 4:
                        System.out.println("Wyszukaj kursy po:");
                        selektor = scanner.nextLine();
                        System.out.println("Fraza do wyszukania:");
                        fraza = scanner.nextLine();
                        Kursy.removeAll(szukajKursow(fraza,selektor));
                        System.out.println("Lista po usuwaniu:");
                        printKursy(Kursy);
                        break;

                }}
                catch ( java.util.InputMismatchException | NumberFormatException e) {
                    System.out.println("Wpisałeś błędny typ danych!");
                    scanner.nextLine();
                }
            }
    }


    //Serializacja
    public static void serializujNaukowcow(ArrayList<PracownikBadawczoDydaktyczny> lista, String plik) {
        try {
            FileOutputStream fout = new FileOutputStream(plik);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(lista);
            oout.close();
            fout.close();
        }
        catch (IOException e) {System.out.println("Błąd zapisywania pliku");}
    }
    public static void serializujAdministratorow(ArrayList<PracownikAdministracyjny> lista, String plik) {
        try {
            FileOutputStream fout = new FileOutputStream(plik);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(lista);
            oout.close();
            fout.close();
        }
        catch (IOException e) {System.out.println("Błąd zapisywania pliku");}
    }
    public static void serializujStudentow(ArrayList<Student> lista, String plik) {
        try {
            FileOutputStream fout = new FileOutputStream(plik);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(lista);
            oout.close();
            fout.close();
        }
        catch (IOException e) {System.out.println("Błąd zapisywania pliku");}
    }
    public static void serializujKursy(ArrayList<Kurs> lista, String plik) {
        try {
            FileOutputStream fout = new FileOutputStream(plik);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(lista);
            oout.close();
            fout.close();
        }
        catch (IOException e) {System.out.println("Błąd zapisywania pliku");}
    }

    //Deserliazacja
    public static ArrayList<PracownikBadawczoDydaktyczny> deserializujNaukowcow(String plik) {
        ArrayList<PracownikBadawczoDydaktyczny> lista = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(plik);
            ObjectInputStream oin = new ObjectInputStream(fin);
            lista = (ArrayList<PracownikBadawczoDydaktyczny>) oin.readObject();
            oin.close();
            fin.close();
        }
        catch (IOException | ClassNotFoundException e) {System.out.println("Błąd odczytu pliku");}
        return lista;
    }
    public static ArrayList<PracownikAdministracyjny> deserializujAdministratorow(String plik) {
        ArrayList<PracownikAdministracyjny> lista = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(plik);
            ObjectInputStream oin = new ObjectInputStream(fin);
            lista = (ArrayList<PracownikAdministracyjny>) oin.readObject();
            oin.close();
            fin.close();
        }
        catch (IOException | ClassNotFoundException e) {System.out.println("Błąd odczytu pliku");}
        return lista;
    }
    public static ArrayList<Student> deserializujStudentow(String plik) {
        ArrayList<Student> lista = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(plik);
            ObjectInputStream oin = new ObjectInputStream(fin);
            lista = (ArrayList<Student>) oin.readObject();
            oin.close();
            fin.close();
        }
        catch (IOException | ClassNotFoundException e) {System.out.println("Błąd odczytu pliku");}
        return lista;
    }
    public static ArrayList<Kurs> deserializujKursy(String plik) {
        ArrayList<Kurs> lista = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream(plik);
            ObjectInputStream oin = new ObjectInputStream(fin);
            lista = (ArrayList<Kurs>) oin.readObject();
            oin.close();
            fin.close();
        }
        catch (IOException | ClassNotFoundException e) {System.out.println("Błąd odczytu pliku");}
        return lista;
    }

    public static ArrayList<Student> getStudenci() {
        if (Studenci.size() == 0) {Studenci = deserializujStudentow("Studenci.txt");}
        return Studenci;
    }

    public static void setStudenci(ArrayList<Student> studenci) {
        Studenci = studenci;
        serializujStudentow(Studenci,"Studenci.txt");
    }

    public static ArrayList<PracownikAdministracyjny> getAdministratorzy() {
        if (Administracja.size() == 0) {Administracja = deserializujAdministratorow("Administracja.txt");}
        return Administracja;
    }
    public static void setAdministratorzy(ArrayList<PracownikAdministracyjny> administratorzy) {
        Administracja = administratorzy;
        serializujAdministratorow(Administracja,"Administracja.txt");
    }
    public static ArrayList<PracownikBadawczoDydaktyczny> getNaukowcy() {
        if (Naukowcy.size() == 0) {Naukowcy = deserializujNaukowcow("Naukowcy.txt");}
        return Naukowcy;
    }
    public static void setNaukowcy(ArrayList<PracownikBadawczoDydaktyczny> naukowcy) {
        Naukowcy = naukowcy;
        serializujNaukowcow(Naukowcy,"Naukowcy.txt");
    }
    public static ArrayList<Kurs> getKursy() {
        if (Kursy.size() == 0) {Kursy = deserializujKursy("Kursy.txt");}
        return Kursy;
    }
    public static void setKursy(ArrayList<Kurs> kursy) {
        Kursy = kursy;
        serializujKursy(Kursy,"Kursy.txt");
    }
}
