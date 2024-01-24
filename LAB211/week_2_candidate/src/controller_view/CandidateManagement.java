/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_view;

import Utils.Library;
import java.util.List;
import model.Candidate;
import model.CandidateList;
import model.Experience;
import model.Fresher;
import model.Intern;

/**
 *
 * @author admin
 */
public class CandidateManagement extends Menu {

    private CandidateList candidateList;
    private Library library;

    public CandidateManagement() {
        super("Candidate Management", new String[]{"Experience", "Fresher", "Intern", "Search", "Exit"});
        candidateList = new CandidateList();
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createExperience();
                break;
            case 2:
                createFresher();
                break;
            case 3:
                createIntern();
                break;
            case 4:
                searchCandidate();
                break;
            case 5:
                exitMenu();
                break;
        }
    }

    public void createExperience() {//10
        Candidate c = library.getCandidate();
        c.setType(1);
        String expYear = library.getString("Enter experience year");
        while(!library.validYearOfExperience(expYear)) {
            expYear = library.getString("Enter email(format <account name>@<domain>.<>)");
        }
        String proSkill = library.getString("Enter professional skill");
        Experience e = new Experience(expYear, proSkill, c);
        candidateList.createExperience(e);
        
    }

    public void createFresher() {
        Candidate c = library.getCandidate();
        c.setType(2);
        String graduatedTime = library.getString("Enter graduatet time");
        String rankGraduation = library.getString("Enter rank of graduation");
        while(!library.validRank(rankGraduation)) {
            rankGraduation = library.getString("Enter rank(format(Excellence|Good|Fair|Poor))");
        }
        String universityName = library.getString("Enter university name");
        Fresher f = new Fresher(graduatedTime, rankGraduation, universityName, c);
        candidateList.createFresher(f);
    }

    public void createIntern() {
        Candidate c = library.getCandidate();
        c.setType(3);
        String major = library.getString("Enter major");
        int semester = library.getInt("Enter semester");
        String universityName = library.getString("Enter university name");

        Intern i = new Intern(major, semester, universityName, c);
        candidateList.createIntern(i);
    }

    public void searchCandidate() {
        printCandidateList();
        String keyword = library.getString("Input Candidate name (First name or Last name)");
        int type = library.getInt("Input type of candidate");
        System.out.println("The candidates found: ");
        printCandidateSearch(candidateList.search(p -> p.checkCandidateExist(keyword, type)));
    }

    public void printCandidateList() {
        System.out.println("List of candidate");
        System.out.println("=============EXPERIENCE CANDIDATE=============");
        printCandidateSearch(candidateList.getCandidateByType(1));
        System.out.println("=============FRESHER CANDIDATE=============");
        printCandidateSearch(candidateList.getCandidateByType(2));
        System.out.println("=============INTERN CANDIDATE=============");
        printCandidateSearch(candidateList.getCandidateByType(3));
    }

    public void printCandidateSearch(List<Candidate> cs) {
        for (Candidate c : cs) {
            System.out.println(c);
        }
    }

}
