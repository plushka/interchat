package com.interchat.web.controller;

import com.interchat.domain.User;
import com.interchat.dto.UserDto;
import com.interchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") UserDto accountDto,
             BindingResult result, WebRequest request, Errors errors) {
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("index", "user", accountDto);
        }
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User toRegisterUser = new User();
        toRegisterUser.setEmail(accountDto.getEmail());
        toRegisterUser.setFirstName(accountDto.getFirstName());
        toRegisterUser.setLastName(accountDto.getLastName());
        toRegisterUser.setNickname(accountDto.getEmail());
        userService.addUser(toRegisterUser);
        return toRegisterUser;
    }
}
