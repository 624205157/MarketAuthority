package com.zhhl.marketauthority.requestbean;

import java.util.Map;

public class ApplyCompanyRequestBean {
//    private String V_C_NAME;
//    private String V_LEGAL_PERSON;
//    private String D_CREATE_DATE;
//    private String FIXED_ASSETS;
//    private String REGISTERED_CAPITAL;
//    private String V_ADDRESS;
//    private String V_TRADE;
//    private String V_CREDIT_CODE;
//    private String V_APPROVE;
//    private String type;
//    private String V_PERSON_PHONE;
//    private String V_CONPANY_TYPE;
//    private String V_FR_SFZ;
    private String tjlx;
    private String PSZT;
    private String id;
    private String PSYJ;
    private String PSSJ;
    private Map<String,String> param;

    public String getTjlx() {
        return tjlx;
    }

    public void setTjlx(String tjlx) {
        this.tjlx = tjlx;
    }

    public String getPSZT() {
        return PSZT;
    }

    public void setPSZT(String PSZT) {
        this.PSZT = PSZT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPSYJ() {
        return PSYJ;
    }

    public void setPSYJ(String PSYJ) {
        this.PSYJ = PSYJ;
    }

    public String getPSSJ() {
        return PSSJ;
    }

    public void setPSSJ(String PSSJ) {
        this.PSSJ = PSSJ;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }
}
