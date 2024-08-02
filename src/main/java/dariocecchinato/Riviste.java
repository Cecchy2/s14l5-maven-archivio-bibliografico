package dariocecchinato;

import java.util.List;
import java.util.Scanner;

public class Riviste extends Pubblications {
    private Periodicita periodicita = Periodicita.settimanale;

    public Riviste(int isbn, String title, int publicationYear, int pageNumber, Periodicita periodicita) {
        super(isbn, title, publicationYear, pageNumber);
        this.periodicita = periodicita;
    }

    public static void addRivista(Scanner scanner, List<Riviste> rivisteList) {
        while (true) {
            try {
                System.out.println("Inserisci il codice ISBN");
                int codiceIsbn = Integer.parseInt(scanner.nextLine());

                System.out.println("Inserisci il titolo");
                String titolo = scanner.nextLine();

                System.out.println("In che anno è stato pubblicato");
                int annoPublicazione = Integer.parseInt(scanner.nextLine());

                System.out.println("Quante pagine ci sono nella tua rivista?");
                int numeroPagine = Integer.parseInt(scanner.nextLine());

                System.out.println("Che periodicità ha la tua rivista: settimanale/mensile/semestrale");
                Periodicita periodicita = Periodicita.valueOf(scanner.nextLine());

                Riviste newRiviste = new Riviste(codiceIsbn, titolo, annoPublicazione, numeroPagine, periodicita);
                System.out.println("Hai aggiunto la rivista con successo!" + newRiviste);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Errore inserisci un numero");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore della Periodicità, scegli tra : settimanale, mensile o semestrale");
            }
        }
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public int getIsbn() {
        return super.getIsbn();
    }

    @Override
    public void setIsbn(int isbn) {
        super.setIsbn(isbn);
    }

    @Override
    public String getTitolo() {
        return super.getTitolo();
    }

    @Override
    public void setTitolo(String title) {
        super.setTitolo(title);
    }

    @Override
    public int getNumeroPagine() {
        return super.getNumeroPagine();
    }

    @Override
    public void setNumeroPagine(int pageNumber) {
        super.setNumeroPagine(pageNumber);
    }

    @Override
    public int getAnnoPublicazione() {
        return super.getAnnoPublicazione();
    }

    @Override
    public void setAnnoPublicazione(int publicationYear) {
        super.setAnnoPublicazione(publicationYear);
    }

    @Override
    public String toString() {
        return super.toString() + "Riviste{" +
                "periodicita=" + periodicita +
                '}';
    }


}
