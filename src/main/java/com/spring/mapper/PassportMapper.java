package com.spring.mapper;

import com.spring.DTO.PassportDTO;
import com.spring.base.MapperService;
import com.spring.model.Passport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PassportMapper implements MapperService<Passport, PassportDTO> {
    @Override
    public Passport toEntity(PassportDTO dto) {
        Passport passport = new Passport();
        if (dto.getId() != null) {
            passport.setId(dto.getId());
        } else {
            passport.setId(null);
        }
        passport.setNumberSeries(dto.getNumberSeries());
        passport.setPassportId(dto.getPassportId());
        passport.setIssuedBy(dto.getIssuedBy());
        passport.setDateIssue(dto.getDateIssue());
        return passport;
    }

    @Override
    public PassportDTO toDto(Passport entity) {
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setId(entity.getId());
        passportDTO.setNumberSeries(entity.getNumberSeries());
        passportDTO.setPassportId(entity.getPassportId());
        passportDTO.setIssuedBy(entity.getIssuedBy());
        passportDTO.setDateIssue(entity.getDateIssue());
        return passportDTO;
    }

    @Override
    public List<Passport> toEntities(List<PassportDTO> dto) {
        List<Passport> passports = new ArrayList<>();
        dto.forEach(PassportDTO -> passports.add(toEntity(PassportDTO)));
        return passports;
    }

    @Override
    public List<PassportDTO> toDtos(List<Passport> entity) {
        List<PassportDTO> passportDTOS = new ArrayList<>();
        entity.forEach(Passport -> passportDTOS.add(toDto(Passport)));
        return passportDTOS;
    }
}
