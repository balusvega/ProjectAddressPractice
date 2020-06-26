package main.java.com.domain;

public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName;
    private String age;
    private String role;
    private String city;
    private String FullName;

    public String getFullName() {
        FullName=firstName+","+lastName;
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        String result = "";
        if ((firstName) != null || !firstName.isEmpty())
            result = result.concat("First Name is ").concat(this.firstName);
        if ((lastName) != null || !lastName.isEmpty())
            result = result.concat("; Last Name is ").concat(this.lastName);
        if (age != null || !age.isEmpty())
            result = result.concat("; Age is ").concat(this.age);
        if ((role) != null || !role.isEmpty())
            result = result.concat("; Role is ").concat(this.role);
        if ((city) != null || !city.isEmpty())
            result = result.concat("; City is ").concat(this.city);
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        boolean isEqual = false;

        if(obj instanceof Person){
            Person anotherPerson = (Person) obj;
            if(this.firstName.equals(anotherPerson.getFirstName())){
                if(this.lastName.equals(anotherPerson.getLastName())){
                    isEqual = true;
                }

            }
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode + this.firstName.hashCode() * 5 + this.lastName.hashCode() * 7;
        return hashCode;
    }

    @Override
    public int compareTo(Person otherPerson){
        int BEFORE = -1;
        int AFTER = 1;
        int EQUAL = 0;

        int returnInt = -1;

        if(this.firstName.compareTo(otherPerson.getFirstName())<0){
            returnInt = BEFORE;
        }else if(this.firstName.compareTo(otherPerson.getFirstName())>0){
            returnInt = AFTER;
        }else{
            if(this.lastName.compareTo(otherPerson.getLastName())<0){
                returnInt = BEFORE;
            }else if(this.lastName.compareTo(otherPerson.getLastName())>0) {
                returnInt = AFTER;
            }else{
                returnInt = EQUAL;
            }
        }
        return returnInt;

    }
}
