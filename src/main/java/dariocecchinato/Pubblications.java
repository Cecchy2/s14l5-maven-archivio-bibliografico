package dariocecchinato;

public abstract class Pubblications {
    private int isbn;
    private String title;
    private int publicationYear;
    private int pageNumber;

    public Pubblications(int isbn, String title, int publicationYear, int pageNumber) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNumber = pageNumber;
    }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return title;
    }

    public void setTitolo(String title) {
        this.title = title;
    }

    public int getNumeroPagine() {
        return pageNumber;
    }

    public void setNumeroPagine(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getAnnoPublicazione() {
        return publicationYear;
    }

    public void setAnnoPublicazione(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Pubblications{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
