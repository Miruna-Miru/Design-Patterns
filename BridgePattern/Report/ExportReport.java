package BridgePattern.Report;


interface Exporter {
    void export(String reportName);
}


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


abstract class Report {
    protected Exporter exporter;
    public Report(Exporter exporter) 
    { 
        this.exporter = exporter;
     }
    public abstract void generate();
}


class MarksReport extends Report {
    public MarksReport(Exporter exporter) { super(exporter); }
    public void generate() 
    { 
        exporter.export("MarksReport");
     }
}

class AttendanceReport extends Report {
    public AttendanceReport(Exporter exporter) { super(exporter); }
    public void generate() 
    {
         exporter.export("AttendanceReport"); 
        }
}


public class ExportReport {
    public static void main(String[] args) {
        Report marksPdf = new MarksReport(new PdfExporter());
        marksPdf.generate();

        Report attendanceExcel = new AttendanceReport(new ExcelExporter());
        attendanceExcel.generate();
    }
}
