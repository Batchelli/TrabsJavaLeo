public class Cone {
    double raioCone;
    double altCone;
    Cone(){
        this.raioCone = raioCone;
        this.altCone = altCone;
    }
    double geratrizCone(){return Math.sqrt(Math.pow(raioCone, 2) + Math.pow(altCone, 2));}
    double aBCone(){return Math.PI * Math.pow(raioCone, 2);}
    double aLCone(){return Math.PI * raioCone * geratrizCone();}
    double areaTCone(){return aBCone() + aLCone();}
    double volCone(){return (Math.PI * Math.pow(raioCone, 2) * altCone) / 3;}
}
