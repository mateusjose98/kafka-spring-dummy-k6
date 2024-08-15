package org.mateusjose98.kafkaspringalura.repository;

import org.mateusjose98.kafkaspringalura.entity.Key;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<Key, Long> {
    Key findByChave(String key);
}
