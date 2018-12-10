package com.example.authority.controller;

import com.example.authority.service.CaptchaService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;


@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    CaptchaService captchaService;
    @GetMapping
    public String Index() {
        return "index后台返回的数据";
    }

    @PostMapping
    public String info() {
        return "info后台返回的数据";
    }

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        BufferedImage image=captchaService.getCaptcha(uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

}
