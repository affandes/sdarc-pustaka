package org.sdarc.pustaka.models;

import java.util.Date;

public record Peminjaman(
        Date tanggalPinjam,
        Date tanggalKembali,
        Anggota anggota,
        Buku[] bukubuku
) {
}
