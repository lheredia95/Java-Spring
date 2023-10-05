package com.trabajando.springboot.app.view.xlsx;

import com.trabajando.springboot.app.models.entity.Factura;
import com.trabajando.springboot.app.models.entity.ItemFactura;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import java.util.Map;

@Component("factura/ver.xlsx")
public class FacturaXlsxView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Factura factura = (Factura) model.get("factura");
        response.setHeader("Content-Disposition", "attachment; filename=" + factura.getCliente().getNombre() + ".xlsx");
        Sheet sheet = workbook.createSheet("reporte " + factura.getCliente().getNombre());


        sheet.createRow(1).createCell(0).setCellValue("Datos del Cliente");
        sheet.createRow(2).createCell(0).setCellValue(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
        sheet.createRow(3).createCell(0).setCellValue(factura.getCliente().getEmail());

        sheet.createRow(5).createCell(0).setCellValue("Datos de la Factura");
        sheet.createRow(6).createCell(0).setCellValue("Folio: " + factura.getId());
        sheet.createRow(7).createCell(0).setCellValue("Descripcion: " + factura.getDescripcion());
        sheet.createRow(8).createCell(0).setCellValue("Fecha: " + factura.getCreateAt());

        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
        theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle tbodyStyle = workbook.createCellStyle();
        tbodyStyle.setBorderBottom(BorderStyle.THIN);
        tbodyStyle.setBorderTop(BorderStyle.THIN);
        tbodyStyle.setBorderRight(BorderStyle.THIN);
        tbodyStyle.setBorderLeft(BorderStyle.THIN);

        Row header = sheet.createRow(10);
        header.createCell(0).setCellValue("Producto");
        header.createCell(1).setCellValue("Precio");
        header.createCell(2).setCellValue("Cantidad");
        header.createCell(3).setCellValue("Total");

        header.getCell(0).setCellStyle(theaderStyle);
        header.getCell(1).setCellStyle(theaderStyle);
        header.getCell(2).setCellStyle(theaderStyle);
        header.getCell(3).setCellStyle(theaderStyle);

        int rownum = 11;
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);

        for (ItemFactura item : factura.getItems()) {
            Row fila = sheet.createRow(rownum++);
            cell = fila.createCell(0);
            cell.setCellValue(item.getProducto().getNombre());
            cell.setCellStyle(tbodyStyle);

            cell = fila.createCell(1);
            cell.setCellValue(item.getProducto().getPrecio());
            cell.setCellStyle(tbodyStyle);

            cell = fila.createCell(2);
            cell.setCellValue(item.getCantidad());
            cell.setCellStyle(tbodyStyle);

            cell = fila.createCell(3);
            cell.setCellValue(item.calcularImporte());
            cell.setCellStyle(tbodyStyle);
        }

        Row filatotal = sheet.createRow(rownum);
        filatotal.createCell(2).setCellValue("Gran Total");
        filatotal.createCell(3).setCellValue(factura.getTotal());
    }
}
