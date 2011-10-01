package com.thetopher.matchingMentors;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: topher
 * Date: 9/30/11
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompleteSolver extends Solver {

    public CompleteSolver(List<Person> pupils, List<Person> mentors)
    {
        super(pupils, mentors);
    }

    @Override
    public int solve() {

        return score();
    }
}
