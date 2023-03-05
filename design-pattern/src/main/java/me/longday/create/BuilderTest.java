package me.longday.create;

import lombok.ToString;

/**
 * @author 君
 * @version 1.0
 * @desc 建造者模式
 * @since 2023-03-05
 */
public class BuilderTest {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend.Builder("焰灵姬")
                .withHairColor("black")
                .withWeight("55")
                .withHeight("178")
                .withProfession("Wizard")
                .withHairType("long")
                .build();
        System.out.println(girlFriend);
    }
}

@ToString
class GirlFriend{
    private final String profession;
    private final String name;
    private final String hairType;
    private final String hairColor;
    private final String height;
    private final String weight;

    private GirlFriend(Builder builder){
        this.profession = builder.profession;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public static class Builder {
        private String profession;
        private String name;
        private String hairType;
        private String hairColor;
        private String height;
        private String weight;

        public Builder(String name){
            if (name == null|| name.length() == 0){
                throw new IllegalArgumentException("name can not be null or empty");
            }
            this.name = name;
        }

        public  Builder withProfession(String profession) {
            this.profession = profession;
            return this;
        }
        public Builder withHairType(String hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withHairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }
        public Builder withHeight(String height) {
            this.height = height;
            return this;
        }
        public Builder withWeight(String weight) {
            this.weight = weight;
            return this;
        }
        public GirlFriend build(){
            return new GirlFriend(this);
        }
    }

}

