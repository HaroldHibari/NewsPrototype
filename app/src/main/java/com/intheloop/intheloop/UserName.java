package com.intheloop.intheloop;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by gbrett on 16/03/2016.
 */
public class UserName {

    private List<String> mAdjectives;
    private List<String> mThings;
    private Random mRandomGenerator;

    public UserName() {
        mRandomGenerator = new Random();
        mAdjectives = Arrays.asList(new String[]{"Cooing", "Deafening", "Faint", "Hissing", "Hushed", "Husky", "Loud", "Melodic", "Lovely", "Magnificent", "Noisy", "Purring", "Quiet", "Silent", "Soft", "Squeaky", "Voiceless", "Whispering"});
        mThings = Arrays.asList(new String[]{"Apple", "Watermelon", "Mouse", "Cat", "Dog", "Pig", "Book", "Cheese", "Boot", "Tiger", "Mushroom", "Duck", "Chicken", "Beast"});
    }

    public String getRandomUserName() {

        String username;
        int index = mRandomGenerator.nextInt(mAdjectives.size());
        username =  mAdjectives.get(index);

        index = mRandomGenerator.nextInt(mThings.size());
        username += " ";
        username += mThings.get(index);

        return username;
    }
}
