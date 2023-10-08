package com.ang.spring.projet.Service;

import com.ang.spring.projet.Models.Report;
import com.ang.spring.projet.Models.StringResult;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service(value = "reportService")
public interface ReportService {
    public StringResult createReport(Report report) throws SQLException;
}
