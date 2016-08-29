package com.firstone.collegeeventsnotifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubh on 02-08-2016.
 */
public class DataProvider {

    private  static List<Events> data=new ArrayList<>();

    public static  List<Events> getData(){return data;}
    static{
        data.add(new Events(10101, "Dancing Competition",
                "Hello students the dance competiton for the upcoming fest MANZAR is waiting you.BURN THE DANCE FLOOR \n \n PS:Participant must make sure they have their songs submitted to us before the competition." +
                        "Prizes worth 5K are waiting for you........ \n Hurry Up ","10 Sept 2016"));
        data.add(new Events(10102, "Singing Competition", "Hello students The much glorified singing competiton is back." +
                " \n \n Registration is open for everyone.Prizes worth 5K are waiting for you............ \n Hurry Up","11 Sept 2016"));

        data.add(new Events(10103,"Dumb Charades","The much glorified game of every generation is back." +
                "\n \n Show ur skills here and you might win yourself a grand prize........REGISTER NOW","11 Sept 2016"));

        data.add(new Events(10104,"BAND FACEOFF","The showdown is here." +
                "  \n THE MUCH AWAITED NIGHT..... \n The Band FACEOFF." +
                "Register you band for the bonanza and entertain the whole crowd watching you \n Prize worth 50K are waiting \n HURRY UP","12 Sept 2016"));

        data.add(new Events(10105,"Quiz Competition","This one is for Genious Minds.\n Do you have this in you to crack our quiz?" +
                " \n Register yourself and show us what you got. \n REGISTER NOW","12 Sept 2016"));

        data.add(new Events(10106,"Tic Tac Toe","The much glorified game of every generation is back." +
                "\n \n Show ur skills here and you might win yourself a grand prize........REGISTER NOW","12 Sept 2016"));

        data.add(new Events(10107,"CRICKET TOURNAMENT","The much glorified game of every generation is back." +
                "\n \n Show ur skills here and you might win yourself a grand prize........REGISTER NOW","13 Sept 2016"));

        data.add(new Events(10108,"HOCKEY MATCH","The much glorified game of every generation is back." +
                "\n \n Show ur skills here and you might win yourself a grand prize........REGISTER NOW","13 Sept 2016"));

        data.add(new Events(10109,"FOOTBALL TOURNAMENT","The much glorified game of every generation is back." +
                "\n \n Show ur skills here and you might win yourself a grand prize........REGISTER NOW","14 Sept 2016"));


        data.add(new Events(10110,"BASKETBALL TOURNAMENT","The much glorified game of every generation is back." +
                "\n \n Show ur skills here and you might win yourself a grand prize........REGISTER NOW","15 Sept 2016"));

        data.add(new Events(10111,"All Star Marathon","The much glorified game of every generation is back." +
                "\n \n Show ur skills here and you might win yourself a grand prize........REGISTER NOW","16 Sept 2016"));



    }
}
