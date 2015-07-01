package cn.hillwind.sep;

/**
 * 传输统计表
 */
public class ChuanShuTJB{

    private static final long serialVersionUID = 1L;

    public static final String ACTION_NEW = "新增";
    public static final String ACTION_MODIFY = "修改";

    /**
     * 传输编号
     * （项目编号）
     */
    private String csbh;
    
    /**
     * 项目名称
     * 2015-04-21 加
     */
    private String xmmc;

    /**
     * 项目负责人
     * 2015-04-21 加
     */
    private String xmfzr;

    /**
     * 分册
     * (分册编号) 第三册第十五分册 第5册第28分册
     */
    private String fence;
    
    /**
     * 分册
     * 用于排序的册号 如 “第三册第十五分册” -> 0003.0015 ,  "第5册第28分册" -> 0005.0028
     */
    private String fenceOrder;

    /**
     * 册名
     */
    private String ceming;

    /**
     * 项目类别
     * 2015-04-21 加
     */
    private String xmlb;

    /**
     * 工程属性
     * 2015-04-21 由文本框改为下拉框
     */
    private String gcsx;

    /**
     * 工单编号
     * 2015-04-21 加,预留，暂不显示
     */
    private String gdbh;

    /**
     * 规划编号
     * \专线编号\加站编号
     */
    private String ghbh;

    /**
     * 工单日期
     * 2015-04-21 加,预留，暂不显示
     */
    private Long gdrq;

    /**
     * 预警日期
     * 2015-04-21 加,预留，暂不显示
     */
    private Long yjrq;

    /**
     * 回单日期
     * 2015-04-21 加,预留，暂不显示
     */
    private Long hdrq;

    /**
     * 单项名称
     */
    private String dxmc;

	/**
     * 工程地址
     * 2015-04-21
     */
    private String gcdz;
    
    /**
     * 发起单位
     * (12个属地) 2015-04-21 修改列名为：发起单位,含义不变
     */
    private String fqdw;
    
    /**
     * 所属区域
     * (12个属地)
     */
    private String ssqy;
    
    /**
     * 行政区域
     * 2015-04-21 加
     */
    private String xzqy;

    /**
     * 集客/属地联系人
     * 2015-04-21 加,预留，暂不显示
     */
    private String sdlxr;

    /**
     * 集客/属地联系方式
     * 2015-04-21 加,预留，暂不显示
     */
    private String sdlxfs;

    /**
     * 客户/购租联系人
     * 2015-04-21 加,预留，暂不显示
     */
    private String gzlxr;

    /**
     * 客户/购租联系方式
     * 2015-04-21 加,预留，暂不显示
     */
    private String gzlxfs;

    /**
     * 路名
     * 2015-04-21 加
     */
    private String luming;

    /**
     * 路段
     * 2015-04-21 加
     */
    private String luduan;

    /**
     * 长度(米)
     */
    private String changdu;

    /**
     * 孔数
     */
    private String kongshu;

    /**
     * 总投资(元)
     */
    private String ztz;

    /**
     * 工程费
     */
    private String gcf;

    /**
     * 设计费(元)
     */
    private String sjf;

    /**
     * 监理费(元)
     */
    private String jlf;

    /**
     * 设计文本送交工程部日期
     * 2015-04-21 加
     */
    private Long sjwbsjgcbrq;

    /**
     * 设计说明备注
     * 2015-04-21 加
     */
    private String sjsmbz;


    /**
     * 设计院名称
     */
    private String designName;
    
    /**
     * 监理单位名称
     */
    private String supervisionName;

    /**
     * 施工单位名称
     */
    private String constructionName;

    /**
     * 单项委托时间
     */
    private Long dxwtsj;

    /**
     * 是否办理管照
     * 2015-04-21 加
     */
    private String sfblgz;

    /**
     * 备注情况
     */
    private String bzqk;

    /**
     * 设计文本分发日期
     * 2015-04-21 加 , 预留（陈鸯填写）
     */
    private Long sjwbffrq;

    /**
     * 施工情况
     * (施工单位填写) 2015-04-21 加
     */
    private String sgqk;

    /**
     * 施工情况简述
     * （含建设情况和竣工资料提交情况） 2015-04-21 加
     */
    private String sgqkjs;

    /**
     * 预计完工时间
     * 2015-04-21 加，需要由项目负责人指定施工单位时，要求施工单位填写，由项目负责人确认。
     */
    private Long yjwgsj;

    /**
     * 开工日期
     */
    private Long kgrq;

    /**
     * 完工日期
     */
    private Long wgrq;

    /**
     * 竣工资料提交时间
     * (施工单位)
     */
    private Long jgzltjsj;

    /**
     * 管照办理情况
     * 施工单位填写 2015-04-21 加
     */
    private String gzblqk;

    /**
     * 施工备注
     * 2015-04-21 加
     */
    private String sgbz;

    /**
     * 工程建设情况
     * (每次监理确认的进度，由ChuanShuProgress表的状态更新至此) 2015-04-21 改名为 施工进度确认
     */
    private String gcjsqk;

    /**
     * 竣工资料确认情况
     * (监理）
     */
    private String jgzl;

    /**
     * 竣工资料确认时间
     * (监理）
     */
    private Long jgzlqrsj;

    /**
     * 监理资料提交时间
     * (监理)
     */
        private Long jlzltjsj;

    /**
     * 录入情况
     */
    private String lrqk;

    /**
     * 录入日期
     */
    private Long lrrq;

    /**
     * 施工合同采购订单号
     */
    private String sghtcgddh;

    /**
     * 验收日期
     * 2015-04-21 加
     */
    private Long ysrq;

    /**
     * 转资情况
     */
    private String zzqk;

    /**
     * 转资日期
     */
    private Long zzrq;

    /**
     * 送审日期
     * 2015-04-21 加
     */
    private Long ssrq;

    /**
     * 送审情况
     * 2015-04-21 加
     */
    private String ssqk;

    /**
     * 三方章确认日期
     * 2015-04-21 加
     */
    private Long sfzqrrq;

	/**
     * 现场信息
     */
    private String xcxx;

    /**
     * 完工用时
     * = 施工完工时间(AQ) - 单项委托时间(AJ)
     */
    private Integer wgys;

    /**
     * 设计出版用时
     * = 设计文本送交工程部日期(AC)-施工完工时间(AQ)
     */
    private Integer sjcbys;

    /**
     * 竣工资料制作用时
     * =  竣工资料确认日期（监理）(AV) -  Max(设计文本送交工程部日期(AE),施工完工时间(AR))
     */
    private Integer jgzlzzys;

    /**
     * 监理出版用时
     * = 监理资料提交日期(AW) - 竣工资料确认日期（监理）(AV)
     */
    private Integer jlcbys;

    /**
     * 录入用时
     * = 录入时间(AX) -  监理资料提交日期(AW)
     */
    private Integer lrys;

    /**
     * 移交资产用时
     * = 验收日期(AZ) - 监理资料提交日期(AW)
     */
    private Integer yjzcys;

    /**
     * 转资用时
     * = 转资时间(BA) - 验收日期(AZ)
     */
    private Integer zzys;

    /**
     * 送审用时
     * = 送审时间（BB） - 监理资料提交日期(AW)
     */
    private Integer ssys;

    /**
     * 审计用时
     * = 三方章确认日期(BD) - 送审时间（BB）
     */
    private Integer sjys;

    public String getCsbh() {
        return csbh;
    }

    public void setCsbh(String csbh) {
        this.csbh = csbh;
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

    public String getFence() {
        return fence;
    }

    public void setFence(String fence) {
        this.fence = fence;
    }

    public String getFenceOrder() {
        return fenceOrder;
    }

    public void setFenceOrder(String fenceOrder) {
        this.fenceOrder = fenceOrder;
    }

    public String getCeming() {
        return ceming;
    }

    public void setCeming(String ceming) {
        this.ceming = ceming;
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

    public Long getKgrq() {
        return kgrq;
    }

    public void setKgrq(Long kgrq) {
        this.kgrq = kgrq;
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

    public String getGcjsqk() {
        return gcjsqk;
    }

    public void setGcjsqk(String gcjsqk) {
        this.gcjsqk = gcjsqk;
    }

    public String getJgzl() {
        return jgzl;
    }

    public void setJgzl(String jgzl) {
        this.jgzl = jgzl;
    }

    public Long getJgzlqrsj() {
        return jgzlqrsj;
    }

    public void setJgzlqrsj(Long jgzlqrsj) {
        this.jgzlqrsj = jgzlqrsj;
    }

    public Long getJlzltjsj() {
        return jlzltjsj;
    }

    public void setJlzltjsj(Long jlzltjsj) {
        this.jlzltjsj = jlzltjsj;
    }

    public String getLrqk() {
        return lrqk;
    }

    public void setLrqk(String lrqk) {
        this.lrqk = lrqk;
    }

    public Long getLrrq() {
        return lrrq;
    }

    public void setLrrq(Long lrrq) {
        this.lrrq = lrrq;
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

    public String getZzqk() {
        return zzqk;
    }

    public void setZzqk(String zzqk) {
        this.zzqk = zzqk;
    }

    public Long getZzrq() {
        return zzrq;
    }

    public void setZzrq(Long zzrq) {
        this.zzrq = zzrq;
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

    public Long getSfzqrrq() {
        return sfzqrrq;
    }

    public void setSfzqrrq(Long sfzqrrq) {
        this.sfzqrrq = sfzqrrq;
    }

    public String getXcxx() {
        return xcxx;
    }

    public void setXcxx(String xcxx) {
        this.xcxx = xcxx;
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
