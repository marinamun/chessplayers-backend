package models;

public class ChessPlayer{
    private int id;
    private String name;
    private String nationality;
    private int blitzRating;
    private int rapidRating;
    private int classicalRating;
    private int age;
    private String favoriteOpening;
    private int worldRanking;
    private String title;
    private String photo;


public ChessPlayer(int id,String name,String nationality,int blitzRating,int rapidRating,int classicalRating,int age, String favoriteOpening,int worldRanking,String title,String photo){
    this.id = id;
    this.name = name;
    this.nationality = nationality;
    this.blitzRating = blitzRating;
    this.rapidRating = rapidRating;
    this.classicalRating = classicalRating; 
    this.age = age;
    this.favoriteOpening = favoriteOpening;
    this.worldRanking = worldRanking;
    this.title = title;
    this.photo = photo;

    }
    public int id(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNationality() {
            return nationality;
        }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getBlitzRating() {
        return blitzRating;
    }

    public void setBlitzRating(int blitzRating) {
        this.blitzRating = blitzRating;
    }

    public int getRapidRating() {
        return rapidRating;
    }

    public void setRapidRating(int rapidRating) {
        this.rapidRating = rapidRating;
    }

    public int getClassicalRating() {
        return classicalRating;
    }

    public void setClassicalRating(int classicalRating) {
        this.classicalRating = classicalRating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteOpening() {
        return favoriteOpening;
    }

    public void setFavoriteOpening(String favoriteOpening) {
        this.favoriteOpening = favoriteOpening;
    }

    public int getWorldRanking() {
        return worldRanking;
    }

    public void setWorldRanking(int worldRanking) {
        this.worldRanking = worldRanking;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}