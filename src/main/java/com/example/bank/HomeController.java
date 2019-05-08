package com.example.bank;

import com.example.bank.models.Customer;
import com.example.bank.models.LoginAttempt;
import com.example.bank.models.customerNotes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    public final String INDEX = "index";
    public final String NOTES = "notes";


    private List<Customer> customers = new ArrayList<>();
    private List<customerNotes> cNotes = new ArrayList<>();

    @GetMapping({"/", "/index.html"})
    public String index() {
        System.out.println("Hver gang index.html bliver loaded bliver denne besked vist, lavet for at teste AJAX");
        return INDEX;
    }

    @GetMapping("/bank.html")
    public String bank(Model model, HttpSession session) {
        Object status = session.getAttribute("customerStatus");
        System.out.println(status);
        if(status !=null) {
            System.out.println("Er logget ind");
            model.addAttribute("customers", customers);
            return "bank";
        }
        else {
            System.out.println("Er ikke logget ind");
        }
        return "redirect:/index.html";
    }

    @PostMapping("/addUser")
    public String addUser(Customer customer, Model model) {
        customers.add(customer);
        model.addAttribute("customers", customers);
        return "redirect:/bank.html";
    }

    @GetMapping("/notes.html")
    public String notes(Model model) {
        model.addAttribute("notes", cNotes);
        System.out.println("Testing");
        return NOTES;
    }

    @PostMapping("/addNote")
    public String addNote(customerNotes notes) {
        cNotes.add(notes);
        notes.setId(cNotes.size()-1);
        return "redirect:/"+NOTES+".html";
    }

    @PostMapping("/editNote/{id}")
    public String editNote(@PathVariable("id") int id, customerNotes editNote) {
        cNotes.get(id).setNote(editNote.getNote());


        return "redirect:/"+NOTES+".html";
    }

    @PostMapping("/login")
    public String login(LoginAttempt loginAttempt, HttpSession session) {
        if(checkUser(loginAttempt)) {
            // hvis man har indtastet korrekte br. oplysninger
            session.setAttribute("customerStatus", "user");
            return "redirect:/bank.html";
        }
        else {
            session.removeAttribute("customerStatus");
        }
        return "redirect:/index.html";
    }

    private boolean checkUser(LoginAttempt loginAttempt) {
        return loginAttempt.getPassword().equals("12345");
    }

}
