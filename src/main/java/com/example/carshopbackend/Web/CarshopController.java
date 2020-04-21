package com.example.carshopbackend.Web;

import com.example.carshopbackend.domain.BrandRepo;
import com.example.carshopbackend.domain.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarshopController {

    @Autowired
    private CarRepo crepo;
    @Autowired
    private BrandRepo brepo;

    @RequestMapping(value = {"/", "/carlist"})
    public String carlist (Model model){
        model.addAttribute("cars", crepo.findAll());
        return "carlist";
    }
}
