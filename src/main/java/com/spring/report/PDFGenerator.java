//package com.spring.report;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.spring.webcontent.DTO.EmployeeDTO;
//import com.spring.webcontent.DTO.UserDTO;
//import com.spring.webcontent.model.User;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Stream;
//
//public class PDFGenerator {
//    private static BaseFont baseFont = loadBaseFont();
//
//    private static Font fontHeader = new Font(baseFont, 16, Font.BOLD, BaseColor.BLACK);
//
//    private static Font fontNormal = new Font(baseFont, 14, Font.NORMAL, BaseColor.BLACK);
//
//    private static BaseFont loadBaseFont() {
//        BaseFont baseFont = null;
//        try {
//            baseFont = BaseFont.createFont("asset/times-roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//        } catch (DocumentException | IOException e) {
//            e.printStackTrace();
//        }
//        return baseFont;
//    }
//
//    public ByteArrayInputStream chequePDFReport(EmployeeDTO requestDTO, User userManager, UserDTO userTechnical) {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try {
//            PdfWriter.getInstance(document, out);
//            document.open();
//            document.setPageSize(PageSize.A4.rotate());
//            document.newPage();
//
//            Paragraph para = new Paragraph("Чек " + requestDTO.getId(), fontHeader);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//            document.add(Chunk.NEWLINE);
//
//            PdfPTable table = new PdfPTable(8);
//            Stream.of("Тип", "Описание", "Адресс", "Телефон", "Email", "Дата подачи", "Дата выполнения", "Стоимость")
//                    .forEach(headerTitle -> {
//                        PdfPCell header = new PdfPCell();
//                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
//                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
//                        header.setBorderWidth(2);
//                        header.setPhrase(new Phrase(headerTitle, fontNormal));
//                        table.addCell(header);
//                    });
//
//            table.addCell(new Phrase(requestDTO.getTypes(), fontNormal));
//            table.addCell(new Phrase(requestDTO.getDescription(), fontNormal));
//            table.addCell(new Phrase(requestDTO.getAddressDTOS().toString(), fontNormal));
//            table.addCell(new Phrase(requestDTO.getPhone().toString(), fontNormal));
//            table.addCell(new Phrase(requestDTO.getEmail(), fontNormal));
//            table.addCell(new Phrase(requestDTO.getDateCreate().toString(), fontNormal));
//            table.addCell(new Phrase(requestDTO.getDateCompletion().toString(), fontNormal));
//            table.addCell(new Phrase(requestDTO.getPrice().toString(), fontNormal));
//
//            table.setTotalWidth(PageSize.A4.rotate().getWidth());
//            table.setLockedWidth(true);
//            document.add(table);
//
//            Paragraph manager = new Paragraph("Чек сформировал: " + userManager.getName(), fontHeader);
//            document.add(manager);
//            document.add(Chunk.NEWLINE);
//
//            Paragraph technical = new Paragraph("Ответственный за проведение услуги: " + userTechnical.getName(), fontHeader);
//            document.add(technical);
//            document.add(Chunk.NEWLINE);
//            document.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//
//    public ByteArrayInputStream profitPDFReport(List<EmployeeDTO> requestDTOList, User userManager) {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        double sumProfit = 0.0;
//
//        try {
//            PdfWriter.getInstance(document, out);
//            document.open();
//            document.setPageSize(PageSize.A4.rotate());
//            document.newPage();
//
//            Paragraph para = new Paragraph("Отчет по прибыли", fontHeader);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//            document.add(Chunk.NEWLINE);
//
//            PdfPTable table = new PdfPTable(8);
//            Stream.of("Тип", "Описание", "Адресс", "Телефон", "Email", "Дата подачи", "Дата выполнения", "Стоимость")
//                    .forEach(headerTitle -> {
//                        PdfPCell header = new PdfPCell();
//                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
//                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
//                        header.setBorderWidth(2);
//                        header.setPhrase(new Phrase(headerTitle, fontNormal));
//                        table.addCell(header);
//                    });
//            for (EmployeeDTO requestDTO : requestDTOList) {
//                table.addCell(new Phrase(requestDTO.getTypes(), fontNormal));
//                table.addCell(new Phrase(requestDTO.getDescription(), fontNormal));
//                table.addCell(new Phrase(requestDTO.getAddressDTOS().toString(), fontNormal));
//                table.addCell(new Phrase(requestDTO.getPhone().toString(), fontNormal));
//                table.addCell(new Phrase(requestDTO.getEmail(), fontNormal));
//                table.addCell(new Phrase(requestDTO.getDateCreate().toString(), fontNormal));
//                table.addCell(new Phrase(requestDTO.getDateCompletion().toString(), fontNormal));
//                sumProfit += requestDTO.getPrice();
//                table.addCell(new Phrase(requestDTO.getPrice().toString(), fontNormal));
//            }
//
//            table.setTotalWidth(PageSize.A4.rotate().getWidth());
//            table.setLockedWidth(true);
//            document.add(table);
//
//            Paragraph profit = new Paragraph("Общий доход: " + sumProfit, fontHeader);
//            document.add(profit);
//            document.add(Chunk.NEWLINE);
//
//            Paragraph manager = new Paragraph("Отчет сформировал: " + userManager.getName(), fontHeader);
//            document.add(manager);
//            document.add(Chunk.NEWLINE);
//            document.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//}
