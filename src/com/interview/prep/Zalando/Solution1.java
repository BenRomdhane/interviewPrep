package com.interview.prep.Zalando;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nikitash Pawar on 6/29/2017.
 */
public class Solution1 {

    public static void main(String[] args) {

        String input="photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(solution(input));

    }

    public static String solution(String S) {
        // write your code in Java SE 8

        List<Image> images =new ArrayList<>();
        Set<String> city=new LinkedHashSet<>();
        String[] split = S.split("[\\r\\n]+");
        for (int i = 0; i < split.length; i++) {
            Image image=null;
            String[] split1 = split[i].split(",");
            for (int j = 0; j < split1.length; j++) {
                String[] split2 = split1[0].split("\\.");
                image = new Image(i, split2[0], split1[1], getDate(split1[2]), split2[1]);
                city.add(split1[1]);

             }
            images.add(image);
        }

        List<Image> imagesCopy=new ArrayList<>();

        for (Image img:images
             ) {
            imagesCopy.add(img);

        }
        List<Image> result=new ArrayList<>();

        for (String cit:city) {
            List<Image> citybased = imagesCopy.stream()
                    .filter(p -> p.getCity().equalsIgnoreCase(cit))
                    .collect(Collectors.toList());

            Collections.sort(citybased, new Comparator<Image>() {
                @Override
                public int compare(Image o1, Image o2) {
                    return o1.getDate().compareTo(o2.getDate());
                }
            });



            for (int i = 0; i < citybased.size(); i++) {

                String format = String.format("%0"+(int)(Math.log10(citybased.size())+1)+"d", i+1);
                Image image = citybased.get(i);
                image.setSeq(format);
                result.add(image);
            }

        }




        Collections.sort(result, new Comparator<Image>() {
            @Override
            public int compare(Image o1, Image o2) {
                return o1.getId()-o2.getId();
            }
        });

        StringBuilder stringBuilder=new StringBuilder();
        for (Image img:result) {
            stringBuilder.append(img.toString());
            stringBuilder.append("\n");
        }
        return  stringBuilder.toString();
    }

    public static Date getDate(String args){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return sdf.parse(args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();

    }

    public static class Image {


        public Image(int id, String name, String city, Date date, String extension) {
            this.id = id;
            this.name = name;
            this.city = city;
            this.date = date;
            this.extension = extension;
        }

        @Override
        public String toString() {
            return city.trim()+seq +"."+extension;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getSeq() {
            return seq;
        }

        public void setSeq(String seq) {
            this.seq = seq;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        int id;
        String name;
        String city;
        Date date;
        String seq;
        String extension;

    }

}
