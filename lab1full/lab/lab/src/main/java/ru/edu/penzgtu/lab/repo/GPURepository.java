package ru.edu.penzgtu.lab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.penzgtu.lab.entity.GPU;

@Repository
public interface GPURepository extends JpaRepository<GPU, Long> {

}
