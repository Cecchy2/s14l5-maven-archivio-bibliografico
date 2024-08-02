package dariocecchinato;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

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

    public static void removeByIsbn(Scanner scanner2, List<Riviste> rivisteList) {
        System.out.println("Inserisci il codice ISBN per rimuovere il libro");
        while (true) {
            try {
                int codiceIsbn = Integer.parseInt(scanner2.nextLine());

                Predicate<Riviste> rivistePredicate = rivista -> rivista.getIsbn() == codiceIsbn;

                if (rivisteList.stream().anyMatch(rivistePredicate)) {
                    rivisteList.remove(rivistePredicate);
                } else {
                    System.out.println("Il codice che hai inserito non esiste");
                }
            } catch (Exception e) {
                System.out.println("devi inserire un numero valido" + e.getMessage());
            }
        }
    }

    public static void searchByIsbn(Scanner scanner, List<Riviste> rivisteList) {
        System.out.println("Inserisci il codice ISBN da ricercare");

        while (true) {
            try {
                int codiceIsbn = Integer.parseInt(scanner.nextLine());
                Predicate<Riviste> rivistaPredicate = rivista -> rivista.getIsbn() == codiceIsbn;

                Riviste rivistaTrovata = rivisteList.stream()
                        .filter(rivistaPredicate)
                        .findFirst()
                        .orElse(null);

                if (rivistaTrovata != null) {
                    System.out.println("La rivista che hai cercato è " + rivistaTrovata.getTitolo() +
                            ", è un  " + rivistaTrovata.periodicita +
                            " di " + rivistaTrovata.getNumeroPagine() +
                            " pagine");

                } else {
                    System.out.println("Non esiste nessuna rivista con questo codice");
                }

            } catch (Exception e) {
                System.out.println("Inserisci un numero valido");
            }
        }
    }

    public static void searchByYear(Scanner scanner, List<Riviste> rivisteList) {
        System.out.println("Inserisci l' anno da ricercare");

        while (true) {
            try {
                int anno = Integer.parseInt(scanner.nextLine());
                Predicate<Riviste> rivistePredicate = book -> book.getAnnoPublicazione() == anno;

                List<Riviste> rivisteTrovate = rivisteList.stream()
                        .filter(rivistePredicate)
                        .toList();

                if (rivisteTrovate != null) {
                    rivisteTrovate.forEach(riviste -> System.out.println("Le riviste di quellánno sono  " + riviste.getTitolo() + " ed è un  " + riviste.periodicita));

                } else {
                    System.out.println("Non ho trovato riviste di quell' anno");
                }

            } catch (Exception e) {
                System.out.println("Inserisci un anno valido");
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
