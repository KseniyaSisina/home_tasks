package ru.ivmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.models.Auto;

import java.util.List;

public interface AutosRepository extends JpaRepository<Auto, Long>{
    List<Auto> findAllByColor(String color);
}

