package jsonxmlutils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import model.Address;
import model.Employee;
import model.Phone;

import java.io.File;

public class EmployeeXmlApp {
    public static void main(String[] args) {
        JAXBContext jaxbContext = null;
//        try {
//            jaxbContext = JAXBContext.newInstance(Employee.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
//            Employee employee = new Employee("Gor", "Aleksanyan", 24,new Address("Hrazdan","Armenia","Yerevanyan",0025),new Phone(776969488,"Phone"));
//            marshaller.marshal(employee, new File("employee.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Employee employee = (Employee) unmarshaller.unmarshal(new File("employee.xml"));
            System.out.println(employee.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
