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
public class QSImageBean implements Serializable {
    /**
     * showapi_res_error : 
     * showapi_res_code : 0
     * showapi_res_body : {"allPages":41,"ret_code":0,"contentlist":[{"title":"搞笑图片第1266期（共5图）","img":"http://www
     * .zbjuran.com/uploads/allimg/180210/1149412B9-0.jpg","type":2,"ct":"2018-02-10 12:02:39.540"},
     * {"title":"搞笑图片第1267期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180210/1150291C3-0.jpg","type":2,
     * "ct":"2018-02-10 12:02:39.540"},{"title":"搞笑图片第1268期（共5图）","img":"http://www.zbjuran
     * .com/uploads/allimg/180210/11514H606-0.jpg","type":2,"ct":"2018-02-10 12:02:39.501"},
     * {"title":"搞笑图片第1270期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180210/11541C949-0.jpg","type":2,
     * "ct":"2018-02-10 12:02:39.477"},{"title":"搞笑图片第1269期（共5图）","img":"http://www.zbjuran
     * .com/uploads/allimg/180210/1152413364-0.jpg","type":2,"ct":"2018-02-10 12:02:39.476"},{"title":"高铁都这么洋气了",
     * "img":"http://sc2.hao123img.com/data/8f8da514d6ccb5399122aa2902e9579e_430","type":2,"ct":"2018-02-09 19:30:04
     * .351"},{"title":"有你这么坑娃的吗","img":"http://sc1.hao123img.com/data/ca10e7d2c38496ae95364a0e8ec66610_0","type":2,
     * "ct":"2018-02-09 18:30:02.745"},{"title":"知道为什么说\u201c照骗\u201d了吧","img":"http://sc4.hao123img
     * .com/data/251efcf6f301560acbff4e9d9191a277_430","type":2,"ct":"2018-02-09 17:00:05.106"},{"title":"这个洗衣机怕是要疯",
     * "img":"http://sc2.hao123img.com/data/2b82d8fd597af8d56646f33839bc45b7_0","type":2,"ct":"2018-02-09 17:00:05
     * .104"},{"title":"搞笑图片第1256期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180209/160G44646-0.jpg",
     * "type":2,"ct":"2018-02-09 16:30:04.292"},{"title":"搞笑图片第1257期（共5图）","img":"http://www.zbjuran
     * .com/uploads/allimg/180209/160P51251-0.jpg","type":2,"ct":"2018-02-09 16:30:04.291"},
     * {"title":"搞笑图片第1260期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180209/161330C93-0.jpg","type":2,
     * "ct":"2018-02-09 16:30:04.291"},{"title":"搞笑图片第1258期（共5图）","img":"http://www.zbjuran
     * .com/uploads/allimg/180209/1609243246-0.jpg","type":2,"ct":"2018-02-09 16:30:04.290"},
     * {"title":"搞笑图片第1259期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180209/161152L30-0.jpg","type":2,
     * "ct":"2018-02-09 16:30:04.289"},{"title":"看看人家公司的年会","img":"http://sc3.hao123img
     * .com/data/5c6e754be0401b1ec04934d9ced563ab_0","type":2,"ct":"2018-02-09 16:00:05.248"},{"title":"我的朋友就是个坑货",
     * "img":"http://sc3.hao123img.com/data/97f90ebdd5e40d38ce7aed0d86e369e7_0","type":2,"ct":"2018-02-09 15:30:02
     * .785"},{"title":"妹子你这是要飞啊","img":"http://sc3.hao123img.com/data/392ebfe0ddb16b62d293f07b39e060ac_430",
     * "type":2,"ct":"2018-02-09 15:30:02.782"},{"title":"妹子，你可得当心点","img":"http://sc0.hao123img
     * .com/data/2e7889f9fb96652618dad7187505b0cf_0","type":2,"ct":"2018-02-09 13:00:06.687"},{"title":"你这给我吃的啥",
     * "img":"http://sc2.hao123img.com/data/ca8ce5dadb0ef9cc1dcd9c0df9fe5d6d_0","type":2,"ct":"2018-02-09 12:30:02
     * .916"},{"title":"你这给我吃的啥","img":"http://sc2.hao123img.com/data/eb918ac6bd382beba9500a9c26ea887d_0","type":2,
     * "ct":"2018-02-09 12:30:02.913"}],"currentPage":1,"allNum":806,"maxResult":20}
     */

    private String showapi_res_error;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * allPages : 41
         * ret_code : 0
         * contentlist : [{"title":"搞笑图片第1266期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180210/1149412B9-0
         * .jpg","type":2,"ct":"2018-02-10 12:02:39.540"},{"title":"搞笑图片第1267期（共5图）","img":"http://www.zbjuran
         * .com/uploads/allimg/180210/1150291C3-0.jpg","type":2,"ct":"2018-02-10 12:02:39.540"},
         * {"title":"搞笑图片第1268期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180210/11514H606-0.jpg","type":2,
         * "ct":"2018-02-10 12:02:39.501"},{"title":"搞笑图片第1270期（共5图）","img":"http://www.zbjuran
         * .com/uploads/allimg/180210/11541C949-0.jpg","type":2,"ct":"2018-02-10 12:02:39.477"},
         * {"title":"搞笑图片第1269期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180210/1152413364-0.jpg","type":2,
         * "ct":"2018-02-10 12:02:39.476"},{"title":"高铁都这么洋气了","img":"http://sc2.hao123img
         * .com/data/8f8da514d6ccb5399122aa2902e9579e_430","type":2,"ct":"2018-02-09 19:30:04.351"},
         * {"title":"有你这么坑娃的吗","img":"http://sc1.hao123img.com/data/ca10e7d2c38496ae95364a0e8ec66610_0","type":2,
         * "ct":"2018-02-09 18:30:02.745"},{"title":"知道为什么说\u201c照骗\u201d了吧","img":"http://sc4.hao123img
         * .com/data/251efcf6f301560acbff4e9d9191a277_430","type":2,"ct":"2018-02-09 17:00:05.106"},
         * {"title":"这个洗衣机怕是要疯","img":"http://sc2.hao123img.com/data/2b82d8fd597af8d56646f33839bc45b7_0","type":2,
         * "ct":"2018-02-09 17:00:05.104"},{"title":"搞笑图片第1256期（共5图）","img":"http://www.zbjuran
         * .com/uploads/allimg/180209/160G44646-0.jpg","type":2,"ct":"2018-02-09 16:30:04.292"},
         * {"title":"搞笑图片第1257期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180209/160P51251-0.jpg","type":2,
         * "ct":"2018-02-09 16:30:04.291"},{"title":"搞笑图片第1260期（共5图）","img":"http://www.zbjuran
         * .com/uploads/allimg/180209/161330C93-0.jpg","type":2,"ct":"2018-02-09 16:30:04.291"},
         * {"title":"搞笑图片第1258期（共5图）","img":"http://www.zbjuran.com/uploads/allimg/180209/1609243246-0.jpg","type":2,
         * "ct":"2018-02-09 16:30:04.290"},{"title":"搞笑图片第1259期（共5图）","img":"http://www.zbjuran
         * .com/uploads/allimg/180209/161152L30-0.jpg","type":2,"ct":"2018-02-09 16:30:04.289"},{"title":"看看人家公司的年会",
         * "img":"http://sc3.hao123img.com/data/5c6e754be0401b1ec04934d9ced563ab_0","type":2,"ct":"2018-02-09 
         * 16:00:05.248"},{"title":"我的朋友就是个坑货","img":"http://sc3.hao123img
         * .com/data/97f90ebdd5e40d38ce7aed0d86e369e7_0","type":2,"ct":"2018-02-09 15:30:02.785"},
         * {"title":"妹子你这是要飞啊","img":"http://sc3.hao123img.com/data/392ebfe0ddb16b62d293f07b39e060ac_430","type":2,
         * "ct":"2018-02-09 15:30:02.782"},{"title":"妹子，你可得当心点","img":"http://sc0.hao123img
         * .com/data/2e7889f9fb96652618dad7187505b0cf_0","type":2,"ct":"2018-02-09 13:00:06.687"},{"title":"你这给我吃的啥",
         * "img":"http://sc2.hao123img.com/data/ca8ce5dadb0ef9cc1dcd9c0df9fe5d6d_0","type":2,"ct":"2018-02-09 
         * 12:30:02.916"},{"title":"你这给我吃的啥","img":"http://sc2.hao123img
         * .com/data/eb918ac6bd382beba9500a9c26ea887d_0","type":2,"ct":"2018-02-09 12:30:02.913"}]
         * currentPage : 1
         * allNum : 806
         * maxResult : 20
         */

        private int allPages;
        private int ret_code;
        private int currentPage;
        private int allNum;
        private int maxResult;
        private List<ContentlistBean> contentlist;

        public int getAllPages() {
            return allPages;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public List<ContentlistBean> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<ContentlistBean> contentlist) {
            this.contentlist = contentlist;
        }

        public static class ContentlistBean {
            /**
             * title : 搞笑图片第1266期（共5图）
             * img : http://www.zbjuran.com/uploads/allimg/180210/1149412B9-0.jpg
             * type : 2
             * ct : 2018-02-10 12:02:39.540
             */

            private String title;
            private String img;
            private int type;
            private String ct;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }
        }
    }
}
//jhfghfh