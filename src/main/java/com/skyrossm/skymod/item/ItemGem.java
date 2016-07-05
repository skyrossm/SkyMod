package com.skyrossm.skymod.item;

/**
 * Created by Skyrossm on 2/23/2016.
 */
public class ItemGem extends ItemSkyMod {

    public String type;

    public ItemGem(String t){
        super("itemGem");
        type = t;
    }

    public String getType(){
        return type;
    }

    public void setType(String t){
        type = t;
    }
}
