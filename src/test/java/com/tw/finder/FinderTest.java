package com.tw.finder;

import com.google.common.collect.Lists;
import com.tw.finder.po.Student;
import com.tw.finder.po.Teacher;
import com.tw.finder.predicate.Predicate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.tw.finder.Finder.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by yunwang on 1/13/16.
 */
public class FinderTest {

    private ArrayList<Teacher> teachers;

    private ArrayList<Student> students;

    @Before
    public void setUp() throws Exception {
        students = Lists.newArrayList();
        students.add(Student.create("wy", 19, true));
        students.add(Student.create("xq", 17, true));
        students.add(Student.create("ym", 17, false));
        students.add(Student.create("fd", 18, true));
        students.add(Student.create("zx", 20, true));


        teachers = Lists.newArrayList();
        teachers.add(Teacher.create("wy", 19, true));
        teachers.add(Teacher.create("xq", 17, true));
        teachers.add(Teacher.create("ym", 17, false));
        teachers.add(Teacher.create("fd", 18, true));
        teachers.add(Teacher.create("zx", 20, true));
    }

    @Test
    public void testFindBySex() throws Exception {
        Predicate<Teacher> p = t -> !t.isMale();
        assertThat(find(teachers, p), notNullValue());
    }


    @Test
    public void testFindByAge() throws Exception {
        Predicate<Student> p = s -> s.getAge() == 18;
        assertThat(find(students, p), notNullValue());
    }

    @Test
    public void testFindByName() throws Exception {

        Predicate<Student> p = s -> s.getName().equals("wy");
        assertThat(find(students, p), notNullValue());
    }
}