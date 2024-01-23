package com.pard.demo;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

public final class HmacSignature {

    public static String getAuthSignature(final String channelSecret, final String requestUri, final String queryOrBody, final String nonce) {
        String data = channelSecret + requestUri + queryOrBody + nonce;
        byte[] bytes = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, channelSecret.getBytes()).doFinal(data.getBytes());
        return new String(Base64.encodeBase64(bytes));
    }
    public static void main(String[] args) {
        String body = "transactionId=20140101123123123&orderId=1002045572";
        String channelSecret = "c7b46e51edd4f8f429e23df929e8df21";
        String requestUri = "/v3/payments";
        String nonce = UUID.randomUUID().toString();
        System.out.println("nonce : "+nonce);
        String signature = getAuthSignature(channelSecret,  requestUri ,body , nonce);

        System.out.println("signature : "+ signature);
        // TBC
    }
}