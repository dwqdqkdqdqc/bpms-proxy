package ru.sitronics.tn.camundaproxyrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sitronics.tn.camundaproxyrestapi.model.BpmSchema;

@Repository
public interface BpmRepository extends JpaRepository<BpmSchema, Long> {
}
