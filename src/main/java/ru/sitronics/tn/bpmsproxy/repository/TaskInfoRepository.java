package ru.sitronics.tn.bpmsproxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sitronics.tn.bpmsproxy.model.TaskInfo;

@Repository
@Deprecated
public interface TaskInfoRepository extends JpaRepository<TaskInfo, Long> {
}
