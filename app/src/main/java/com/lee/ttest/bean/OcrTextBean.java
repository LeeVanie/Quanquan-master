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
public class OcrTextBean {


    /**
     * log_id : 4156933427436305658
     * direction : 0
     * words_result_num : 10
     * words_result : [{"words":"灸"},{"words":"云联动"},{"words":"Cloud Linkage"},{"words":"白俊副总经理"},
     * {"words":"成都云联动科技有限公司"},{"words":"015198138595"},{"words":"成都市高新区天府大道中段天府三街吉泰"},{"words":"1173714062"},
     * {"words":"路666号福年广场T2-2109"},{"words":"1173714062@qq1cm"}]
     */

    private long log_id = 0;
    private int direction;
    private int words_result_num;
    private List<WordsResultBean> words_result;

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public long getLog_id() {
        return log_id;
    }

    public int getDirection() {
        return direction;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public static class WordsResultBean {
        /**
         * words : 灸
         */

        private String words;

        public void setWords(String words) {
            this.words = words;
        }

        public String getWords() {
            return words;
        }
    }
}
//jhfghfh