package com.example.mymiwork;

import java.net.URI;

public class Word {
    private String mDefaultTranslation;
    private String mMiworkTranslation;
    private int mSoundResourceID;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String DefaultTranslation, String MiworkTranslation,int SoundResourceID ){
        mDefaultTranslation = DefaultTranslation;
        mMiworkTranslation = MiworkTranslation;
        mSoundResourceID = SoundResourceID;
    }

    public Word(String DefaultTranslation, String MiworkTranslation, int ImageResourceID, int SoundResourceID ){
        mDefaultTranslation = DefaultTranslation;
        mMiworkTranslation = MiworkTranslation;
        mImageResourceID = ImageResourceID;
        mSoundResourceID = SoundResourceID;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiworkTranslation() {
        return mMiworkTranslation;
    }

    public int getmSoundResourceID(){ return  mSoundResourceID;}

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public  boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiworkTranslation='" + mMiworkTranslation + '\'' +
                ", mSoundResourceID=" + mSoundResourceID +
                ", mImageResourceID=" + mImageResourceID +
                '}';
    }
}
