package com.web.furama.services.impl;

import com.web.furama.services.PaymentService;
import org.springframework.stereotype.Service;

@Service("paypal")
public class PaypalServiceImpl implements PaymentService {


    @Override
    public String getToken() {
        return "Get paypal token successful";
    }
}
