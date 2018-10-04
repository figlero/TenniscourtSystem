package controller;

import model.Person;

public interface IPersonDAO {

    public Person createPerson(Person person);

    public Person readPerson(long id);

    public Person getPersonByName(String name);
}
