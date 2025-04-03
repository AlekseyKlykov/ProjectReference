package hw09_ProjectReference;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Pets")
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date birthday;
    private String breed;
    private int petsOwnerID;
    private String color;
Pets(){};

    Pets(String name, Date birthday, String breed, int petsOwnerID, String color){
    this.name = name;
    this.birthday=birthday;
    this.breed=breed;
    this.petsOwnerID=petsOwnerID;
    this.color=color;


    }

    public void setPetsOwnerID(int petsOwnerID) {
        this.petsOwnerID = petsOwnerID;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPetsOwnerID() {
        return petsOwnerID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getBreed() {
        return breed;
    }

    public int getId() {
        return id;
    }
}
