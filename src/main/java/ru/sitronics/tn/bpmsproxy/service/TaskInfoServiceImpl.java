package ru.sitronics.tn.bpmsproxy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.bpmsproxy.dto.TaskInfoDto;
import ru.sitronics.tn.bpmsproxy.model.TaskInfo;
import ru.sitronics.tn.bpmsproxy.repository.TaskInfoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Deprecated
public class TaskInfoServiceImpl implements TaskInfoService {

    private final TaskInfoRepository taskInfoRepository;

    @Override
    public TaskInfoDto createTaskInfo(TaskInfoDto taskInfoDto) {
        TaskInfo taskInfo = new TaskInfo();
        BeanUtils.copyProperties(taskInfoDto, taskInfo);
        TaskInfoDto response = new TaskInfoDto();
        BeanUtils.copyProperties(taskInfoRepository.save(taskInfo), response);
        return response;
    }

    @Override
    public List<TaskInfoDto> getAllTaskInfo() {
        return taskInfoRepository.findAll().stream()
                .map(taskInfo -> {
                    TaskInfoDto taskInfoDto = new TaskInfoDto();
                    BeanUtils.copyProperties(taskInfo, taskInfoDto);
                    return taskInfoDto;
                })
                .collect(Collectors.toList());
    }
}
