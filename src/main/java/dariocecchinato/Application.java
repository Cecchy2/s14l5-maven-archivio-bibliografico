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
        //bookList.forEach(System.out::println);


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
        //rivisteList.forEach(System.out::println);

        //--------------------------------------Scanner per i metodi sui libri------------------------------------------

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------Aggiungi un Libro----------------------------------------------");

        while (true) {
            System.out.println("Vuoi inserire un Libro o una Rivista?");
            System.out.println("1. Libro");
            System.out.println("2. Rivista");
            System.out.println("3. Esci");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    Book.addBook(scanner, bookList);
                    break;
                case "2":
                    Riviste.addRivista(scanner, rivisteList);
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
