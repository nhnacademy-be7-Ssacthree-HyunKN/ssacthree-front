package com.nhnacademy.mini_dooray.ssacthree_front.commons.controller;

import com.nhnacademy.mini_dooray.ssacthree_front.elastic.exception.InvalidPageNumberException;
import com.nhnacademy.mini_dooray.ssacthree_front.member.exception.LoginFailedException;
import com.nhnacademy.mini_dooray.ssacthree_front.member.exception.PaycoConnectionFailedException;
import com.nhnacademy.mini_dooray.ssacthree_front.member.exception.SleepMemberLoginFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class WebControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("exception", e.getMessage());
        return "error";
    }

    @ExceptionHandler(LoginFailedException.class)
    public String handleLoginFailedException(LoginFailedException e,
        RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("loginFailedMessage", e.getMessage());
        return "redirect:/";
    }

    @ExceptionHandler(InvalidPageNumberException.class)
    public ModelAndView handleInvalidPageException(InvalidPageNumberException e) {
        ModelAndView modelAndView = new ModelAndView("error"); // error.html
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        modelAndView.addObject("exception", e.getMessage()); // 에러 메시지 모델에 추가
        return modelAndView;
    }

    @ExceptionHandler(PaycoConnectionFailedException.class)
    public String handlePaycoConnectionFailedException(PaycoConnectionFailedException e,
        RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("connectionResult", e.getMessage());
        return "redirect:/members/my-page";
    }


    @ExceptionHandler(SleepMemberLoginFailedException.class)
    public String handleSleepMemberLoginFailedException(SleepMemberLoginFailedException e,
        Model model) {
        String memberLoginId = e.getMemberLoginId();
        model.addAttribute("memberLoginId", memberLoginId);
        return "sleepMember";
    }

}
