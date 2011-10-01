package com.thetopher.matchingMentors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: topher
 * Date: 9/30/11
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PupilsPreferenceSolver extends Solver {

    public PupilsPreferenceSolver(List<Person> pupils, List<Person> mentors)
    {
        super(pupils, mentors);
    }

    public int solve()
    {
        Set<Person> flatSet = new HashSet<Person>();
        List<Set<Person>> setList = new ArrayList<Set<Person>>();

        for (int level = 0; level < pupils.get(0).getList().size(); ++level)
        {   Set<Person> cur = new HashSet<Person>();
            setList.add(cur);
            for (int m = 0; m < pupils.size(); ++m)
            {
                Person mentor = pupils.get(m).getList().get(level);
                if (flatSet.add(mentor))
                    cur.add(mentor);
            }
        }


        return score();
    }

    static class Tree<T>
    {
        private List<Tree<T>> childs;
        private T value;

        public Tree()
        {
            childs = new ArrayList<Tree<T>>();
        }

        public Tree(T value)
        {
            this.value = value;
            childs = new ArrayList<Tree<T>>();
        }

        public T getValue()
        {
            return value;
        }

        public void setValue(T value)
        {
            this.value = value;
        }

        public Tree<T> addChild(Tree<T> t)
        {
            childs.add(t);
            return this;
        }

        public List<Tree<T>> getChilds()
        {
            return childs;
        }

        public Tree<T> getChild(T c)
        {   int i = childs.indexOf(c);

            if (-1 == i)
                return null;
            else
                return childs.get(i);
        }
    }
}
