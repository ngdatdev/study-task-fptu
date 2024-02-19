package dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import model.History;
import model.Worker;

public class HistoryDao {

    private List<History> histories;

    public HistoryDao() {
        histories = new ArrayList<>();
        readData();
    }

    public List<History> getHistories() {
        return histories;
    }

    public void addHistory(Worker w, String status) {
        History h = new History(w, status, LocalDate.now());
        histories.add(h);
    }

    private void readData() {
        histories.add(new History(new Worker(1, "Nguyen Dat", 20, 2000, "Da Nang"), "Up", LocalDate.of(2023, Month.MARCH, 26)));
    }

}
