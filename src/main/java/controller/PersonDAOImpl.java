package controller;

import model.Person;
import org.hibernate.Session;
import util.BeanUtil;
import util.HibernateUtil;

import javax.persistence.Query;


public class PersonDAOImpl implements IPersonDAO{

    HibernateUtil hibernateUtil;
    Session session;

    public PersonDAOImpl(){
        hibernateUtil = BeanUtil.getBean("hibernateUtil");
        session = hibernateUtil.getSession();
    }

    @Override
    public Person createPerson(Person person) {
        session = hibernateUtil.getSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    @Override
    public Person readPerson(long id) {
        session = hibernateUtil.getSession();
        session.beginTransaction();
        Person person = session.load(Person.class, id);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    @Override
    public Person getPersonByName(String name) {
        session = hibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Person p WHERE p.name=:value");
        query.setParameter("value",name);
        Person person = (Person)query.getSingleResult();
        session.getTransaction().commit();
        return person;
    }
}
