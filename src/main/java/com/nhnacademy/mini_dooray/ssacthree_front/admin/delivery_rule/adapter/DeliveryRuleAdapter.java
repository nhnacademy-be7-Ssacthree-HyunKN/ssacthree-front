package com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.adapter;

import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleCreateRequest;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleGetResponse;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleUpdateRequest;
import com.nhnacademy.mini_dooray.ssacthree_front.commons.dto.MessageResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gateway-service", url = "${admin-client.url}", contextId = "deliveryRuleCustomerClient")
public interface DeliveryRuleAdapter {

    @GetMapping("/delivery-rules")
    ResponseEntity<List<DeliveryRuleGetResponse>> getAllDeliveryRules();

    @PutMapping("/delivery-rules")
    ResponseEntity<MessageResponse> updateDeliveryRule(
        @RequestBody DeliveryRuleUpdateRequest deliveryRuleUpdateRequest);

    @PostMapping("/delivery-rules")
    ResponseEntity<MessageResponse> createDeliveryRule(
        @RequestBody DeliveryRuleCreateRequest deliveryRuleCreateRequest);

}
