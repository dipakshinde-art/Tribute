package org.codeextended.uploadimage;

import com.google.firebase.database.Exclude;

import java.util.Vector;


public class Upload {
    private String mName;
    private String mImageUrl;
    private String mKey;
    private String mComments;
    private String mPost;
    private String mLikes,mcommentsCount;

    public Upload() {
        //empty constructor needed
    }

    public String getmPost() {
        return mPost;
    }

    public void setmPost(String mPost) {
        this.mPost = mPost;
    }

    public Upload(String name, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }

    public Upload(String name, String imageUrl, String post, String comments, String likes,String commentsCount) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
        mPost=post;
        mComments = comments;
        mLikes= likes;
        mcommentsCount =commentsCount;
        mComments=comments;
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }


    public String getmLikes() {
        return mLikes;
    }

    public void setmLikes(String mLikes) {
        this.mLikes = mLikes;
    }

    public String getmComments() {
        return mComments;
    }

    public void setmComments(String mComments) {
        this.mComments = mComments;
    }

    public String getMcommentsCount() {
        return mcommentsCount;
    }

    public void setMcommentsCount(String mcommentsCount) {
        this.mcommentsCount = mcommentsCount;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}

