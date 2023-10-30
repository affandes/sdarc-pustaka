package org.sdarc.pustaka.controllers;

import org.sdarc.pustaka.models.Buku;
import org.sdarc.pustaka.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping(path = "/api/buku")
public class BukuController {

    @Autowired
    BukuRepository repo;

    @PostMapping(path = "/buat-baru")
    public @ResponseBody Buku buatSatuBuku(
            @RequestParam String judul,
            @RequestParam String penulis,
            @RequestParam String penerbit,
            @RequestParam int tahunTerbit,
            @RequestParam String isbn,
            @RequestParam int stok,
            @RequestParam String posisi
    ) {

        Buku buku = new Buku();
        buku.judul = judul;
        buku.penulis = penulis;
        buku.penerbit = penerbit;
        buku.tahunTerbit = tahunTerbit;
        buku.isbn = isbn;
        buku.stok = stok;
        buku.posisi = posisi;

        repo.save(buku);

        return buku;

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Buku cariSatuBukuById(@PathVariable("id") Integer id) {
        Buku buku = repo.findById(id).orElse(null);
        return buku;
    }

    @PutMapping("/{id}")
    public Buku ubahSatuBukuById(
            @PathVariable("id") Integer id,
            @RequestParam String judul,
            @RequestParam String penulis,
            @RequestParam String penerbit,
            @RequestParam int tahunTerbit,
            @RequestParam String isbn,
            @RequestParam int stok,
            @RequestParam String posisi
    ) {
        Buku buku = repo.findById(id).orElse(null);

        buku.judul = judul;
        buku.penulis = penulis;
        buku.penerbit = penerbit;
        buku.tahunTerbit = tahunTerbit;
        buku.isbn = isbn;
        buku.stok = stok;
        buku.posisi = posisi;

        repo.save(buku);

        return buku;
    }

    @DeleteMapping("/{id}")
    public Buku hapusSatuBukuById(@PathVariable("id") Integer id) {
        Buku buku = repo.findById(id).orElse(null);
        repo.delete(buku);
        return buku;
    }

    @PostMapping("/upload")
    public String uploadGambar(@RequestParam("file") MultipartFile file) {

        Path path = Paths.get("./output.jpg");

        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return "Gagal";
        }

        return "Berhasil";
    }

}
