package com.sherry.new_sherry_product.controller.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PROJECT_NAME: new_sherry_product
 * @DESCRIPTION:
 * @USER: lipy6
 * @DATE: 2023/3/9 16:28
 */
@Controller
public class WebController {
    @RequestMapping("/indexHome")
    public String sayHello() {
        return "index.html";
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/QRindex")
    public String QRindex() {
        return "QRProject/QR/index.html";
    }

    @RequestMapping("QRSvgIndex")
    public String QRSvgIndex() {
        return "QRProject/QR/index-svg.html";
    }

    @RequestMapping("/toHtml")
    public String toHome() {
        return "toHTML.html";
    }

    @RequestMapping("/toScanQR")
    public String toScanQR() {
        return "scanQR.html";
    }

    @RequestMapping("/vueIndexPage")
    public String vueIndexPage(){
        return "vueIndex.html";
    }

}
