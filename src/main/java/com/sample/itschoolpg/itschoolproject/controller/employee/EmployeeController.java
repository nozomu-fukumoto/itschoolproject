package com.sample.itschoolpg.itschoolproject.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.sample.itschoolpg.itschoolproject.entitiy.EmployeeEntity;
import com.sample.itschoolpg.itschoolproject.mapper.EmployeeMapper;


@Controller
public class EmployeeController {
  
  @Autowired
  EmployeeMapper employeeMapper;

  // 一覧画面表示機能
  @RequestMapping(value="/employee")
  public String showEmployeeList(Model model,@ModelAttribute("formModel") EmployeeEntity employeeEntity) {
    List<EmployeeEntity> employeeList = employeeMapper.selectAll();
    model.addAttribute("employeeList", employeeList);
    return "employee/employee_list";
  }

  // 検索結果の受け取り処理
  // @ModelAttributeでformからformModelを受け取り、
  // formModelから型(EmployeeEntity)と変数(employeeList)を指定する
  @RequestMapping(value="/employee/search")
  public String SearchEmployee(Model model, @ModelAttribute("formModel") EmployeeEntity employeeEntity) {
    List<EmployeeEntity> employeeList = employeeMapper.selectName(employeeEntity.getName());
    model.addAttribute("employeeList", employeeList);
    return "employee/employee_list";
  }

  // 詳細画面表示機能
  // @RequestParamから指定した変数で型(EmployeeEntity)と変数(employeeList)を指定する
  @GetMapping(value="/employee/")
  public String showEmployeeDetail(Model model, @RequestParam("id") long id) {
    List<EmployeeEntity> employeeList = employeeMapper.selectDetail(id);
    model.addAttribute("employeeList", employeeList);
    return "employee/employee_detail";
  }

  // 社員情報追加画面表示機能
  @RequestMapping(value="/employee/addpage")
  public String showEmployeeAddPage(Model model) {
    return "employee/employee_add";
  }

  // 社員情報追加機能
  @RequestMapping(value="/employee/addpage/add")
  public String addEmployee(EmployeeEntity employeeEntity) {
    employeeMapper.add(employeeEntity);
    return "redirect:/employee";
  }

  // 社員情報更新機能
  @RequestMapping(value="/employee/update")
  public String updateEmployee(EmployeeEntity employeeEntity) {
    employeeMapper.update(employeeEntity);
    return "redirect:/employee"; 
  }
  
  // 社員情報削除機能
  @RequestMapping(value="/employee/delete")
  public String deleteEmployee(Model model, @RequestParam("id") long id) {
    employeeMapper.delete(id);
    return "redirect:/employee"; 
  }

}
