package com.pard.externalapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class KakaoDTO {

    private List<Document> documents;
    private Meta meta;

    @Data
    public static class Document {
        private Address address;
        @JsonProperty("address_name")
        private String addressName;
        @JsonProperty("address_type")
        private String addressType;
        @JsonProperty("road_address")
        private RoadAddress roadAddress;
        private String x;
        private String y;
    }

    @Data
    public static class Address {
        @JsonProperty("address_name")
        private String addressName;
        @JsonProperty("b_code")
        private String bCode;
        @JsonProperty("h_code")
        private String hCode;
        @JsonProperty("main_address_no")
        private String mainAddressNo;
        @JsonProperty("mountain_yn")
        private String mountainYn;
        @JsonProperty("region_1depth_name")
        private String region1DepthName;
        @JsonProperty("region_2depth_name")
        private String region2DepthName;
        @JsonProperty("region_3depth_h_name")
        private String region3DepthHName;
        @JsonProperty("region_3depth_name")
        private String region3DepthName;
        @JsonProperty("sub_address_no")
        private String subAddressNo;
        private String x;
        private String y;
    }

    @Data
    public static class RoadAddress {
        // RoadAddress fields (add as needed)
    }

    @Data
    public static class Meta {
        @JsonProperty("is_end")
        private boolean isEnd;
        @JsonProperty("pageable_count")
        private int pageableCount;
        @JsonProperty("total_count")
        private int totalCount;
    }
}


