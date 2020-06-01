package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class CustomerController {
    private CustomerService customerService = new CustomerService();

    @GetMapping("/")
    public String index(Model model) {
        List<Customer> customerList = customerService.finAll();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("/customer/create")
    public ModelAndView showCustomer() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) Math.random() * 1000);
        customerService.Save(customer);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirec) {
        customerService.delete(id);
        redirec.addAttribute("success", "delete success");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "/edit";
    }

    @PostMapping("customer/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("success", "update success");
        return "redirect:/";
    }
}
