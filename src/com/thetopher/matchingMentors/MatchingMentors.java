package com.thetopher.matchingMentors;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: topher
 * Date: 9/30/11
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatchingMentors {

    public static void main(String[] args)
    {
        List<Person> pupils = createList(new String[]{"Zebulon", "Yaris", "Xavier", "Warren",
                "Vern", "Umlaut", "Topher", "Steve", "Ralph", "Quilleran"});
        List<Person> mentors = createList(new String[]{"Allen", "Bob", "Carl", "David", "Frank",
                "Greg", "Harold", "Ira", "Joel", "Klaus"});

        makeChoices(pupils, mentors);

        Solver[] solvers = new Solver[]{new RandomSolver(pupils, mentors)};
        for (Solver s : solvers)
        {
            clear(pupils, mentors);
            int score = s.solve();
            System.out.println("Solver: " + s.getClass().getCanonicalName());
            System.out.println("Score: " + score);
            System.out.println(s.solution());
        }
    }


    private static void clear(List<Person> pupils, List<Person> mentors)
    {
        for (Person p : pupils)
            p.clear();

        for (Person p : mentors)
            p.clear();
    }

    private static void makeChoices(List<Person> pupils, List<Person> mentors)
    {
        Set<Integer> done = new HashSet<Integer>();
        Random rand = new Random(1L);

        for (Person p : pupils)
        {
            done.clear();
            for (int i = 0; i < 5; ++i)
            {
                int choice;
                do {
                    choice = rand.nextInt(mentors.size());
                } while (done.contains(choice));

                p.addPerson(mentors.get(choice));
                done.add(choice);
            }
        }

        for (Person m : mentors)
        {
            done.clear();
            for (int i = 0; i < 5; ++i)
            {
                int choice;
                do {
                    choice = rand.nextInt(pupils.size());
                } while (done.contains(choice));

                m.addPerson(pupils.get(choice));
                done.add(choice);
            }
        }
    }

    private static List<Person> createList(String[] names)
    {
        List<Person> l = new ArrayList<Person>();
        for (String n : names)
            l.add(new Person(n));

        return l;
    }
}
