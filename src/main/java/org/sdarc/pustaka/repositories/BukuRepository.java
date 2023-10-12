package org.sdarc.pustaka.repositories;

import org.sdarc.pustaka.models.Buku;
import org.springframework.data.repository.CrudRepository;

public interface BukuRepository extends CrudRepository<Buku, Integer> {
}
