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
public class BsbdjListBean implements Serializable {

    private String appCode;
    private String pageToken;
    private String dataType;
    private String retcode;
    private boolean hasNext;
    private List<DataBean> data;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * url : http://www.budejie.com/detail-27135211.html
         * catId1 : 58240
         * likeCount : 68
         * id : 27135211
         * shareCount : 1
         * content : 可以说是史上最不走心男朋友了
         * imageUrls : ["http://wimg.spriteapp.cn/ugc/2018/01/16/5a5df4a9a9203_d.jpg","http://dimg.spriteapp
         * .cn/ugc/2018/01/16/5a5df4a9a9203_d.jpg","http://wimg.spriteapp.cn/ugc/2018/01/16/5a5df4a9a9203.jpg",
         * "http://dimg.spriteapp.cn/ugc/2018/01/16/5a5df4a9a9203.jpg"]
         * dislikeCount : 34
         * publishDate : 1516114288
         * tags : ["搞笑图片"]
         * commentCount : 4
         * catName1 : 搞笑图片
         * publishDateStr : 2018-01-16T14:51:28
         * title : 可以说是史上最不走心男朋友了
         * posterId : 8246674
         * posterScreenName : 百思是很好玩的 [飞天小女警]
         * imageURLs : false
         * labels : []
         * pDate : false
         * subtitle : false
         * commenterScreenName : false
         * rating : false
         * sellerScreenName : false
         * coverUrl : false
         * description : false
         * videoUrls : ["http://wvideo.spriteapp.cn/video/2018/0113/552ddee8f87411e7be84842b2b4c75ab_wpdm.mp4",
         * "http://dvideo.spriteapp.cn/video/2018/0113/552ddee8f87411e7be84842b2b4c75ab_wpdm.mp4"]
         */

        private String url;
        private String catId1;
        private int likeCount;
        private String id;
        private int shareCount;
        private String content;
        private int dislikeCount;
        private int publishDate;
        private int commentCount;
        private String catName1;
        private String publishDateStr;
        private String title;
        private String posterId;
        private String posterScreenName;
        private boolean imageURLs;
        private boolean pDate;
        private boolean subtitle;
        private boolean commenterScreenName;
        private boolean rating;
        private boolean sellerScreenName;
        private boolean coverUrl;
        private boolean description;
        private List<String> imageUrls;
        private List<String> tags;
        private List<?> labels;
        private List<String> videoUrls;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCatId1() {
            return catId1;
        }

        public void setCatId1(String catId1) {
            this.catId1 = catId1;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getDislikeCount() {
            return dislikeCount;
        }

        public void setDislikeCount(int dislikeCount) {
            this.dislikeCount = dislikeCount;
        }

        public int getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(int publishDate) {
            this.publishDate = publishDate;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getCatName1() {
            return catName1;
        }

        public void setCatName1(String catName1) {
            this.catName1 = catName1;
        }

        public String getPublishDateStr() {
            return publishDateStr;
        }

        public void setPublishDateStr(String publishDateStr) {
            this.publishDateStr = publishDateStr;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPosterId() {
            return posterId;
        }

        public void setPosterId(String posterId) {
            this.posterId = posterId;
        }

        public String getPosterScreenName() {
            return posterScreenName;
        }

        public void setPosterScreenName(String posterScreenName) {
            this.posterScreenName = posterScreenName;
        }

        public boolean isImageURLs() {
            return imageURLs;
        }

        public void setImageURLs(boolean imageURLs) {
            this.imageURLs = imageURLs;
        }

        public boolean isPDate() {
            return pDate;
        }

        public void setPDate(boolean pDate) {
            this.pDate = pDate;
        }

        public boolean isSubtitle() {
            return subtitle;
        }

        public void setSubtitle(boolean subtitle) {
            this.subtitle = subtitle;
        }

        public boolean isCommenterScreenName() {
            return commenterScreenName;
        }

        public void setCommenterScreenName(boolean commenterScreenName) {
            this.commenterScreenName = commenterScreenName;
        }

        public boolean isRating() {
            return rating;
        }

        public void setRating(boolean rating) {
            this.rating = rating;
        }

        public boolean isSellerScreenName() {
            return sellerScreenName;
        }

        public void setSellerScreenName(boolean sellerScreenName) {
            this.sellerScreenName = sellerScreenName;
        }

        public boolean isCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(boolean coverUrl) {
            this.coverUrl = coverUrl;
        }

        public boolean isDescription() {
            return description;
        }

        public void setDescription(boolean description) {
            this.description = description;
        }

        public List<String> getImageUrls() {
            return imageUrls;
        }

        public void setImageUrls(List<String> imageUrls) {
            this.imageUrls = imageUrls;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<?> getLabels() {
            return labels;
        }

        public void setLabels(List<?> labels) {
            this.labels = labels;
        }

        public List<String> getVideoUrls() {
            return videoUrls;
        }

        public void setVideoUrls(List<String> videoUrls) {
            this.videoUrls = videoUrls;
        }
    }
}
//jhfghfh