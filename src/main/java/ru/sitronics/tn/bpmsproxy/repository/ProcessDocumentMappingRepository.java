package ru.sitronics.tn.bpmsproxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sitronics.tn.bpmsproxy.model.ProcessDocumentMapping;

import java.util.Optional;

@Repository
@Deprecated
public interface ProcessDocumentMappingRepository extends JpaRepository<ProcessDocumentMapping, Long> {
    Optional<ProcessDocumentMapping> findByDocumentType(String documentType);
}
