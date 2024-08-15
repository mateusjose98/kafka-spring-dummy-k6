package org.mateusjose98.kafkaspringalura.repository;

import org.mateusjose98.kafkaspringalura.entity.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixRepository extends JpaRepository<Pix, Long> {

    Pix findByIdentifier(String identifier);
}
