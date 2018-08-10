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
public class BsbdjDetailsBean implements Serializable {

    /**
     * appCode : baisibudejie
     * retcode : 000000
     * data : [{"id":"95648662","publishDate":1516268366,"rating":null,"likeCount":1,"tags":null,"url":"http://www
     * .budejie.com/detail-27140779.html","imageUrls":null,"source":null,"content":"吉林啊",
     * "publishDateStr":"2018-01-18T09:39:26","referId":"27140779","commenterId":"12097543","commentCount":0,
     * "commenterScreenName":"淑女坊化妆品"},{"id":"95648287","publishDate":1516267787,"rating":null,"likeCount":1,
     * "tags":null,"url":"http://www.budejie.com/detail-27140779.html","imageUrls":null,"source":null,
     * "content":"如此淡定","publishDateStr":"2018-01-18T09:29:47","referId":"27140779","commenterId":"21047767",
     * "commentCount":0,"commenterScreenName":"吾-待-汝-归"}]
     * pageToken : null
     * hasNext : false
     * dataType : comment
     */

    private String appCode;
    private String retcode;
    private Object pageToken;
    private boolean hasNext;
    private String dataType;
    private List<DataBean> data;

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public void setPageToken(Object pageToken) {
        this.pageToken = pageToken;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public String getAppCode() {
        return appCode;
    }

    public String getRetcode() {
        return retcode;
    }

    public Object getPageToken() {
        return pageToken;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public String getDataType() {
        return dataType;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        /**
         * id : 95648662
         * publishDate : 1516268366
         * rating : null
         * likeCount : 1
         * tags : null
         * url : http://www.budejie.com/detail-27140779.html
         * imageUrls : null
         * source : null
         * content : 吉林啊
         * publishDateStr : 2018-01-18T09:39:26
         * referId : 27140779
         * commenterId : 12097543
         * commentCount : 0
         * commenterScreenName : 淑女坊化妆品
         */

        private String id;
        private int publishDate;
        private Object rating;
        private int likeCount;
        private Object tags;
        private String url;
        private Object imageUrls;
        private Object source;
        private String content;
        private String publishDateStr;
        private String referId;
        private String commenterId;
        private int commentCount;
        private String commenterScreenName;

        public void setId(String id) {
            this.id = id;
        }

        public void setPublishDate(int publishDate) {
            this.publishDate = publishDate;
        }

        public void setRating(Object rating) {
            this.rating = rating;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setImageUrls(Object imageUrls) {
            this.imageUrls = imageUrls;
        }

        public void setSource(Object source) {
            this.source = source;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setPublishDateStr(String publishDateStr) {
            this.publishDateStr = publishDateStr;
        }

        public void setReferId(String referId) {
            this.referId = referId;
        }

        public void setCommenterId(String commenterId) {
            this.commenterId = commenterId;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public void setCommenterScreenName(String commenterScreenName) {
            this.commenterScreenName = commenterScreenName;
        }

        public String getId() {
            return id;
        }

        public int getPublishDate() {
            return publishDate;
        }

        public Object getRating() {
            return rating;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public Object getTags() {
            return tags;
        }

        public String getUrl() {
            return url;
        }

        public Object getImageUrls() {
            return imageUrls;
        }

        public Object getSource() {
            return source;
        }

        public String getContent() {
            return content;
        }

        public String getPublishDateStr() {
            return publishDateStr;
        }

        public String getReferId() {
            return referId;
        }

        public String getCommenterId() {
            return commenterId;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public String getCommenterScreenName() {
            return commenterScreenName;
        }
    }
}
//jhfghfh