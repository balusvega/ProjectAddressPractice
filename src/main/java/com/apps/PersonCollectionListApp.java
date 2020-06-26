package main.java.com.apps;

import main.java.com.modules.PersonCollectionList;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class PersonCollectionListApp {

    public static void main(String[] args) {

//        List<String> personsProfile = new ArrayList<String>();
        Set<String> personsProfile = new HashSet<String>();
        PersonCollectionList personsList = new PersonCollectionList();
        File myFile = new File("D:\\QATraining\\Person.txt");
        personsList.readFile(myFile);


        // adding persons to the list
/*        personsList.addPersons("Lsea,Klip,31,analyst,morrisville", personsProfile);
        personsList.addPersons("Lott,Fero,,analyst,morrisville", personsProfile);
        personsList.addPersons(",Reddy,40,analyst,morrisville", personsProfile);
        personsList.addPersons("Norm,Chit,,analyst, ", personsProfile);
        personsList.addPersons("Lott,Fero,40,analyst,durham", personsProfile);
        System.out.println("Current List is "+ personsProfile);*/

        personsList.populateData();
        personsList.printPersons();
        personsList.countCity();
        personsList.countPerson();

    }
}
