package com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.service.impl;

import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.adapter.DeliveryRuleAdapter;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleCreateRequest;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleGetResponse;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.dto.DeliveryRuleUpdateRequest;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.exception.DeliveryRuleCreateFailedException;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.exception.DeliveryRuleGetFailedException;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.exception.DeliveryRuleUpdateFailedException;
import com.nhnacademy.mini_dooray.ssacthree_front.admin.delivery_rule.service.DeliveryRuleService;
import com.nhnacademy.mini_dooray.ssacthree_front.commons.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryRuleServiceImpl implements DeliveryRuleService {

    private final DeliveryRuleAdapter deliveryRuleAdapter;

    @Override
    public MessageResponse createDeliveryRule(DeliveryRuleCreateRequest deliveryRuleCreateRequest) {
        ResponseEntity<MessageResponse> response = deliveryRuleAdapter.createDeliveryRule(deliveryRuleCreateRequest);

        try {
            if(response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
            throw new DeliveryRuleCreateFailedException("배송정책 생성에 실패하였습니다.");
        }
        catch (HttpClientErrorException | HttpServerErrorException e ) {
            throw new DeliveryRuleCreateFailedException("배송정책 생성에 실패하였습니다.");
        }
    }

    @Override
    public List<DeliveryRuleGetResponse> getAllDeliveryRules() {
        ResponseEntity<List<DeliveryRuleGetResponse>> response = deliveryRuleAdapter.getAllDeliveryRules();

        try {
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
            throw new DeliveryRuleGetFailedException("배송정책 조회에 실패하였습니다.");
        } catch (HttpClientErrorException | HttpServerErrorException e ) {
            throw new DeliveryRuleGetFailedException("배송정책 조회에 실패하였습니다.");
        }
    }

    @Override
    public MessageResponse updateDeliveryRule(DeliveryRuleUpdateRequest deliveryRuleUpdateRequest) {
        ResponseEntity<MessageResponse> response = deliveryRuleAdapter.updateDeliveryRule(deliveryRuleUpdateRequest);

        try {
            if(response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
            throw new DeliveryRuleUpdateFailedException("배송정책 수정에 실패하였습니다.");
        }
        catch (HttpClientErrorException | HttpServerErrorException e ) {
            throw new DeliveryRuleUpdateFailedException("배송정책 수정에 실패하였습니다.");
        }
    }
}
