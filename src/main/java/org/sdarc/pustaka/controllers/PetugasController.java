package org.sdarc.pustaka.controllers;

import org.sdarc.pustaka.models.Petugas;
import org.sdarc.pustaka.repositories.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/petugas")
public class PetugasController {

    @Autowired
    PetugasRepository repo;

    @PostMapping(path = "/tambah-petugas")
    public @ResponseBody Petugas tambahPetugas(
            @RequestParam String nama,
            @RequestParam String userName,
            @RequestParam String password
    ){
        Petugas petugas = new Petugas();
        petugas.nama = nama;
        petugas.username = userName;
        petugas.password = password;

        repo.save(petugas);

        return petugas;
    }

    /*
    Sengaja gak bikin pencarian petugas,
    kayak gak masuk akal aja petugas nyari petugas awoakowak
     */

    @PutMapping("/{nomor}")
    public Petugas ubahPetugasById(
            @PathVariable("nomor")String nomor,
            @RequestParam String nama,
            @RequestParam String userName,
            @RequestParam String password
    ){
        Petugas petugas = repo.findById(nomor).orElse(null);
        petugas.nama = nama;
        petugas.username = userName;
        petugas.password = password;

        repo.save(petugas);

        return petugas;
    }

    @DeleteMapping("/{nomor}")
    public String hapusPetugasById(
            @PathVariable("nomor") String nomor
    ){
        Petugas petugas = repo.findById(nomor).orElse(null);
        repo.delete(petugas);

        return "BERHASIL MENGHAPUS";
    }
}


