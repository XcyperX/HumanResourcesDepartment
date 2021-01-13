package com.spring.mapper;

import com.spring.DTO.AgreementDataDTO;
import com.spring.base.MapperService;
import com.spring.model.AgreementData;
import com.spring.model.Employee;
import com.spring.model.Payment;
import com.spring.model.Subdivision;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgreementDataMapper implements MapperService<AgreementData, AgreementDataDTO> {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public AgreementData toEntity(AgreementDataDTO dto) {
        AgreementData agreementData = new AgreementData();
        agreementData.setId(dto.getId());
        agreementData.setSubdivision(new Subdivision(employeeService.getById(dto.getEmployeeId()).getSubdivisionId()));
        agreementData.setStart(dto.getStart());
        agreementData.setFinish(dto.getFinish());
        agreementData.setPayment(Payment.valueOf(dto.getPayment()));
        agreementData.setPrice(dto.getPrice());
        agreementData.setSumTax(dto.getSumTax());
        agreementData.setDeductionCode(dto.getDeductionCode());
        agreementData.setEmployee(new Employee(dto.getEmployeeId()));
        return agreementData;
    }

    @Override
    public AgreementDataDTO toDto(AgreementData entity) {
        AgreementDataDTO agreementDataDTO = new AgreementDataDTO();
        agreementDataDTO.setId(entity.getId());
        agreementDataDTO.setStart(entity.getStart());
        agreementDataDTO.setFinish(entity.getFinish());
        agreementDataDTO.setPayment(entity.getPayment().getNamePayment());
        agreementDataDTO.setPrice(entity.getPrice());
        agreementDataDTO.setSumTax(entity.getSumTax());
        agreementDataDTO.setDeductionCode(entity.getDeductionCode());
        agreementDataDTO.setEmployeeId(entity.getEmployee().getId());
        return agreementDataDTO;
    }

    @Override
    public List<AgreementData> toEntities(List<AgreementDataDTO> dto) {
        List<AgreementData> agreementData = new ArrayList<>();
        dto.forEach(agreementDataDTO -> agreementData.add(toEntity(agreementDataDTO)));
        return agreementData;
    }

    @Override
    public List<AgreementDataDTO> toDtos(List<AgreementData> entity) {
        List<AgreementDataDTO> agreementDataDTOS = new ArrayList<>();
        entity.forEach(agreementData -> agreementDataDTOS.add(toDto(agreementData)));
        return agreementDataDTOS;
    }
}
