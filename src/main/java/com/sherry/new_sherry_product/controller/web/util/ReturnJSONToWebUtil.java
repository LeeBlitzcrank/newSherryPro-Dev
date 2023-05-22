package com.sherry.new_sherry_product.controller.web.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @PROJECT_NAME: new_sherry_product
 * @DESCRIPTION:
 * @USER: lipy6
 * @DATE: 2023/2/23 16:41
 */
public class ReturnJSONToWebUtil {
    public static void renderResult(HttpServletResponse response, Boolean res){
        JSONObject json=new JSONObject();
        json.put("code",res?0:1);
        json.put("msg",res?"成功":"失败");
        renderResult(response,json);
    }

    public static void renderResult(HttpServletResponse response,String res){
        JSONObject json=new JSONObject();
        json.put("msg",res);
        renderResult(response,json);
    }

    public static void renderResult(HttpServletResponse response, Object obj){
        PrintWriter out = null;
        try {
            String jsonArray = JSONObject.toJSONString(obj);
            response.setContentType(
                    "text/html;charset=utf-8");
            out = response.getWriter();
            out.println(jsonArray);
            out.flush();
            out.close();
            return;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

}
