/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import controller.HistoryController;
import controller.WorkerController;
import dao.HistoryDao;
import dao.WorkerDao;
import view.ManageWorker;

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        HistoryDao historyDao = new HistoryDao();
        WorkerDao workerDao = new WorkerDao();
        HistoryController historyController = new HistoryController(historyDao);
        WorkerController workerController = new WorkerController(workerDao, historyDao);
        
        new ManageWorker(historyController, workerController).run();
    }
}
