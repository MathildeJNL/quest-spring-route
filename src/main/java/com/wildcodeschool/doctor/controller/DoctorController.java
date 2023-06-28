package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    //récupérer le numéro du docteur
    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable Integer number) {
    //créer un docteur avec le nom et le numéro correspondant
        if(number >= 1 && number < 13 ){
            //303
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        }else if(number == 13){
            //créer le docteur à renvoyer
            return new Doctor(number, "Jodie Whittaker");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Impossible de récupérer l'incarnation %d", number));
    }
}
