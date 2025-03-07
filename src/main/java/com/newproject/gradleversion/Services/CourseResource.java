package com.newproject.gradleversion.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseResource {

    private final Map<Integer, Course> courses;

    public CourseResource() {
        courses = new HashMap<>();

        Course c1 = new Course();
        c1.setId(1);
        c1.setName("Workshop Rest");
        c1.setDuration("24hs");

        Course c2 = new Course();
        c2.setId(2);
        c2.setName("Workshop Spring MVC");
        c2.setDuration("24hs");

        Course c3 = new Course();
        c3.setId(3);
        c3.setName("Java Backend Web Development");
        c3.setDuration("60hs");

        courses.put(1, c1);
        courses.put(2, c2);
        courses.put(3, c3);
    }

    @GetMapping
    public ResponseEntity<List<Course>> list() {
        return new ResponseEntity<>(new ArrayList<>(courses.values()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> fyndById(@PathVariable Integer id) {
        Course course = courses.get(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // if not found return code 404
        }
    }
}

