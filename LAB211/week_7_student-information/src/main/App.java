
package main;

import controller.StudentController;
import model.StudentList;
import view.StudentView;

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        StudentList s = new StudentList();
        StudentController sc = new StudentController(s);
        new StudentView(sc).run();
    }
}
