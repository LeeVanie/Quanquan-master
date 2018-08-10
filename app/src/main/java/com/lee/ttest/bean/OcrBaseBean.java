package com.lee.ttest.bean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class OcrBaseBean {
    /**
     * log_id : 2224850491736101443
     * direction : 0
     * words_result_num : 10
     * words_result : {"品牌型号":{"words":"建设牌JS110-B"},"发证日期":{"words":"20060101"},"使用性质":{"words":"非营运"},
     * "发动机号码":{"words":"05L32751"},"注册登记日期":{"words":""},"号牌号码":{"words":"鲁GMP8791"},"所有人":{"words":"孙振平"},
     * "住址":{"words":"山东省高密市姜庄镇渝京屯村"},"车辆识别代号":{"words":"LAPXCHLU450022451"},"车辆类型":{"words":"普通二轮摩托车"}}
     */

    private long log_id = 0;

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public long getLog_id() {
        return log_id;
    }

}
//jhfghfh