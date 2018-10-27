package com.smswc.osam2018.osam2018_final_edition.data;

import java.util.ArrayList;

public class ArticleTypes {
    private static  ArrayList<ArticleType> types = null;
    public static ArrayList<ArticleType> getList() {

        if(types == null) {
            types = new ArrayList<>();
            types.add(new ArticleType(0, "공지"));
            types.add(new ArticleType(1, "자유게시판"));
            types.add(new ArticleType(2, "모집"));
        }
        return types;
    }

    public static class ArticleType {
        private int typeNo;
        private String typeName;

        ArticleType(int typeNo, String typeName) {
            this.typeNo = typeNo;
            this.typeName = typeName;
        }

        public int getTypeNo() {
            return typeNo;
        }

        public String getTypeName() {
            return typeName;
        }
    }
}
