package dz_2;

public class Song{

    private String author;
    private String name;

    /**
     * Constructor
     * @param author - author's name
     * @param name - song's name
     */
    public Song(String author, String name) {
        this.author = author;
        this.name = name;
    }

    /**
     * @return song's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return author's name
     */
    public String getAuthor() {
        return author;
    }

}
