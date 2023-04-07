package com.mingo.bot.domain;

import lombok.Data;

import java.awt.*;
import java.util.HashMap;

@Data
public class Embed {
    private String title;
    private String description;
    private Color color;
    private HashMap<String, String> field;
    private boolean blankField;
    private String image;
    private String thumbnail;

}
