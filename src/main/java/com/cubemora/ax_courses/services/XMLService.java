package com.cubemora.ax_courses.services;


import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cubemora.ax_courses.models.studentRepository;
import com.cubemora.ax_courses.models.students;





@Service
public class XMLService {
    private final studentRepository repository;

    public XMLService(studentRepository repository) {
        this.repository = repository;
    }

    public void exportDataToXml() {

        List<students> data = repository.findAll();
        

        System.out.println("Registros: " + data);

        try {
            
            studentsList studentList = new studentsList();
            studentList.setStudentList(data);

            JAXBContext context = JAXBContext.newInstance(studentsList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File("data.xml"); 
            marshaller.marshal(studentList, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 30000)
    public void scheduledExport() {
        exportDataToXml();
    }
}