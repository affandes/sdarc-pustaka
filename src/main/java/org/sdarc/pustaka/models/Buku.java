package org.sdarc.pustaka.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Buku {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Integer id;

        public String judul;

        public String penulis;

        public String penerbit;

        public int tahunTerbit;

        public String isbn;

        public int stok;

        public String posisi;
}
