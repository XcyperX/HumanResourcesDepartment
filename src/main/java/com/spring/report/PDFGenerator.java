package com.spring.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.DTO.*;
import com.spring.model.Manufacturer;
import com.spring.model.User;
import com.spring.service.*;
import lombok.RequiredArgsConstructor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//@Component
public class PDFGenerator {
//    @Autowired
//    private StoreService storeService;
//    @Autowired
//    private ManufacturerService manufacturerService;
//    @Autowired
//    private PositionService positionService;
//    @Autowired
//    private CategoriesService categoriesService;
//    @Autowired
//    private PositionNameService positionNameService;
//    @Autowired
//    private SubdivisionService subdivisionService;

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

    public ByteArrayInputStream PDFReport(User user, List<UserDTO> userDTOList, List<PositionNameDTO> positionNameDTOList, List<SubdivisionDTO> subdivisionDTOList) {
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

            PdfPTable table = new PdfPTable(12);
            Stream.of("Фамилия", "Имя", "Отчество", "Пол", "Адресс", "Телефон", "Email", "Паспорт", "Должность", "Дата приема", "Дата увольнения", "Подразделение")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, fontNormal));
                        table.addCell(header);
                    });

            for (UserDTO userDTO : userDTOList) {
                table.addCell(new Phrase(userDTO.getLastName(), fontNormal));
                table.addCell(new Phrase(userDTO.getFirstName(), fontNormal));
                table.addCell(new Phrase(userDTO.getSecondName(), fontNormal));
                table.addCell(new Phrase(userDTO.getGender(), fontNormal));
                table.addCell(new Phrase(userDTO.getAddress().toString(), fontNormal));
                table.addCell(new Phrase(userDTO.getPhone(), fontNormal));
                table.addCell(new Phrase(userDTO.getEmail(), fontNormal));
                table.addCell(new Phrase(userDTO.getPassport() != null ? userDTO.getPassport().toString() : "null", fontNormal));
                if (userDTO.getPosition() != null) {
                    for (PositionNameDTO positionNameDTO : positionNameDTOList) {
                        if (positionNameDTO.getId().equals(userDTO.getPosition().getPositionNameId())) {
                            table.addCell(new Phrase(positionNameDTO.getName(), fontNormal));
                        }
                    }
                } else {
                    table.addCell(new Phrase("null", fontNormal));
                }
                if (userDTO.getPosition() != null) {
                    table.addCell(new Phrase(userDTO.getPosition().getDateReceipt() != null ? userDTO.getPosition().getDateReceipt().toString() : "null", fontNormal));
                    table.addCell(new Phrase(userDTO.getPosition().getDateDismissal() != null ? userDTO.getPosition().getDateDismissal().toString() : "null", fontNormal));
                } else {
                    table.addCell(new Phrase("null", fontNormal));
                    table.addCell(new Phrase("null", fontNormal));
                }
                if (userDTO.getSubdivisionId() != null) {
                    for (SubdivisionDTO subdivisionDTO : subdivisionDTOList) {
                        if (subdivisionDTO.getId().equals(userDTO.getSubdivisionId())) {
                            table.addCell(new Phrase(subdivisionDTO.getName(), fontNormal));
                        }
                    }
                } else {
                    table.addCell(new Phrase("null", fontNormal));
                }
            }

            table.setTotalWidth(PageSize.A4.rotate().getWidth());
            table.setLockedWidth(true);
            document.add(table);

            Paragraph userParag = new Paragraph("Отчет сформировал: " + user.getLastName() + " " + user.getFirstName() +
                    " " + user.getSecondName(), fontHeader);
            Paragraph dateParag = new Paragraph("Дата формирования отчета: " + LocalDate.now(), fontHeader);
            document.add(userParag);
            document.add(dateParag);
            document.add(Chunk.NEWLINE);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream PDFReportSales(List<OrderHistoryDTO> orderHistoryDTOS, User user, List<StoreDTO> storeDTOS,
                                               List<ManufacturerDTO> manufacturerDTOS, List<CategoriesDTO> categoriesDTOS) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = null;

        try {
            writer = PdfWriter.getInstance(document, out);
            document.open();
            document.setPageSize(PageSize.A4.rotate());
            document.newPage();

            Paragraph para = new Paragraph("Отчет по продажам", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);
            Stream.of("Название", "Склад", "Категория", "Производитель", "Количество", "Цена")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, fontNormal));
                        table.addCell(header);
                    });

            float sum = 0;

            for (OrderHistoryDTO orderHistoryDTO : orderHistoryDTOS) {
                for (OrderProductInfoDTO orderProductInfoDTO : orderHistoryDTO.getOrderProductInfoDTOS()) {
                    table.addCell(new Phrase(orderProductInfoDTO.getProduct().getName(), fontNormal));
                    table.addCell(new Phrase(storeDTOS.stream().filter(i -> i.getId().equals(orderProductInfoDTO.getProduct().getStoreId())).findFirst().get().getName(), fontNormal));
                    table.addCell(new Phrase(categoriesDTOS.stream().filter(i -> i.getId().equals(orderProductInfoDTO.getProduct().getCategoriesId())).findFirst().get().getName(), fontNormal));
                    table.addCell(new Phrase(manufacturerDTOS.stream().filter(i -> i.getId().equals(orderProductInfoDTO.getProduct().getManufacturerId())).findFirst().get().getName(), fontNormal));
                    table.addCell(new Phrase(orderProductInfoDTO.getAmount().toString(), fontNormal));
                    table.addCell(new Phrase(String.valueOf(orderProductInfoDTO.getAmount() * orderProductInfoDTO.getProduct().getPrice()), fontNormal));
                    sum += (orderProductInfoDTO.getAmount() * orderProductInfoDTO.getProduct().getPrice());
                }
            }


//            table.setTotalWidth(PageSize.A4.rotate().getWidth());
//            table.setLockedWidth(true);
            document.add(table);

            Paragraph endSales = new Paragraph("Продажи на сумму: " + sum, fontHeader);
            document.add(endSales);

            JFreeChart chart = createChart(orderHistoryDTOS, categoriesDTOS);
            BufferedImage bufferedImage = chart.createBufferedImage(500, 500);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            document.add(image);

            Paragraph userParag = new Paragraph("Отчет сформировал: " + user.getLastName() + " " + user.getFirstName() +
                    " " + user.getSecondName(), fontHeader);
            Paragraph dateParag = new Paragraph("Дата формирования отчета: " + LocalDate.now(), fontHeader);
            document.add(userParag);
            document.add(dateParag);
            document.add(Chunk.NEWLINE);

            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    private JFreeChart createChart(List<OrderHistoryDTO> orderHistoryDTOS, List<CategoriesDTO> categoriesDTOS) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (CategoriesDTO categoriesDTO : categoriesDTOS) {
            Float number = 0F;
            for (OrderHistoryDTO orderHistoryDTO : orderHistoryDTOS) {
                for (OrderProductInfoDTO orderProductInfoDTO : orderHistoryDTO.getOrderProductInfoDTOS()) {
                    if (orderProductInfoDTO.getProduct().getCategoriesId().equals(categoriesDTO.getId())) {
                        number += orderProductInfoDTO.getProduct().getPrice();
                    }
                }
            }
            if (number != 0) {
                dataset.setValue(categoriesDTO.getName(), number);
            }
        }

        return ChartFactory.createPieChart("Продажи по категориям", dataset, true, true,
                false);
    }
}
