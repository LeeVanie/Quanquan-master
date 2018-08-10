package com.lee.ttest.bean;

import java.util.List;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class HistoryDetailsBean {
    /**
     * result : [{"_id":"18850116","title":"散文家周作人诞辰","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/toh/201001/14/2E18238645.jpg","year":1885,"month":1,"day":16,"des":"在133年前的今天，1885年1月16日 (农历腊月初一)
     * ，散文家周作人诞辰。","content":"在133年前的今天，1885年1月16日 (农历腊月初一)
     * ，散文家周作人诞辰。\n周作人（1885～1967），现代散文家、诗人。文学翻译家。原名栅寿。字星杓，后改名奎缓，自号起孟、启明（又作岂明）、知堂等，笔名仲密、药堂、周遐寿等。浙江绍兴人。鲁迅二弟。\n1903
     * 年进江南水师学堂学习海军管理，毕业后考取官费留学日本。1906年7月到日本攻读海军技术，后改学外国语。1911年回国后在绍兴任中学英文教员。辛亥革命后，任浙江省军政府教育司视学、绍兴县教育会会长、省立五中教员。1917
     * 年任北京大学文科教授。参加《新青年》的编辑工作，发表了《人的文学》、《平民文学》、《思想革命》等重要理论文章，并从事散文、新诗创作和译介外国文学作品。\n1927年4
     * 月李大钊被杀害，曾保护李大钊之子李葆华避居自家一个月之久。1931年\u201c九·一八\u201d
     * 事变后，对中国前途悲观失望。抗日战争爆发后，投靠日本，出任伪北京大学文学院长、伪华北政务委员会教育总署督办，堕落成为汉奸文人。1945年以叛国罪被判刑入狱，1949
     * 年出狱，后定居北京，在人民文学出版社从事日本、希腊文学作品的翻译和写作有关回忆鲁迅的著述。主要著作：散文集《自己的园地》、《雨天的书》、《泽泻集》、《谈龙集》、《谈虎集》，诗集《过去的生命》，小说集《孤儿记》，论文集《艺术与生活》、《中国新文学的源流》，论著《欧洲文学史》，文学史料集《鲁迅的故乡》、《鲁迅的青年时代》，回忆录《知堂回想录》，译有《日本狂言逊》、《伊索寓言》、《欧里庇得斯悲剧集》等。\n1966年\u201c文化大革命\u201d中遭受冲击，曾被红卫兵关进茅厕，于1967年5月7日粹死，死因不明，仓促火化、销户，骨灰匣亦丢失。\n","lunar":"甲申年腊月初一"}]
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
         * _id : 18850116
         * title : 散文家周作人诞辰
         * pic : http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201001/14/2E18238645.jpg
         * year : 1885
         * month : 1
         * day : 16
         * des : 在133年前的今天，1885年1月16日 (农历腊月初一)，散文家周作人诞辰。
         * content : 在133年前的今天，1885年1月16日 (农历腊月初一)，散文家周作人诞辰。
         周作人（1885～1967），现代散文家、诗人。文学翻译家。原名栅寿。字星杓，后改名奎缓，自号起孟、启明（又作岂明）、知堂等，笔名仲密、药堂、周遐寿等。浙江绍兴人。鲁迅二弟。
         1903年进江南水师学堂学习海军管理，毕业后考取官费留学日本。1906年7月到日本攻读海军技术，后改学外国语。1911
         年回国后在绍兴任中学英文教员。辛亥革命后，任浙江省军政府教育司视学、绍兴县教育会会长、省立五中教员。1917
         年任北京大学文科教授。参加《新青年》的编辑工作，发表了《人的文学》、《平民文学》、《思想革命》等重要理论文章，并从事散文、新诗创作和译介外国文学作品。
         1927年4月李大钊被杀害，曾保护李大钊之子李葆华避居自家一个月之久。1931
         年“九·一八”事变后，对中国前途悲观失望。抗日战争爆发后，投靠日本，出任伪北京大学文学院长、伪华北政务委员会教育总署督办，堕落成为汉奸文人。1945年以叛国罪被判刑入狱，1949
         年出狱，后定居北京，在人民文学出版社从事日本、希腊文学作品的翻译和写作有关回忆鲁迅的著述。主要著作：散文集《自己的园地》、《雨天的书》、《泽泻集》、《谈龙集》、《谈虎集》，诗集《过去的生命》，小说集《孤儿记》，论文集《艺术与生活》、《中国新文学的源流》，论著《欧洲文学史》，文学史料集《鲁迅的故乡》、《鲁迅的青年时代》，回忆录《知堂回想录》，译有《日本狂言逊》、《伊索寓言》、《欧里庇得斯悲剧集》等。
         1966年“文化大革命”中遭受冲击，曾被红卫兵关进茅厕，于1967年5月7日粹死，死因不明，仓促火化、销户，骨灰匣亦丢失。

         * lunar : 甲申年腊月初一
         */

        private String _id;
        private String title;
        private String pic;
        private int year;
        private int month;
        private int day;
        private String des;
        private String content;
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

        public void setContent(String content) {
            this.content = content;
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

        public String getContent() {
            return content;
        }

        public String getLunar() {
            return lunar;
        }
    }
}
//jhfghfh