package Frontend;

import java.util.ArrayList;
import Backend.Uczelnia.*;
import javax.swing.*;

public class DisplayArray {
    public static int width = 650;
    public static int height = 600;
    protected static JTextArea textArea = new JTextArea();
    protected static JFrame mainFrame = new JFrame("Wyniki wyszukiwania");

    public static void defaultDisplay() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textArea.setEditable(false);
        mainFrame.add(textArea);
        mainFrame.setSize(width, height);
        mainFrame.getContentPane().setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        mainFrame.setVisible(true);
    }

    public static void displayAdministrator(ArrayList<PracownikAdministracyjny> lista) {
        ArrayList<PracownikAdministracyjny> wyniki = new ArrayList<>(lista);
        textArea.setText("");
        defaultDisplay();

        textArea.setRows(lista.size()*2+1);
        textArea.append("Żądana lista pracowników administracyjnych:\n");
        for (PracownikAdministracyjny admin : lista) {
            textArea.append(admin.getImie() + " " + admin.getNazwisko() + ", " + admin.getPesel() + ", " + admin.getStanowisko() + ", Staż: " + admin.getStazPracy() + " miesięcy, " + admin.getPensja() + ", " + admin.getWiek() + ", " + admin.getJedzenie() + ", " + admin.getPlec() + ", " + admin.getLiczbaNadgodzin() + " nadgodzin \n");
        }
        JButton deleteButton = new JButton("Usuń wyszukanych administratorów");
        mainFrame.getContentPane().add(deleteButton);
        deleteButton.addActionListener(e -> Backend.Uczelnia.Main.getAdministratorzy().removeAll(wyniki));


    }
    public static void displayNaukowiec(ArrayList<PracownikBadawczoDydaktyczny> lista) {
        ArrayList<PracownikBadawczoDydaktyczny> wyniki = new ArrayList<>(lista);
        textArea.setText("");
        defaultDisplay();
        textArea.setRows(lista.size()*2+1);
        textArea.append("Żądana lista pracowników naukowych:\n");
        for (PracownikBadawczoDydaktyczny naukowiec : lista) {
            textArea.append(naukowiec.getImie() + " " + naukowiec.getNazwisko() + ", " + naukowiec.getPesel() + ", " + naukowiec.getStanowisko() + ", Staż: " + naukowiec.getStazPracy() + " miesięcy, " + naukowiec.getPensja() + ", " + naukowiec.getWiek() + ", " + naukowiec.getJedzenie() + ", " + naukowiec.getPlec() + ", liczba publikacji: " + naukowiec.getLiczbaPublikacji() + "\n");
        }
        JButton deleteButton = new JButton("Usuń wyszukanych naukowców");
        mainFrame.getContentPane().add(deleteButton);
        deleteButton.addActionListener(e -> Backend.Uczelnia.Main.getNaukowcy().removeAll(wyniki));
    }
    public static void displayStudent(ArrayList<Student> lista) {
        ArrayList<Student> wyniki = new ArrayList(lista);
        textArea.setText("");
        defaultDisplay();
        textArea.setRows(lista.size()*2+1);
        textArea.append("Żądana lista studentów:\n");
        for (Student student : lista) {
            textArea.append(student.getNumerIndeksu()+ " " + student.getImie() + " " + student.getNazwisko() + ", " + student.getPesel() + ", " + student.getRokStudiow() + "r. wiek: " + student.getWiek() + ", " + student.getJedzenie() + ", " + student.getPlec()+ ", liczba kursów: " + student.getListaKursow().size() + "\n");
        }
        JButton deleteButton = new JButton("Usuń wyszukanych studentów");
        mainFrame.getContentPane().add(deleteButton);
        deleteButton.addActionListener(e -> Backend.Uczelnia.Main.getStudenci().removeAll(wyniki));
    }
    public static void displayKurs(ArrayList<Kurs> lista) {
        ArrayList<Kurs> wyniki = new ArrayList(lista);
        textArea.setText("");
        defaultDisplay();
        textArea.setRows(lista.size()*2+1);
        textArea.append("Żądana lista kursów:\n");
        for (Kurs kurs : lista) {
            textArea.append(kurs.getNazwaKursu() + " " + kurs.getLiczbaECTS() + " ECTS, Prowadzący: " + kurs.getProwadzacy().getImie() + " " + kurs.getProwadzacy().getNazwisko() + "\n");
        }
        JButton deleteButton = new JButton("Usuń wyszukane kursy");
        mainFrame.getContentPane().add(deleteButton);
        deleteButton.addActionListener(e -> Backend.Uczelnia.Main.getKursy().removeAll(wyniki));
    }
    public static void displayAll() {
        textArea.setText("");
        defaultDisplay();
        textArea.setRows(30);
        textArea.append("Wszyscy i wszystko:\n");
        textArea.append("\nŻądana lista pracowników administracyjnych:\n");
        for (PracownikAdministracyjny admin : Backend.Uczelnia.Main.getAdministratorzy()) {
            textArea.append(admin.getImie() + " " + admin.getNazwisko() + ", " + admin.getPesel() + ", " + admin.getStanowisko() + ", Staż: " + admin.getStazPracy() + " miesięcy, " + admin.getPensja() + ", " + admin.getWiek() + ", " + admin.getJedzenie() + ", " + admin.getPlec() + ", " + admin.getLiczbaNadgodzin() + " nadgodzin \n");
        }
        textArea.append("\nŻądana lista pracowników naukowych:\n");
        for (PracownikBadawczoDydaktyczny naukowiec : Backend.Uczelnia.Main.getNaukowcy()) {
            textArea.append(naukowiec.getImie() + " " + naukowiec.getNazwisko() + ", " + naukowiec.getPesel() + ", " + naukowiec.getStanowisko() + ", Staż: " + naukowiec.getStazPracy() + " miesięcy, " + naukowiec.getPensja() + ", " + naukowiec.getWiek() + ", " + naukowiec.getJedzenie() + ", " + naukowiec.getPlec() + ", liczba publikacji: " + naukowiec.getLiczbaPublikacji() + "\n");
        }
        textArea.append("\nŻądana lista studentów:\n");
        for (Student student : Backend.Uczelnia.Main.getStudenci()) {
            textArea.append(student.getNumerIndeksu() + " " + student.getImie() + " " + student.getNazwisko() + ", " + student.getPesel() + ", " + student.getRokStudiow() + "r. wiek: " + student.getWiek() + ", " + student.getJedzenie() + ", " + student.getPlec()+ ", liczba kursów: " + student.getListaKursow().size() + "\n");
        }
        textArea.append("\nŻądana lista kursów:\n");
        for (Kurs kurs : Backend.Uczelnia.Main.getKursy()) {
            textArea.append(kurs.getNazwaKursu() + " " + kurs.getLiczbaECTS() + " ECTS, Prowadzący: " + kurs.getProwadzacy().getImie() + " " + kurs.getProwadzacy().getNazwisko() + "\n");
        }

    }
}
