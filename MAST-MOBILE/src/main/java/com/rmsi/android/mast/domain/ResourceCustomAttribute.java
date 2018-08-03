package com.rmsi.android.mast.domain;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.rmsi.android.mast.util.StringUtility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ambar.Srivastava on 1/4/2018.
 */

public class ResourceCustomAttribute implements Serializable {
    private Long attribId;
    transient private String type;
    transient private int controlType;
    transient private String name;
    transient private View view;
    private String attribValue;
    transient private Long groupId;
    transient private int listing;
    transient private List<Option> OptionsList = new ArrayList<>();
    transient private Long featureId;
    transient private String validate;

     private String Subclassificationid;
    transient private Drawable initialBackground;

    public static String TABLE_NAME = "RESOURCE_ATTRIBUTE_MASTER";
    public static String TABLE_ATTRIBUTE_VALUE_NAME = "RESOURCE_FORM_VALUES";

    public static String COL_ID = "ATTRIB_ID";
    public static String COL_TYPE = "ATTRIBUTE_TYPE";
    //ATTRIBUTE_TYPE_NAME
    public static String COL_TYPE_NAME = "ATTRIBUTE_TYPE_NAME";
    public static String COL_FLAG = "FLAG";
    public static String COL_CONTROL_TYPE = "ATTRIBUTE_CONTROLTYPE";
    public static String COL_NAME = "ATTRIBUTE_NAME";
    public static String COL_NAME_OTHER_LANG = "ATTRIBUTE_NAME_OTHER";
    public static String COL_LISTING = "LISTING";
    public static String COL_VALIDATE = "VALIDATION";
    public static String COL_SUBCLASSIFICATION = "SUBCLASSI_ID";

    public static String COL_VALUE_GROUP_ID = "GROUP_ID";
    public static String COL_VALUE_ATTRIBUTE_ID = "ATTRIB_ID";
    public static String COL_VALUE_VALUE = "ATTRIB_VALUE";
    public static String COL_VALUE_SUBID = "SUBCLASSIFICATION_ID";
    public static String COL_VALUE_FEATURE_ID = "FEATURE_ID";
    public static String COL_VALUE_OPTION_ID = "OPTION_ID";

    public static int CONTROL_TYPE_STIRNG = 1;
    public static int CONTROL_TYPE_DATE = 2;
    public static int CONTROL_TYPE_BOOLEAN = 3;
    public static int CONTROL_TYPE_NUMBER = 4;
    public static int CONTROL_TYPE_SPINNER = 5;

    public static String TYPE_GENERAL = "1";
    public static String TYPE_NATURAL_PERSON = "2";
    public static String TYPE_MULTIMEDIA = "3";
    public static String TYPE_TENURE = "4";
    public static String TYPE_NON_NATURAL_PERSON = "5";
    public static String TYPE_CUSTOM = "6";
    public static String TYPE_GENERAL_PROPERTY = "7";
    public static String TYPE_TENURE_INFOMRATION = "Resource";
    private Long resID;

    public Long getResID() {
        return resID;
    }

    public void setResID(Long resID) {
        this.resID = resID;
    }

    public String getSubclassificationid() {
        return Subclassificationid;
    }

    public void setSubclassificationid(String subclassificationid) {
        Subclassificationid = subclassificationid;
    }


    public Long getId() {
        return attribId;
    }

    public void setId(Long id) {
        this.attribId = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getControlType() {
        return controlType;
    }

    public void setControlType(int controlType) {
        this.controlType = controlType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
        this.initialBackground = view.getBackground();
    }

    public Drawable getInitialBackground() {
        return initialBackground;
    }

    public List<Option> getOptionsList() {
        return OptionsList;
    }

    public void setOptionsList(List<Option> OptionsList) {
        this.OptionsList = OptionsList;
    }

    public String getValue() {
        return attribValue;
    }

    public void setValue(String value) {
        this.attribValue = value;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public int getListing() {
        return listing;
    }

    public void setListing(int listing) {
        this.listing = listing;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    /** Checks list of attributes for required fields. */
    public static boolean hasRequiredFields(List<Attribute> attributes){
        if(attributes == null || attributes.size() < 1)
            return false;
        for(Attribute attribute : attributes){
            if(StringUtility.empty(attribute.getValidate()).equalsIgnoreCase("true"))
                return true;
        }
        return false;
    }
}