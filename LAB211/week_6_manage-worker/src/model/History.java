package model;

import java.time.LocalDate;

public class History {

    private Worker worker;
    private String status;
    private LocalDate date;

    public History(Worker worker, String status, LocalDate date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-5s%-10s%-10s%-10s%-10s",
                worker.getCode(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation(), status, date);
    }

}
