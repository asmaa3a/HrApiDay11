package org.example.mappers;


import org.example.DTO.jobsdto1;
import org.example.MODELS.jobs;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface jobMapper {

    jobMapper INSTANCE = Mappers.getMapper(jobMapper.class);

    jobsdto1 toDeptDto(jobs d);

    jobs toModel(jobsdto1 dto);


}
