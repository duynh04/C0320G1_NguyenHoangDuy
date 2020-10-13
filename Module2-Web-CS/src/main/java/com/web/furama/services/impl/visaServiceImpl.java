package com.web.furama.services.impl;

import com.web.furama.services.PaymentService;
import org.springframework.stereotype.Service;

@Service("visa")
public class visaServiceImpl implements PaymentService {

    @Override
    public String getToken() {
        return "Get visa token successful";
    }
}
