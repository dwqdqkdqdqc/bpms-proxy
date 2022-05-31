package ru.sitronics.tn.camundaproxyrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sitronics.tn.camundaproxyrestapi.model.TaskInfo;

public interface TaskInfoRepository extends JpaRepository<TaskInfo, Long> {
}
