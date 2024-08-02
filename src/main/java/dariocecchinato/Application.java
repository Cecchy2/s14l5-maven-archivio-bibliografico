package dariocecchinato;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

        //--------------------------------------Creo Lista Libri Randomizzata con Faker---------------------------------
        List<Book> bookList = new ArrayList<>();

        Supplier<Book> randomBookList = () -> {
            Faker bookFaker = new Faker();
            return new Book(bookFaker.number().numberBetween(1000, 2000),
                    bookFaker.book().title(),
                    bookFaker.number().numberBetween(1900, 2024),
                    bookFaker.number().numberBetween(70, 400),
                    bookFaker.book().author(),
                    bookFaker.book().genre());
        };
        for (int i = 0; i < 50; i++) {
            bookList.add(randomBookList.get());
        }
        System.out.println("--------------------------------------LIBRI-----------------------------------------------");
        bookList.forEach(book -> System.out.println("codice ISBN- " +
                book.getIsbn() + ", Titolo- " +
                book.getTitolo() + ", Anno- " +
                book.getAnnoPublicazione() + ", Numero Pagine- " +
                book.getNumeroPagine() + ", Autore- " +
                book.getAuthor() + ", Genere- " +
                book.getGenre()));


        //--------------------------------------Creo Lista Riviste Randomizzata con Faker---------------------------------
        List<Riviste> rivisteList = new ArrayList<>();

        Supplier<Riviste> randomRivisteList = () -> {
            Faker rivisteFaker = new Faker();
            return new Riviste(rivisteFaker.number().numberBetween(1000, 2000),
                    rivisteFaker.book().title(),
                    rivisteFaker.number().numberBetween(2020, 2024),
                    rivisteFaker.number().numberBetween(20, 40),
                    Periodicita.settimanale);
        };
        for (int i = 0; i < 30; i++) {
            rivisteList.add(randomRivisteList.get());
        }
        System.out.println("--------------------------------------RIVISTE-----------------------------------------------");
        rivisteList.forEach(book -> System.out.println("codice ISBN- " +
                book.getIsbn() + ", Titolo- " +
                book.getTitolo() + ", Anno- " +
                book.getAnnoPublicazione() + ", Numero Pagine- " +
                book.getNumeroPagine() + ", Periodicità- " +
                book.getPeriodicita()));

        //--------------------------------------Scanner per i metodi sui libri------------------------------------------

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------SCEGLI COSA FARE-------------------------------------------------");

        while (true) {
            System.out.println("Scegli cosa fare scrivendo il numero");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Aggiungi Rivista");
            System.out.println("3. Rimuovi Libro tramite codice ISBN");
            System.out.println("4. Rimuovi Rivista tramite codice ISBN");
            System.out.println("5. Cerca Libro per ISBN");
            System.out.println("6. Cerca Rivista per ISBN");
            System.out.println("7. Cerca Libro per Anno");
            System.out.println("8. Cerca Rivista per Anno");
            System.out.println("9. Cerca Libro per Autore");
            System.out.println("0. Esci");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    Book.addBook(scanner, bookList);
                    break;
                case "2":
                    Riviste.addRivista(scanner, rivisteList);
                    break;
                case "3":
                    Book.removeByIsbn(scanner, bookList);
                    break;
                case "4":
                    Riviste.removeByIsbn(scanner, rivisteList);
                    break;
                case "5":
                    Book.searchByIsbn(scanner, bookList);
                    break;
                case "6":
                    Riviste.searchByIsbn(scanner, rivisteList);
                    break;
                case "7":
                    Book.searchByYear(scanner, bookList);
                    break;
                case "8":
                    Riviste.searchByYear(scanner, rivisteList);
                    break;
                case "9":
                    Book.ricercaPerAutore(scanner, bookList);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Scelta non valida riprova");
                    break;
            }
        }
    }


}
