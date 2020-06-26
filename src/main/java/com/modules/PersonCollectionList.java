package main.java.com.modules;

import main.java.com.domain.Person;
import main.java.com.exceptions.InvalidPersonProfileException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PersonCollectionList {

    Set<Person> persons= new HashSet<Person>();
    Map<String, Integer> personCount = new HashMap<String, Integer>();
    Map<String, Integer> cityCount = new HashMap<String, Integer>();
    List<String> lines = new ArrayList<String>();

/*    public void addPersons(String str, Set<String> personList){
        personList.add(str);
    }*/

    public void readFile(File myFile) {
        try {
            lines = FileUtils.readLines(myFile, StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File is not in the valid format");
        }
    }

    public void populateData(String fileName) {

          lines = new FileExample().readFile(fileName);

        for(String aString : lines){
            try{
                persons.add(convertData(aString));
            } catch (InvalidPersonProfileException exp){
                System.out.println("Invalid Person name -"+aString);
            }
        }
    }

/*    public void populateData(Set<String> personList) {
        for(String aString : personList){
            try{
                persons.add(convertData(aString));
            } catch (InvalidPersonProfileException exp){
                System.out.println("Invalid Person name -"+aString);
            }
        }
    }*/

    public void printPersons(){
        for (Person aPerson : persons){
            System.out.println(aPerson);
        }
    }

    public  void countPerson(){
        for (Person aPerson : persons){
            if(personCount.get(aPerson.getFullName())==null){
                personCount.put(new String(aPerson.getFullName()), new Integer(1));
            }else{
                Integer count = personCount.get(aPerson.getFullName());
                personCount.put(new String(aPerson.getFullName()), new Integer(count.intValue() + 1));
            }
        }
        System.out.println("::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::: P E R S O N    C O U N T ");
        for(Map.Entry<String, Integer> entry : personCount.entrySet()){
            System.out.println("Person: "+entry.getKey()+ "::: count: "+entry.getValue());
        }
    }

/*    public  void countCity(){
        for (Person aPerson : persons){
            if(cityCount.get(aPerson.getCity())==null){
                cityCount.put(new String(aPerson.getCity()), new Integer(1));
            }else{
                Integer count = cityCount.get(aPerson.getCity());
                cityCount.put(new String(aPerson.getCity()), new Integer(count.intValue() + 1));
            }
        }
        System.out.println("::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::: C I T Y    C O U N T ");
        for(Map.Entry<String, Integer> entry : cityCount.entrySet()){
            System.out.println("City: "+entry.getKey()+ "::: count: "+entry.getValue());
        }
    }*/

    public  void countCity(){
        for (Person aPerson : persons){
            if(cityCount.get(aPerson.getCity())==null){
                cityCount.put(new String(aPerson.getCity()), new Integer(1));
            }else{
                Integer count = cityCount.get(aPerson.getCity());
                cityCount.put(new String(aPerson.getCity()), new Integer(count.intValue() + 1));
            }
        }
        System.out.println("::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::: C I T Y    C O U N T ");
        for(Map.Entry<String, Integer> entry : cityCount.entrySet()){
            System.out.println("City: "+entry.getKey()+ "::: count: "+entry.getValue());
        }
    }

    private Person convertData (String person) throws InvalidPersonProfileException {
        String[] splits = person.split(",");
        if(splits.length!=5) {
            throw new InvalidPersonProfileException();
        }else {
            if(splits[0] == null || splits[0].isEmpty() || splits[1] == null || splits[1].isEmpty())
                throw new InvalidPersonProfileException();
        }

        Person aPersonProfile = new Person();
        aPersonProfile.setFirstName(splits[0].trim().toUpperCase());
        aPersonProfile.setLastName(splits[1].trim().toUpperCase());

        if(splits[2] == null || splits[2].isEmpty() || splits[2].equals(" "))
            aPersonProfile.setAge("");
        else
            aPersonProfile.setAge(splits[2]);
        if(splits[3] == null || splits[3].isEmpty() || splits[3].equals(" "))
            aPersonProfile.setRole("");
        else
            aPersonProfile.setRole(splits[3].trim().toUpperCase());
        if(splits[4] == null || splits[4].isEmpty() || splits[4].equals(" ")) {
            aPersonProfile.setCity("EMPTY");
        }
        else {
            aPersonProfile.setCity(splits[4].trim().toUpperCase());
        }
        return aPersonProfile;
    }


}
