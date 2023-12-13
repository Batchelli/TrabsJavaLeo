public class Piramide {
    double lbPiramide;
    double altPiramide;
    Piramide(){
        this.lbPiramide = lbPiramide;
        this.altPiramide = altPiramide;
    }
    double areaBPiramide(){return Math.pow(lbPiramide, 2);}
    double areaLPiramide(){return (4 * lbPiramide * altPiramide) / 2;}
    double areaTPiramide(){return areaBPiramide() + areaLPiramide();}
    double volPiramide(){return (areaBPiramide() * altPiramide) / 3;}
}
