import javax.swing.*;

public class Main {
    public static void getAllInfos(Frequency l, Frequency m, Frequency h){
        l.getInfo();
        m.getInfo();
        h.getInfo();
    }
    public static void main(String[] args) {

        Equalizer equalizer = new Equalizer();

//       Frequency low = new Frequency("low",200, 0);
//        low.setEnable(false);
//        Frequency mid = new Frequency("mid",2500, 0);
//        mid.setEnable(false);
//        Frequency high = new Frequency("high",12000, 0);
//        high.setEnable(false);



//        getAllInfos(low, mid, high);
//
///*
//        ADDITIONAL OPTIONS
// */
//        low.setHzPrecision(100);
//        low.moreHz();
////        low.lessHz();
//
//        low.setVoltagePrecision(10);
//        low.moreVoltage();
////        low.lessVoltage();
//
//        low.setWidth(1);
//        low.moreWidth();
////        low.lessWidth();
//
//        getAllInfos(low, mid, high);
    }
}