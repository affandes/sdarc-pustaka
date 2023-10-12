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
            @RequestParam String penerbit
    ) {

        Buku buku = new Buku();
        buku.judul = judul;
        buku.penulis = penulis;
        buku.penerbit = penerbit;

        repo.save(buku);

        return buku;

    }

    @GetMapping("/{id}")
    public Buku cariSatuBukuById(@PathVariable("id") Integer id) {
        Buku buku = repo.findById(id).orElse(null);
        return buku;
    }
}
