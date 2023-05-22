package com.sherry.new_sherry_product.controller.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sherry.new_sherry_product.controller.web.model.ExcelModel;
import com.sherry.new_sherry_product.controller.web.service.ExcelModelService;
import com.sherry.new_sherry_product.controller.web.util.ReadExcelUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sherry.new_sherry_product.controller.web.util.ReturnJSONToWebUtil.renderResult;

/**
 * @PROJECT_NAME: new_sherry_product
 * @DESCRIPTION:
 * @USER: lipy6
 * @DATE: 2023/2/23 16:35
 */
public class ReadExcelController {
    @PostMapping("/excelExport")
    public void test(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="file",required = false) MultipartFile file){
        long startTime = System.currentTimeMillis();
        List<String> list = new ArrayList();
        Map<String,Object> res = new HashMap<>();
        int row=1;
        int rowSuccess=0;
        Integer errorCount=0;
        QueryWrapper<ExcelModel> wrapper;
//        ReadExcel readExcel = new ReadExcel();
        List<ExcelModel> excelInfo = ReadExcelUtil.getExcelInfo(file);
        for (ExcelModel patientInfo : excelInfo) {
//            System.out.println(patientInfo);
            wrapper=new QueryWrapper<>();
            row++;
            patientInfo.setHealingId(patientInfo.getHealingId());
            wrapper.eq("healing_Id", patientInfo.getHealingId());
            wrapper.ne("patient_state", 9);
            //业务代码，通过患者id查询数据库中式否有该患者，如果已存在，则不保存，跳过该患者
//            int patientCount = ExcelModelService.getBaseMapper().getPatientCount(wrapper);
//            if (patientCount>0){
//                list.add("在第"+row+"行的<"+patientInfo.getHealingId()+">患者已存在！！");
//                errorCount++;
//            }else {
//                boolean save = ExcelModelService.save(patientInfo);
//                if (save){
//                    rowSuccess++;
//                }
//            }
        }
        if (list.size()>0){
            res.put("log", list);
        }
        res.put("success", "导入数据成功条数:"+rowSuccess);
        res.put("error", "导入数据失败条数:"+errorCount);
        long endTime = System.currentTimeMillis();
        String time = String.valueOf((endTime - startTime) / 1000);
        res.put("time", "导入数据用时:"+time+"秒");
        renderResult(response, res);
    }

}
