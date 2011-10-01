package com.thetopher.matchingMentors;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: topher
 * Date: 9/30/11
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Solver {
    public abstract int solve();

    protected List<Person> pupils;
    protected List<Person> mentors;

    public Solver(List<Person> pupils, List<Person> mentors)
    {
        this.pupils = pupils;
        this.mentors = mentors;
    }

    protected int score()
    {
        int total = 0;

        for (Person p : pupils)
            total += p.getScore();

        for (Person m : mentors)
            total += m.getScore();

        return total;
    }


    public String solution()
    {
        StringBuilder s = new StringBuilder();

        s.append("Pupils:\n");
        for (Person p : pupils)
            s.append(p + "\n");

        s.append("\n");
        for (Person m : mentors)
                    s.append(m + "\n");

        return s.toString();
    }
}
