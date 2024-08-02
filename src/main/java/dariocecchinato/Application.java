package dariocecchinato;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        File file = new File("src/saved_project.txt");
        File riviste = new File("src/riviste_project.txt");


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
        bookList.forEach(System.out::println);


        //---------------------------------------Salvo la lista dei libri in un File.text--------------------------------

        /*Book.salvaFile(bookList,file);*/
        /* try {
            String bookListStringed = bookList.stream()
                    .map(Book::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            FileUtils.writeStringToFile(file, bookListStringed, StandardCharsets.UTF_8);

            //----------------------------------------Leggo il File Contenente la lista di Libri----------------------------

            String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            String[] contentAsArray = content.split(System.lineSeparator());
            System.out.println("--------------------------------Lettura File--------------------------------------------");
            System.out.println(Arrays.toString(contentAsArray));
        } catch (IOException e) {
            throw new RuntimeException();
        }*/


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
        rivisteList.forEach(System.out::println);

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
            System.out.println("10. Salva la lista dei LIBRI in un File");
            System.out.println("11. Leggi la lista dei LIBRI");
            System.out.println("12. Salva la lista delle RIVISTE in un file");
            System.out.println("13. Leggi la lista delle RIVISTE");

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
                    Book.ricercaLibroPerAutore(scanner, bookList);
                    break;
                case "10":
                    Book.salvaFile(file, bookList);
                    break;
                case "11":
                    Book.leggiFile(file, bookList);
                    break;
                case "12":
                    Riviste.salvaFile(riviste, rivisteList);
                    break;
                case "13":
                    Riviste.leggiFile(riviste, rivisteList);
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
