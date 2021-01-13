package com.spring.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.DTO.*;
import com.spring.model.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class PDFGenerator {
    private static BaseFont baseFont = loadBaseFont();

    private static Font fontHeader = new Font(baseFont, 16, Font.BOLD, BaseColor.BLACK);

    private static Font fontNormal = new Font(baseFont, 10, Font.NORMAL, BaseColor.BLACK);

    private static BaseFont loadBaseFont() {
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont("asset/times-roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        return baseFont;
    }

    public ByteArrayInputStream PDFReport(List<EmployeeDTO> employeeDTOList, User user, List<PositionNameDTO> positionNameDTOList, List<SubdivisionDTO> subdivisionDTOList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            document.setPageSize(PageSize.A4.rotate());
            document.newPage();

            Paragraph para = new Paragraph("Список сотрудников", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(13);
            Stream.of("Имя", "Фамилия", "Адресс", "Телефон", "Email", "Паспорт", "Дата рождения", "Пол", "Статус", "Должность", "Дата приема", "Дата увольнения", "Подразделение")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, fontNormal));
                        table.addCell(header);
                    });

            for (EmployeeDTO employeeDTO : employeeDTOList) {
                table.addCell(new Phrase(employeeDTO.getFirstName(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getLastName(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getAddress().toString(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getPhone(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getEmail(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getPassport().toString(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getDateBirth().toString(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getGender(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getStatus(), fontNormal));
                for (PositionNameDTO positionNameDTO : positionNameDTOList) {
                    if (positionNameDTO.getId().equals(employeeDTO.getPosition().getPositionNameId())) {
                        table.addCell(new Phrase(positionNameDTO.getName(), fontNormal));
                    }
                }
                table.addCell(new Phrase(employeeDTO.getPosition().getDateReceipt() != null ? employeeDTO.getPosition().getDateReceipt().toString() : "null", fontNormal));
                table.addCell(new Phrase(employeeDTO.getPosition().getDateDismissal() != null ? employeeDTO.getPosition().getDateDismissal().toString() : "null", fontNormal));
                for (SubdivisionDTO subdivisionDTO : subdivisionDTOList) {
                    if (subdivisionDTO.getId().equals(employeeDTO.getSubdivisionId())) {
                        table.addCell(new Phrase(subdivisionDTO.getName(), fontNormal));
                    }
                }
            }

            table.setTotalWidth(PageSize.A4.rotate().getWidth());
            table.setLockedWidth(true);
            document.add(table);

            Paragraph manager = new Paragraph("Отчет сформировал: " + user.getName(), fontHeader);
            document.add(manager);
            document.add(Chunk.NEWLINE);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream PDFReportAgreement(List<EmployeeDTO> employeeDTOList, User user, List<AgreementDataDTO> agreementDataDTOS, List<SubdivisionDTO> subdivisionDTOList) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            document.setPageSize(PageSize.A4.rotate());
            document.newPage();

            Paragraph para = new Paragraph("Договор подряда", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(10);
            Stream.of("Имя", "Фамилия", "Телефон", "Подразделение", "Дата начала", "Дата окончания", "Сумма по договору", "Оплата", "Код вычета", "Сумма вычета")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, fontNormal));
                        table.addCell(header);
                    });

            for (AgreementDataDTO agreementDataDTO : agreementDataDTOS) {
                EmployeeDTO employeeDTO = employeeDTOList.stream().filter(i -> i.getId().equals(agreementDataDTO.getEmployeeId())).findFirst().orElseThrow();
                table.addCell(new Phrase(employeeDTO.getFirstName(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getLastName(), fontNormal));
                table.addCell(new Phrase(employeeDTO.getPhone(), fontNormal));
                table.addCell(new Phrase(subdivisionDTOList.stream().filter(i -> i.getId().equals(employeeDTO.getSubdivisionId())).findFirst().orElseThrow().getName(), fontNormal));
                table.addCell(new Phrase(agreementDataDTO.getStart().toString(), fontNormal));
                table.addCell(new Phrase(agreementDataDTO.getFinish().toString(), fontNormal));
                table.addCell(new Phrase(agreementDataDTO.getPrice().toString(), fontNormal));
                table.addCell(new Phrase(agreementDataDTO.getPayment(), fontNormal));
                table.addCell(new Phrase(agreementDataDTO.getDeductionCode(), fontNormal));
                table.addCell(new Phrase(agreementDataDTO.getSumTax().toString(), fontNormal));
            }

            table.setTotalWidth(PageSize.A4.rotate().getWidth());
            table.setLockedWidth(true);
            document.add(table);

            Paragraph manager = new Paragraph("Отчет сформировал: " + user.getName(), fontHeader);
            document.add(manager);
            document.add(Chunk.NEWLINE);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
