package com.example.mymiwork;

import java.net.URI;

public class Word {
    private String mDefaultTranslation;
    private String mMiworkTranslation;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String DefaultTranslation, String MiworkTranslation){
        mDefaultTranslation = DefaultTranslation;
        mMiworkTranslation = MiworkTranslation;
    }

    public Word(String DefaultTranslation, String MiworkTranslation, int ImageResourceID ){
        mDefaultTranslation = DefaultTranslation;
        mMiworkTranslation = MiworkTranslation;
        mImageResourceID = ImageResourceID;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiworkTranslation() {
        return mMiworkTranslation;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public  boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
