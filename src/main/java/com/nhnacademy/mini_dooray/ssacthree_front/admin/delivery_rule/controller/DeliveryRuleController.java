package com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.controller;

import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleCreateRequest;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleUpdateRequest;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.service.DeliveryRuleService;

import com.nhnacademy.mini_dooray.ssacthree_front.commons.exception.exception.ValidationFailedException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/delivery-rules")
public class DeliveryRuleController {

    private final DeliveryRuleService deliveryRuleService;

    @GetMapping
    public String deliveryRule(Model model) {
        model.addAttribute("deliveryRules", deliveryRuleService.getAllDeliveryRules());
        return "admin/deliveryRule/deliveryRules";
    }

    @PostMapping
    public String updateDeliveryRule(@Valid @ModelAttribute DeliveryRuleUpdateRequest deliveryRuleUpdateRequest,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        deliveryRuleService.updateDeliveryRule(deliveryRuleUpdateRequest);

        return "redirect:/admin/delivery-rules";
    }

    @GetMapping("/create")
    public String createDeliveryRule() {
        return "admin/deliveryRule/createDeliveryRule";
    }

    @PostMapping("/create")
    public String createDeliveryRule(@Valid @ModelAttribute DeliveryRuleCreateRequest deliveryRuleCreateRequest,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        deliveryRuleService.createDeliveryRule(deliveryRuleCreateRequest);

        return "redirect:/admin/delivery-rules";
    }
}
