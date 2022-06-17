package ru.sitronics.tn.bpmsproxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sitronics.tn.bpmsproxy.model.BpmSchema;

@Repository
@Deprecated
public interface BpmRepository extends JpaRepository<BpmSchema, Long> {
}
