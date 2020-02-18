package com.rohit.image_gallary;

import java.util.List;

public class Model {


        public Photos photos;
        public String stat;

        public Photos getPhotos() {
            return photos;
        }

        public void setPhotos(Photos photos) {
            this.photos = photos;
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

    @Override
    public String toString() {
        return "Model{" +
                "photos=" + photos +
                ", stat='" + stat + '\'' +
                '}';
    }
}

