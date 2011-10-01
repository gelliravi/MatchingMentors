package com.thetopher.matchingMentors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: topher
 * Date: 9/30/11
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private String name;
    private Person assigned;
    private ArrayList<Person> list;

    public Person(String name)
    {
        this.name = name;
        list = new ArrayList<Person>(5);
    }

    public Person addPerson(Person p)
    {
        list.add(p);
        return this;
    }

    public List<Person> getList()
    {
        return list;
    }

    public String getName()
    {
        return name;
    }

    public void setAssigned(Person p)
    {
        assigned = p;
    }

    public Person getAssigned()
    {
        return assigned;
    }

    public int getScore()
    {
        for (int i = 0; i < list.size(); ++i)
        {
            if (list.get(i).equals(assigned))
                return list.size() - i;
        }

        return 0;
    }

    public void clear()
    {
        assigned = null;

    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(name + "[" + getScore() + "](" + assigned.getName());
        s.append(") preferred: [");
        for (Person c : list)
        {
            if (c.equals(list.get(0)))
                s.append(c.name);
            else
                s.append(", " + c.name);
        }
        s.append("]");

        return s.toString();
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public boolean equals(Object o)
    {
        if (o instanceof Person)
        {
            return name.equals(((Person)o).getName());
        }

        return false;
    }
}
