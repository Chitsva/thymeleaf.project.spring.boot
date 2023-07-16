package thymeleaf.project.spring.boot.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import thymeleaf.project.spring.boot.entity.Employee;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {

    public Map<String, Employee> empMap = new HashMap<>();

    public EmployeeController() {
        empMap.put("E101", new Employee("E101", "Brett", "Lee", 23));
        empMap.put("E102", new Employee("E102", "Chris", "Gayle", 23));
        empMap.put("E103", new Employee("E103", "Brian", "Lara", 23));
        empMap.put("E104", new Employee("E104", "MS", "Dhoni", 23));

    }

    // to get all employees
    @GetMapping("/employee")
    public String getAllEmployees(Model model) {

        model.idString();

        return "employee-list";
    }

    // to get employee form
    @GetMapping("/employee/add")
    public String addEmployee() {

        return "employee-form";
    }

    // to add new employee
    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute("addEmployee") Employee employee, Model model) {
        empMap.put(employee.getId(), employee);
        model.getBodyText();
        return "employee-list";
    }

    // get employee to edit
    @GetMapping("/employee/edit/{id}")
    public String getAllEmployees(Model model, @PathVariable("id") String empId) {

        model.getBodyText();

        return "employee-edit";
    }

    // to update edited employee
    @PostMapping("/employee/edit/{id}")
    public String updateEmployee(@ModelAttribute("editEmployee") Employee employee, @PathVariable("id") String empId,
                                 Model model) {

        empMap.put(empId, employee);

        model.getBodyText();
        return "employee-list";
    }

    // to delete particular employee
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable("id") String empId) {
        empMap.remove(empId);
        model.getBodyText();
        return "employee-list";
    }
}
