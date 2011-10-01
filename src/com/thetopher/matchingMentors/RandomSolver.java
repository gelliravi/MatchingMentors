package com.thetopher.matchingMentors;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: topher
 * Date: 9/30/11
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomSolver extends Solver {

    public RandomSolver(List<Person> pupils, List<Person> mentors)
    {
        super(pupils, mentors);
    }

    public int solve()
    {
        Random rand = new Random();
        Set<Integer> done = new HashSet<Integer>();

        for (Person p : pupils)
        {
            int v;
            do {
                v = rand.nextInt(mentors.size());
            } while(done.contains(v));

            p.setAssigned(mentors.get(v));
            mentors.get(v).setAssigned(p);
            done.add(v);
        }

        return score();
    }



}
