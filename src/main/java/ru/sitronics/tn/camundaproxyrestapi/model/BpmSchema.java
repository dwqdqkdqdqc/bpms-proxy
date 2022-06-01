package ru.sitronics.tn.camundaproxyrestapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import ru.sitronics.tn.camundaproxyrestapi.util.view.Views;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bpm_schemes")
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
    private String processId;
    @Column(nullable = false)
    @JsonView(Views.Full.class)
    private String xml;
    @JsonView(Views.Simple.class)
    private String description;
    @JsonView(Views.Simple.class)
    @Column(updatable = false,  nullable = false)
    private String createUser;
    @JsonView(Views.Simple.class)
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;
    @JsonView(Views.Simple.class)
    private String modifyUser;
    @JsonView(Views.Simple.class)
    private LocalDateTime modifiedDate;
}
