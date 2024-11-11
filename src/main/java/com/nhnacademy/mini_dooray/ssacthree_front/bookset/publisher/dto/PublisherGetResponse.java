package com.nhnacademy.mini_dooray.ssacthree_front.bookset.publisher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherGetResponse {
    private long publisherId;
    private String publisherName;
    private boolean publisherIsUsed;
}
