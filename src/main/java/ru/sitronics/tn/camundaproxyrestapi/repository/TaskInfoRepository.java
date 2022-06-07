package ru.sitronics.tn.camundaproxyrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sitronics.tn.camundaproxyrestapi.model.TaskInfo;

@Repository
public interface TaskInfoRepository extends JpaRepository<TaskInfo, Long> {
}
