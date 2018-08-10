package com.lee.ttest.common;

import com.lee.ttest.R;
import com.lee.ttest.widget.GifLoadingView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class Common {
    
    public static Common mCommon;
    public static boolean ISLOGIN = false;
    public static String SHARE = "SHARE";
    public static String REMARK = "";
    public static final int ACCESS_COARSE_LOCATION = 3;
    public static boolean ifWifi = false;
    public String ADDRESS = "";

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public static Common getInstense(){
        if (mCommon == null){
            mCommon = new Common();
        }
        return mCommon;
    }
    
    
    private Map<String, Integer> map;
    public Map<String, Integer> getWeatherPIC(){
        map  = new HashMap<>();
        
        map.put("100", R.drawable.w100);
        map.put("101", R.drawable.w101);
        map.put("102", R.drawable.w102);
        map.put("103", R.drawable.w103);
        map.put("104", R.drawable.w104);
        map.put("200", R.drawable.w200);
        map.put("201", R.drawable.w201);
        map.put("202", R.drawable.w202);
        map.put("203", R.drawable.w203);
        map.put("204", R.drawable.w204);
        map.put("205", R.drawable.w205);
        map.put("206", R.drawable.w206);
        map.put("207", R.drawable.w207);
        map.put("208", R.drawable.w208);
        map.put("209", R.drawable.w209);
        map.put("210", R.drawable.w210);
        map.put("211", R.drawable.w211);
        map.put("212", R.drawable.w212);
        map.put("213", R.drawable.w213);
        map.put("300", R.drawable.w300);
        map.put("301", R.drawable.w301);
        map.put("302", R.drawable.w302);
        map.put("303", R.drawable.w303);
        map.put("304", R.drawable.w304);
        map.put("305", R.drawable.w305);
        map.put("306", R.drawable.w306);
        map.put("307", R.drawable.w307);
        map.put("308", R.drawable.w307);
        map.put("309", R.drawable.w309);
        map.put("310", R.drawable.w310);
        map.put("311", R.drawable.w311);
        map.put("312", R.drawable.w312);
        map.put("313", R.drawable.w313);
        map.put("314", R.drawable.w314);
        map.put("315", R.drawable.w315);
        map.put("316", R.drawable.w316);
        map.put("317", R.drawable.w317);
        map.put("318", R.drawable.w318);
        map.put("399", R.drawable.w399);
        map.put("400", R.drawable.w400);
        map.put("401", R.drawable.w401);
        map.put("402", R.drawable.w402);
        map.put("403", R.drawable.w403);
        map.put("404", R.drawable.w404);
        map.put("405", R.drawable.w405);
        map.put("406", R.drawable.w406);
        map.put("407", R.drawable.w407);
        map.put("408", R.drawable.w408);
        map.put("409", R.drawable.w409);
        map.put("410", R.drawable.w410);
        map.put("499", R.drawable.w499);
        map.put("500", R.drawable.w500);
        map.put("501", R.drawable.w501);
        map.put("502", R.drawable.w502);
        map.put("503", R.drawable.w503);
        map.put("504", R.drawable.w504);
        map.put("507", R.drawable.w507);
        map.put("508", R.drawable.w508);
        map.put("509", R.drawable.w509);
        map.put("510", R.drawable.w510);
        map.put("511", R.drawable.w511);
        map.put("512", R.drawable.w512);
        map.put("513", R.drawable.w513);
        map.put("514", R.drawable.w514);
        map.put("515", R.drawable.w515);
        map.put("900", R.drawable.w900);
        map.put("901", R.drawable.w901);
        map.put("999", R.drawable.w999);
        
        return map;
    } 

    
}
//jhfghfh