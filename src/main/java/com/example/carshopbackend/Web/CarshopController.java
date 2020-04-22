package com.example.carshopbackend.Web;

import com.example.carshopbackend.domain.BrandRepo;
import com.example.carshopbackend.domain.Car;
import com.example.carshopbackend.domain.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class CarshopController {

    @Autowired
    private CarRepo crepo;
    @Autowired
    private BrandRepo brepo;

    @RequestMapping(value = {"/", "/cars"})
    public String carlist(Model model) {
        model.addAttribute("cars", crepo.findAll());
        return "cars";
    }

    @RequestMapping(value = "/cars/{id}")
    public String carById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("car", crepo.findById(id));
        return "cardetails";
    }

    @RequestMapping(value = "/addcar", method = RequestMethod.GET)
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("brands", brepo.findAll());
        return "addcar";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(Car car) {
        crepo.save(car);
        System.out.println(car.getId());
        return "redirect:cars";
    }

    @RequestMapping(value = "/editcar/{id}", method = RequestMethod.GET)
    public String editCar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("car", crepo.findById(id));
        System.out.println("Car from repo: " + crepo.findById(id).get().getId());
        model.addAttribute("brands", brepo.findAll());
        return "editcar";
    }

    @RequestMapping(value = "/deletecar/{id}/confirm", method = RequestMethod.GET)
    public String confirmDelete(@PathVariable("id") Long id, Model model) {
        model.addAttribute("car", crepo.findById(id));
        return "confirmationpage";
    }

    @RequestMapping(value = "/deletecar/{id}", method = RequestMethod.GET)
    private String deleteCar(@PathVariable("id") Long id) {
        crepo.deleteById(id);
        return "redirect:cars";
    }

    //REST


}
