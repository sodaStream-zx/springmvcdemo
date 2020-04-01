package com.controller;

import com.model.Student;
import com.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author 一杯咖啡
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private BaseService studentService;

    /**
     * 请求中的时间参数格式
     */
    /*@InitBinder
    protected void initDate(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy/MM/dd"));
    }*/
    @RequestMapping("/findall")
    public ModelAndView list() {
        List<Student> list = studentService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("studentlist", list);
        mv.setViewName("/student/list");
        return mv;
    }

    /**
     * 添加单个
     */
    @RequestMapping(value = "/addpage")
    public String addpage() {
        return "/student/add";
    }

    @RequestMapping(value = "/addone", method = RequestMethod.POST)
    public String save(Model model, @Valid Student student) {
        Boolean flag = studentService.add(student);
        if (flag) {
            model.addAttribute("msg", "添加成功");
        } else {
            model.addAttribute("msg", "添加失败");
        }
        //redirect 重定向 forward 请求转发
        return "forward:/student/findall";
    }

    /**
     * 删除单个
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "sid", required = true) Integer id, Model model) {
        boolean flag = studentService.delete(id);
        if (flag) {
            model.addAttribute("msg", "删除成功");
        } else {
            model.addAttribute("msg", "删除失败");
        }
        return "forward:/student/findall";
    }

    /**
     * 修改单个
     */
    @RequestMapping(value = "/changepage/{id}")
    public String changepage(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("id", id);
        Student student = (Student) studentService.findOne(id);
        model.addAttribute("student", student);
        return "/student/change";
    }

    @RequestMapping(value = "/updateone", method = RequestMethod.POST)
    public String changeone(@Valid Student student, Model model) {
        boolean flag = studentService.fresh(student);
        if (flag) {
            model.addAttribute("msg", "修改成功");
        } else {
            model.addAttribute("msg", "修改失败");
        }
        return "forward:/student/findall";
    }

    /**
     * 查询单个
     */
   /* @ModelAttribute
    public void findaOne(@PathVariable(value = "id") Integer id,Model model){
      model.addAttribute("student",(Student) studentService.findOne(id));

    }*/
    @RequestMapping(value = "/findone/{id}")
    public String showOne(Model model, @PathVariable(value = "id") Integer id) {
        System.out.println("contains:" + model.containsAttribute("student") + " :" + id);
        model.addAttribute("msg", model.containsAttribute("student"));
        return "forward:/student/findall";
    }

    @RequestMapping(value = "/time")
    @ResponseBody
    public String ShowTime(@RequestParam(name = "d") Date date) {
        System.out.println(date);
        return "time";
    }
}
