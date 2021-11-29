/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.jpaexample1.impl.dao.jpa.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.jpaexample1.impl.dao.jpa.DAOFactoryJPAImpl;
import org.solent.com504.jpaexample1.model.dao.AppointmentDAO;
import org.solent.com504.jpaexample1.model.dao.PersonDAO;
import org.solent.com504.jpaexample1.model.dto.Appointment;
import org.solent.com504.jpaexample1.model.dto.Person;


/**
 *
 * @author cgallen
 */
public class AppointmentDAOTest {

    final static Logger LOG = LogManager.getLogger(AppointmentDAOTest.class);

    private AppointmentDAO appointmentDao = null;

    private DAOFactoryJPAImpl daoFactory = new DAOFactoryJPAImpl();

    @Before
    public void before() {
        appointmentDao = daoFactory.getAppointmentDAO();
        appointmentDao.deleteAll();
        assertNotNull(appointmentDao);
    }

    @Test
    public void createAppointmentDAOTest() {
        LOG.debug("start of createAppointmentDAOTest(");
        appointmentDao.deleteAll();
        Appointment appointment = new Appointment();
        appointment.setHr(1);
        appointmentDao.save(appointment);
        
        List<Appointment> apps = appointmentDao.findAll();
        assertEquals(1, apps.size());
        // this test simply runs the before method
        LOG.debug("end of createAppointmentDAOTest(");
    }
    
    @Test
    public void addPersonToAppointmentTest() {
        LOG.debug("start of addPersonToAppointmentTest(");
        PersonDAO personDao = daoFactory.getPersonDAO();
        appointmentDao.deleteAll();
        Appointment appointment = new Appointment();
        appointment.setHr(1);
        Person personA = new Person();
        personA.setFirstName("FirstName");
        personDao.save(personA);
        appointment.setPersonA(personA);
        appointmentDao.save(appointment);
        List<Appointment> apps = appointmentDao.findAll();
        assertEquals(1, apps.size());
        // this test simply runs the before method
        LOG.debug("end of createAppointmentDAOTest(");
    }
    
    
    
    
    
    
    
}
