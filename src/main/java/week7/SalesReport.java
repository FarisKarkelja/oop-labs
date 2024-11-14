package week7;

import java.time.LocalDate;
import java.util.*;

record Sale(String category, double amount, LocalDate saleDate) {
    @Override
    public String toString() {
        return "Category: " + category + "\nAmount: " + amount + "\nDate of sale: " + saleDate;
    }
}

class SalesReport {
    public void generateReport(List<Sale> sales) {
        for (Sale sale : sales) {
            System.out.println(sale);
        }
    }

    public void generateReport(List<Sale> sales, String productCategory) {
        List<Sale> filteredByCategory = new ArrayList<>();
        for (Sale sale : sales) {
            if (sale.category().equals(productCategory)) {
                filteredByCategory.add(sale);
            }
        }
        System.out.println("Report for category: " + productCategory);
        for (Sale sale : filteredByCategory) {
            System.out.println(sale);
        }
    }

    public void generateReport(List<Sale> sales, LocalDate startDate, LocalDate endDate) {
        List<Sale> filteredByDate = new ArrayList<>();
        for (Sale sale : sales) {
            if (!sale.saleDate().isBefore(startDate) && !sale.saleDate().isAfter(endDate)) {
                filteredByDate.add(sale);
            }
        }
        System.out.println("Report for Date Range: " + startDate + " to " + endDate);
        for (Sale sale : filteredByDate) {
            System.out.println(sale);
        }
    }

}

class MainProg {
    public static void main(String[] args) {
        List<Sale> sales = new ArrayList<>();
        Collections.addAll(sales,
                new Sale("Electronics", 250.0, LocalDate.of(2024, 11, 1)),
                new Sale("Clothing", 75.0, LocalDate.of(2024, 11, 5)),
                new Sale("Electronics", 120.0, LocalDate.of(2024, 10, 20)),
                new Sale("Furniture", 300.0, LocalDate.of(2024, 10, 15)),
                new Sale("Clothing", 45.0, LocalDate.of(2024, 11, 7))
        );

        SalesReport salesReport = new SalesReport();

        salesReport.generateReport(sales);
        System.out.println("< = = = = = = = = = = = = = = >");
        salesReport.generateReport(sales, "Electronics");
        System.out.println("< = = = = = = = = = = = = = = >");
        salesReport.generateReport(sales, LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 31));
    }
}