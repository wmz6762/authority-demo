package com.example.authority.service;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.awt.image.BufferedImage;

@Service
public class CaptchaService {

    @Autowired
    private Producer producer;

    public BufferedImage getCaptcha(String uuid) throws Exception {
        if (StringUtils.isEmpty(uuid)) {
            throw new Exception("");
        }
        String code=producer.createText();

        return producer.createImage(code);
    }
}
