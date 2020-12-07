package com.czy.jg.bean;

import java.io.Serializable;

/**
 * <p>
 * 机构-企业信息表
 * </p>
 *
 * @author Ln
 * @since 2020-02-13
 */
public class JgCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String companyId;
    /**
     * 机构名称
     */
    private String jgname;
    /**
     * 机构地址
     */
    private String jgaddress;
    /**
     * 统一社会信用代码
     */
    private String creditcode;
    /**
     * 固定资产（万元）
     */
    private String assets;
    /**
     * 成立日期
     */
    private String establishdate;
    /**
     * 开始工作日期
     */
    private String startdate;
    /**
     * 经济类型
     */
    private String economictype;
    /**
     * 批准成立机关
     */
    private String cloffice;
    /**
     * 手机号
     */
    private String mobilephone;
    /**
     * 传真
     */
    private String fax;
    /**
     * 所在地区(市级)
     */
    private String regionCity;
    /**
     * 所在地区(区域)
     */
    private String regionRegion;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 企业网址
     */
    private String website;
    /**
     * 营业执照登记机关
     */
    private String blrAuthority;
    /**
     * 邮政编码
     */
    private String postalcode;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 单位性质
     */
    private String unitproperty;
    /**
     * 检验检测（试验）设备价值（万元）
     */
    private String equipmentvalue;
    /**
     * 事业单位法人登记管理机关
     */
    private String sydwfrAuthority;
    /**
     * 事业单位法人证书编号
     */
    private String sydwfrCertificate;
    /**
     * 总人数
     */
    private String totalnumber;
    /**
     * 检验人员数
     */
    private String jyPeople;
    /**
     * 无损检测人员数
     */
    private String wsjcPeople;
    /**
     * 试验人员数
     */
    private String syPeople;
    /**
     * 技术负责人
     */
    private String jsfzPeople;
    /**
     * 技术负责人职称
     */
    private String jsfzTitle;
    /**
     * 机构类型
     */
    private String organizationtype;
    /**
     * 机构法人姓名
     */
    private String jgfrname;
    /**
     * 机构法人身份证
     */
    private String jgfrssfz;
    /**
     * 机构法人手机号
     */
    private String jgfrphone;
    /**
     * 代办人姓名
     */
    private String dbrname;
    /**
     * 代办人身份证
     */
    private String dbrssfz;
    /**
     * 代办人手机号
     */
    private String dbrphone;
    /**
     * 关联id
     */
    private String glId;
    /**
     * 修改状态
     */
    private String upType;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 更新时间
     */
    private String updatetime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * 获取主键
     *
     * @return 主键
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置主键
     *
     * @param companyId 主键
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取机构名称
     *
     * @return 机构名称
     */
    public String getJgname() {
        return jgname;
    }

    /**
     * 设置机构名称
     *
     * @param jgname 机构名称
     */
    public void setJgname(String jgname) {
        this.jgname = jgname;
    }

    /**
     * 获取机构地址
     *
     * @return 机构地址
     */
    public String getJgaddress() {
        return jgaddress;
    }

    /**
     * 设置机构地址
     *
     * @param jgaddress 机构地址
     */
    public void setJgaddress(String jgaddress) {
        this.jgaddress = jgaddress;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return 统一社会信用代码
     */
    public String getCreditcode() {
        return creditcode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param creditcode 统一社会信用代码
     */
    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode;
    }

    /**
     * 获取固定资产（万元）
     *
     * @return 固定资产（万元）
     */
    public String getAssets() {
        return assets;
    }

    /**
     * 设置固定资产（万元）
     *
     * @param assets 固定资产（万元）
     */
    public void setAssets(String assets) {
        this.assets = assets;
    }

    /**
     * 获取成立日期
     *
     * @return 成立日期
     */
    public String getEstablishdate() {
        return establishdate;
    }

    /**
     * 设置成立日期
     *
     * @param establishdate 成立日期
     */
    public void setEstablishdate(String establishdate) {
        this.establishdate = establishdate;
    }

    /**
     * 获取开始工作日期
     *
     * @return 开始工作日期
     */
    public String getStartdate() {
        return startdate;
    }

    /**
     * 设置开始工作日期
     *
     * @param startdate 开始工作日期
     */
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    /**
     * 获取经济类型
     *
     * @return 经济类型
     */
    public String getEconomictype() {
        return economictype;
    }

    /**
     * 设置经济类型
     *
     * @param economictype 经济类型
     */
    public void setEconomictype(String economictype) {
        this.economictype = economictype;
    }

    /**
     * 获取批准成立机关
     *
     * @return 批准成立机关
     */
    public String getCloffice() {
        return cloffice;
    }

    /**
     * 设置批准成立机关
     *
     * @param cloffice 批准成立机关
     */
    public void setCloffice(String cloffice) {
        this.cloffice = cloffice;
    }

    /**
     * 获取手机号
     *
     * @return 手机号
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * 设置手机号
     *
     * @param mobilephone 手机号
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * 获取传真
     *
     * @return 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取所在地区(市级)
     *
     * @return 所在地区(市级)
     */
    public String getRegionCity() {
        return regionCity;
    }

    /**
     * 设置所在地区(市级)
     *
     * @param regionCity 所在地区(市级)
     */
    public void setRegionCity(String regionCity) {
        this.regionCity = regionCity;
    }

    /**
     * 获取所在地区(区域)
     *
     * @return 所在地区(区域)
     */
    public String getRegionRegion() {
        return regionRegion;
    }

    /**
     * 设置所在地区(区域)
     *
     * @param regionRegion 所在地区(区域)
     */
    public void setRegionRegion(String regionRegion) {
        this.regionRegion = regionRegion;
    }

    /**
     * 获取邮箱
     *
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取企业网址
     *
     * @return 企业网址
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 设置企业网址
     *
     * @param website 企业网址
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * 获取营业执照登记机关
     *
     * @return 营业执照登记机关
     */
    public String getBlrAuthority() {
        return blrAuthority;
    }

    /**
     * 设置营业执照登记机关
     *
     * @param blrAuthority 营业执照登记机关
     */
    public void setBlrAuthority(String blrAuthority) {
        this.blrAuthority = blrAuthority;
    }

    /**
     * 获取邮政编码
     *
     * @return 邮政编码
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * 设置邮政编码
     *
     * @param postalcode 邮政编码
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * 获取所属行业
     *
     * @return 所属行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置所属行业
     *
     * @param industry 所属行业
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取单位性质
     *
     * @return 单位性质
     */
    public String getUnitproperty() {
        return unitproperty;
    }

    /**
     * 设置单位性质
     *
     * @param unitproperty 单位性质
     */
    public void setUnitproperty(String unitproperty) {
        this.unitproperty = unitproperty;
    }

    /**
     * 获取检验检测（试验）设备价值（万元）
     *
     * @return 检验检测（试验）设备价值（万元）
     */
    public String getEquipmentvalue() {
        return equipmentvalue;
    }

    /**
     * 设置检验检测（试验）设备价值（万元）
     *
     * @param equipmentvalue 检验检测（试验）设备价值（万元）
     */
    public void setEquipmentvalue(String equipmentvalue) {
        this.equipmentvalue = equipmentvalue;
    }

    /**
     * 获取事业单位法人登记管理机关
     *
     * @return 事业单位法人登记管理机关
     */
    public String getSydwfrAuthority() {
        return sydwfrAuthority;
    }

    /**
     * 设置事业单位法人登记管理机关
     *
     * @param sydwfrAuthority 事业单位法人登记管理机关
     */
    public void setSydwfrAuthority(String sydwfrAuthority) {
        this.sydwfrAuthority = sydwfrAuthority;
    }

    /**
     * 获取事业单位法人证书编号
     *
     * @return 事业单位法人证书编号
     */
    public String getSydwfrCertificate() {
        return sydwfrCertificate;
    }

    /**
     * 设置事业单位法人证书编号
     *
     * @param sydwfrCertificate 事业单位法人证书编号
     */
    public void setSydwfrCertificate(String sydwfrCertificate) {
        this.sydwfrCertificate = sydwfrCertificate;
    }

    /**
     * 获取总人数
     *
     * @return 总人数
     */
    public String getTotalnumber() {
        return totalnumber;
    }

    /**
     * 设置总人数
     *
     * @param totalnumber 总人数
     */
    public void setTotalnumber(String totalnumber) {
        this.totalnumber = totalnumber;
    }

    /**
     * 获取检验人员数
     *
     * @return 检验人员数
     */
    public String getJyPeople() {
        return jyPeople;
    }

    /**
     * 设置检验人员数
     *
     * @param jyPeople 检验人员数
     */
    public void setJyPeople(String jyPeople) {
        this.jyPeople = jyPeople;
    }

    /**
     * 获取无损检测人员数
     *
     * @return 无损检测人员数
     */
    public String getWsjcPeople() {
        return wsjcPeople;
    }

    /**
     * 设置无损检测人员数
     *
     * @param wsjcPeople 无损检测人员数
     */
    public void setWsjcPeople(String wsjcPeople) {
        this.wsjcPeople = wsjcPeople;
    }

    /**
     * 获取试验人员数
     *
     * @return 试验人员数
     */
    public String getSyPeople() {
        return syPeople;
    }

    /**
     * 设置试验人员数
     *
     * @param syPeople 试验人员数
     */
    public void setSyPeople(String syPeople) {
        this.syPeople = syPeople;
    }

    /**
     * 获取技术负责人
     *
     * @return 技术负责人
     */
    public String getJsfzPeople() {
        return jsfzPeople;
    }

    /**
     * 设置技术负责人
     *
     * @param jsfzPeople 技术负责人
     */
    public void setJsfzPeople(String jsfzPeople) {
        this.jsfzPeople = jsfzPeople;
    }

    /**
     * 获取技术负责人职称
     *
     * @return 技术负责人职称
     */
    public String getJsfzTitle() {
        return jsfzTitle;
    }

    /**
     * 设置技术负责人职称
     *
     * @param jsfzTitle 技术负责人职称
     */
    public void setJsfzTitle(String jsfzTitle) {
        this.jsfzTitle = jsfzTitle;
    }

    /**
     * 获取机构类型
     *
     * @return 机构类型
     */
    public String getOrganizationtype() {
        return organizationtype;
    }

    /**
     * 设置机构类型
     *
     * @param organizationtype 机构类型
     */
    public void setOrganizationtype(String organizationtype) {
        this.organizationtype = organizationtype;
    }

    /**
     * 获取机构法人姓名
     *
     * @return 机构法人姓名
     */
    public String getJgfrname() {
        return jgfrname;
    }

    /**
     * 设置机构法人姓名
     *
     * @param jgfrname 机构法人姓名
     */
    public void setJgfrname(String jgfrname) {
        this.jgfrname = jgfrname;
    }

    /**
     * 获取机构法人身份证
     *
     * @return 机构法人身份证
     */
    public String getJgfrssfz() {
        return jgfrssfz;
    }

    /**
     * 设置机构法人身份证
     *
     * @param jgfrssfz 机构法人身份证
     */
    public void setJgfrssfz(String jgfrssfz) {
        this.jgfrssfz = jgfrssfz;
    }

    /**
     * 获取机构法人手机号
     *
     * @return 机构法人手机号
     */
    public String getJgfrphone() {
        return jgfrphone;
    }

    /**
     * 设置机构法人手机号
     *
     * @param jgfrphone 机构法人手机号
     */
    public void setJgfrphone(String jgfrphone) {
        this.jgfrphone = jgfrphone;
    }

    /**
     * 获取代办人姓名
     *
     * @return 代办人姓名
     */
    public String getDbrname() {
        return dbrname;
    }

    /**
     * 设置代办人姓名
     *
     * @param dbrname 代办人姓名
     */
    public void setDbrname(String dbrname) {
        this.dbrname = dbrname;
    }

    /**
     * 获取代办人身份证
     *
     * @return 代办人身份证
     */
    public String getDbrssfz() {
        return dbrssfz;
    }

    /**
     * 设置代办人身份证
     *
     * @param dbrssfz 代办人身份证
     */
    public void setDbrssfz(String dbrssfz) {
        this.dbrssfz = dbrssfz;
    }

    /**
     * 获取代办人手机号
     *
     * @return 代办人手机号
     */
    public String getDbrphone() {
        return dbrphone;
    }

    /**
     * 设置代办人手机号
     *
     * @param dbrphone 代办人手机号
     */
    public void setDbrphone(String dbrphone) {
        this.dbrphone = dbrphone;
    }

    /**
     * 获取关联id
     *
     * @return 关联id
     */
    public String getGlId() {
        return glId;
    }

    /**
     * 设置关联id
     *
     * @param glId 关联id
     */
    public void setGlId(String glId) {
        this.glId = glId;
    }

    /**
     * 获取修改状态
     *
     * @return 修改状态
     */
    public String getUpType() {
        return upType;
    }

    /**
     * 设置修改状态
     *
     * @param upType 修改状态
     */
    public void setUpType(String upType) {
        this.upType = upType;
    }

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return 更新时间
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 所在国家
     */
    private String regionCountry;
    /**
     * 所在省
     */
    private String regionProvince;
    /**
     * 级别
     */
    private String jgLevel;
    /**
     * 营业执照注册号
     */
    private String registrationNumber;

    public String getRegionProvince() {
        return regionProvince;
    }

    public void setRegionCountry(String regionCountry) {
        this.regionCountry = regionCountry;
    }

    public String getRegionCountry() {
        return regionCountry;
    }

    public void setRegionProvince(String regionProvince) {
        this.regionProvince = regionProvince;
    }

    public void setJgLevel(String jgLevel) {
        this.jgLevel = jgLevel;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getJgLevel() {
        return jgLevel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "IclicJgCompany{" +
        ", companyId=" + companyId +
        ", jgname=" + jgname +
        ", jgaddress=" + jgaddress +
        ", creditcode=" + creditcode +
        ", assets=" + assets +
        ", establishdate=" + establishdate +
        ", startdate=" + startdate +
        ", economictype=" + economictype +
        ", cloffice=" + cloffice +
        ", mobilephone=" + mobilephone +
        ", fax=" + fax +
        ", regionCity=" + regionCity +
        ", regionRegion=" + regionRegion +
        ", email=" + email +
        ", website=" + website +
        ", blrAuthority=" + blrAuthority +
        ", postalcode=" + postalcode +
        ", industry=" + industry +
        ", unitproperty=" + unitproperty +
        ", equipmentvalue=" + equipmentvalue +
        ", sydwfrAuthority=" + sydwfrAuthority +
        ", sydwfrCertificate=" + sydwfrCertificate +
        ", totalnumber=" + totalnumber +
        ", jyPeople=" + jyPeople +
        ", wsjcPeople=" + wsjcPeople +
        ", syPeople=" + syPeople +
        ", jsfzPeople=" + jsfzPeople +
        ", jsfzTitle=" + jsfzTitle +
        ", organizationtype=" + organizationtype +
        ", jgfrname=" + jgfrname +
        ", jgfrssfz=" + jgfrssfz +
        ", jgfrphone=" + jgfrphone +
        ", dbrname=" + dbrname +
        ", dbrssfz=" + dbrssfz +
        ", dbrphone=" + dbrphone +
        ", glId=" + glId +
        ", upType=" + upType +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
