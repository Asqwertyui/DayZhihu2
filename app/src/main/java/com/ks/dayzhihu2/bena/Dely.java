package com.ks.dayzhihu2.bena;

import java.util.List;

/**
 * Created by F0519 on 2019/6/30.
 */

public class Dely {

    /**
     * date : 20190630
     * stories : [{"images":["https://pic1.zhimg.com/v2-bb796ab0fe89bdf995b212c7427146ec.jpg"],"type":0,"id":9712911,"ga_prefix":"063016","title":"曾经有个人，把一个导管插到自己的心脏里"},{"images":["https://pic3.zhimg.com/v2-2ed5d8c9480c0dbb51721d02047290d2.jpg"],"type":0,"id":9712944,"ga_prefix":"063009","title":"欧洲有哪些小城市值得一去？"},{"images":["https://pic2.zhimg.com/v2-ede2d00c9a0f8cc30d9ad44a71b432cd.jpg"],"type":0,"id":9712932,"ga_prefix":"063007","title":"切尔诺贝利这样的核事故，有没可能发生在国内？"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-e931187fac8a95cd2b723bc71c452ec8.jpg","type":0,"id":9712928,"ga_prefix":"062807","title":"想试试 iOS 13？现在就可以尝鲜"},{"image":"https://pic4.zhimg.com/v2-6464e1af5f9da2fd3b3112022b759ed7.jpg","type":0,"id":9712709,"ga_prefix":"062407","title":"我拆了根 Apple Pencil，告诉你它的原理是什么"},{"image":"https://pic2.zhimg.com/v2-9dde01ce46ea2f25e2b3f27248f0ca15.jpg","type":0,"id":9712688,"ga_prefix":"062307","title":"中国电影票房 9 年来首次负增长，是什么原因导致的？"},{"image":"https://pic3.zhimg.com/v2-618ea58f3bcf9491e56701c5890f2bae.jpg","type":0,"id":9712730,"ga_prefix":"062209","title":"私处毛发清洁，该用洗发露还是沐浴露？"},{"image":"https://pic4.zhimg.com/v2-e93a312f674d01e57bca0e0abe897547.jpg","type":0,"id":9712644,"ga_prefix":"061914","title":"自己人的广告 · 终极问题的终极答案"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-bb796ab0fe89bdf995b212c7427146ec.jpg"]
         * type : 0
         * id : 9712911
         * ga_prefix : 063016
         * title : 曾经有个人，把一个导管插到自己的心脏里
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-e931187fac8a95cd2b723bc71c452ec8.jpg
         * type : 0
         * id : 9712928
         * ga_prefix : 062807
         * title : 想试试 iOS 13？现在就可以尝鲜
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
