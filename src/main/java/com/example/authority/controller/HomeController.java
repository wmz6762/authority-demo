package com.example.authority.controller;

import com.example.authority.domain.dto.ImageCode;
import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/")
public class HomeController {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private Producer producer;

    @GetMapping
    public String Index() {
        return "index后台返回的数据";
    }

    @PostMapping
    public String info() {
        return "info后台返回的数据";
    }

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletRequest request,HttpServletResponse response, String uuid) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        String code=producer.createText();
        BufferedImage image=producer.createImage(code);
        ImageCode imageCode=new ImageCode(image,code, LocalDateTime.now().plusMinutes(1));
        sessionStrategy.setAttribute(new ServletWebRequest(request),"imagecode",imageCode);
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

}
