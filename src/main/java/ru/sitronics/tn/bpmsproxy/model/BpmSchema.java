package ru.sitronics.tn.bpmsproxy.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.sitronics.tn.bpmsproxy.util.view.Views;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bpm_schemes")
@Deprecated
public class BpmSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Simple.class)
    private Long id;
    @Column(updatable = false, nullable = false)
    @JsonView(Views.Simple.class)
    private String processName;
    @Column(updatable = false, nullable = false)
    @JsonView(Views.Full.class)
    //TODO change name to "processKey" and change field name in DB
    private String processId;
    @Column(nullable = false)
    @JsonView(Views.Full.class)
    private String xml;
    @JsonView(Views.Simple.class)
    private String description;
    @JsonView(Views.Simple.class)
    private boolean deployed;
    @JsonView(Views.Simple.class)
    @Column(updatable = false,  nullable = false)
    private String createUser;
    @JsonView(Views.Simple.class)
    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private Instant createdDate;
    @JsonView(Views.Simple.class)
    private String modifyUser;
    @JsonView(Views.Simple.class)
    @UpdateTimestamp
    private Instant modifiedDate;
}
