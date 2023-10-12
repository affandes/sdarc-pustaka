package org.sdarc.pustaka.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Random;

@Entity
public class Petugas{

    @Id
    public String nomor;
    public String nama;
    public String username;
    public String password;

    public Petugas(){
        this.nomor = generateUniqueID();
    }

    private String generateUniqueID() {
        Random random = new Random();
        StringBuilder idBuilder = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            idBuilder.append(random.nextInt(10)); // Generates a random digit (0-9)
        }

        return idBuilder.toString();
    }

}
