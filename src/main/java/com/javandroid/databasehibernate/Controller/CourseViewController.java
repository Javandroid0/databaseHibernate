package com.javandroid.databasehibernate.Controller;

import com.javandroid.databasehibernate.Service.CourseService;
import com.javandroid.databasehibernate.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseViewController {
    private final CourseService courseService;

    public CourseViewController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String courseList(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses";
    }

    @GetMapping("/new")
    public String showNewCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "course_form";
    }

    @PostMapping
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditCourseForm(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "course_form";
        }
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return "redirect:/courses";
    }
}
