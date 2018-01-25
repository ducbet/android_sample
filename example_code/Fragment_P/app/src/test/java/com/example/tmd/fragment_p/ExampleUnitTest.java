package com.example.tmd.fragment_p;

import org.junit.Test;

import static java.lang.System.exit;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public static final String EMPTY_POT = "EMPTY_POT";
    public static final String POT_HAVE_DRY_TEA = "POT_HAVE_DRY_TEA";
    public static final String POT_HAVE_TEA_IN_BOILING_WATER = "POT_HAVE_TEA_IN_BOILING_WATER";
    public static final String POT_HAVE_HOT_TEA = "POT_HAVE_HOT_TEA";
    public static final String GREEN_TEA = "GREEN_TEA";
    public static final String BLACK_TEA = "BLACK_TEA";

    @Test
    public void main() {
        DryTea dryTea = new DryTea(GREEN_TEA);
        BoilingWater boilingWater = new BoilingWater();
        Pot pot = produceTea(dryTea, boilingWater);// POT_HAVE_HOT_TEA
        System.out.println(
            "Pot state: " + pot.getState() + ", tea type: " + pot.getDryTea().getTeaType());
    }

    public void dontHave(String objectName, String action) {
        System.out.printf("You don't have %s so you can't %s\n", objectName, action);
        exit(1);
    }

    public Pot produceTea(DryTea dryTea, BoilingWater boilingWater) {
        if (dryTea == null) {
            dontHave("dryTea", "putTeaInPot");
        }
        Pot potHaveDryTea = putTeaInPot(dryTea);// POT_HAVE_DRY_TEA
        if (boilingWater == null) {
            dontHave("boilingWater", "addBoilingWater");
        }
        if (potHaveDryTea == null) {
            dontHave("teaInPot", "addBoilingWater");
        }
        Pot pot = addBoilingWater(potHaveDryTea, boilingWater);// POT_HAVE_TEA_IN_BOILING_WATER
        if (pot == null) {
            dontHave(pot.getState(), "wait");
        }
        return wait(pot);
    }

    public Pot putTeaInPot(DryTea dryTea) {
        Pot pot = new Pot();// EMPTY_POT
        if (dryTea == null) {
            dontHave("dryTea", "putTeaInPot");
        }
        return pourSpoonTeaIntoPot(dryTea, pot);// POT_HAVE_DRY_TEA
    }

    public Pot pourSpoonTeaIntoPot(DryTea dryTea, Pot pot) {
        if (dryTea == null) {
            dontHave("dryTea", "fetchTea");
        }
        pot.setDryTea(dryTea);
        return pot;// POT_HAVE_DRY_TEA
    }

    Pot addBoilingWater(Pot pot, BoilingWater boilingWater) {
        pot.setBoilingWater(boilingWater);
        return pot;// POT_HAVE_TEA_IN_BOILING_WATER
    }

    Pot wait(Pot pot) {
        pot.waitIn(5);
        return pot;
    }

    class BoilingWater {
    }

    class DryTea {
        String teaType;

        public DryTea(String teaType) {
            this.teaType = teaType;
        }

        public String getTeaType() {
            return teaType;
        }

        public void setTeaType(String teaType) {
            this.teaType = teaType;
        }
    }

    class Pot {
        private DryTea dryTea;
        private BoilingWater boilingWater;
        private String state;

        public Pot() {
            state = EMPTY_POT;
        }

        public String getState() {
            return state;
        }

        public boolean haveDryTea() {
            return dryTea != null;
        }

        public DryTea getDryTea() {
            return dryTea;
        }

        public void setDryTea(DryTea dryTea) {
            if (!getState().equals(EMPTY_POT)) {
                System.out.printf("Pot not empty");
                exit(0);
            }
            this.dryTea = dryTea;
            this.state = POT_HAVE_DRY_TEA;
        }

        public BoilingWater getBoilingWater() {
            return boilingWater;
        }

        public void setBoilingWater(BoilingWater boilingWater) {
            if (!getState().equals(POT_HAVE_DRY_TEA)) {
                System.out.printf("Pot don't have dry tea");
                exit(0);
            }
            this.boilingWater = boilingWater;
            this.state = POT_HAVE_TEA_IN_BOILING_WATER;
        }

        public void waitIn(int minute) {
            this.state = POT_HAVE_HOT_TEA;
        }
    }
}
