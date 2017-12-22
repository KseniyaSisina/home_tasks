package ru.ivmiit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;
import ru.ivmiit.services.RegistrationService;
import ru.ivmiit.validators.UserRegistrationFormValidator;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserRegistrationFormValidator userRegistrationFormValidator;

    @InitBinder("userForm")
    public void initUserFormValidator(WebDataBinder binder) {
        binder.addValidators(userRegistrationFormValidator);
    }
    @PostMapping(value = "/signUp")
    public String addUser(@Valid @ModelAttribute("userForm") UserForm userForm,
                          BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/signUp";
        }

        User user = User.builder()
                .phone(userForm.getPhone()).build();
        registrationService.registration(userForm);
        String LOGIN = "levinskaya.ko@gmail.com";
        String MD5 = "18ce7b49fb41b0a32429847bb13a9d6f";
        String PHONE = user.getPhone();
        String TYPE = "biznes";
        String CIFR = "7";
        String request = "https://gate.smsaero.ru/send/" + "?user="
                + LOGIN + "&password="
                +  MD5+ "&to="
                +  PHONE
                + "&text=" + "Вы успешно зарегистрировались!"
                + "&from="
                + TYPE + "&type="
                + CIFR;
        System.out.println(request);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity(request,String.class);
        System.out.println(responseEntity.getBody());
        return "registration_success";
    }

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }
}
