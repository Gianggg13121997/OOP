package model;

public class student {
    private int id;
    private String name;
    private int score;
    private String gender;
    private String conduct;
    private int idClazz;

    public student(int id, String name, int score, String gender, String conduct, int idClazz) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.conduct = conduct;
        this.idClazz = idClazz;
    }

    public int getIdClazz() {
        return idClazz;
    }

    public void setIdClazz(int idClazz) {
        this.idClazz = idClazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", gender='" + gender + '\'' +
                ", conduct='" + conduct + '\''+", id class = "
                +idClazz + '}';
    }
}
