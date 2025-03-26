package com.genius.Entities.Identity;
import com.genius.Entities.BaseEntity;
import java.util.List;

public class Artist extends Account {
    public Artist(String name, int age, String email, String username, String password) {
        super(name, age, email, username, password);
    }
}