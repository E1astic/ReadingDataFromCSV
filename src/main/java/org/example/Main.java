package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons=ForeignNamesCSV.getListOfPersons();
        for(int i=0;i<10;++i){
            System.out.println(persons.get(i));
        }
    }
}