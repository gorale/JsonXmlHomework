package jsonxmlutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import model.Address;
import model.Employee;
import model.Phone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeApp {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Employee> employeeList = new ArrayList<>(3);
/*
        employeeList.add(new Employee("Gor", "Aleksanyan", 24,new Address("Hrazdan","Armenia","Yerevanyan",0025),new Phone(776969488,"Phone")));
        employeeList.add(new Employee("Tigran", "Tigranyan", 29,new Address("Hrazdan","Armenia","Raykom",0045),new Phone(44122312,"Phone")));


        try (FileWriter writer = new FileWriter("employee.json")) {
            gson.toJson(employeeList,
                    writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        try (FileReader reader = new FileReader("employee.json")) {
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            for (JsonElement jsonElement : jsonArray) {
                String firstName = String.valueOf(jsonElement.getAsJsonObject().get("firstName"));
                String lastName = String.valueOf(jsonElement.getAsJsonObject().get("lastName"));
                String age1 = String.valueOf(jsonElement.getAsJsonObject().get("age"));
                int age = Integer.parseInt(age1);
                String city = String.valueOf(jsonElement.getAsJsonObject().getAsJsonObject("address").get("city"));
                String country = String.valueOf(jsonElement.getAsJsonObject().getAsJsonObject("address").get("country"));
                String street = String.valueOf(jsonElement.getAsJsonObject().getAsJsonObject("address").get("street"));
                String postalCode = String.valueOf(jsonElement.getAsJsonObject().getAsJsonObject("address").get("postalCode"));
                int postal = Integer.parseInt(postalCode);
                String phone1 = String.valueOf(jsonElement.getAsJsonObject().getAsJsonObject("phone").get("number"));
                int phone = Integer.parseInt(phone1);
                String type = String.valueOf(jsonElement.getAsJsonObject().getAsJsonObject("phone").get("type"));

                Employee employee = new Employee(firstName,lastName,age,new Address(city,country,street,postal),new Phone(phone,type));
                System.out.println(employee);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
