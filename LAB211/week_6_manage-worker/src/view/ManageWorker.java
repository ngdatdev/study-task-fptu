/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.HistoryController;
import controller.WorkerController;

/**
 *
 * @author admin
 */
public class ManageWorker extends Menu<String> {

    private HistoryController historyController;
    private WorkerController workerController;

    public ManageWorker(HistoryController historyController, WorkerController workerController) {
        super("Management worker", new String[]{"Add worker", "Up salary", "Down salary", "Display history", "Exit"});
        this.historyController = historyController;
        this.workerController = workerController;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                workerController.addWorker();
                break;
            case 2:
                try {
                workerController.increaseSalary();
                } catch (Exception e) {
                System.out.println("Not found code");
                }
                break;
            case 3:
                try {
                workerController.decreaseSalary();
                } catch (Exception e) {
                System.out.println("Not found code");
                }
                break;
            case 4:
                historyController.displayHistory();
                break;
            case 5:
                exitMenu();
                break;
        }
    }

}
