package com.lee.ttest.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class HistoryBean implements Serializable {


    /**
     * result : [{"_id":"17940116","title":"英国史学家爱德华·吉本逝世","pic":"","year":1794,"month":1,"day":16,
     * "des":"在224年前的今天，1794年1月16日 (农历腊月十五)，英国史学家爱德华·吉本逝世。","lunar":"癸丑年腊月十五"},{"_id":"18820116",
     * "title":"《申报》首用国内电讯","pic":"","year":1882,"month":1,"day":16,"des":"在136年前的今天，1882年1月16日 (农历冬月廿七)
     * ，《申报》首用国内电讯。","lunar":"辛巳年冬月廿七"},{"_id":"18850116","title":"散文家周作人诞辰","pic":"http://juheimg.oss-cn-hangzhou
     * .aliyuncs.com/toh/201001/14/2E18238645.jpg","year":1885,"month":1,"day":16,"des":"在133年前的今天，1885年1月16日 
     * (农历腊月初一)，散文家周作人诞辰。","lunar":"甲申年腊月初一"},{"_id":"19000116","title":"英国放弃对萨摩亚岛的主权","pic":"http://juheimg
     * .oss-cn-hangzhou.aliyuncs.com/toh/201001/14/04134836774.jpg","year":1900,"month":1,"day":16,
     * "des":"在118年前的今天，1900年1月16日 (农历腊月十六)，英国放弃对萨摩亚岛的主权。","lunar":"己亥年腊月十六"},{"_id":"19010116",
     * "title":"古巴独裁者、总统巴蒂斯塔·伊·萨尔迪瓦出生","pic":"","year":1901,"month":1,"day":16,"des":"在117年前的今天，1901年1月16日 (农历冬月廿六)
     * ，古巴独裁者、总统巴蒂斯塔·伊·萨尔迪瓦出生。","lunar":"庚子年冬月廿六"},{"_id":"19060116","title":"无线电发明家波波夫逝世","pic":"http://juheimg
     * .oss-cn-hangzhou.aliyuncs.com/toh/201001/13/11233216271.jpg","year":1906,"month":1,"day":16,
     * "des":"在112年前的今天，1906年1月16日 (农历腊月廿二)，无线电发明家波波夫逝世。","lunar":"乙巳年腊月廿二"},{"_id":"19160116","title":"蔡锷率护国军讨伐袁世凯",
     * "pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/C3135539875.jpg","year":1916,"month":1,
     * "day":16,"des":"在102年前的今天，1916年1月16日 (农历腊月十二)，蔡锷率护国军讨伐袁世凯。","lunar":"乙卯年腊月十二"},{"_id":"19200116",
     * "title":"协约国要求引渡德皇威廉二世，遭荷兰拒绝","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/27135425384
     * .jpg","year":1920,"month":1,"day":16,"des":"在98年前的今天，1920年1月16日 (农历冬月廿六)，协约国要求引渡德皇威廉二世，遭荷兰拒绝。",
     * "lunar":"己未年冬月廿六"},{"_id":"19230116","title":"孙中山夺回广州，发表和平统一宣言","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/toh/200905/17/07135352202.jpg","year":1923,"month":1,"day":16,"des":"在95年前的今天，1923年1月16日 (农历冬月三十)
     * ，孙中山夺回广州，发表和平统一宣言。","lunar":"壬戌年冬月三十"},{"_id":"19340116","title":"蒋介石占领福州，十九路军兵败降蒋","pic":"http://juheimg
     * .oss-cn-hangzhou.aliyuncs.com/toh/200905/17/0F135146234.jpg","year":1934,"month":1,"day":16,
     * "des":"在84年前的今天，1934年1月16日 (农历腊月初二)，蒋介石占领福州，十九路军兵败降蒋。","lunar":"癸酉年腊月初二"},{"_id":"19360116",
     * "title":"丹麦物理学家玻尔抵达纽约","pic":"","year":1936,"month":1,"day":16,"des":"在82年前的今天，1936年1月16日 (农历腊月廿二)
     * ，丹麦物理学家玻尔抵达纽约。","lunar":"乙亥年腊月廿二"},{"_id":"19400116","title":"希特勒取消原定的西线进攻计划","pic":"http://juheimg
     * .oss-cn-hangzhou.aliyuncs.com/toh/200905/17/FF134955300.jpg","year":1940,"month":1,"day":16,
     * "des":"在78年前的今天，1940年1月16日 (农历腊月初八)，希特勒取消原定的西线进攻计划。","lunar":"己卯年腊月初八"},{"_id":"19420116",
     * "title":"尼赫鲁接替甘地成为国大党领袖","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/BA134851752.jpg",
     * "year":1942,"month":1,"day":16,"des":"在76年前的今天，1942年1月16日 (农历冬月三十)，尼赫鲁接替甘地成为国大党领袖。","lunar":"辛巳年冬月三十"},
     * {"_id":"19440116","title":"美国的艾森豪威尔将军被任命为盟军总司令","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/toh/200911/29/A921251410.jpg","year":1944,"month":1,"day":16,"des":"在74年前的今天，1944年1月16日 (农历腊月廿一)
     * ，美国的艾森豪威尔将军被任命为盟军总司令。","lunar":"癸未年腊月廿一"},{"_id":"19450116","title":"法国将雷诺汽车公司国有化","pic":"","year":1945,
     * "month":1,"day":16,"des":"在73年前的今天，1945年1月16日 (农历腊月初三)，法国将雷诺汽车公司国有化。","lunar":"甲申年腊月初三"},{"_id":"19690116",
     * "title":"苏联两艘宇宙飞船第一次完成空中对接","pic":"","year":1969,"month":1,"day":16,"des":"1969年1月16日 (农历冬月廿八)
     * ，苏联两艘宇宙飞船第一次完成空中对接。","lunar":"戊申年冬月廿八"},{"_id":"19700116","title":"穆阿马·卡扎菲上校成为利比亚总理","pic":"http://juheimg
     * .oss-cn-hangzhou.aliyuncs.com/toh/200905/17/BD133748325.jpg","year":1970,"month":1,"day":16,"des":"1970年1月16日 
     * (农历腊月初九)，穆阿马·卡扎菲上校成为利比亚总理。","lunar":"己酉年腊月初九"},{"_id":"19750116","title":"葡萄牙同意安哥拉独立","pic":"","year":1975,
     * "month":1,"day":16,"des":"1975年1月16日 (农历腊月初五)，葡萄牙同意安哥拉独立。","lunar":"甲寅年腊月初五"},{"_id":"19790116",
     * "title":"伊朗巴列维王朝被推翻","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/20/C7175238380.jpg",
     * "year":1979,"month":1,"day":16,"des":"1979年1月16日 (农历腊月十八)，伊朗巴列维王朝被推翻。","lunar":"戊午年腊月十八"},{"_id":"19800116",
     * "title":"邓小平提出80年代抓好三件事","pic":"","year":1980,"month":1,"day":16,"des":"1980年1月16日 (农历冬月廿九)，邓小平提出80年代抓好三件事。",
     * "lunar":"己未年冬月廿九"},{"_id":"19810116m2","title":"世界上最大的战舰的巡洋战舰\u201c基洛夫号\u201d在波罗的海试航","pic":"http://juheimg
     * .oss-cn-hangzhou.aliyuncs.com/toh/201001/14/19172544975.jpg","year":1981,"month":1,"day":16,"des":"1981年1月16日 
     * (农历腊月十一)，世界上最大的战舰的巡洋战舰\u201c基洛夫号\u201d在波罗的海试航。","lunar":"庚申年腊月十一"},{"_id":"19810116m1","title":"中国政府决定发行国库券",
     * "pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201001/14/EC18054113.jpg","year":1981,"month":1,
     * "day":16,"des":"1981年1月16日 (农历腊月十一)，中国政府决定发行国库券。","lunar":"庚申年腊月十一"},{"_id":"19820116",
     * "title":"梵蒂冈与英国恢复终止450年的关系","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/15133417369.jpg",
     * "year":1982,"month":1,"day":16,"des":"1982年1月16日 (农历腊月廿二)，梵蒂冈与英国恢复终止450年的关系。","lunar":"辛酉年腊月廿二"},
     * {"_id":"19840116","title":"第4次伊斯兰国家首脑议会在摩洛哥的卡萨布兰卡举行","pic":"","year":1984,"month":1,"day":16,"des":"1984年1月16日
     * (农历腊月十四)，第4次伊斯兰国家首脑议会在摩洛哥的卡萨布兰卡举行。","lunar":"癸亥年腊月十四"},{"_id":"19850116","title":"我国第一座海水淡化工程在西沙群岛永兴岛建成投产",
     * "pic":"","year":1985,"month":1,"day":16,"des":"1985年1月16日 (农历冬月廿六)，我国第一座海水淡化工程在西沙群岛永兴岛建成投产。",
     * "lunar":"甲子年冬月廿六"},{"_id":"19860116","title":"中国现代著名出版家胡愈之在北京逝世","pic":"http://juheimg.oss-cn-hangzhou
     * .aliyuncs.com/toh/200401/16/1C17366417.jpg","year":1986,"month":1,"day":16,"des":"1986年1月16日 (农历腊月初七)
     * ，中国现代著名出版家胡愈之在北京逝世。","lunar":"乙丑年腊月初七"},{"_id":"19860116m1","title":"科学家发现了一种钡镧铜氧化物在35K时开始出现超导现象","pic":"",
     * "year":1986,"month":1,"day":16,"des":"1986年1月16日 (农历腊月初七)，科学家发现了一种钡镧铜氧化物在35K时开始出现超导现象。","lunar":"乙丑年腊月初七"},
     * {"_id":"19870116","title":"胡耀邦辞去中共中央总书记职务","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/toh/200905/17/44133247823.jpg","year":1987,"month":1,"day":16,"des":"1987年1月16日 (农历腊月十七)
     * ，胡耀邦辞去中共中央总书记职务。","lunar":"丙寅年腊月十七"},{"_id":"19880116","title":"上海流行甲肝","pic":"http://juheimg.oss-cn-hangzhou
     * .aliyuncs.com/toh/200905/17/3E133236253.jpg","year":1988,"month":1,"day":16,"des":"1988年1月16日 (农历冬月廿七)
     * ，上海流行甲肝。","lunar":"丁卯年冬月廿七"},{"_id":"19930116","title":"江西九江长江大桥建成","pic":"http://juheimg.oss-cn-hangzhou
     * .aliyuncs.com/toh/201001/14/2F14053664.jpg","year":1993,"month":1,"day":16,"des":"1993年1月16日 (农历腊月廿四)
     * ，江西九江长江大桥建成。","lunar":"壬申年腊月廿四"},{"_id":"19970116","title":"国家电力公司组建成立","pic":"","year":1997,"month":1,
     * "day":16,"des":"1997年1月16日 (农历腊月初八)，国家电力公司组建成立。","lunar":"丙子年腊月初八"},{"_id":"20010116","title":"刚果民主共和国国家元首遇刺",
     * "pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201001/14/8D13597932.jpg","year":2001,"month":1,
     * "day":16,"des":"2001年1月16日 (农历腊月廿二)，刚果民主共和国国家元首遇刺。","lunar":"庚辰年腊月廿二"},{"_id":"20060116",
     * "title":"利比里亚新当选总统成为非洲历史上第一位民选女总统","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/toh/201001/14/CF173134345.jpg","year":2006,"month":1,"day":16,"des":"2006年1月16日 (农历腊月十七)
     * ，利比里亚新当选总统成为非洲历史上第一位民选女总统。","lunar":"乙酉年腊月十七"},{"_id":"20070116","title":"斯里兰卡一辆公共汽车当天早晨在斯东南部地区发生爆炸","pic":"",
     * "year":2007,"month":1,"day":16,"des":"2007年1月16日 (农历冬月廿八)，斯里兰卡一辆公共汽车当天早晨在斯东南部地区发生爆炸。","lunar":"丙戌年冬月廿八"},
     * {"_id":"8810116","title":"黄巢即皇帝位","pic":"","year":881,"month":1,"day":16,"des":"在1137年前的今天，0881年1月16日 (农历腊月十三)
     * ，黄巢即皇帝位。","lunar":"庚子年腊月十三"},{"_id":"b170126","title":"罗马帝国建立","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/toh/201108/3/E8174314648.jpg","year":-27,"month":1,"day":16,"des":"在2045年前的今天，前27年1月16日 (农历冬月廿三)
     * ，罗马帝国建立。","lunar":"壬辰年冬月廿三"}]
     * reason : 请求成功！
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public int getError_code() {
        return error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public static class ResultBean {
        /**
         * _id : 17940116
         * title : 英国史学家爱德华·吉本逝世
         * pic : 
         * year : 1794
         * month : 1
         * day : 16
         * des : 在224年前的今天，1794年1月16日 (农历腊月十五)，英国史学家爱德华·吉本逝世。
         * lunar : 癸丑年腊月十五
         */

        private String _id;
        private String title;
        private String pic;
        private int year;
        private int month;
        private int day;
        private String des;
        private String lunar;

        public void set_id(String _id) {
            this._id = _id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }

        public String get_id() {
            return _id;
        }

        public String getTitle() {
            return title;
        }

        public String getPic() {
            return pic;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public String getDes() {
            return des;
        }

        public String getLunar() {
            return lunar;
        }
    }
}
//jhfghfh