package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.sitronics.tn.camundaproxyrestapi.dto.ProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.StartProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.exception.CustomApplicationException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.sitronics.tn.camundaproxyrestapi.process_definition.ProcessDefinitionConstants.*;

@WebMvcTest(ProcessDefinitionController.class)
class ProcessDefinitionControllerTest {

    @MockBean
    private ProcessDefinitionService processDefinitionService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private StartProcessInstanceDto startProcessInstanceDto;
    private ProcessInstanceDto processInstanceDto;

    @BeforeEach
    void setup() throws JsonProcessingException {
        startProcessInstanceDto = objectMapper.readValue(REQUEST_JSON, StartProcessInstanceDto.class);
        processInstanceDto = objectMapper.readValue(RESPONSE_JSON, ProcessInstanceDto.class);
    }

    @Test
    void startProcess() throws Exception {
        //given
        //when
        when(processDefinitionService.startProcess(KEY, startProcessInstanceDto))
                .thenReturn(processInstanceDto);
        //then
        mockMvc.perform(post(START_PROCESS_URI, KEY)
                .contentType(MediaType.APPLICATION_JSON).content(REQUEST_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(RESPONSE_JSON));

        Mockito.verify(processDefinitionService, Mockito.times(1))
                .startProcess(KEY, startProcessInstanceDto);
    }

    @Test
    void startProcessWithWrongKey() throws Exception {
        //given
        //when
        when(processDefinitionService.startProcess(KEY, startProcessInstanceDto))
                .thenThrow(new CustomApplicationException(HttpStatus.NOT_FOUND, "Wrong key"));
        //then
        mockMvc.perform(post(START_PROCESS_URI, KEY)
                        .contentType(MediaType.APPLICATION_JSON).content(REQUEST_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(processDefinitionService, Mockito.times(1))
                .startProcess(KEY, startProcessInstanceDto);
    }

    @Test
    void startProcessWithWrongMethod() throws Exception {
        //given
        //when
        when(processDefinitionService.startProcess(KEY, startProcessInstanceDto))
                .thenReturn(new ProcessInstanceDto());
        //then
        mockMvc.perform(get(START_PROCESS_URI, KEY)
                        .contentType(MediaType.APPLICATION_JSON).content(REQUEST_JSON))
                .andExpect(status().isMethodNotAllowed())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(processDefinitionService, Mockito.times(0))
                .startProcess(KEY, startProcessInstanceDto);
    }

    @Test
    void startProcessWithNoBody() throws Exception {
        //given
        //when
        when(processDefinitionService.startProcess(KEY, startProcessInstanceDto))
                .thenReturn(new ProcessInstanceDto());
        //then
        mockMvc.perform(post(START_PROCESS_URI, KEY)
                        .contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(processDefinitionService, Mockito.times(0))
                .startProcess(KEY, startProcessInstanceDto);
    }
}