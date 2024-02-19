package controller;

import dao.HistoryDao;
import dao.WorkerDao;
import model.Worker;
import utils.Library;

public class WorkerController {

    private WorkerDao workerDao;
    private HistoryDao historyDao;
    private Library library;

    public WorkerController(WorkerDao wd, HistoryDao hd) {
        this.workerDao = wd;
        this.historyDao = hd;
        library = new Library();
    }

    public void addWorker() {
        String name = library.getString("Enter name");
        int age = library.validAge("Enter age");
        int salary = library.validMoney("Enter salary");
        String location = library.getString("Enter location");

        workerDao.addWorker(new Worker(0, name, age, salary, location));
    }

    public void increaseSalary() {
        int code = library.getInt("Enter code");
        int salaryAdding = library.validMoney("Enter salaryAdding");
        Worker w = workerDao.findWorker(code).orElseThrow();
        w.setSalary(w.getSalary() + salaryAdding);
        workerDao.updateSalary(w, w.getSalary());
        historyDao.addHistory(new Worker(w), "Up");
    }

    public void decreaseSalary() {
        int code = library.getInt("Enter code");
        int salaryReducing = library.validMoney("Enter salaryReducing");
        Worker w = workerDao.findWorker(code).orElseThrow();
        w.setSalary((w.getSalary() - salaryReducing) >= 0 ? w.getSalary() - salaryReducing : 0);
        workerDao.updateSalary(w, w.getSalary());
        historyDao.addHistory(new Worker(w), "Down");
    }

}
