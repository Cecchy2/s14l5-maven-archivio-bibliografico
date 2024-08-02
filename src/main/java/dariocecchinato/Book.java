package dariocecchinato;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Book extends Pubblications {
    private String Author;
    private String Genre;

    public Book(int isbn, String title, int publicationYear, int pageNumber, String author, String genre) {
        super(isbn, title, publicationYear, pageNumber);
        Author = author;
        Genre = genre;
    }

    public static void addBook(Scanner scanner, List<Book> bookList) {
        while (true) {
            try {
                System.out.println("Inserisci il codice ISBN");
                int codiceIsbn = Integer.parseInt(scanner.nextLine());

                System.out.println("Inserisci il titolo");
                String titolo = scanner.nextLine();

                System.out.println("In che anno è stato pubblicato");
                int annoPublicazione = Integer.parseInt(scanner.nextLine());

                System.out.println("Quante pagine ci sono nel tuo libro?");
                int numeroPagine = Integer.parseInt(scanner.nextLine());

                System.out.println("Chi è l' autore?");
                String autore = scanner.nextLine();

                System.out.println("A quale genere appartiene?");
                String genere = scanner.nextLine();

                Book newBook = new Book(codiceIsbn, titolo, annoPublicazione, numeroPagine, autore, genere);
                System.out.println("Hai aggiunto il libro con successo!" + newBook);
                break;


            } catch (NumberFormatException e) {
                System.out.println("Errore inserisci un numero");
            }
        }
    }

    public static void removeByIsbn(Scanner scanner2, List<Book> bookList) {
        System.out.println("Inserisci il codice ISBN per rimuovere il libro");
        while (true) {
            try {
                int codiceIsbn = Integer.parseInt(scanner2.nextLine());

                Predicate<Book> bookPredicate = book -> book.getIsbn() == codiceIsbn;

                if (bookList.stream().anyMatch(bookPredicate)) {
                    bookList.remove(bookPredicate);
                    System.out.println("Hai rimosso il libro daalla lista");
                } else {
                    System.out.println("Il codice che hai inserito non esiste");
                }
            } catch (Exception e) {
                System.out.println("devi inserire un numero valido" + e.getMessage());
            }
        }
    }

    public static void searchByIsbn(Scanner scanner, List<Book> bookList) {
        System.out.println("Inserisci il codice ISBN da ricercare");

        while (true) {
            try {
                int codiceIsbn = Integer.parseInt(scanner.nextLine());
                Predicate<Book> bookPredicate = book -> book.getIsbn() == codiceIsbn;

                Book libroTrovato = bookList.stream()
                        .filter(bookPredicate)
                        .findFirst()
                        .orElse(null);

                if (libroTrovato != null) {
                    System.out.println("Il libro che hai cercato è: " + libroTrovato.getTitolo() + " di " + libroTrovato.Author + " del " + libroTrovato.getGenre());
                } else {
                    System.out.println("Non ho trovato libri con questo codice");
                }

            } catch (Exception e) {
                System.out.println("Inserisci un numero valido");
            }
        }
    }

    public static void searchByYear(Scanner scanner, List<Book> bookList) {
        System.out.println("Inserisci l' anno da ricercare");

        while (true) {
            try {
                int anno = Integer.parseInt(scanner.nextLine());
                Predicate<Book> bookPredicate = book -> book.getAnnoPublicazione() == anno;

                List<Book> libriTrovati = bookList.stream()
                        .filter(bookPredicate)
                        .toList();

                if (libriTrovati != null) {
                    libriTrovati.forEach(
                            book -> System.out.println(
                                    book.getTitolo() + "- di :" +
                                            book.Author + "- genere: " +
                                            book.getGenre()));
                    break;

                } else {
                    System.out.println("Non ho trovato libri di quell' anno");
                }

            } catch (Exception e) {
                System.out.println("Inserisci un anno valido");
            }
        }
    }

    public static void ricercaLibroPerAutore(Scanner scanner, List<Book> bookList) {
        System.out.println("Inserisci l' autore che vuoi ricercare");
        String author = scanner.nextLine();
        Predicate<Book> bookPredicate = book -> book.getAuthor().equals(author);
        List<Book> libriPerAutore = bookList.stream()
                .filter(bookPredicate)
                .toList();

        libriPerAutore
                .forEach(libro -> System.out.println(libro
                        .getTitolo() + " genere " + libro
                        .getGenre()));

    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public String toString() {
        return "codice ISBN- " + getIsbn() +
                ", Titolo- " + getTitolo() +
                ", Anno- " + getAnnoPublicazione() +
                ", Numero Pagine- " + getNumeroPagine() +
                ", Autore- " + Author +
                ", Genere- " + Genre;
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
    public int getNumeroPagine() {
        return super.getNumeroPagine();
    }

    @Override
    public void setNumeroPagine(int pageNumber) {
        super.setNumeroPagine(pageNumber);
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
    public int getIsbn() {
        return super.getIsbn();
    }

    @Override
    public void setIsbn(int isbn) {
        super.setIsbn(isbn);
    }

}
