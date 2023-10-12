package org.sdarc.pustaka.controllers;

import org.sdarc.pustaka.models.Anggota;
import org.sdarc.pustaka.repositories.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/anggota")
public class AnggotaController {

    @Autowired
    AnggotaRepository repo;

    @PostMapping(path = "/tambah-anggota")
    public @ResponseBody Anggota tambahAnggota(
            @RequestParam String nama,
            @RequestParam int jk,
            @RequestParam String email,
            @RequestParam String nomorHp
    ){
        Anggota anggota = new Anggota();
        anggota.nama = nama;
        anggota.jk = jk;
        anggota.email = email;
        anggota.nomorHp = nomorHp;

        repo.save(anggota);

        return anggota;
    }

    @GetMapping("/{nomor}")
    public Anggota cariAnggotaById(@PathVariable("nomor")String nomor){
        Anggota anggota = repo.findById(nomor).orElse(null);
        return anggota;
    }

    @PutMapping("/{nomor}")
    public Anggota ubahAnggotaById(
            @PathVariable("nomor")String nomor,
            @RequestParam String nama,
            @RequestParam int jk,
            @RequestParam String email,
            @RequestParam String nomorHp
    ){
        Anggota anggota = repo.findById(nomor).orElse(null);
        anggota.nama = nama;
        anggota.jk = jk;
        anggota.email = email;
        anggota.nomorHp = nomorHp;

        repo.save(anggota);

        return anggota;
    }

    @DeleteMapping("/{nomor}")
    public String hapusAnggotaById(@PathVariable("nomor") String nomor){
        Anggota anggota = repo.findById(nomor).orElse(null);
        repo.delete(anggota);
        return "BERHASIL MENGHAPUS";
    }

}
