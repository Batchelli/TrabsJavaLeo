public class Cilindro {
    double raioCilindro;
    double altCilindro;
    Cilindro(){
        this.raioCilindro = raioCilindro;
        this.altCilindro = altCilindro;
    }
    double areaBaseCilindro(){return Math.PI * Math.pow(raioCilindro, 2);}
    double areaLateralCilindro(){return 2 * Math.PI * raioCilindro * altCilindro;}
    double areaTCilindro(){return 2 * areaBaseCilindro() + areaLateralCilindro();}
    double volCilindro(){return Math.PI * Math.pow(raioCilindro, 2) * altCilindro;}
}
