package Frontend;

import javax.swing.*;
import java.awt.*;
import Backend.Uczelnia.*;

public class MainWindow  {
    public static int width = 300;
    public static int height = 200;

    public static void main(String[] args) { //TODO: sortowanie
        Backend.Uczelnia.Main.deserializujWszystko();
        Thread onShutdown = new Thread(Main::serializujWszystko);
        Runtime.getRuntime().addShutdownHook(onShutdown);

        JFrame mainFrame = new JFrame("Menu główne");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button1 = new JButton("Dodawanie");
        JButton button2 = new JButton("Wyszukiwanie");
        JButton button4 = new JButton("Wyjdź");

        mainFrame.getContentPane().setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().add(button1);
        mainFrame.getContentPane().add(button2);
        mainFrame.getContentPane().add(button4);

        button1.addActionListener(e -> DodawanieWindow());
        button2.addActionListener(e -> WyszukiwanieWindow());
        button4.addActionListener(e -> System.exit(1));

        mainFrame.setSize(width, height);
        mainFrame.setVisible(true);


    }
    public static void DodawanieWindow() {
        JFrame mainFrame = new JFrame("Dodawanie");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton button1 = new JButton("    Dodaj Naukowca    ");
        JButton button2 = new JButton("Dodaj Administratora");
        JButton button3 = new JButton("     Dodaj Studenta     ");
        JButton button4 = new JButton("         Dodaj Kurs         ");

        mainFrame.getContentPane().setLayout(new GridLayout(4, 1));
        mainFrame.getContentPane().add(button1);
        mainFrame.getContentPane().add(button2);
        mainFrame.getContentPane().add(button3);
        mainFrame.getContentPane().add(button4);

        button1.addActionListener(e -> DodawanieMenu.dodajNaukowca());
        button2.addActionListener(e -> DodawanieMenu.dodajAdministratora());
        button3.addActionListener(e -> DodawanieMenu.dodajStudenta());
        button4.addActionListener(e -> DodawanieMenu.dodajKurs());

        mainFrame.setSize(width, height);
        mainFrame.setVisible(true);
    }

    public static void WyszukiwanieWindow() {
        JFrame mainFrame = new JFrame("Wyszukiwanie");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton button1 = new JButton("    Wyszukaj Naukowca    ");
        JButton button2 = new JButton("Wyszukaj Administratora");
        JButton button3 = new JButton("     Wyszukaj Studenta     ");
        JButton button4 = new JButton("         Wyszukaj Kurs         ");
        JButton button5 = new JButton("     Wyświetl wszystko     ");

        mainFrame.getContentPane().setLayout(new GridLayout(5, 1));
        mainFrame.getContentPane().add(button1);
        mainFrame.getContentPane().add(button2);
        mainFrame.getContentPane().add(button3);
        mainFrame.getContentPane().add(button4);
        mainFrame.getContentPane().add(button5);


        button1.addActionListener(e -> WyszukiwanieMenu.wyszukajNaukowca());
        button2.addActionListener(e -> WyszukiwanieMenu.wyszukajAdministratora());
        button3.addActionListener(e -> WyszukiwanieMenu.wyszukajStudenta());
        button4.addActionListener(e -> WyszukiwanieMenu.wyszukajKurs());
        button5.addActionListener(e -> WyszukiwanieMenu.wyswietlWszystko());

        mainFrame.setSize(width, height);
        mainFrame.setVisible(true);
    }


}

