package domain;

public class Notes {
    private final boolean mattedCoat;
    private final boolean sensitiveSkin;
    private final boolean heavyUndercoat;
    private final boolean extraLongCoat;
    private final boolean needsBreaks;
    private final boolean anxious;
    private final boolean affectionate;
    private final boolean playful;
    private final boolean foodie;
    private final boolean communicative;
    private final boolean overweight;
    private final boolean underweight;
    private final boolean hatesBaths;
    private final boolean Noisesensitive;
    private final boolean ExtraCare;


    public Notes( boolean mattedCoat, boolean sensitiveSkin,  boolean heavyUndercoat, boolean extraLongCoat,  boolean needsBreaks, boolean anxious, boolean affectionate, boolean playful, boolean foodie, boolean communicative, boolean overweight, boolean underweight, boolean hatesBaths, boolean noisesensitive, boolean extraCare) {
        this.mattedCoat = mattedCoat;
        this.sensitiveSkin = sensitiveSkin;
        this.heavyUndercoat = heavyUndercoat;
        this.extraLongCoat = extraLongCoat;
        this.needsBreaks = needsBreaks;
        this.anxious = anxious;
        this.affectionate = affectionate;
        this.playful = playful;
        this.foodie = foodie;
        this.communicative = communicative;
        this.overweight = overweight;
        this.underweight = underweight;
        this.hatesBaths = hatesBaths;
        Noisesensitive = noisesensitive;
        ExtraCare = extraCare;
    }

    public int extraMinutes() {
        int extra = 0;
        if ( anxious || foodie) {
            extra += 20;
        }
        if (underweight) {
            extra += 15;
        }
        if (ExtraCare  || hatesBaths  || Noisesensitive || needsBreaks) {
            extra += 30;
        }
        if (affectionate || playful || communicative) {
            extra += 10;
        }
        if (overweight) {
            extra -= 10;
        }
        if (mattedCoat || sensitiveSkin || heavyUndercoat ||extraLongCoat) {
            extra += 45;
        }

        return extra;
    }


}
