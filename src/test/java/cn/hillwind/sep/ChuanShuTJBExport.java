package cn.hillwind.sep;

/**
 * 传输统计表导出.
 * 日期类型以Long表示，为毫秒数，可以通过 new Date(longValue)得到一个Date对象。
 */
public class ChuanShuTJBExport {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     */
    private Long id;

    /**
     * 项目编号
     *
     */
    private String csbh;

    /**
     * 册号
     *
     */
    private String fence;

    /**
     * 项目名称
     *
     */
    private String xmmc;

    /**
     * 项目负责人
     *
     */
    private String xmfzr;

    /**
     * 项目类别
     * 二平面、WLAN、专线、基站、室分、市政、其他、骨干层、汇聚层
     */
    private String xmlb;

    /**
     * 工程属性
     * 管道,光缆,设备,客户端
     */
    private String gcsx;

    /**
     * 工单编号
     *
     */
    private String gdbh;

    /**
     * 专线编号/加站编号
     *
     */
    private String ghbh;

    /**
     * 工单日期
     * date
     */
    private Long gdrq;

    /**
     * 预警日期
     * date
     */
    private Long yjrq;

    /**
     * 回单日期
     * date
     */
    private Long hdrq;

    /**
     * 单项名称
     *
     */
    private String dxmc;

    /**
     * 工程地址
     *
     */
    private String gcdz;

    /**
     * 发起单位
     * 宝山,北区,崇明,奉贤,嘉定,金山,闵行,南汇,南区,浦东,青浦,松江,西区,优化,信息,视频,行政
     */
    private String fqdw;

    /**
     * 所属区域
     * 宝山,北区,崇明,奉贤,嘉定,金山,闵行,南汇,南区,浦东,青浦,松江,西区,优化,信息,视频,行政
     */
    private String ssqy;

    /**
     * 行政区域
     * 黄浦,卢湾,静安,徐汇,浦东,长宁,虹口,杨浦,普陀,闸北,闵行,宝山,嘉定,青浦,奉贤,南汇,崇明,金山,松江
     */
    private String xzqy;

    /**
     * 集客/属地联系人
     *
     */
    private String sdlxr;

    /**
     * 集客/属地联系方式
     *
     */
    private String sdlxfs;

    /**
     * 客户/购租联系人
     *
     */
    private String gzlxr;

    /**
     * 客户/购租联系方式
     *
     */
    private String gzlxfs;

    /**
     * 路名
     *
     */
    private String luming;

    /**
     * 路段
     *
     */
    private String luduan;

    /**
     * 长度（米）
     *
     */
    private String changdu;

    /**
     * 孔数/芯数
     *
     */
    private String kongshu;

    /**
     * 总投资（元）
     *
     */
    private String ztz;

    /**
     * 施工费（元）
     *
     */
    private String gcf;

    /**
     * 设计费（元）
     *
     */
    private String sjf;

    /**
     * 监理费（元）
     *
     */
    private String jlf;

    /**
     * 设计文本送交工程部日期
     * date
     */
    private Long sjwbsjgcbrq;

    /**
     * 册名
     *
     */
    private String ceming;

    /**
     * 设计说明备注
     *
     */
    private String sjsmbz;

    /**
     * 设计单位名称
     * 全称
     */
    private String designName;

    /**
     * 监理单位名称
     * 全称
     */
    private String supervisionName;

    /**
     * 施工单位名称
     * 全称
     */
    private String constructionName;

    /**
     * 设计单位_PSP_ID
     * 给管线系统用
     */
    private String designCompanyId;

    /**
     * 监理单位_PSP_ID
     * 给管线系统用
     */
    private String supervisionCompanyId;

    /**
     * 施工单位_PSP_ID
     * 给管线系统用
     */
    private String constructionCompanyId;

    /**
     * 设计单位_PMS_REF_ID
     * 给PMS用
     */
    private String designCompanyRefId;

    /**
     * 监理单位_PMS_REF_ID
     * 给PMS用
     */
    private String supervisionCompanyRefId;

    /**
     * 施工单位_PMS_REF_ID
     * 给PMS用
     */
    private String constructionCompanyRefId;

    /**
     * 委托时间
     * date
     */
    private Long dxwtsj;

    /**
     * 是否办理管照
     * 是、否
     */
    private String sfblgz;

    /**
     * 备注
     *
     */
    private String bzqk;

    /**
     * 设计文本分发日期
     * date
     */
    private Long sjwbffrq;

    /**
     * 施工情况
     * 未开工,在建,完工,受阻,无法实施,站点取消
     */
    private String sgqk;

    /**
     * 施工情况简述
     *
     */
    private String sgqkjs;

    /**
     * 预计完工时间
     * date
     */
    private Long yjwgsj;

    /**
     * 完工时间
     * date
     */
    private Long wgrq;

    /**
     * 竣工资料提交时间
     * date
     */
    private Long jgzltjsj;

    /**
     * 管照办理情况
     * 办理中,管照已上交,情况说明已上交,无需办理
     */
    private String gzblqk;

    /**
     * 施工备注
     *
     */
    private String sgbz;

    /**
     * 竣工资料确认日期
     * date
     */
    private String jgzl;

    /**
     * 监理资料提交日期
     * date
     */
    private Long jlzltjsj;

    /**
     * 录入日期
     * date
     */
    private Long lrrq;

    /**
     * 录入情况
     *
     */
    private String lrqk;

    /**
     * 施工采购订单号
     *
     */
    private String sghtcgddh;

    /**
     * 验收日期
     * date
     */
    private Long ysrq;

    /**
     * 转资日期
     * date
     */
    private Long zzrq;

    /**
     * 转资情况
     *
     */
    private String zzqk;

    /**
     * 送审日期
     * date
     */
    private Long ssrq;

    /**
     * 送审情况
     * (未送审,审核中,审核通过)
     */
    private String ssqk;

    /**
     * 三方章确认日期
     * date
     */
    private String sfzqrrq;

    /**
     * 完工用时(天)
     *
     */
    private Integer wgys;

    /**
     * 设计出版用时(天)
     *
     */
    private Integer sjcbys;

    /**
     * 竣工资料用时(天)
     *
     */
    private Integer jgzlzzys;

    /**
     * 监理出版用时(天)
     *
     */
    private Integer jlcbys;

    /**
     * 录入用时(天)
     *
     */
    private Integer lrys;

    /**
     * 移交资产用时(天)
     *
     */
    private Integer yjzcys;

    /**
     * 转资用时(天)
     *
     */
    private Integer zzys;

    /**
     * 送审用时(天)
     *
     */
    private Integer ssys;

    /**
     * 审计用时(天)
     *
     */
    private Integer sjys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCsbh() {
        return csbh;
    }

    public void setCsbh(String csbh) {
        this.csbh = csbh;
    }

    public String getFence() {
        return fence;
    }

    public void setFence(String fence) {
        this.fence = fence;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getXmfzr() {
        return xmfzr;
    }

    public void setXmfzr(String xmfzr) {
        this.xmfzr = xmfzr;
    }

    public String getXmlb() {
        return xmlb;
    }

    public void setXmlb(String xmlb) {
        this.xmlb = xmlb;
    }

    public String getGcsx() {
        return gcsx;
    }

    public void setGcsx(String gcsx) {
        this.gcsx = gcsx;
    }

    public String getGdbh() {
        return gdbh;
    }

    public void setGdbh(String gdbh) {
        this.gdbh = gdbh;
    }

    public String getGhbh() {
        return ghbh;
    }

    public void setGhbh(String ghbh) {
        this.ghbh = ghbh;
    }

    public Long getGdrq() {
        return gdrq;
    }

    public void setGdrq(Long gdrq) {
        this.gdrq = gdrq;
    }

    public Long getYjrq() {
        return yjrq;
    }

    public void setYjrq(Long yjrq) {
        this.yjrq = yjrq;
    }

    public Long getHdrq() {
        return hdrq;
    }

    public void setHdrq(Long hdrq) {
        this.hdrq = hdrq;
    }

    public String getDxmc() {
        return dxmc;
    }

    public void setDxmc(String dxmc) {
        this.dxmc = dxmc;
    }

    public String getGcdz() {
        return gcdz;
    }

    public void setGcdz(String gcdz) {
        this.gcdz = gcdz;
    }

    public String getFqdw() {
        return fqdw;
    }

    public void setFqdw(String fqdw) {
        this.fqdw = fqdw;
    }

    public String getSsqy() {
        return ssqy;
    }

    public void setSsqy(String ssqy) {
        this.ssqy = ssqy;
    }

    public String getXzqy() {
        return xzqy;
    }

    public void setXzqy(String xzqy) {
        this.xzqy = xzqy;
    }

    public String getSdlxr() {
        return sdlxr;
    }

    public void setSdlxr(String sdlxr) {
        this.sdlxr = sdlxr;
    }

    public String getSdlxfs() {
        return sdlxfs;
    }

    public void setSdlxfs(String sdlxfs) {
        this.sdlxfs = sdlxfs;
    }

    public String getGzlxr() {
        return gzlxr;
    }

    public void setGzlxr(String gzlxr) {
        this.gzlxr = gzlxr;
    }

    public String getGzlxfs() {
        return gzlxfs;
    }

    public void setGzlxfs(String gzlxfs) {
        this.gzlxfs = gzlxfs;
    }

    public String getLuming() {
        return luming;
    }

    public void setLuming(String luming) {
        this.luming = luming;
    }

    public String getLuduan() {
        return luduan;
    }

    public void setLuduan(String luduan) {
        this.luduan = luduan;
    }

    public String getChangdu() {
        return changdu;
    }

    public void setChangdu(String changdu) {
        this.changdu = changdu;
    }

    public String getKongshu() {
        return kongshu;
    }

    public void setKongshu(String kongshu) {
        this.kongshu = kongshu;
    }

    public String getZtz() {
        return ztz;
    }

    public void setZtz(String ztz) {
        this.ztz = ztz;
    }

    public String getGcf() {
        return gcf;
    }

    public void setGcf(String gcf) {
        this.gcf = gcf;
    }

    public String getSjf() {
        return sjf;
    }

    public void setSjf(String sjf) {
        this.sjf = sjf;
    }

    public String getJlf() {
        return jlf;
    }

    public void setJlf(String jlf) {
        this.jlf = jlf;
    }

    public Long getSjwbsjgcbrq() {
        return sjwbsjgcbrq;
    }

    public void setSjwbsjgcbrq(Long sjwbsjgcbrq) {
        this.sjwbsjgcbrq = sjwbsjgcbrq;
    }

    public String getCeming() {
        return ceming;
    }

    public void setCeming(String ceming) {
        this.ceming = ceming;
    }

    public String getSjsmbz() {
        return sjsmbz;
    }

    public void setSjsmbz(String sjsmbz) {
        this.sjsmbz = sjsmbz;
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
    }

    public String getSupervisionName() {
        return supervisionName;
    }

    public void setSupervisionName(String supervisionName) {
        this.supervisionName = supervisionName;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getDesignCompanyId() {
        return designCompanyId;
    }

    public void setDesignCompanyId(String designCompanyId) {
        this.designCompanyId = designCompanyId;
    }

    public String getSupervisionCompanyId() {
        return supervisionCompanyId;
    }

    public void setSupervisionCompanyId(String supervisionCompanyId) {
        this.supervisionCompanyId = supervisionCompanyId;
    }

    public String getConstructionCompanyId() {
        return constructionCompanyId;
    }

    public void setConstructionCompanyId(String constructionCompanyId) {
        this.constructionCompanyId = constructionCompanyId;
    }

    public String getDesignCompanyRefId() {
        return designCompanyRefId;
    }

    public void setDesignCompanyRefId(String designCompanyRefId) {
        this.designCompanyRefId = designCompanyRefId;
    }

    public String getSupervisionCompanyRefId() {
        return supervisionCompanyRefId;
    }

    public void setSupervisionCompanyRefId(String supervisionCompanyRefId) {
        this.supervisionCompanyRefId = supervisionCompanyRefId;
    }

    public String getConstructionCompanyRefId() {
        return constructionCompanyRefId;
    }

    public void setConstructionCompanyRefId(String constructionCompanyRefId) {
        this.constructionCompanyRefId = constructionCompanyRefId;
    }

    public Long getDxwtsj() {
        return dxwtsj;
    }

    public void setDxwtsj(Long dxwtsj) {
        this.dxwtsj = dxwtsj;
    }

    public String getSfblgz() {
        return sfblgz;
    }

    public void setSfblgz(String sfblgz) {
        this.sfblgz = sfblgz;
    }

    public String getBzqk() {
        return bzqk;
    }

    public void setBzqk(String bzqk) {
        this.bzqk = bzqk;
    }

    public Long getSjwbffrq() {
        return sjwbffrq;
    }

    public void setSjwbffrq(Long sjwbffrq) {
        this.sjwbffrq = sjwbffrq;
    }

    public String getSgqk() {
        return sgqk;
    }

    public void setSgqk(String sgqk) {
        this.sgqk = sgqk;
    }

    public String getSgqkjs() {
        return sgqkjs;
    }

    public void setSgqkjs(String sgqkjs) {
        this.sgqkjs = sgqkjs;
    }

    public Long getYjwgsj() {
        return yjwgsj;
    }

    public void setYjwgsj(Long yjwgsj) {
        this.yjwgsj = yjwgsj;
    }

    public Long getWgrq() {
        return wgrq;
    }

    public void setWgrq(Long wgrq) {
        this.wgrq = wgrq;
    }

    public Long getJgzltjsj() {
        return jgzltjsj;
    }

    public void setJgzltjsj(Long jgzltjsj) {
        this.jgzltjsj = jgzltjsj;
    }

    public String getGzblqk() {
        return gzblqk;
    }

    public void setGzblqk(String gzblqk) {
        this.gzblqk = gzblqk;
    }

    public String getSgbz() {
        return sgbz;
    }

    public void setSgbz(String sgbz) {
        this.sgbz = sgbz;
    }

    public String getJgzl() {
        return jgzl;
    }

    public void setJgzl(String jgzl) {
        this.jgzl = jgzl;
    }

    public Long getJlzltjsj() {
        return jlzltjsj;
    }

    public void setJlzltjsj(Long jlzltjsj) {
        this.jlzltjsj = jlzltjsj;
    }

    public Long getLrrq() {
        return lrrq;
    }

    public void setLrrq(Long lrrq) {
        this.lrrq = lrrq;
    }

    public String getLrqk() {
        return lrqk;
    }

    public void setLrqk(String lrqk) {
        this.lrqk = lrqk;
    }

    public String getSghtcgddh() {
        return sghtcgddh;
    }

    public void setSghtcgddh(String sghtcgddh) {
        this.sghtcgddh = sghtcgddh;
    }

    public Long getYsrq() {
        return ysrq;
    }

    public void setYsrq(Long ysrq) {
        this.ysrq = ysrq;
    }

    public Long getZzrq() {
        return zzrq;
    }

    public void setZzrq(Long zzrq) {
        this.zzrq = zzrq;
    }

    public String getZzqk() {
        return zzqk;
    }

    public void setZzqk(String zzqk) {
        this.zzqk = zzqk;
    }

    public Long getSsrq() {
        return ssrq;
    }

    public void setSsrq(Long ssrq) {
        this.ssrq = ssrq;
    }

    public String getSsqk() {
        return ssqk;
    }

    public void setSsqk(String ssqk) {
        this.ssqk = ssqk;
    }

    public String getSfzqrrq() {
        return sfzqrrq;
    }

    public void setSfzqrrq(String sfzqrrq) {
        this.sfzqrrq = sfzqrrq;
    }

    public Integer getWgys() {
        return wgys;
    }

    public void setWgys(Integer wgys) {
        this.wgys = wgys;
    }

    public Integer getSjcbys() {
        return sjcbys;
    }

    public void setSjcbys(Integer sjcbys) {
        this.sjcbys = sjcbys;
    }

    public Integer getJgzlzzys() {
        return jgzlzzys;
    }

    public void setJgzlzzys(Integer jgzlzzys) {
        this.jgzlzzys = jgzlzzys;
    }

    public Integer getJlcbys() {
        return jlcbys;
    }

    public void setJlcbys(Integer jlcbys) {
        this.jlcbys = jlcbys;
    }

    public Integer getLrys() {
        return lrys;
    }

    public void setLrys(Integer lrys) {
        this.lrys = lrys;
    }

    public Integer getYjzcys() {
        return yjzcys;
    }

    public void setYjzcys(Integer yjzcys) {
        this.yjzcys = yjzcys;
    }

    public Integer getZzys() {
        return zzys;
    }

    public void setZzys(Integer zzys) {
        this.zzys = zzys;
    }

    public Integer getSsys() {
        return ssys;
    }

    public void setSsys(Integer ssys) {
        this.ssys = ssys;
    }

    public Integer getSjys() {
        return sjys;
    }

    public void setSjys(Integer sjys) {
        this.sjys = sjys;
    }
}
