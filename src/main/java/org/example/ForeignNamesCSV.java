package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForeignNamesCSV {
    private static String fileName="foreign_names.csv";

   public static List<Person> getListOfPersons(){
        List<Person> persons=new ArrayList<>();

        CSVParser csvParser=new CSVParserBuilder().withSeparator(';').build();
        try(FileReader fileReader=new FileReader(fileName);
            CSVReader csvReader=new CSVReaderBuilder(fileReader)
                    .withCSVParser(csvParser)
                    .withSkipLines(1)
                    .build()){
            String[] str;            // массив из элементов считываемой строки
            while((str=csvReader.readNext())!=null){   // считываем строку из csv-файла
                // получаем id
                int id=Integer.parseInt(str[0]);
                // получаем имя
                String name=str[1];
                // получаем пол
                Gender gender = str[2].equals("Male") ? Gender.MALE : str[2].equals("Female") ? Gender.FEMALE : null;
                // получаем дату
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy");
                Date birthday=dateFormat.parse(str[3]);
                // создаем отдел с автогенерирующимся id
                Division division=new Division(str[4]);
                // получаем зарплату
                int salary=Integer.parseInt(str[5]);

                Person person=new Person(id, name, gender, birthday, division, salary);
                persons.add(person);
            }
        }
        catch(IOException | CsvValidationException | ParseException e){
            e.printStackTrace();
        }
        return persons;
    }

}
