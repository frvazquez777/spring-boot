package com.frvazquez.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frvazquez.model.CourseModel;
import com.frvazquez.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final Log LOG = LogFactory.getLog(CourseController.class);
	private static final String COURSES_VIEW = "courses";

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: listAllCourses");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("coursemodel", new CourseModel());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("coursemodel") CourseModel courseModel) {
		LOG.info("Call: addCourse  --- PARAM: " + courseModel);

		courseService.AddCourse(courseModel);
		return "redirect:/courses/listcourses";
	}

	@GetMapping("/deletecourse")
	public String deleteCourse(@RequestParam(name = "name") String name) {
		LOG.info("Call: Delete Course  --- PARAM: " + name);

		courseService.removeCourse(name);
		return "redirect:/courses/listcourses";
	}

	@GetMapping("/updatecourse")
	public String updateCourse(Model model, @RequestParam(name = "name") String name) {
		LOG.info("Call: Update Course  --- PARAM: " + name);

		CourseModel courseModel = courseService.updateCourse(name);
		courseModel.setSu(true);
		model.addAttribute("coursemodel", courseModel);
		return "courses";
	}
}
