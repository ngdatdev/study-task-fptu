package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Worker;

public class WorkerDao {

    private List<Worker> workers;

    public WorkerDao() {
        workers = new ArrayList<>();
        readData();
    }

    public void addWorker(Worker w) {
        int code = workers.size() + 1;
        w.setCode(code);
        workers.add(w);
    }

    public Optional<Worker> findWorker(int code) {
        return workers.stream().filter(w -> w.getCode() == code).findFirst();
    }

    public void updateSalary(Worker worker, int salary) {
        workers.stream().filter(w -> w.equals(worker)).findFirst().ifPresent(w -> w.setSalary(salary));
    }

    private void readData() {
        Worker w1 = new Worker(1, "Nguyen Dat", 20, 2000, "Da Nang");
        Worker w2 = new Worker(2, "Thanh Dat", 24, 3000, "Da Nang");
        Worker w3 = new Worker(3, "Gia Huy", 20, 2000, "Quang Nam");
        Worker w4 = new Worker(4, "Quy Loi", 20, 2000, "Sai Gon");
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(w4);
    }

}
