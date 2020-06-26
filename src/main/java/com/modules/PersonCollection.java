package main.java.com.modules;

import main.java.com.domain.Person;
import main.java.com.exceptions.InvalidPersonProfileException;

public class PersonCollection {

/*    Map<Integer, String> monthMap = new HashMap<Integer, String>();

    public void demoAdd(){

        monthMap.put(new Integer(1), new String("January"));
        monthMap.put(new Integer(2), "February");*/

    Person[] aPerson;
    int validListCounter;
    String[] cityName;
    int cityCount=0;
    int[] totalPersonCount;
    String result;

    public String popualteProfile (String[] personlist) {

        //System.out.println("Input data list length is " + personlist.length);
        validListCounter = 0;

        for (int counter=0; counter< personlist.length; counter++){
            try {
                convertData(personlist[counter]);
                validListCounter++;
            } catch (InvalidPersonProfileException exp){
            }
        }

        //System.out.println("Valid list count is: "+validListCounter);
        aPerson = new Person[validListCounter];
        cityName = new String[validListCounter];
        validListCounter = 0;

        for(int counter = 0; counter < personlist.length; counter++) {
            try {
                aPerson[validListCounter] = convertData(personlist[counter]);
                boolean uniqueCity=false;
                for(int secondCounter=0; secondCounter<validListCounter;secondCounter++){
                    if(cityName[secondCounter]!=null &&
                            aPerson[validListCounter].getCity().equals(cityName[secondCounter])){
                        uniqueCity=true;
                    }
                }
                if(!uniqueCity) {
                    cityName[cityCount] = aPerson[validListCounter].getCity();
                    cityCount++;
                                    }
                validListCounter++;
             } catch (InvalidPersonProfileException exp) {
                  result = "INVALID PERSON FULL NAME: "+personlist[counter];
                  // System.out.println("INVALID PERSON FULL NAME: "+personlist[counter]);
            }
        }
        //System.out.println("City count is "+cityCount);
        return result;
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

    public String[] printPersonProfile () {
        String[] printList = new String[validListCounter];
        for(int counter = 0; counter < validListCounter; counter++) {
            result = aPerson[counter].toString();
            //System.out.println(aPerson[counter].toString());
            printList[counter] = result;
        }
        return printList;
    }

    public String[] personCount () {
        totalPersonCount = new int[validListCounter];
        String[] result = new String[validListCounter];
        for (int counter=0; counter<aPerson.length; counter++){
            for (int nameCounter=0; nameCounter<cityCount; nameCounter++){
                if(cityName[nameCounter].equals(aPerson[counter].getCity())) {
                    totalPersonCount[nameCounter]++;
                }
            }
        }
        for(int counter=0; counter<cityCount; counter++) {
            result[counter] = ("City: " + cityName[counter] +" >> Person Count: "+totalPersonCount[counter]+", ");
        }
        return result;
    }

        /*public void personCount () {
        totalPersonCount = new int[validListCounter];
        for (int counter=0; counter<aPerson.length; counter++){
            for (int nameCounter=0; nameCounter<cityCount; nameCounter++){
                if(cityName[nameCounter].equals(aPerson[counter].getCity())) {
                    totalPersonCount[nameCounter]++;
                }
            }
        }
        System.out.println("::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::::  PERSON COUNT ::::::::::::");
        for (int counter=0;counter<cityCount;counter++){
            System.out.println("City: "+cityName[counter]+" >> Person Count: "+totalPersonCount[counter]);
        }
        System.out.println("::::::::::::::::::::::::::::::::::::");
    }*/
}