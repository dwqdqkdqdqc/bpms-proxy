package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.sitronics.tn.camundaproxyrestapi.dto.ProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.StartProcessInstanceDto;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProcessDefinitionController.class)
class ProcessDefinitionControllerTest {

    @MockBean
    private ProcessDefinitionService processDefinitionService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void startProcess() throws Exception {
        //given
        String requestJson = """
                {
                    "variables": {
                      "aVariable": {
                        "value": "aStringValue",
                        "type": "String"
                      },
                      "anotherVariable": {
                        "value": true,
                        "type": "Boolean"
                      }
                    },
                    "businessKey": "myBusinessKey"
                  }""";

        String responseJson = """
                {
                  "links": [
                    {
                      "method": "GET",
                      "href": "http://localhost:8080/rest-test/process-instance/anId",
                      "rel": "self"
                    }
                  ],
                  "id": "anId",
                  "definitionId": "aProcessDefinitionId",
                  "businessKey": "myBusinessKey",
                  "ended": false,
                  "suspended": false
                }""";

        StartProcessInstanceDto startProcessInstanceDto =
                objectMapper.readValue(requestJson, StartProcessInstanceDto.class);

        ProcessInstanceDto processInstanceDto =
                objectMapper.readValue(responseJson, ProcessInstanceDto.class);

        //when
        when(processDefinitionService.startProcess("myId", startProcessInstanceDto))
                .thenReturn(processInstanceDto);

        //then
        mockMvc.perform(post("/process-definition/key/{key}/start", "myId")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseJson));
    }
}