package com.sherry.new_sherry_product.controller.web.model;

import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @PROJECT_NAME: new_sherry_product
 * @DESCRIPTION:
 * @USER: lipy6
 * @DATE: 2023/2/23 16:22
 */
public class ExcelModel {

    private static final long serialVersionUID = 1L;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public String getHealingId() {
        return healingId;
    }

    public void setHealingId(String healingId) {
        this.healingId = healingId;
    }

    public Integer getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Integer patientSex) {
        this.patientSex = patientSex;
    }

    public LocalDate getPatientBirthdate() {
        return patientBirthdate;
    }

    public void setPatientBirthdate(LocalDate patientBirthdate) {
        this.patientBirthdate = patientBirthdate;
    }

    public String getElseInfo() {
        return elseInfo;
    }

    public void setElseInfo(String elseInfo) {
        this.elseInfo = elseInfo;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPatientState() {
        return patientState;
    }

    public void setPatientState(Integer patientState) {
        this.patientState = patientState;
    }

    /**
     * 患者姓名
     */
    @TableField("patient_name")
    private String patientName;


    /**
     * 加密存储，不可反编译、列表不显示
     */
    @TableField("patient_identity")
    private String patientIdentity;


    /**
     * 就诊卡号
     */
    @TableField("healing_Id")
    private String healingId;


    /**
     * （性别）自动从身份证中截取
     */
    @TableField("patient_sex")
    private Integer patientSex;


    /**
     * (出生年月)自动从身份证中截取
     */
    @TableField("patient_birthDate")
    private LocalDate patientBirthdate;


    /**
     * 其他信息说明
     */
    @TableField("else_Info")
    private String elseInfo;


    /**
     * 创建人ID
     */
    @TableField("create_id")
    private Long createId;


    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


    @TableField("patient_state")
    private Integer patientState;


}
