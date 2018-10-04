package util;


import model.Reservations;
import model.Court;
import model.Person;
import model.UsrReservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class HibernateUtil {

    SessionFactory sessionFactory;
    Session session;

    public HibernateUtil(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(UsrReservation.class);
        configuration.addAnnotatedClass(Court.class);
        configuration.addAnnotatedClass(Reservations.class);


        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(ssrb.build());
        session = sessionFactory.openSession();
    }

    public Session getSession(){
        if(session.isOpen()){
            return session;
        }else{
            session = sessionFactory.openSession();
            return session;
        }
    }
}
