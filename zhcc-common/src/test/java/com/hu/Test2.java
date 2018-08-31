package com.hu;

/**
 * @author hulichao
 * @date 2018/8/30
 */
public class Test2 {
    public static void main(String[] args) {
        String a = "{\"picUrl\":\"http://qcloud.dpfile.com/pc/JrIhrHLNyX4SGfkFwr2cbbt4Er3N-NnzD1D5M1nJvXLwOhDDGs4Uhg-WpyRcYZPA.jpg\",\"width\":\"1050\",\"categoryId\":110,\"dealCategoryName\":\"火锅\",\"picThumbnailUrl\":null,\"isEntertainment\":false,\"picId\":816247098,\"picRelativeUrl\":\"d7126c4fa2e01c0012dad19aaf1e21bb\",\"isMerchant\":false,\"software\":\"10.3.2\",\"title\":\"\",\"height\":\"1400\",\"shopId\":15922116,\"shopName\":\"一哥澳门豆捞\",\"ruleId\":\"6291\",\"bizType\":1,\"make\":\"apple\"}";
        if (a.contains("\"isEntertainment\":false")) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }
    }
}
