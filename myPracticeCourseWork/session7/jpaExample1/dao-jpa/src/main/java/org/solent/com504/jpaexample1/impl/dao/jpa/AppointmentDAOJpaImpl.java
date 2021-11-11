/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.jpaexample1.impl.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.jpaexample1.model.dao.AppointmentDAO;
import org.solent.com504.jpaexample1.model.dto.Appointment;
import org.solent.com504.jpaexample1.model.dto.Person;

/**
 *
 * @author cgallen
 */
public class AppointmentDAOJpaImpl implements AppointmentDAO {

    final static Logger LOG = LogManager.getLogger(PersonDAOJpaImpl.class);

    private EntityManager entityManager;

    public AppointmentDAOJpaImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Appointment findById(Long id) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        return appointment;
    }

    @Override
    public Appointment save(Appointment appointment) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(appointment);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOG.error(ex);
            entityManager.getTransaction().rollback();
        }
        return appointment;
    }

    @Override
    public List<Appointment> findAll() {
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT a from Appointment a", Appointment.class);
        List<Appointment> appointmentList = q.getResultList();
        return appointmentList;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        try {
            Query q = entityManager.createQuery("DELETE FROM Appointment appointment WHERE appointment.id=:id");
            q.setParameter("id", id);
            q.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOG.error(ex);
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public Appointment delete(Appointment appointment) {
        deleteById(appointment.getId());
        return appointment;
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        try {
            entityManager.createQuery("DELETE FROM Appointment").executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOG.error(ex);
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Appointment> findByPersonA(Person personA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> findByPersonB(Person personB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> findByDate(Integer year, Integer month, Integer hour, Integer minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
