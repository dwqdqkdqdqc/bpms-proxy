package ru.sitronics.tn.camundaproxyrestapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sitronics.tn.camundaproxyrestapi.util.view.Views;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bpm_schemes")
public class BpmSchema {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonView(Views.Simple.class)
    private Long id;
    @Column(updatable = false, nullable = false)
    @JsonView(Views.Simple.class)
    private String processName;
    @Column(nullable = false)
    @JsonView(Views.Full.class)
    private String xml;
    @JsonView(Views.Simple.class)
    private String description;
}
