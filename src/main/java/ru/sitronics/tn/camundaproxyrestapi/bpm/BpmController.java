package ru.sitronics.tn.camundaproxyrestapi.bpm;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.camundaproxyrestapi.exception.CustomApplicationException;
import ru.sitronics.tn.camundaproxyrestapi.model.BpmSchema;
import ru.sitronics.tn.camundaproxyrestapi.util.ObjectUtils;
import ru.sitronics.tn.camundaproxyrestapi.util.view.Views;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/bpm")
@RequiredArgsConstructor
public class BpmController {
    private final BpmService bpmService;

    @GetMapping
    @JsonView(Views.Simple.class)
    public ResponseEntity<?> getSchemes() {
        return ResponseEntity.ok(bpmService.getSchemes());
    }

    @GetMapping("/{id}")
    @JsonView(Views.Full.class)
    public ResponseEntity<?> saveSchema(@PathVariable Long id) {
        return ResponseEntity.ok(bpmService.getSchema(id));
    }

    @PostMapping
    @JsonView(Views.Full.class)
    public ResponseEntity<?> saveSchema(@RequestBody BpmSchema schema) {
        return ResponseEntity.ok(bpmService.saveSchema(schema));
    }

    @PostMapping("/{id}")
    @JsonView(Views.Full.class)
    public ResponseEntity<?> updateSchema(@PathVariable Long id, @RequestBody BpmSchema schema) {
        BpmSchema currentSchema = bpmService.getSchema(id).orElseThrow(() -> new CustomApplicationException("Wrong ID"));
        currentSchema.setModifiedDate(LocalDateTime.now());
        schema = ObjectUtils.partialUpdate(currentSchema, schema);
        return ResponseEntity.ok(bpmService.saveSchema(schema));
    }


//    @PostMapping("/save")
//    public ResponseEntity<?> saveSchema(@RequestPart BpmSchema schema, @RequestPart MultipartFile file) throws IOException {
//        System.out.println(new String(file.getBytes(), StandardCharsets.UTF_8));
//        return ResponseEntity.ok(bpmService.saveSchema(schema));
//    }

//    @PostMapping("/save")
//    @JsonView(Views.Full.class)
//    public ResponseEntity<?> saveSchema(@RequestPart BpmSchema schema, @RequestPart String file) {
//        schema.setXml(file);
//        return ResponseEntity.ok(bpmService.saveSchema(schema));
//    }

    @PostMapping("/deploy")
    @JsonView(Views.Full.class)
    public ResponseEntity<?> deploySchema(@RequestBody BpmSchema schema) {
        return ResponseEntity.ok(bpmService.deploy(schema));
    }

    @PostMapping("/deploy/{id}")
    @JsonView(Views.Full.class)
    public ResponseEntity<?> deploySchema(@PathVariable Long id, @RequestBody BpmSchema schema) {
        BpmSchema currentSchema = bpmService.getSchema(id).orElseThrow(() -> new CustomApplicationException("Wrong ID"));
        currentSchema.setModifiedDate(LocalDateTime.now());
        schema = ObjectUtils.partialUpdate(currentSchema, schema);
        return ResponseEntity.ok(bpmService.deploy(schema));
    }
}
