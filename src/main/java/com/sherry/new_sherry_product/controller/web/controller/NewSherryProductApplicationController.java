package com.sherry.new_sherry_product.controller.web.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

/**
 * @Author ： lpy
 * @Date : 21:58 2022/1/5
 */
@RestController
@RequestMapping("/NewSherryProductApplicationController")
@Api(value = "数据库Controller", tags = {"数据库相关接口"})
public class NewSherryProductApplicationController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "查询数据库最近十条")
    @PostMapping("/toMysql")
    public List<Map<String, Object>> toMysql() {
        String sql = " select * from test_mysql order by sysdate desc limit 10 ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                }
            }
        }
        Logger.getGlobal().info("------toMysql-----" + list);

        return list;
    }

    /**
     * 数据库添加一行
     *
     * @return
     */
    @ApiOperation(value = "新增数据库一行数据")
    @PostMapping("/addMysqlLine")
    public List<Map<String, Object>> addMysqlLine(@ApiParam("内容正文") @RequestParam(value = "Content", required = true) String Content) {
        String sql = " insert into test_mysql values (null, \'" + Content + "\', sysdate(), sysdate() ) ; ";
        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {

        } finally {
            sql = " select t.id, t.content as 内容正文, t.date_name as '时间' from test_mysql t order by t.sysdate desc limit 1 ; ";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            for (Map<String, Object> map : list) {
                Set<Map.Entry<String, Object>> entries = map.entrySet();
                if (entries != null) {
                    Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                    }
                }
            }
            return list;
        }
    }


}
