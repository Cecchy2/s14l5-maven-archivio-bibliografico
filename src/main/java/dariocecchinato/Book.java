package dariocecchinato;

import java.util.List;
import java.util.Scanner;

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
                Book bookToRemove= bookList.stream()
                        .filter(book -> book.getIsbn() == codiceIsbn).anyMatch()
            }catch (Exception e){
                System.out.println("devi inserire il codice esatto" + e.getMessage());
            }
        }

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
        return super.toString() + " Book{" +
                "author='" + Author + '\'' +
                ", genre='" + Genre + '\'' +
                '}';
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
