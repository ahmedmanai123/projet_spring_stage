package com.ang.spring.projet.Service;

import com.ang.spring.projet.Models.Report;
import com.ang.spring.projet.Models.StringResult;
import com.ang.spring.projet.util.Constant;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@Service("reportService")

public class ReportServiceImpl implements ReportService{
    @Autowired
    DataSource dataSource;
    @Autowired
    ResourceLoader resourceLoader;

    public StringResult createReport(Report report) throws SQLException {
        try {
            Resource jrxmlResource = resourceLoader.getResource("classpath:/reports/EmployeeList.jrxml");

            if (jrxmlResource.exists()) {
                StringResult reportName = new StringResult();
                String jasperFilePath = compileJRXML(jrxmlResource);

                if (jasperFilePath != null) {
                    InputStream jasperStream = resourceLoader.getResource("file:" + jasperFilePath).getInputStream();
                    Map<String, Object> parameters = new HashMap<>();
                    Connection conn = this.dataSource.getConnection();
                    byte[] reportBytes = JasperRunManager.runReportToPdf(jasperStream, parameters, conn);
                    reportName.setNom("EmployeeList_" + System.currentTimeMillis() + ".pdf");
                    FileOutputStream fileOutputStream = new FileOutputStream(Constant.REPORT_RESULT_FOLDER + reportName.getNom());
                    fileOutputStream.write(reportBytes);
                    fileOutputStream.close();
                    return reportName;
                }
            } else {
                System.out.println("Resource not found: " + jrxmlResource.getURL());
            }
        } catch (JRException | IOException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String compileJRXML(Resource jrxmlResource) {
        try {
            String jrxmlFilePath = jrxmlResource.getFile().getAbsolutePath();
            String jasperFilePath = jrxmlFilePath.replace(".jrxml", ".jasper");

            JasperCompileManager.compileReportToFile(jrxmlFilePath, jasperFilePath);

            return jasperFilePath;
        } catch (IOException | JRException e) {
            e.printStackTrace();
        }

        return null;
    }


}
