package com.botscrew.models.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @author Den Boyko
 * @version 1.0
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userId")
    private Long id;

    private String firstName;

    private String lastName;

    private String profilePic;

    private String locale;

    private Integer timezone;

    private String gender;

    @Lob
    private String contexts;

    @OneToMany(mappedBy = "owner")
    private List<Room> rooms;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String profilePic, String locale, Integer timezone, String gender, String contexts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.locale = locale;
        this.timezone = timezone;
        this.gender = gender;
        this.contexts = contexts;
    }

    public User(Long id, String firstName, String lastName, String profilePic, String locale, Integer timezone, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.locale = locale;
        this.timezone = timezone;
        this.gender = gender;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

}
