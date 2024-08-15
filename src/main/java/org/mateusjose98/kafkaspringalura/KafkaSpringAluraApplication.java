package org.mateusjose98.kafkaspringalura;

import org.mateusjose98.kafkaspringalura.entity.Key;
import org.mateusjose98.kafkaspringalura.repository.KeyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaSpringAluraApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringAluraApplication.class, args);
    }
    private final KeyRepository keyRepository;

    public KafkaSpringAluraApplication(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(keyRepository.findByChave("123") == null) {
            Key k1 = new Key();
            k1.setChave("123");
            keyRepository.save(k1);
        }

        if(keyRepository.findByChave("007") == null) {
            Key k2 = new Key();
            k2.setChave("007");
            keyRepository.save(k2);
        }



    }
}
