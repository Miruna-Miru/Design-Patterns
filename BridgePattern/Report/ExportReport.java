package BridgePattern.Report;

// Implementor for export format
interface Exporter {
    void export(String reportName);
}

// Concrete Exporters
class PdfExporter implements Exporter {
    public void export(String reportName) {
        System.out.println("Exporting " + reportName + " as PDF");
    }
}

class ExcelExporter implements Exporter {
    public void export(String reportName) {
        System.out.println("Exporting " + reportName + " as Excel");
    }
}

// Abstraction for Report
abstract class Report {
    protected Exporter exporter;
    public Report(Exporter exporter) { this.exporter = exporter; }
    public abstract void generate();
}

// Refined Abstractions
class MarksReport extends Report {
    public MarksReport(Exporter exporter) { super(exporter); }
    public void generate() { exporter.export("MarksReport"); }
}

class AttendanceReport extends Report {
    public AttendanceReport(Exporter exporter) { super(exporter); }
    public void generate() { exporter.export("AttendanceReport"); }
}

// Test
public class ExportReport {
    public static void main(String[] args) {
        Report marksPdf = new MarksReport(new PdfExporter());
        marksPdf.generate();

        Report attendanceExcel = new AttendanceReport(new ExcelExporter());
        attendanceExcel.generate();
    }
}
