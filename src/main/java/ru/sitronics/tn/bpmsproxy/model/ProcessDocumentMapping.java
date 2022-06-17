package ru.sitronics.tn.bpmsproxy.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="process_document_mapping")
@Deprecated
public class ProcessDocumentMapping {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "process_name")
    private String processName;
    @Column(name = "document_type")
    private String documentType;
}
