package com.spring.mapper;

import com.spring.DTO.StatusDTO;
import com.spring.base.MapperService;
import com.spring.model.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusMapper implements MapperService<Status, StatusDTO> {
    @Override
    public Status toEntity(StatusDTO dto) {
        Status status = new Status();
        status.setId(dto.getId());
        status.setName(dto.getName());
        return status;
    }

    @Override
    public StatusDTO toDto(Status entity) {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(entity.getId());
        statusDTO.setName(entity.getName());
        return statusDTO;
    }

    @Override
    public List<Status> toEntities(List<StatusDTO> dto) {
        List<Status> statuses = new ArrayList<>();
        dto.forEach(StatusDTO -> statuses.add(toEntity(StatusDTO)));
        return statuses;
    }

    @Override
    public List<StatusDTO> toDtos(List<Status> entity) {
        List<StatusDTO> statusDTOS = new ArrayList<>();
        entity.forEach(Status -> statusDTOS.add(toDto(Status)));
        return statusDTOS;
    }
}
