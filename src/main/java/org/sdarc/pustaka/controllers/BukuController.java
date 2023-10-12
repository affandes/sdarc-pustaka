package org.sdarc.pustaka.controllers;

import org.sdarc.pustaka.models.Buku;
import org.sdarc.pustaka.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
