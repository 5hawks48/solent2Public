/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.solent.com504.jpaexample1.test.dto.jaxb;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.jpaexample1.model.dto.Person;

/**
 *
 * @author Steven Hawkins <5hawks48@solent.ac.uk>
 */
public class ModelJaxbTest {
    
    @Test
    public void testJaxb(){
        try {   
        // test file we will write and read. 
        // Note in target folder so that will be deleted on each run and will not be saved to git
        File file = new File("target/testTransactionData.xml");
        System.out.println("writing test file to " + file.getAbsolutePath());
        
        // this contains a list of Jaxb annotated classes for the context to parse
            // NOTE you must also have a jaxb.index or ObjectFactory in the same classpath
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            try {
                Person p = new Person();            
                p.setFirstName("FirstName");
                jaxbMarshaller.marshal(p, file);
                
            } catch (Exception e) {
                throw new RuntimeException("Person error:", e);
            }


        } catch (JAXBException e) {
            throw new RuntimeException("problem testing jaxb marshalling", e);
        }
    }
}
