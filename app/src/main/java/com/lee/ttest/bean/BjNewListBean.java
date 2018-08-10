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
public class BjNewListBean implements Serializable {

    private String code;
    private boolean charge;
    private String msg;
    private ResultBeanX result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

    public static class ResultBeanX implements Serializable {

        private String status;
        private String msg;
        private ResultBean result;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public static class ResultBean implements Serializable {

            private String channel;
            private String num;
            private List<ListBean> list;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean implements Serializable {
                /**
                 * title : 为“不当中国人” 台湾留学生欲众筹状告挪威政府
                 * time : 2018-08-09 09:03:00
                 * src : 观察者网
                 * category : mil
                 * pic : https://n.sinaimg.cn/mil/crawl/37/w550h287/20180809/OQL1-fzrwica0449136.png
                 * content : 
                 * [观察者网综合报道]一群中国台湾学生因不满被标为“中国籍”，向挪威政府要求改为“台湾”。但这一要求不但被挪威政府驳回，向台湾当局请求资金支援状告挪威也被拒绝，只能在网络上发起众筹……据台湾联合新闻网8月8日报道，去年，这些台湾留学生因被挪威标注为“中国籍”，而向当地移民局提起诉愿，希望挪威政府可以将他们的“国籍”标注为“台湾”。另台湾“风传媒”报道，来自中国台湾的留学生约瑟夫（Joseph）与一些旅居挪威的“台湾人”组成“在挪台湾人国籍‘正名’运动”，于2017年3月向挪威移民局（UDI）提起诉愿，主张挪威将自己标为“中国籍”的做法已违反挪威宪法，构成对“台湾人”的歧视，希望由“Kina”（挪威语的中国）改为“台湾”。该团体还称，“台湾人”若被列为“中国籍”，不仅尊严受损；在海关出示证件时，还可能遭到误认、刁难；发生紧急危难时，也难以确认联络单位。不过，面对这一要求，挪威移民局多次以“员工休假潮”、“申请签证高峰”为由延后处理，又在2017年11月驳回诉愿，送交挪威移民诉愿委员会（UNE）审理。今年3月，UNE再度驳回这些留学生的要求。该委员会负责人理斯巴肯（Mats Risbakken）指出，<strong>“台湾人”标为“Kina”符合挪威的外交政策，而且居留证标为“中国”，并不影响“台湾人”在挪威的权益</strong>。据台媒报道，2010年6月起，挪威办理移民登记的税务局开始将台湾留学生标为“中国籍”。挪威外交部连络主任安德森（Frode O。 Andersen）指出，挪威外交部从未介入这一决定，<strong>“挪威从未承认台湾是一个独立国家”</strong>。该团体事后决定控告挪威政府，并首先以驳回诉愿的UNE与最先标注中国国籍的税务局为对象提起民事诉讼，但又面临庞大的诉讼费用。据了解，在挪威打官司一个审级大约需要100万台币（约合人民币22.3万）。联合新闻网5月报道称，这波留学生为筹措经费向台湾外事部门求援，但后者以“当局不介入民间诉讼，且没有预算补助”为由，表示无法向学生提供经济援助。本月初，该团体开始在台湾众筹平台“啧啧”发起集资活动，集资目标为一个审级所需的新台币122万元（约合人民币27.3万），并注明“倘若无法募得新台币122万元，团队将不会提起诉讼”，并退还募得资金。<strong>截至目前，该团体已募得约新台币102万，完成度83%。</strong>对此，有台湾网友批评该团体“真的没其它正事可以干吗？”并质问他们“世界上有个‘台湾国’吗？”，提醒大家“诈骗集团翻新手法了，要小心！”2016年，另一名（中国）台湾女学生也曾不满被标为“中国”而向冰岛政府提出抗议，但她最终被标为“无国籍”。原居留证，红框内写着“chinese”（“中国”）今年2月，（中国）台湾前奥运选手纪政又推动所谓“2020东京奥运台湾正名公投”，台当局对此一直态度“暧昧”。令人意外的是，本月6日，台当局行政机构负责人赖清德开始宣称，根据1981年《洛桑协议》的规定，台湾参加奥运会必须用“中华台北”作为名称，“我相信很多人不满意，但是目前的状况是这样。”我外交部及国台办曾多次强调，两岸同属一个中国的事实从未改变，也不可能改变。坚持一个中国原则、反对“台独”、反对“两个中国”和“一中一台”，是我们处理台湾对外交往问题的一贯立场。
                 * url : http://mil.sina.cn/zgjq/2018-08-09/detail-ihhnunsp7444908.d.html?vt=4&pos=108
                 * weburl : http://mil.news.sina.com.cn/china/2018-08-09/doc-ihhnunsp7444908.shtml
                 */

                private String title;
                private String time;
                private String src;
                private String category;
                private String pic;
                private String content;
                private String url;
                private String weburl;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWeburl() {
                    return weburl;
                }

                public void setWeburl(String weburl) {
                    this.weburl = weburl;
                }
            }
        }
    }
}
//jhfghfh