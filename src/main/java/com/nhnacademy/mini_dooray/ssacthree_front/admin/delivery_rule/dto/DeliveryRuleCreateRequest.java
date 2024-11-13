package com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DeliveryRuleCreateRequest {

    @NotBlank
    private String deliveryRuleName;

    @NotNull
    @Min(0)
    private int deliveryFee;

    @Min(0)
    private int deliveryDiscountCost;
}
